package org.example.QuickExp;

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

    private List<BigInteger> aList;
    private List<BigInteger> bList;

    private List<BigInteger> aTimes;
    private List<BigInteger> bTimes;

    public Graphics(List<BigInteger> aList, List<BigInteger> bList,
                    List<BigInteger> aTimes, List<BigInteger> bTimes) {
        this.aList = aList;
        this.bList = bList;
        this.aTimes = aTimes;
        this.bTimes = bTimes;
    }

    public void showGraphics(){
        XYDataset dataset = createDS(this.aList, this.bList, this.aTimes, this.bTimes);
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

    private XYDataset createDS(List<BigInteger> aList, List<BigInteger> bList,
                               List<BigInteger> aTimes, List<BigInteger> bTimes){

        XYSeries aSeries = new XYSeries("a");
        for(int i=0; i<aList.size();i++){
            aSeries.add(Long.toBinaryString(aList.get(i).longValue()).length(), aTimes.get(i));
        }

        XYSeries bSeries = new XYSeries("b");
        for(int i=0;i<bList.size();i++){
            bSeries.add(Long.toBinaryString(bList.get(i).longValue()).length(), bTimes.get(i));
        }

        XYSeriesCollection ds = new XYSeriesCollection();
        ds.addSeries(aSeries);
        ds.addSeries(bSeries);

        return ds;
    }


    private JFreeChart createChart(XYDataset ds){
        JFreeChart chart = ChartFactory.createXYLineChart(
                "График времени работы алгоритма",
                "Длина числа",
                "Время выполнения алгоритма",
                ds,
                PlotOrientation.VERTICAL,
                true, true, false
        );

        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
        renderer.setSeriesPaint(1, Color.BLUE);
        renderer.setSeriesStroke(1, new BasicStroke(2.0f));

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);
        plot.setRangeGridlinesVisible(false);
        plot.setDomainGridlinesVisible(false);

        chart.getLegend().setFrame(BlockBorder.NONE);

        chart.setTitle(new TextTitle("Время выполнения алгоритма в зависимости от длины числа",
                        new Font("Serif", Font.BOLD, 18)
                )
        );

        return chart;
    }
}
