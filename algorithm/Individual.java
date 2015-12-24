/* This class represents an individual in our population with its
 * own "chromosome" composed of exactly the same number of genes
 * as the solution sequence. The individual has a fitness score
 * that is calculated by comparing the number of in-common, in-place
 * "genes" in the chromosome compared to the solution.
 * 
 * Each individual is originally generated with a random chromosome
 * of values between the minimum and maximum value of any element in
 * the solution.
 */

package algorithm;

import java.util.Random;

import game.Game2048;

public class Individual implements GAConstants {
	
	/** Current sequence of GENE_LENGTH integers, which is exactlythe solution size */
	private Move[] genes;
	
	/** Current fitness score (of the genes array) */
	private int fitness = 0;
	
	/** Random generator for "mutations" in sequence */
	private Random randomGenerator;
	
	private int numMoves = 0;
	private int score = 0;
	
	public Individual() {
		this.randomGenerator = new Random();
		this.numMoves = randomGenerator.nextInt(MAX_MOVES + 1);	// initializes an "empty" chromosome
		this.genes = new Move[numMoves];
	}
	
	public Individual(int numMoves) {
		this.randomGenerator = new Random();
		this.numMoves = numMoves;	// initializes an "empty" chromosome
		this.genes = new Move[numMoves];
	}
	
	public Move generateMove() {
		int direction = randomGenerator.nextInt(NUM_MOVES);
		switch (direction) {
			case 0:
				return Move.UP;
			case 1:
				return Move.DOWN;
			case 2:
				return Move.LEFT;
			case 3:
				return Move.RIGHT;
			default:
				return null;
		}
	}
	
	/** Creates a randomly generated chromosome */
	public void generateIndividual() {
		for (int i = 0; i < this.genes.length; i++) {
			Move gene = generateMove();
			genes[i] = gene;
		}
	}
	
	public void runSimulation() {
		Game2048 simulation = new Game2048(genes);
		fitness = simulation.getHighestTile();
		score = simulation.getScore();
	}
	
	public void setFitness(int fitness) {
		this.fitness = fitness;
	}
	
	/** Calculates the individual's current fitness score */
	public int getMaxTile() {
		return fitness;
	}
	
	public int getScore() {
		return score;
	}
	
	/** Returns the gene at the specified chromosomal index */
	public Move getGene(int index) {
		return genes[index];
	}
	
	/** Sets a specific gene to a value and resets individual's fitness */
	public void setGene(int index, Move gene) {
		this.genes[index] = gene;
		this.fitness = 0;
	}
	
	public int getNumMoves() {
		return this.numMoves;
	}
	
	public Move[] getGenes() {
		return this.genes;
	}
	
	@Override
	public String toString() {
		String chromosome = "";
		for (int i = 0; i < this.genes.length; i++)
			chromosome += genes[i] + " ";
		return chromosome;
	}
}
