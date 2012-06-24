//package methods;
//
//import main.EDO;
//
//public class NewtonRaphson {
// 
//	public static double execute(EDO edo,double erro1, double erro2, double Vant, double delta_tempo){
//		double x_k = Vant;
//	    double x_k_prox;
//	    while(1)
//	    {
//	        // x_k_prox = x_k - (fx / f'x):
//	        x_k_prox = x_k - (edo.df(x_k,delta_tempo,Vant) / edo.derivative(delta_tempo));
//	        // |f(x_k)| <= erro1:
//	        if (fabs(edo.df(Vant,x_k,delta_tempo)) <= erro1) break;
//	        // |x_k_prox - x_k| <= erro2:
//	        if (Math.abs(x_k_prox - x_k) <= erro2) break;
//	        x_k = x_k_prox;
//	    }
//	    return(x_k_prox);
//	}
//	
//}
