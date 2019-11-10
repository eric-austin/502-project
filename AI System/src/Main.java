

public class Main {

	public static void main(String[] args) {
		Population test = new Population();
		for(CandidateSolution c : test.candidates) {
			c.printCandidateSolution();
			System.out.println("\n\n");
		}
	}
}
