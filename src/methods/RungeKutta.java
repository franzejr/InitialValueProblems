package methods;

import main.EDO;

public class RungeKutta implements EDOSolver {
	
	public double[] solve(double discretValue) {
		double k1, k2, k3;
		
		double[] result = new double[1000];
		result[0] = edo.getInitialValue();
		double t = 0;
		System.out.println(result[0]);
		for (int i = 1; i < 1000; i++) {
			k1 = result[i-1] + (discretValue/3)*(edo.df(t, result[i-1]));
			k2 = result[i-1] + 2*(discretValue/3)*(edo.df(t, result[i-1]));
			k3 = result[i-1] + (discretValue)*(edo.df(t, result[i-1]));
			
			
			result[i] = ( result[i-1] +
						3*discretValue/8*(
								edo.df(t, result[i-1])
								+3*(edo.df(t+discretValue/3, k1))
								+3*(edo.df(t+2*discretValue/3, k2))
								+edo.df(t+discretValue, k3)
								)						
						);
			t += discretValue;
			System.out.println(result[i]);
		}
		return result;
	}

}
