package main;

import methods.EDOSolver;
import methods.Euler;
import methods.PredictorCorrector;
import methods.RungeKutta;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*Discret Value and number of points */
		double discretValue = 0.01;
		int numPoints = (int) (4.92/discretValue) + 1;
		double[] result;
		
		/*Testing Euler Methods */
		Euler euler = new Euler();
		
			/*Forward */
			result = euler.forward(discretValue, numPoints);
			
			/*Backward */
			//result = euler.backward(discretValue, numPoints);
			
			/*Modified */
			//result = euler.modified(discretValue, numPoints);
		
		/*Testing Runge-Kutta */
			
			RungeKutta rk = new RungeKutta();
			//result = rk.solve(discretValue, numPoints);
		
		/*Testing Predictor-Corrector */
			PredictorCorrector predictorCorrector = new PredictorCorrector();
			//result = predictorCorrector.execute(discretValue, numPoints);
			
		/*Printing */
		for (double r : result) {
			System.out.println(r +"\n");
		}
	

	}

}
