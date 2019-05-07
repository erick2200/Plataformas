package erick.pruebas;

public class Estudiante {

	private int id;
	
	private int edad;
	
	private String nombre;

	public Estudiante() {
		this.id = 0;
		this.edad = 0;
		this.nombre = "";
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
