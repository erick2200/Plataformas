package proyecto.recursos;

public class Silabo {
	private int id_silabo;
	private int fk_casi;
	private String contenido;
	private String fecha;
	
	
	public Silabo(int id_silabo, int fk_casi, String contenido, String fecha) {
		this.id_silabo = id_silabo;
		this.fk_casi = fk_casi;
		this.contenido = contenido;
		this.fecha = fecha;
	}

	public int getId_silabo() {
		return id_silabo;
	}

	public void setId_silabo(int id_silabo) {
		this.id_silabo = id_silabo;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getFk_casi() {
		return fk_casi;
	}

	public void setFk_casi(int fk_casi) {
		this.fk_casi = fk_casi;
	}
	
	
	
}