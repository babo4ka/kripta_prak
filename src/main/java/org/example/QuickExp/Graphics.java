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
import java.util.List;

public class Graphics {

    private List<BigInteger> aList;
    private List<BigInteger> bList;

    private List<BigInteger> aTimes;
    private List<BigInteger> bTimes;

    private List<BigInteger> aTimes2;
    private List<BigInteger> bTimes2;



    private Graphics(GraphicsBuilder builder){
        this.aList = builder.aList;
        this.bList = builder.bList;
        this.aTimes = builder.aTimes;
        this.bTimes = builder.bTimes;

        this.aTimes2 = builder.aTimes2;
        this.bTimes2 = builder.bTimes2;
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

    public void showGraphics2(){
        XYDataset dataset = createDS2(this.aList, this.bList, this.aTimes, this.bTimes,
                this.aTimes2, this.bTimes2);
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.darkGray);

        JFrame frame = new JFrame();
        frame.add(chartPanel);

        frame.pack();
        frame.setTitle("График времени выполнения алгоритмов");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }

    private XYDataset createDS(List<BigInteger> aList, List<BigInteger> bList,
                               List<BigInteger> aTimes, List<BigInteger> bTimes){

        XYSeries aSeries = new XYSeries("a");
        for(int i=0; i<aList.size();i++){
            aSeries.add(aList.get(i).toString(2).length(), aTimes.get(i));
        }

        XYSeries bSeries = new XYSeries("b");
        for(int i=0;i<bList.size();i++){
            bSeries.add(bList.get(i).toString(2).length(), bTimes.get(i));
        }

        XYSeriesCollection ds = new XYSeriesCollection();
        ds.addSeries(aSeries);
        ds.addSeries(bSeries);

        return ds;
    }


    private final Color [] colors = {Color.RED, Color.BLUE, Color.MAGENTA, Color.YELLOW};
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

        for(int i=0; i<ds.getSeriesCount();i++){
            renderer.setSeriesPaint(i, colors[i]);
            renderer.setSeriesStroke(i, new BasicStroke(2.0f));
        }

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



    private XYDataset createDS2(List<BigInteger> aList, List<BigInteger> bList,
                               List<BigInteger> aTimes, List<BigInteger> bTimes,
                                List<BigInteger> aTimes2, List<BigInteger> bTimes2){

        XYSeries aSeries = new XYSeries("a (a^b%m)");
        for(int i=0; i<aList.size();i++){
            aSeries.add(aList.get(i).toString(2).length(), aTimes.get(i));
        }

        XYSeries bSeries = new XYSeries("b (a^b%m)");
        for(int i=0;i<bList.size();i++){
            bSeries.add(bList.get(i).toString(2).length(), bTimes.get(i));
        }

        XYSeries aSeries2 = new XYSeries("a ((a^b)%m)");
        for(int i=0; i<aList.size();i++){
            aSeries2.add(aList.get(i).toString(2).length(), aTimes2.get(i));
        }

        XYSeries bSeries2 = new XYSeries("b ((a^b)%m)");
        for(int i=0;i<bList.size();i++){
            bSeries2.add(bList.get(i).toString(2).length(), bTimes2.get(i));
        }

        XYSeriesCollection ds = new XYSeriesCollection();
        ds.addSeries(aSeries);
        ds.addSeries(bSeries);
        ds.addSeries(aSeries2);
        ds.addSeries(bSeries2);

        return ds;
    }


    public static class GraphicsBuilder{
        private List<BigInteger> aList;
        private List<BigInteger> bList;

        private List<BigInteger> aTimes;
        private List<BigInteger> bTimes;


        private List<BigInteger> aTimes2;
        private List<BigInteger> bTimes2;

        public GraphicsBuilder(List<BigInteger> aList, List<BigInteger> bList,
                        List<BigInteger> aTimes, List<BigInteger> bTimes) {
            this.aList = aList;
            this.bList = bList;
            this.aTimes = aTimes;
            this.bTimes = bTimes;
        }

        public GraphicsBuilder addSecond(List<BigInteger> aTimes2, List<BigInteger> bTimes2){
            this.aTimes2 = aTimes2;
            this.bTimes2 = bTimes2;

            return this;
        }

        public Graphics build(){
            return new Graphics(this);
        }
    }
}
