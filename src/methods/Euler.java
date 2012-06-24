package methods;

import main.EDO;

public class Euler implements EDOSolver {


	/*
	 * Explicit - so we can only put the formula
	 */
	public double[] forward(double discretValue, int numDisc) {
		double[] result = new double[numDisc];
		result[0] = edo.getInitialValue();
		double t = 0;
		//System.out.println(result[0]);
		for (int i = 1; i < numDisc; i++) {
			result[i] = result[i-1] + discretValue*edo.df(t, result[i-1]);
			t += discretValue;
			//System.out.println(result[i]);
		}
		
		return result;
	}

	/*
	 * Implicit - we must to use newton raphson
	 */
	public double[] backward(double discretValue,int numPoints) {
		
		
		double atual, anterior;
		
		double[] result = new double[numPoints];
		result[0] = edo.getInitialValue();
		
		double t = 0;
		
		t += discretValue;
		System.out.println(result[0]);
		int entrou = 0;
		for (int i = 1; i < numPoints; i+= discretValue) {
			
			//System.out.println(result[i]);
		}
		return result;
	}

	/*
	 * Implicit - so we must to use newton raphson
	 */
	public double[] modified(double discretValue, int numPoints) {
		double[] result = new double[numPoints];
		result[0] = edo.getInitialValue();
		double t = 0;
		//System.out.println(result[0]);
		for (int i = 1; i < numPoints; i++) {
			result[i] = ( result[i-1] + 
					      (discretValue/2)* 
					      ( 7*Math.exp(-0.5*(t+discretValue)) + 7*Math.exp(-0.5*(t)) -20*result[i-1] )   
					    )					
					    /
					    (1+10*discretValue);
			t += discretValue;
			//System.out.println(result[i]);
		}
		return result;
	}

}
