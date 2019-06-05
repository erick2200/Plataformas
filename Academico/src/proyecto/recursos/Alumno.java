package proyecto.recursos;

public class Alumno {
	private int cui;
	private String nombre;
	private String apellido;
	private int edad;
	private String sexo;
	
	
	public Alumno() {}
	
	public Alumno(int cui,String nombre,String apellido,int edad,String sexo) {
		this.cui=cui;
		this.nombre=nombre;
		this.apellido=apellido;
		this.edad=edad;
		this.sexo=sexo;
	}

	public int getCui() {
		return cui;
	}

	public void setCui(int cui) {
		this.cui = cui;
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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	
}