

public class Main {
	//instance variables
	static protected double scalingFactor = 0.5;
	static protected double crossoverRate = 0.5;
	protected int nGenerations = 10;

	public static void main(String[] args) throws InterruptedException {
		Population testpop = new Population();
		System.out.println("Best solution fitness: " + testpop.bestSolution.fitness);
		for (int i = 0; i < 10; i++) {
			testpop.booleanMutate();
			System.out.println("Best solution fitness: " + testpop.bestSolution.fitness);
		}
	}
}
