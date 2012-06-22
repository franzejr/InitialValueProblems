package methods;

import main.EDO;

public class Euler implements EDOSolver {


	/*
	 * Explicit
	 */
	public double[] forward(double discretValue, int numDisc) {
		double[] result = new double[numDisc];
		result[0] = edo.getInitialValue();
		double t = 0;
		System.out.println(result[0]);
		for (int i = 1; i < numDisc; i++) {
			result[i] = result[i-1] + discretValue*edo.df(t, result[i-1]);
			t += discretValue;
			System.out.println(result[i]);
		}
		
		return result;
	}

	/*
	 * Implicit
	 */
	public double[] backward(double discretValue,int numPoints) {
		
		
		double atual, anterior;
		
		double[] result = new double[numPoints];
		result[0] = edo.getInitialValue();
		double t = 0;
		t += discretValue;
		System.out.println(result[0]);
		int entrou = 0;
		for (int i = 1; i < numPoints; i++) {
			anterior = result[i-1];
			do{
				atual = result[i-1] + discretValue*edo.df(anterior, t);
				anterior = atual;
				entrou++;
				System.out.println("entrou:"+entrou);
			}while(Math.abs(atual - anterior)>0.0001);
			result[i] = atual;
			t += discretValue;
			System.out.println(result[i]);
		}
		return result;
	}

	/*
	 * Implicit
	 */
	public double[] modified(double discretValue) {
		double[] result = new double[100];
		result[0] = edo.getInitialValue();
		double t = 0;
		System.out.println(result[0]);
		for (int i = 1; i < 100; i++) {
			result[i] = ( result[i-1] + 
					      (discretValue/2)* 
					      ( 7*Math.exp(-0.5*(t+discretValue)) + 7*Math.exp(-0.5*(t)) -20*result[i-1] )   
					    )					
					    /
					    (1+10*discretValue);
			t += discretValue;
			System.out.println(result[i]);
		}
		return result;
	}

}
