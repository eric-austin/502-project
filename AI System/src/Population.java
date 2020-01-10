import java.io.IOException;
import java.util.ArrayList;
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
	protected int initPopSize = 20;
	protected int currentPopSize = initPopSize;
	protected int maxPopSize = 40;
	protected double totalFitness = 0.0;
	protected CandidateSolution bestSolution = null;
	static protected Random rng = new Random();
	protected NavigableMap<Double, CandidateSolution> candidates = new TreeMap<Double, CandidateSolution>();
	protected ArrayList<CandidateSolution> inferiorCandidates = new ArrayList<>();
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
		//randomly select a candidate solution
		CandidateSolution oldC = this.next();
		CandidateSolution newC = new CandidateSolution(oldC); 
		//randomly select a boolean var to mutate
		int i = Population.rng.nextInt(this.booleanIndexes.length);
		if (newC.policyMix[this.booleanIndexes[i]] == 1.0) {
			newC.policyMix[this.booleanIndexes[i]] = 0.0;
		} else {
			newC.policyMix[this.booleanIndexes[i]] = 1.0;
		}
		//evaluate the new Candidate Solution's fitness
		newC.writeCommandFile();
		try {
			this.runVensim();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		newC.evaluateFitness();
		this.updateBest(newC);
		this.addCandidate(newC);
	}
	
	/**
	 * mutate a single real number value of a (weighted) randomly selected candidate solution
	 */
	public void realSingleMutate() {
		//weighted randomly select a candidate solution
		CandidateSolution oldC = this.next();
		CandidateSolution newC = new CandidateSolution(oldC);
		//uniform randomly select another current candidate
		ArrayList<CandidateSolution> currentPop = (ArrayList<CandidateSolution>)this.candidates.values();
		int i = Population.rng.nextInt(currentPop.size());
		CandidateSolution candidateA = currentPop.get(i);
		//uniform randomly select an inferior discarded candidate
		//if no discarded candidates yet, select another current candidate
		CandidateSolution candidateB = null;
		if (this.inferiorCandidates.size() == 0) {
			int j = Population.rng.nextInt(currentPop.size());
			if (i == j) {
				//if indexes i and j are equal increment j by 1 to ensure different candidate vectors are used
				j++;
			}
			candidateB = currentPop.get(j);
		} else {
			//else we have inferior discarded candidates and can randomly select one
			i = Population.rng.nextInt(this.inferiorCandidates.size());
			candidateB = this.inferiorCandidates.get(i);
		}
		//randomly select a real var to mutate
		i = Population.rng.nextInt(this.realIndexes.length);
		int k = this.realIndexes[i];
		//new value for this parameter is the old value plus the difference between other two candidates
		newC.policyMix[k] = newC.policyMix[k] + Main.scalingFactor * (candidateA.policyMix[k] - candidateB.policyMix[k]);
		// if new value is above max range for this var, set to max
		if (newC.policyMix[k] > Policies.allPolicies[k].maxValue) {
			newC.policyMix[k] = Policies.allPolicies[k].maxValue;
		} else if (newC.policyMix[k] < Policies.allPolicies[k].minValue) {
			//else if it is below the minimum then set to min value
			newC.policyMix[k] = Policies.allPolicies[k].minValue;
		}
		//evaluate the new Candidate Solution's fitness
		newC.writeCommandFile();
		try {
			this.runVensim();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//evaluate fitness and update best
		newC.evaluateFitness();
		this.updateBest(newC);
		this.addCandidate(newC);
	}
	
	/**
	 * mutate all real number values of a (weighted) randomly selected candidate solution
	 */
	public void realAllMutate() {
		//weighted randomly select a candidate solution
		CandidateSolution oldC = this.next();
		CandidateSolution newC = new CandidateSolution(oldC);
		//uniform randomly select another current candidate
		ArrayList<CandidateSolution> currentPop = (ArrayList<CandidateSolution>)this.candidates.values();
		int i = Population.rng.nextInt(currentPop.size());
		CandidateSolution candidateA = currentPop.get(i);
		//uniform randomly select an inferior discarded candidate
		//if no discarded candidates yet, select another current candidate
		CandidateSolution candidateB = null;
		if (this.inferiorCandidates.size() == 0) {
			int j = Population.rng.nextInt(currentPop.size());
			if (i == j) {
				//if indexes i and j are equal increment j by 1 to ensure different candidate vectors are used
				j++;
			}
			candidateB = currentPop.get(j);
		} else {
			//else we have inferior discarded candidates and can randomly select one
			i = Population.rng.nextInt(this.inferiorCandidates.size());
			candidateB = this.inferiorCandidates.get(i);
		}
		//iterate through all real vars and mutate
		for (int x = 0; x < this.realIndexes.length; x++) {
			int k = this.realIndexes[x];
			//new value for this parameter is the old value plus the difference between other two candidates
			newC.policyMix[k] = newC.policyMix[k] + Main.scalingFactor * (candidateA.policyMix[k] - candidateB.policyMix[k]);
			// if new value is above max range for this var, set to max
			if (newC.policyMix[k] > Policies.allPolicies[k].maxValue) {
				newC.policyMix[k] = Policies.allPolicies[k].maxValue;
			} else if (newC.policyMix[k] < Policies.allPolicies[k].minValue) {
				//else if it is below the minimum then set to min value
				newC.policyMix[k] = Policies.allPolicies[k].minValue;
			}
		}
		//evaluate the new Candidate Solution's fitness
		newC.writeCommandFile();
		try {
			this.runVensim();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//evaluate fitness and update best
		newC.evaluateFitness();
		this.updateBest(newC);
		this.addCandidate(newC);
	}
	
	/**
	 * mutate a single natural (discrete) value of a randomly selected candidate solution
	 */
	public void naturalSingleMutate() {
		//weighted randomly select a candidate solution
		CandidateSolution oldC = this.next();
		CandidateSolution newC = new CandidateSolution(oldC);
		//uniform randomly select another current candidate
		ArrayList<CandidateSolution> currentPop = (ArrayList<CandidateSolution>)this.candidates.values();
		int i = Population.rng.nextInt(currentPop.size());
		CandidateSolution candidateA = currentPop.get(i);
		//uniform randomly select an inferior discarded candidate
		//if no discarded candidates yet, select another current candidate
		CandidateSolution candidateB = null;
		if (this.inferiorCandidates.size() == 0) {
			int j = Population.rng.nextInt(currentPop.size());
			if (i == j) {
				//if indexes i and j are equal increment j by 1 to ensure different candidate vectors are used
				j++;
			}
			candidateB = currentPop.get(j);
		} else {
			//else we have inferior discarded candidates and can randomly select one
			i = Population.rng.nextInt(this.inferiorCandidates.size());
			candidateB = this.inferiorCandidates.get(i);
		}
		//randomly select a natural var to mutate
		i = Population.rng.nextInt(this.naturalIndexes.length);
		int k = this.naturalIndexes[i];
		//new value for this parameter is the old value plus the difference between other two candidates
		newC.policyMix[k] = newC.policyMix[k] + (candidateA.policyMix[k] - candidateB.policyMix[k]);
		// if new value is above max range for this var, set to max
		if (newC.policyMix[k] > Policies.allPolicies[k].maxValue) {
			newC.policyMix[k] = Policies.allPolicies[k].maxValue;
		} else if (newC.policyMix[k] < Policies.allPolicies[k].minValue) {
			//else if it is below the minimum then set to min value
			newC.policyMix[k] = Policies.allPolicies[k].minValue;
		}
		//evaluate the new Candidate Solution's fitness
		newC.writeCommandFile();
		try {
			this.runVensim();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//evaluate fitness and update best
		newC.evaluateFitness();
		this.updateBest(newC);
		this.addCandidate(newC);
	}
	
	/**
	 * mutate all natural (discrete) values of a (weighted) randomly selected candidate
	 */
	public void naturalAllMutate() {
		//weighted randomly select a candidate solution
		CandidateSolution oldC = this.next();
		CandidateSolution newC = new CandidateSolution(oldC);
		//uniform randomly select another current candidate
		ArrayList<CandidateSolution> currentPop = (ArrayList<CandidateSolution>)this.candidates.values();
		int i = Population.rng.nextInt(currentPop.size());
		CandidateSolution candidateA = currentPop.get(i);
		//uniform randomly select an inferior discarded candidate
		//if no discarded candidates yet, select another current candidate
		CandidateSolution candidateB = null;
		if (this.inferiorCandidates.size() == 0) {
			int j = Population.rng.nextInt(currentPop.size());
			if (i == j) {
				//if indexes i and j are equal increment j by 1 to ensure different candidate vectors are used
				j++;
			}
			candidateB = currentPop.get(j);
		} else {
			//else we have inferior discarded candidates and can randomly select one
			i = Population.rng.nextInt(this.inferiorCandidates.size());
			candidateB = this.inferiorCandidates.get(i);
		}
		//iterate through all natural vars and mutate
		for (int x = 0; x < this.naturalIndexes.length; x++) {
			int k = this.naturalIndexes[x];
			//use random double and scaling factor to determine whether a var should be updated or left alone
			if (Population.rng.nextDouble() < Main.scalingFactor) {
				newC.policyMix[k] = newC.policyMix[k] + (candidateA.policyMix[k] - candidateB.policyMix[k]);
			}
			// if new value is above max range for this var, set to max
			if (newC.policyMix[k] > Policies.allPolicies[k].maxValue) {
				newC.policyMix[k] = Policies.allPolicies[k].maxValue;
			} else if (newC.policyMix[k] < Policies.allPolicies[k].minValue) {
				//else if it is below the minimum then set to min value
				newC.policyMix[k] = Policies.allPolicies[k].minValue;
			}
		}
		//evaluate the new Candidate Solution's fitness
		newC.writeCommandFile();
		try {
			this.runVensim();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//evaluate fitness and update best
		newC.evaluateFitness();
		this.updateBest(newC);
		this.addCandidate(newC);
	}
	
	/**
	 * Weighted random selection of two candidate solutions to crossover
	 */
	public void crossover() {
		//weighted randomly select two candidate solutions
		CandidateSolution candidateA = this.next();
		CandidateSolution candidateB = this.next();
		//new candidate solution to be create by crossover
		CandidateSolution candidateNew = new CandidateSolution();
		//iterate through all policies and randomly select value from either A or B to use for new
		for (int i = 0; i < Policies.allPolicies.length; i++) {
			if (Population.rng.nextDouble() < Main.crossoverRate) {
				candidateNew.policyMix[i] = candidateA.policyMix[i];
			} else {
				candidateNew.policyMix[i] = candidateB.policyMix[i];
			}
		}
		//evaluate the new Candidate solution's fitess
		candidateNew.writeCommandFile();
		try {
			this.runVensim();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//evaluate fitness and update best
		candidateNew.evaluateFitness();
		this.updateBest(candidateNew);
		this.addCandidate(candidateNew);
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
