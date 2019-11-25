/**
 * Class representing an individual policy
 *
 */
public class Policy {
	//instance variables
	protected String name;
	protected int dataType;
	protected double minValue;
	protected double maxValue;
	protected boolean isFixed = false;
	
	//constructor
	public Policy(String n, int dt, double min, double max) {
		this.name = n;
		this.dataType = dt;
		this.minValue = min;
		this.maxValue = max;
	}
	
	//methods 
	public void setIsFixed(boolean bool) {
		this.isFixed = bool;
	}
}
