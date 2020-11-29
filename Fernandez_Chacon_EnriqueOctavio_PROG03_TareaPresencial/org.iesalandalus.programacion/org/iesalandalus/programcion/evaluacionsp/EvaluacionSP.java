package org.iesalandalus.programcion.evaluacionsp;

public class EvaluacionSP {
	
	private static float PESO_PARTICIPACION=0.10f;
	private static float PESO_CUESTIONARIOS=0.05f;
	private static float PESO_TAREAS_ONLINE=0.25f;
	private static float PESO_TAREAS_PRESENCIALES=0.25f;
	private static float PESO_EXAMEN=0.35f;
	private static float CALIFICACION_ALGUN_INSTRUMENTO_OBLIGATORIO_NO_SUPERADO=4f;
	private static float CALIFICACION_CORTE=4f;
	private String nombre;
	
	private Instrumento participacion;
	private Instrumento cuestionarios;
	private Instrumento tareasOnline;
	private Instrumento tareasPresenciales;
	private Instrumento examen;

	
	public EvaluacionSP(String nombre) throws IllegalArgumentException,NullPointerException {
		setNombre(nombre);
		participacion=new Instrumento("participacion", PESO_PARTICIPACION);
		cuestionarios=new Instrumento("cuestionarios", PESO_CUESTIONARIOS);
		tareasOnline=new Instrumento("tareasOnline", PESO_TAREAS_ONLINE);
		tareasPresenciales=new Instrumento("tareasPresenciales", PESO_TAREAS_PRESENCIALES);
		examen=new Instrumento("examen", PESO_EXAMEN);
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		if(nombre==null) {
			throw new NullPointerException("ERROR: El valor del nombre de la asignatura no puede ser null.");
		}else {
			this.nombre = nombre;
		}
		
	}

	public Instrumento getParticipacion() {
		return participacion;
	}

	public Instrumento getCuestionarios() {
		return cuestionarios;
	}

	public Instrumento getTareasOnline() {
		return tareasOnline;
	}

	public Instrumento getTareasPresenciales() {
		return tareasPresenciales;
	}

	public Instrumento getExamen() {
		return examen;
	}
	
	public float getCalificacion() {
		float notaExamen, notaTareaOnline, notaTareaPresencial, notaCuestionarios, notaParticipacion, notaFinal;
		notaExamen=examen.getCalificacionPonderada();
		notaTareaOnline=tareasOnline.getCalificacionPonderada();
		notaTareaPresencial=tareasPresenciales.getCalificacionPonderada();
		notaCuestionarios=cuestionarios.getCalificacionPonderada();
		notaParticipacion=participacion.getCalificacionPonderada();
		notaFinal=notaExamen+notaTareaOnline+notaTareaPresencial+notaParticipacion+notaCuestionarios;
		boolean importantesAprobadas=superaInstrumentosObligatorios();
		
		if(importantesAprobadas==true) {
			return notaFinal;
		}else{
			boolean superaCorte=superaCalificacion(notaFinal);
			if(superaCorte==true) {
				notaFinal=CALIFICACION_ALGUN_INSTRUMENTO_OBLIGATORIO_NO_SUPERADO;
				return notaFinal;
			}else {
				return notaFinal;
			}
		}
		
		
	}
	
	public Resultado getResultado() {
		float notaFinal=getCalificacion();
		if(notaFinal>=5) {
			return Resultado.APROBADO;
		}else {
			return Resultado.SUSPENSO;
		}
	}
	
	private boolean superaCalificacion(float nota) {
		if(nota>CALIFICACION_CORTE) {
			return true;
		}else {
			return false;
		}
	}
	
	private boolean superaInstrumentosObligatorios() {
		float notaExamen, notaTareaOnline,notaTareaPresencial;
		notaExamen=examen.getCalificacion();
		notaTareaOnline=tareasOnline.getCalificacion();
		notaTareaPresencial=tareasPresenciales.getCalificacion();
		if(notaExamen>=5&&notaTareaOnline>=5&&notaTareaPresencial>=5) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Su nota = " + getCalificacion() + ", Estado = " + getResultado() + "]";
	}
	
	
	
}
