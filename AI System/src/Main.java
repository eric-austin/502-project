import java.io.IOException;

public class Main {
	
	public static void runVensim() {
		try {
			Process pb = new ProcessBuilder("C:\\Program Files\\Vensim\\vendss64.exe", "..\\eps-1.4.2-alberta\\commandscript.cmd").start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Population testpop = new Population();
		runVensim();
	}
}
