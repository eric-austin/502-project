import java.io.IOException;
import java.util.Random;

/**
 * Class representing a population of candidate solutions
 * used to find optimal solution to problem
 *
 */
public class Population {
	//instance variables
	protected int popSize = 10;
	static protected Random rng = new Random();
	protected CandidateSolution[] candidates = new CandidateSolution[popSize];
	
	//constructors
	public Population() throws InterruptedException {
		for(int i = 0; i < popSize; i++) {
			this.candidates[i] = new CandidateSolution();
			this.candidates[i].writeCommandFile();
			Population.runVensim();
			Thread.sleep(5000);
			this.candidates[i].evaluateFitness();
		}
	}
	
	//methods
	/**
	 * calls the vensim simulator
	 */
	public static void runVensim() {
		try {
			Process pb = new ProcessBuilder("C:\\Program Files\\Vensim\\vendss64.exe", "..\\eps-1.4.2-alberta\\commandscript.cmd").start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
