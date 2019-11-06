/**
 * Class representing an individual policy
 *
 */
public class Policy {
	//instance variables
	public String name;
	public int dataType;
	public double minValue;
	public double maxValue;
	
	//constructor
	public Policy(String n, int dt, double min, double max) {
		this.name = n;
		this.dataType = dt;
		this.minValue = min;
		this.maxValue = max;
	}
}
