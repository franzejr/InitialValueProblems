package methods;

public class PredictorCorrector implements EDOSolver {
	
	public double[] execute(double discretValue,int numDisc){
		double t = 0.0;
		
		RungeKutta rk = new RungeKutta();
		double[] initialPoints = rk.solve(discretValue, numDisc);
		
		//Instanciando um novo vetor de resultados
		double result[] = new double[numDisc];
		
		//Inicializando os 3 primeiros pontos
		result[0] = initialPoints[0];
		t += discretValue;
		result[1] = initialPoints[1];
		t += discretValue;
		result[2] = initialPoints[2];
	
		double un_mais1;
		double un,un_menos1,un_menos2;
		double preditor;
		double corretor = 0.0;
		
		double corretorAntigo;
		
		for(int i = 2; i < result.length -1 ; i++, t += discretValue ){
			
			/*Fase Preditora */
			
			       un = edo.df(t,result[i]);
			un_menos1 = edo.df(t - discretValue,result[i-1]);
		
			un_menos2 = edo.df(t - 2*discretValue,result[i-2] );
			
			//Aplicando a formula preditora
			preditor = result[i] + (discretValue/12)*( 23*un - 16*un_menos1 + 5*un_menos2);
			
			//Inicializacao da fase corretora
			corretorAntigo = preditor;
			/* Fase Corretora */
			
			do{
				 un_mais1 = edo.df(t+discretValue,corretorAntigo);
				
				//Aplicando a formula
				corretor = result[i] + (discretValue/12)*( 5*un_mais1 + 8*un - un_menos1);
				//Salvando o corretor antigo
				corretorAntigo = corretor;
				
				
			}while(Math.abs(corretorAntigo-corretor) > 0.00000000001);
			
			result[i+1] = corretor;
			//System.out.println(result[i+1]);
		}
		
		return result;
		
	}

}
