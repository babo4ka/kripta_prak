package quickExpTask.QuickExp;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Graphics {

    private List<BigInteger> lengthList;

    private List<BigInteger> fastAlgDurs;

    private List<BigInteger> longAlgDurs;



    public Graphics(List<BigInteger> lengthList, List<BigInteger> fastAlgDurs, List<BigInteger> longAlgDurs){
        this.lengthList = lengthList;
        this.fastAlgDurs = fastAlgDurs;
        this.longAlgDurs = longAlgDurs;
    }

    public void showGraphics(){
        XYDataset dataset = createDS();
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.darkGray);

        JFrame frame = new JFrame();
        frame.add(chartPanel);

        frame.pack();
        frame.setTitle("График времени выполнения алгоритма");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }


    private XYDataset createDS(){

        List<XYSeries> seriesList = new ArrayList<>();

        XYSeries fastSeries = new XYSeries("Длина чисел a и b в битах (a ^ b % m)");
        for(int i=0; i<this.lengthList.size();i++){
            fastSeries.add(this.lengthList.get(i), this.fastAlgDurs.get(i));
        }
        seriesList.add(fastSeries);

        if(this.longAlgDurs != null){
            XYSeries longSeries = new XYSeries("Длина чисел a и b в битах ((a ^ b) % m)");
            for(int i=0;i<this.lengthList.size();i++){
                longSeries.add(this.lengthList.get(i), this.longAlgDurs.get(i));
            }
            seriesList.add(longSeries);
        }


        XYSeriesCollection ds = new XYSeriesCollection();
        seriesList.forEach(ds::addSeries);


        return ds;
    }


    private final Color [] colors = {Color.RED, Color.BLUE, Color.MAGENTA, Color.YELLOW};

    private JFreeChart createChart(XYDataset ds){
        JFreeChart chart = ChartFactory.createXYLineChart(
                "График времени работы алгоритма",
                "Длина числа в битах",
                "Время выполнения алгоритма в наносекундах",
                ds,
                PlotOrientation.VERTICAL,
                true, true, false
        );

        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();


        for(int i=0; i<ds.getSeriesCount();i++) {
            plot.setRenderer(renderer);
            plot.setBackgroundPaint(Color.white);
            plot.setRangeGridlinesVisible(false);
            plot.setDomainGridlinesVisible(false);
        }

        chart.getLegend().setFrame(BlockBorder.NONE);

        chart.setTitle(new TextTitle("Время выполнения алгоритма в зависимости от битовой длины числа",
                        new Font("Serif", Font.BOLD, 18)
                )
        );

        return chart;
    }

}
