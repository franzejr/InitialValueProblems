package methods;

import main.EDO;

public class NewtonRaphson {
 
	/* Backward Euler */
	
	public static double backwardEq(EDO edo,double estimated, double current, double t, double discretValue){
		//t = t_n+1
		return current - estimated + discretValue*edo.df(t,estimated);
	}
	
	public static double backwardDeriv(EDO edo,double estimated, double tn, double discretValue){
		return -1 + discretValue*edo.derivative(estimated);
	}
	
	public static double backward(EDO edo,double error1, double error2, double u_n,double discretValue){
		double x_k = u_n;
	    double x_k_prox,t=0.0;
	    
	    while(true)
	    {
	        // x_k_prox = x_k - (fx / f'x):
	        x_k_prox = x_k - (backwardEq(edo,x_k,u_n,t, discretValue) / backwardDeriv(edo,x_k, t, discretValue));
	        // |f(x_k)| <= erro1:
	        if (Math.abs(backwardDeriv(edo, x_k, t, discretValue)) <= error1) break;
	        // |x_k_prox - x_k| <= erro2:
	        if (Math.abs(x_k_prox - x_k) <= error2) break;
	        x_k = x_k_prox;
	    }
	    return(x_k_prox);
	}
	
	
	
	/* Modified Euler */
	
	public static double modifiedEq(EDO edo,double estimated, double current, double t, double discretValue){
		//t = t_n+1
		return current - estimated + (discretValue/2)*(edo.df(t,estimated) + edo.df(t - discretValue,current));
	}
	
	public static double modifiedDeriv(EDO edo,double estimated, double tn, double discretValue){
		return -1 + (discretValue/2)*edo.derivative(estimated);
	}
	
	public static double modified(EDO edo,double error1, double error2, double u_n,double discretValue){
		double x_k = u_n;
	    double x_k_prox,t=0.0;
	    
	    while(true)
	    {
	        // x_k_prox = x_k - (fx / f'x):
	        x_k_prox = x_k - (modifiedEq(edo,x_k,u_n,t, discretValue) / modifiedDeriv(edo,x_k, t, discretValue));
	        // |f(x_k)| <= erro1:
	        if (Math.abs(modifiedDeriv(edo, x_k, t, discretValue)) <= error1) break;
	        // |x_k_prox - x_k| <= erro2:
	        if (Math.abs(x_k_prox - x_k) <= error2) break;
	        x_k = x_k_prox;
	    }
	    return(x_k_prox);
	}
	
}
