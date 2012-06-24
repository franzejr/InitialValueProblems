package main;

/*
 * Class that represents an EDO
 * 
 */
public class EDO {
	
	
	/*
	 * Initial Value
	 */
	private double initialValue = 0.08;
	/*
	 * Ordinary Differential Equation
	 */
	public double df(double t, double y) {
		double g = 9.80665;
		double retorno = ( (64.0/1000)*(Math.sqrt(2*g*y)) )/(Math.pow(y, 2));
		return retorno;
	}
	/*
	 * Derivative
	 */
	public double derivative(double y){
		double g = 9.80665;
		return -0.135765*Math.sqrt(g*y)/(y*y*y);
	}

	public double getInitialValue() {
		return initialValue;
	}
	
	public void setInitialValue(double initialValue) {
		this.initialValue = initialValue;
	}
	
	

}
