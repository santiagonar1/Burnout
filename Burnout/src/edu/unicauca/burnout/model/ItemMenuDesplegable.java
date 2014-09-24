package edu.unicauca.burnout.model;

public class ItemMenuDesplegable {
	
	private String titulo;
	private int icono;
	
	public ItemMenuDesplegable(){
	}
	
	public ItemMenuDesplegable(String titulo, int icono) {
		this.titulo = titulo;
		this.icono = icono;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getIcono() {
		return icono;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setIcono(int icono) {
		this.icono = icono;
	}
	
	

}
