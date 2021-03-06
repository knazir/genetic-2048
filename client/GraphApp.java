package client;


import java.awt.BasicStroke;
import java.awt.Color;
import java.util.Random;
import java.util.Timer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import algorithm.GAConstants;
import algorithm.GeneticAlgorithm;
import algorithm.Population;

public class GraphApp extends ApplicationFrame implements GAConstants {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		
		GraphApp chart = new GraphApp("Genetic Algorithm Evolution Progress", GRAPH_TITLE);
		chart.pack( );
		RefineryUtilities.centerFrameOnScreen(chart);
		chart.setVisible(true);
		
		long endTime = System.nanoTime();
		long duration = (endTime - startTime)/1000000;	// in milliseconds
		System.out.println("Duration: " + duration + " milliseconds");
	}

	public GraphApp(String applicationTitle, String chartTitle) {
		super(applicationTitle);
		JFreeChart xyLineChart = ChartFactory.createXYLineChart(
				chartTitle,
				"Generation",
				"Fitness/Score",
				createDataset(),
				PlotOrientation.VERTICAL,
				true , true , false);

		ChartPanel chartPanel = new ChartPanel(xyLineChart);
		chartPanel.setPreferredSize( new java.awt.Dimension(APPLICATION_WIDTH , APPLICATION_HEIGHT));
		final XYPlot plot = xyLineChart.getXYPlot( );
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
		renderer.setSeriesPaint(0, Color.RED );
		renderer.setSeriesStroke(0 , new BasicStroke(2.0f));
		plot.setRenderer(renderer); 
		setContentPane(chartPanel); 
	}

	private XYDataset createDataset() {
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries populationFitnessData = new XYSeries("Population"); 
		XYSeries populationScoreData = new XYSeries("Score");
		
		runGeneticAlgorithm(populationFitnessData, populationScoreData);
		dataset.addSeries(populationFitnessData);
		dataset.addSeries(populationScoreData);
		return dataset;
	}

	private void runGeneticAlgorithm(XYSeries fitnessData, XYSeries scoreData) {
		GeneticAlgorithm algorithm = new GeneticAlgorithm();
		Population population = new Population(POPULATION_SIZE);
		population.initialize();
		int generation = 0;

		while (population.getFittest().getMaxTile() != MAX_FITNESS) {
			generation++;
			fitnessData.add(generation, population.getFittest().getMaxTile());
			scoreData.add(generation, population.getFittest().getScore());
			population = algorithm.evolvePopulation(population);
		}
		
		// display final generation
		fitnessData.add(generation + 1, population.getFittest().getMaxTile());
	}
}
