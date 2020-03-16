import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	//instance variables
	static protected int initPop = 0;
	static protected int maxPop = 0;
	static protected int nGenerations = 0;
	static protected double scalingFactor = 0.75;
	static protected double envWeight = 0;
	static protected double econWeight = 0;
	static protected ArrayList<Integer> disabledIndexes = new ArrayList<>();

	public static void main(String[] args) throws InterruptedException {
		//read from user input file
		String filename = args[0];
		try {
			BufferedReader inputStream = new BufferedReader(new FileReader(filename));
			initPop = Integer.parseInt(inputStream.readLine());
			maxPop = Integer.parseInt(inputStream.readLine());
			nGenerations = Integer.parseInt(inputStream.readLine());
			envWeight = Double.parseDouble(inputStream.readLine());
			econWeight = Double.parseDouble(inputStream.readLine());
			String line = null;
			while ((line = inputStream.readLine()) != null) {
				disabledIndexes.add(Integer.parseInt(line));
			}
			inputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//disable policies selected by the user
		for(Integer i : disabledIndexes) {
			Policies.allPolicies[i].setIsFixed(true);
		}
		
		//initialize random population
		Population testpop = new Population(initPop, maxPop);
		System.out.println("Best solution fitness: " + testpop.bestSolution.fitness);
		
		//set up values that cap number of applications of a given extension rule
		int maxCrossover = (maxPop - initPop + 1)/2 + 1;
		int maxMutate = (maxPop - initPop + 1)/5 + 1;
		int nCrossover1 = 0;
		int nCrossover2 = 0;
		int nMutateBool = 0;
		int nMutateRealOne = 0;
		int nMutateRealAll = 0;
		int nMutateNatOne = 0;
		int nMutateNatAll = 0;
		
		//iterate over given number of generations
		for (int i = 0; i < Main.nGenerations; i++) {
			//each generation keep track of applications of each rule
			nCrossover1 = 0;
			nCrossover2 = 0;
			nMutateBool = 0;
			nMutateRealOne = 0;
			nMutateRealAll = 0;
			nMutateNatOne = 0;
			nMutateNatAll = 0;

			//each generation consists of a series of mutations/crossovers until max pop threshold is breached
			while (testpop.currentPop <= testpop.maxPop) {
				//select random mutation
				int nextExt = Population.rng.nextInt(100);
				//have random value determine rule to apply as long as max for that rule not exceeded
				if ((nextExt < 25) && (nCrossover1 <= maxCrossover)) {
					testpop.crossover1();
					nCrossover1++;
				} else if ((nextExt < 50) && (nCrossover2 <= maxCrossover)) {
					testpop.crossover2();
					nCrossover2++;
				} else if ((nextExt < 60) && (nMutateBool <= maxMutate)) {
					testpop.booleanMutate();
					nMutateBool++;
				} else if ((nextExt < 70) && (nMutateRealOne <= maxMutate)) {
					testpop.realSingleMutate();
					nMutateRealOne++;
				} else if ((nextExt < 80) && (nMutateRealAll <= maxMutate)) {
					testpop.realAllMutate();
					nMutateRealAll++;
				} else if ((nextExt < 90) && (nMutateNatOne <= maxMutate)) {
					testpop.naturalSingleMutate();
					nMutateNatOne++;
				} else {
					testpop.naturalAllMutate();
					nMutateNatAll++;
				}
			}
			//cull weakest candidates
			testpop.cull();
			//adjust mutation factor
			if( (i > 0) && ((i % (Main.nGenerations/5)) == 0) ) {
				scalingFactor -= (scalingFactor/5.0);
			}
		}
		//output best solution found
		System.out.println("Best solution fitness: " + testpop.bestSolution.fitness);
		testpop.bestSolution.printCandidateSolution();
	}
}
