import java.util.Random;

/**
 * Class representing a candidate solution to the optimization problem
 * ie. it represents a specific policy mix and the fitness of that mix determined by
 * an (external) objective function
 */

public class CandidateSolution {
	//instance variables
	static public Random rng = new Random();
	public Gene[] policyMix = new Gene[Policies.allPolicies.length];
	public double fitness = 0.0;
	
	//constructors
	/**
	 * Create a new CandidateSolution with random values for all policy parameters
	 */
	public CandidateSolution() {
		//iterate through entire list of policies
		for (int i = 0; i < Policies.allPolicies.length; i++) {
			//if this policy is a boolean, randomly set to on (1.0) or off (0.0)
			if (Policies.allPolicies[i].dataType == Policies.bool) {
				if (CandidateSolution.rng.nextBoolean()) {
					this.policyMix[i] = new Gene(1.0, true);
				} else {
					this.policyMix[i] = new Gene(0.0, true);
				}
			} else if (Policies.allPolicies[i].dataType == Policies.natural) {
				//if it is a natural number policy set to a random natural number in range
				this.policyMix[i] = new Gene(rng.nextInt((int)(Policies.allPolicies[i].maxValue - Policies.allPolicies[i].minValue) + 1) + Policies.allPolicies[i].minValue, true);
			} else {
				//else it is a real number policy and set to a random real number in range
				this.policyMix[i] = new Gene(((Policies.allPolicies[i].maxValue - Policies.allPolicies[i].minValue) * CandidateSolution.rng.nextDouble()) + Policies.allPolicies[i].minValue, true);
			}
		}
	}
	
	//methods
	/**
	 * Print a candidate solution in a readable way
	 */
	public void printCandidateSolution() {
		System.out.println("Quality: " + this.fitness);
		for (int i = 0; i < Policies.allPolicies.length; i++) {
			System.out.println(Policies.allPolicies[i].name + " = " + this.policyMix[i].policyValue);
		}
	}
}
