/**
 * Class represents an element of the vector representing the policy mix of 
 * a candidate solution
 *
 */
public class Gene {
	//instance variables
	public double policyValue;
	public Boolean modifiable;

	//constuctor
	public Gene(double val, Boolean bool) {
		this.policyValue = val;
		this.modifiable = bool;
	}
}
