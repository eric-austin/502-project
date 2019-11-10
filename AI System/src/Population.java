import java.util.Random;

/**
 * Class representing a population of candidate solutions
 * used to find optimal solution to problem
 *
 */
public class Population {
	//instance variables
	private int popSize = 3;
	static public Random rng = new Random();
	public CandidateSolution[] candidates = new CandidateSolution[popSize];
	
	//constructors
	public Population() {
		for(int i = 0; i < popSize; i++) {
			this.candidates[i] = new CandidateSolution();
		}
	}
}
