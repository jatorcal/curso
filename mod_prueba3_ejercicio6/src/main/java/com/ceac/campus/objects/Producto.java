package com.ceac.campus.objects;

// Crea la clase producto con las propiedades y el constructor que permita inicializar con todos los campos.s
public class Producto {

	public int code;

	public String descripcion;

	public float peso;

	public Producto() {
		
	}
	
	public Producto(int code, String description, float peso) {
		setCode(code);
		setDescripcion(description);
		setPeso(peso);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

}
