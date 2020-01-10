

public class Main {
	//instance variables
	static protected int initPopSize = 20;
	static protected int currentPopSize = 20;
	static protected int maxPopSize = 50;
	static protected double scalingFactor = 0.5;
	static protected double crossoverRate = 0.5;
	static protected int nGenerations = 10;
	static protected double rateReductionFactor = 0.95;

	public static void main(String[] args) throws InterruptedException {
		//initialize random population
		Population testpop = new Population();
		System.out.println("Best solution fitness: " + testpop.bestSolution.fitness);
		//iterate over given number of generations
		for (int i = 0; i < Main.nGenerations; i++) {
			//each generation consists of a series of mutations/crossovers until max pop threshold is breached
			while (Main.currentPopSize <= Main.maxPopSize) {
				testpop.booleanMutate();
				testpop.realSingleMutate();
				testpop.realAllMutate();
				testpop.naturalSingleMutate();
				testpop.naturalAllMutate();
				testpop.crossover();
			}
			//cull weakest candidates
			
		}
	}
}
