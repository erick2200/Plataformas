package proyecto.recursos;

public class Matricula {
	private int idmatricula;
	private String fecha;
	private int fk_cui;
	
	public Matricula(int idmatricula, String fecha, int fk_cui) {
		super();
		this.idmatricula = idmatricula;
		this.fecha = fecha;
		this.fk_cui = fk_cui;
	}

	public int getIdmatricula() {
		return idmatricula;
	}

	public void setIdmatricula(int idmatricula) {
		this.idmatricula = idmatricula;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getFk_cui() {
		return fk_cui;
	}

	public void setFk_cui(int fk_cui) {
		this.fk_cui = fk_cui;
	}
	
}
