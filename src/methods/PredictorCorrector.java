package methods;

public class PredictorCorrector implements EDOSolver {

	public double[] initialize(double discretValue,int numDisc) {
		double k1, k2, k3;

		double[] result = new double[numDisc];
		result[0] = edo.getInitialValue();
		double t = 0;
		//System.out.println(result[0]);
		for (int i = 1; i < result.length ; i++) {
			
			k1 = result[i - 1] + (discretValue / 3)
					* (edo.df(t, result[i - 1]));
			
			k2 = result[i - 1] + 2 * (discretValue / 3)
					* (edo.df(t, result[i - 1]));
			
			k3 = result[i - 1] + (discretValue) * (edo.df(t, result[i - 1]));

			result[i] = (result[i - 1] + 3
					* discretValue
					/ 8
					* (edo.df(t, result[i - 1]) + 3
							* (edo.df(t + discretValue / 3, k1)) + 3
							* (edo.df(t + 2 * discretValue / 3, k2)) + edo.df(t
							+ discretValue, k3)));
			
			t += discretValue;
			
			//System.out.println(result[i]);
		}
		return result;
	}
	
	public double[] execute(double discretValue,int numDisc){
		double t = 0.0;
		double[] initialPoints = initialize(discretValue, numDisc);
		
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
			int entrou = 0;
			
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
				
				entrou++;
				
			}while(Math.abs(corretorAntigo-corretor) > 0.00000000001);
			
			System.out.println("entrou:"+entrou);
			result[i+1] = corretor;
			System.out.println("result: "+result[i+1]+"disc.: "+ (t+discretValue));
		}
		
		return result;
		
	}

}
