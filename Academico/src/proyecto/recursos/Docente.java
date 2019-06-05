package proyecto.recursos;

public class Docente {
	
	int cud;
	String nombre;
	String apellido;
	String grado_academico;
	
	public Docente(int cud,String nombre,String apellido,String grado_academico) {
		this.cud=cud;
		this.nombre=nombre;
		this.apellido=apellido;
		this.grado_academico=grado_academico;
	}

	public int getCud() {
		return cud;
	}

	public void setCud(int cud) {
		this.cud = cud;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getGrado_academico() {
		return grado_academico;
	}

	public void setGrado_academico(String grado_academico) {
		this.grado_academico = grado_academico;
	}
	
}