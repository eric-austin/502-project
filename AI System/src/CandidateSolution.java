import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Class representing a candidate solution to the optimization problem
 * ie. it represents a specific policy mix and the fitness of that mix determined by
 * an (external) objective function
 */

public class CandidateSolution {
	//instance variables
	public double[] policyMix = new double[Policies.allPolicies.length];
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
				if (Population.rng.nextBoolean()) {
					this.policyMix[i] = 1.0;
				} else {
					this.policyMix[i] = 0.0;
				}
			} else if (Policies.allPolicies[i].dataType == Policies.natural) {
				//if it is a natural number policy set to a random natural number in range
				this.policyMix[i] = Population.rng.nextInt((int)(Policies.allPolicies[i].maxValue - Policies.allPolicies[i].minValue) + 1) + Policies.allPolicies[i].minValue;
			} else {
				//else it is a real number policy and set to a random real number in range
				this.policyMix[i] = ((Policies.allPolicies[i].maxValue - Policies.allPolicies[i].minValue) * Population.rng.nextDouble()) + Policies.allPolicies[i].minValue;
			}
		}
	}
	
	//methods
	/**
	 * creates a cmd file for Vensim DSS to run a simulation using the policy settings of the 
	 * CandidateSolution
	 */
	public void writeCommandFile() {
		try {
			//create a buffered writer to write command file
			BufferedWriter outputStream = new BufferedWriter(new FileWriter("..\\eps-1.4.2-alberta\\commandscript.cmd"));
			//set up simulation
			String line = "SPECIAL>NOINTERACTION\n";
			outputStream.write(line);
			line = "SPECIAL>LOADMODEL|EPS.mdl\n";
			outputStream.write(line);
			line = "SIMULATE>RUNNAME|CurrentRun\n";
			outputStream.write(line);
			//iterate through all the policies and write values for those that aren't fixed off
			for (int i = 0; i < Policies.allPolicies.length; i++) {
				if (!Policies.allPolicies[i].isFixed) {
					line = "SIMULATE>SETVAL|" + Policies.allPolicies[i].name + "=" + this.policyMix[i] + "\n";
					outputStream.write(line);
				}
			}
			//run simulation
			line = "MENU>RUN|O\n";
			outputStream.write(line);
			line = "MENU>VDF2CSV|CurrentRun.vdf|RunResults.csv|OutputVarsToExport.lst\n";
			outputStream.write(line);
			line = "MENU>EXIT";
			outputStream.write(line);
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * Print a candidate solution in a readable way
	 */
	public void printCandidateSolution() {
		System.out.println("Quality: " + this.fitness);
		for (int i = 0; i < Policies.allPolicies.length; i++) {
			System.out.println(Policies.allPolicies[i].name + " = " + this.policyMix[i]);
		}
	}
}
