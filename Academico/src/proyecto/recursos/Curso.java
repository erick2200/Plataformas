package proyecto.recursos;

public class Curso {
	private int casi;
	private String nombre;
	private int creditos;
	private String categoria;
	private int h_teoricas;
	private int h_practicas;
	private String descripcion;
	
	public Curso(int casi, String nombre, int creditos, String categoria, int h_teoricas, int h_practicas,String descripcion) {
		this.casi = casi;
		this.nombre = nombre;
		this.creditos = creditos;
		this.categoria = categoria;
		this.h_teoricas = h_teoricas;
		this.h_practicas = h_practicas;
		this.descripcion = descripcion;
	}
	public int getCasi() {
		return casi;
	}
	public void setCasi(int casi) {
		this.casi = casi;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCreditos() {
		return creditos;
	}
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getH_teoricas() {
		return h_teoricas;
	}
	public void setH_teoricas(int h_teoricas) {
		this.h_teoricas = h_teoricas;
	}
	public int getH_practicas() {
		return h_practicas;
	}
	public void setH_practicas(int h_practicas) {
		this.h_practicas = h_practicas;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
