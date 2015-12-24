package client;

import algorithm.GAConstants;
import algorithm.GeneticAlgorithm;
import algorithm.Move;
import algorithm.Population;

public class TextClient implements GAConstants {
	
	private static int generation = 0;
	
	public static void main(String[] args) {
		runGeneticAlgorithm();
		System.out.println("Took " + generation + " generations with final score: " + MAX_FITNESS);
		
	}
	
	private static void runGeneticAlgorithm() {
		GeneticAlgorithm algorithm = new GeneticAlgorithm();
		Population population = new Population(POPULATION_SIZE);
		population.initialize();

		while (population.getFittest().getMaxTile() < MAX_FITNESS) {
			generation++;
			population = algorithm.evolvePopulation(population);
		}
	}
	
	private void printBestMoves(Population population) {
		Move[] moves = population.getFittest().getGenes();
		for (int i = 0; i < moves.length; i++) {
			System.out.print(moves[i] + " ");
		}
		System.out.println("\n");
	}
}
