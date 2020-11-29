package org.iesalandalus.programcion.evaluacionsp;

public class Instrumento {
	
	private static float PESO_MAXIMO=0.35f;
	private static float PESO_MINIMO=0.05f;
	private static float CALIFICACION_MINIMA=0;
	private static float CALIFICACION_MAXIMA=10;
	private String nombre;
	private float peso;
	private float calificacion;
	
	public Instrumento(String nombre,float peso){
		setNombre(nombre);
		setPeso(peso);
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		if(nombre==null){
			throw new NullPointerException("ERROR: El valor del nombre de la asignatura no puede ser null.");
		}else{
			this.nombre = nombre;
		}
	}

	public float getPeso() {
		return peso;
	}

	private void setPeso(float peso) {
		if(peso<PESO_MINIMO||peso>PESO_MAXIMO){
			throw new IllegalArgumentException("ERROR: El peso de la asignatura no se encuentra en el rango de valores.");
		}else {
			this.peso = peso;
		}
	}

	public float getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(float calificacion) {
		if(calificacion<CALIFICACION_MINIMA||calificacion>CALIFICACION_MAXIMA) {
			throw new IllegalArgumentException("ERROR: La calificacion no es válida.");
		}else {
			this.calificacion = calificacion;
		}
		
	}
	
	public float getCalificacionPonderada() {
		float calificacionPonderada=calificacion*peso;
		return calificacionPonderada;
	}

	@Override
	public String toString() {
		return "Instrumento [nombre=" + nombre + ", peso=" + peso + ", calificacion=" + calificacion + "]";
	}
	
	
	
}
