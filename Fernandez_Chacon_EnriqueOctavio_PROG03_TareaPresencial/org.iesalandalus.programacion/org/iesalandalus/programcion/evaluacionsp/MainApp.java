package org.iesalandalus.programcion.evaluacionsp;

public class MainApp {
	
	private static EvaluacionSP primeraEvaluacion;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			primeraEvaluacion=new EvaluacionSP("primeraEvaluacion");
			Consola.leerCalificacionesEvaluacionSP(primeraEvaluacion);
			System.out.println(primeraEvaluacion);
		}catch(NullPointerException | IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
