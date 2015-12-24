package algorithm;

public interface GAConstants {

	public static final int POPULATION_SIZE = 100;


	/* ALGORITHM BEHAVIOR CONSTANTS */
	public static final double UNIFORM_RATE = 0.5;
	public static final double MUTATION_RATE = 0.015;
	public static final int TOURNAMENT_SIZE = 5;
	public static final int MAX_FITNESS = 1024;
	public static final int MAX_MOVES = 1000;
	public static final int NUM_MOVES = 4;
	public static final int UP = 0;
	public static final int DOWN = 1;
	public static final int LEFT = 2;
	public static final int RIGHT = 3;
	public static final long SEED = 650283865;
	public static final int SENTINEL = Integer.MAX_VALUE;


	/* DYNAMIC GRAPHING APP CONSTANTS */
	public static final int GRAPH_Y_MAX = 3000;
	public static final String START = "Start";
	public static final String STOP = "Stop";
	public static final String RESTART = "Restart";
	public static final int COUNT = 2 * 60;
	public static final int FASTER = 10;
	public static final int FAST = FASTER * 5;
	public static final int SLOW = FAST * 5;

	/* GUI CONSTANTS */
	public static final String GRAPH_TITLE = "Fitness by Generation | Population: " 
			+ POPULATION_SIZE + " | Target Fitness: " + MAX_FITNESS;
	public static final int APPLICATION_WIDTH = 1024;
	public static final int APPLICATION_HEIGHT = 768;

}