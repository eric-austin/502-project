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
	protected int initPop;
	protected int currentPop = 0;
	protected int maxPop;
	protected double totalFitness = 0.0;
	protected CandidateSolution bestSolution = null;
	static protected Random rng = new Random();
	protected ArrayList<CandidateSolution> candidates = new ArrayList<>();
	protected NavigableMap<Double, Integer> selectionWheel = new TreeMap<Double, Integer>();
	protected ArrayList<CandidateSolution> inferiorCandidates = new ArrayList<>();
	protected int[] booleanIndexes = null;
	protected int[] naturalIndexes = null;
	protected int[] realIndexes = null;
	
	//constructors
	public Population(int initP, int maxP) throws InterruptedException {
		this.buildIndexLists();
		this.initPop = initP;
		this.maxPop = maxP;
		CandidateSolution currentCandidate = null;
		for(int i = 0; i < this.initPop; i++) {
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
		this.candidates.add(candidate);
		this.totalFitness += candidate.fitness;
		this.selectionWheel.put(totalFitness, this.currentPop);
		this.currentPop++;
	}
	
	/**
	 * get a random CandidateSolution from the population with probability proportional to fitness
	 */
	public int next() {
		double value = Population.rng.nextDouble() * this.totalFitness;
		return this.selectionWheel.higherEntry(value).getValue();
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
		CandidateSolution oldC = this.candidates.get(this.next());
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
		CandidateSolution oldC = this.candidates.get(this.next());
		CandidateSolution newC = new CandidateSolution(oldC);
		//uniform randomly select another current candidate
		int i = Population.rng.nextInt(this.candidates.size());
		CandidateSolution candidateA = this.candidates.get(i);
		//uniform randomly select an inferior discarded candidate
		//if no discarded candidates yet, select another current candidate
		CandidateSolution candidateB = null;
		if (this.inferiorCandidates.size() == 0) {
			int j = Population.rng.nextInt(this.candidates.size());
			if (i == j) {
				//if indexes i and j are equal increment j by 1 to ensure different candidate vectors are used
				j++;
			}
			candidateB = this.candidates.get(j);
		} else {
			//else we have inferior discarded candidates and can randomly select one
			i = Population.rng.nextInt(this.inferiorCandidates.size());
			candidateB = this.inferiorCandidates.get(i);
		}
		//randomly select a real var to mutate
		i = Population.rng.nextInt(this.realIndexes.length);
		int k = this.realIndexes[i];
		//new value for this parameter is the old value plus a scaled sum of the difference between best and target and the difference between random current and random old
		newC.policyMix[k] = newC.policyMix[k] + Main.scalingFactor * ((this.bestSolution.policyMix[k] - newC.policyMix[k]) + (candidateA.policyMix[k] - candidateB.policyMix[k]));
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
		CandidateSolution oldC = this.candidates.get(this.next());
		CandidateSolution newC = new CandidateSolution(oldC);
		//uniform randomly select another current candidate
		int i = Population.rng.nextInt(this.candidates.size());
		CandidateSolution candidateA = this.candidates.get(i);
		//uniform randomly select an inferior discarded candidate
		//if no discarded candidates yet, select another current candidate
		CandidateSolution candidateB = null;
		if (this.inferiorCandidates.size() == 0) {
			int j = Population.rng.nextInt(this.candidates.size());
			if (i == j) {
				//if indexes i and j are equal increment j by 1 to ensure different candidate vectors are used
				j++;
			}
			candidateB = this.candidates.get(j);
		} else {
			//else we have inferior discarded candidates and can randomly select one
			i = Population.rng.nextInt(this.inferiorCandidates.size());
			candidateB = this.inferiorCandidates.get(i);
		}
		//iterate through all real vars and mutate
		for (int x = 0; x < this.realIndexes.length; x++) {
			int k = this.realIndexes[x];
			//new value for this parameter is the old value plus a scaled sum of the difference between best and target and the difference between random current and random old
			newC.policyMix[k] = newC.policyMix[k] + Main.scalingFactor * ((this.bestSolution.policyMix[k] - newC.policyMix[k]) + (candidateA.policyMix[k] - candidateB.policyMix[k]));
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
		CandidateSolution oldC = this.candidates.get(this.next());
		CandidateSolution newC = new CandidateSolution(oldC);
		//uniform randomly select another current candidate
		int i = Population.rng.nextInt(this.candidates.size());
		CandidateSolution candidateA = this.candidates.get(i);
		//uniform randomly select an inferior discarded candidate
		//if no discarded candidates yet, select another current candidate
		CandidateSolution candidateB = null;
		if (this.inferiorCandidates.size() == 0) {
			int j = Population.rng.nextInt(this.candidates.size());
			if (i == j) {
				//if indexes i and j are equal increment j by 1 to ensure different candidate vectors are used
				j++;
			}
			candidateB = this.candidates.get(j);
		} else {
			//else we have inferior discarded candidates and can randomly select one
			i = Population.rng.nextInt(this.inferiorCandidates.size());
			candidateB = this.inferiorCandidates.get(i);
		}
		//randomly select a natural var to mutate
		i = Population.rng.nextInt(this.naturalIndexes.length);
		int k = this.naturalIndexes[i];
		//new value for this parameter is the old value plus the difference between best and target plus difference between random current and old
		newC.policyMix[k] = newC.policyMix[k] + ((this.bestSolution.policyMix[k] - newC.policyMix[k]) + (candidateA.policyMix[k] - candidateB.policyMix[k]));
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
		CandidateSolution oldC = this.candidates.get(this.next());
		CandidateSolution newC = new CandidateSolution(oldC);
		//uniform randomly select another current candidate
		int i = Population.rng.nextInt(this.candidates.size());
		CandidateSolution candidateA = this.candidates.get(i);
		//uniform randomly select an inferior discarded candidate
		//if no discarded candidates yet, select another current candidate
		CandidateSolution candidateB = null;
		if (this.inferiorCandidates.size() == 0) {
			int j = Population.rng.nextInt(this.candidates.size());
			if (i == j) {
				//if indexes i and j are equal increment j by 1 to ensure different candidate vectors are used
				j++;
			}
			candidateB = this.candidates.get(j);
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
				newC.policyMix[k] = newC.policyMix[k] + ((this.bestSolution.policyMix[k] - newC.policyMix[k]) + (candidateA.policyMix[k] - candidateB.policyMix[k]));
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
	 * Weighted random selection of two candidate solutions to crossover at any random breakpoint
	 */
	public void crossover1() {
		//weighted randomly select two candidate solutions
		CandidateSolution candidateA = this.candidates.get(this.next());
		CandidateSolution candidateB = this.candidates.get(this.next());
		//new candidate solution to be create by crossover
		CandidateSolution candidateNew = new CandidateSolution();
		//select a random index to split the vector
		int i = Population.rng.nextInt(Policies.allPolicies.length);
		//iterate through all policies and assign values from first target to indexes below breakpoint, second target above breakpoint
		for (int j = 0; j <= i; j++) {
			candidateNew.policyMix[j] = candidateA.policyMix[j];
		}
		for(int j = i + 1; j < Policies.allPolicies.length; j++) {
			candidateNew.policyMix[j] = candidateB.policyMix[j];
		}
		//evaluate the new Candidate solution's fitness
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
	 * Weighted random selection of two candidate solutions to crossover at any random breakpoint
	 */
	public void crossover2() {
		//weighted randomly select two candidate solutions
		CandidateSolution candidateA = this.candidates.get(this.next());
		CandidateSolution candidateB = this.candidates.get(this.next());
		//new candidate solution to be create by crossover
		CandidateSolution candidateNew = new CandidateSolution();
		//select a random category breakpoint to split the vector
		int k = Population.rng.nextInt(Policies.categoryIndexes.length);
		int i = Policies.categoryIndexes[k];
		//iterate through all policies and assign values from first target to indexes below breakpoint, second target above breakpoint
		for (int j = 0; j <= i; j++) {
			candidateNew.policyMix[j] = candidateA.policyMix[j];
		}
		for(int j = i + 1; j < Policies.allPolicies.length; j++) {
			candidateNew.policyMix[j] = candidateB.policyMix[j];
		}
		//evaluate the new Candidate solution's fitness
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
	 * cull the weakest members of the current candidate population to reduce current pop to init pop size
	 */
	public void cull() {
		
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
