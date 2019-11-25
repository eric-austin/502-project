import java.io.IOException;
import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;

/**
 * Class representing a population of candidate solutions
 * used to find optimal solution to problem
 *
 */
public class Population {
	//instance variables
	protected int initPopSize = 10;
	protected int currentPopSize = initPopSize;
	protected int maxPopSize = 20;
	protected double totalFitness = 0.0;
	protected CandidateSolution bestSolution = null;
	static protected Random rng = new Random();
	protected NavigableMap<Double, CandidateSolution> candidates = new TreeMap<Double, CandidateSolution>();
	protected int[] booleanIndexes = null;
	protected int[] naturalIndexes = null;
	protected int[] realIndexes = null;
	
	//constructors
	public Population() throws InterruptedException {
		this.buildIndexLists();
		CandidateSolution currentCandidate = null;
		for(int i = 0; i < initPopSize; i++) {
			currentCandidate = new CandidateSolution();
			currentCandidate.writeCommandFile();
			this.runVensim();
			currentCandidate.evaluateFitness();
			this.updateBest(currentCandidate);
			this.addCandidate(currentCandidate);
		}
	}
	
	//methods
	/**
	 * calls the vensim simulator
	 * @throws InterruptedException 
	 */
	public void runVensim() throws InterruptedException {
		try {
			Process pb = new ProcessBuilder("C:\\Program Files\\Vensim\\vendss64.exe", "..\\eps-1.4.2-alberta\\commandscript.cmd").start();
			pb.waitFor();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * add a CandidateSolution to the collection of candidates
	 */
	public void addCandidate(CandidateSolution candidate) {
		this.totalFitness += candidate.fitness;
		this.candidates.put(totalFitness, candidate);
	}
	
	/**
	 * get a random CandidateSolution from the population with probability proportional to fitness
	 */
	public CandidateSolution next() {
		double value = Population.rng.nextDouble() * this.totalFitness;
		return this.candidates.higherEntry(value).getValue();
	}
	
	/**
	 * check whether given candidate is better than current best and update if yes
	 */
	public void updateBest(CandidateSolution candidate) {
		if (this.bestSolution == null) {
			this.bestSolution = candidate;
		} else {
			if (this.bestSolution.fitness < candidate.fitness) {
				this.bestSolution = candidate;
			}
		}
	}
	
	/**
	 * mutate a single boolean value of a (weighted) randomly selected candidate solution
	 */
	public void booleanMutate() {
		CandidateSolution c = this.next();
	}
	
	/**
	 * build list of policy data type indexes
	 */
	public void buildIndexLists() {
		//build lists of indexes
		int count = 0;
		int index = 0;
		for (Policy p : Policies.allPolicies) {
			if (p.dataType == Policies.bool) {
				count++;
			}
		}
		this.booleanIndexes = new int[count];
		for (count = 0; count < Policies.allPolicies.length; count++) {
			if (Policies.allPolicies[count].dataType == Policies.bool) {
				this.booleanIndexes[index] = count;
				index++;
			}
		}
		count = 0;
		index = 0;
		for (Policy p : Policies.allPolicies) {
			if (p.dataType == Policies.natural) {
				count++;
			}
		}
		this.naturalIndexes = new int[count];
		for (count = 0; count < Policies.allPolicies.length; count++) {
			if (Policies.allPolicies[count].dataType == Policies.natural) {
				this.naturalIndexes[index] = count;
				index++;
			}
		}
		count = 0;
		index = 0;
		for (Policy p : Policies.allPolicies) {
			if (p.dataType == Policies.real) {
				count++;
			}
		}
		this.realIndexes = new int[count];
		for (count = 0; count < Policies.allPolicies.length; count++) {
			if (Policies.allPolicies[count].dataType == Policies.real) {
				this.realIndexes[index] = count;
				index++;
			}
		}
	}
}
