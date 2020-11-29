package org.iesalandalus.programcion.evaluacionsp;

import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

	private Consola() {
		
	}
	
	private static void leerCalificacionesInstrumento(Instrumento instrumento) throws IllegalArgumentException {
		float i=10.1f;
		do {
			System.out.print("Introduzca la nota de "+ instrumento.getNombre()+": ");
			i=Entrada.real();
			System.out.println();
		}while(i<0&&i>10);
		instrumento.setCalificacion(i);
	}
	
	public static void leerCalificacionesEvaluacionSP(EvaluacionSP evaluacion) {
		System.out.println("-------------------");
		System.out.println("CALCULADORA DE NOTA");
		System.out.println("-------------------\n");
		leerCalificacionesInstrumento(evaluacion.getParticipacion());
		leerCalificacionesInstrumento(evaluacion.getCuestionarios());
		leerCalificacionesInstrumento(evaluacion.getTareasOnline());
		leerCalificacionesInstrumento(evaluacion.getTareasPresenciales());
		leerCalificacionesInstrumento(evaluacion.getExamen());
	}
	
	
}
