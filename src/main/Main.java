package main;

import methods.EDOSolver;
import methods.Euler;
import methods.PredictorCorrector;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double discretValue = 0.00001;
		int numPoints = (int)(4.92/discretValue);
		
//		RungeKutta rk = new RungeKutta();
		//EDOSolver rk2 = new RungeKutta();
//		EDO edo = new EDO();
		Euler euler = new Euler();
		//ss.modified(discreteValue);
//		EDOSolver euler = new Euler();
		//euler.forward(discretValue,numPoints);
		euler.backward(discretValue,numPoints);
		//euler.backward(edo, 0.01);
		//euler.modified(edo, 0.01);
//		double result[] = rk.solve(0.01);
		
		
////		/*Testing Predictor-Corrector */
//		PredictorCorrector predictorCorrector = new PredictorCorrector();
//		double result[] = predictorCorrector.execute(discretValue, numPoints);
//		
//		for (double r : result) {
//			System.out.println(r +"\n");
//		}
//		
//		MainFrame m = new MainFrame();
//		m.setVisible(true);

	}

}
