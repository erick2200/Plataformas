package proyecto.recursos;

public class Asistencia{
	private int id_asistencia;
	private int fk_grupo;
	private boolean asistencia_profesor;
	private String fecha;
	
	public Asistencia(int id_asistencia,int fk_grupo,boolean asistencia_profesor,String fecha) {
		this.id_asistencia=id_asistencia;
		this.fk_grupo=fk_grupo;
		this.asistencia_profesor=asistencia_profesor;
		this.fecha=fecha;
	}

	public int getId_asistencia() {
		return id_asistencia;
	}

	public void setId_asistencia(int id_asistencia) {
		this.id_asistencia = id_asistencia;
	}

	public boolean getAsistencia_profesor() {
		return asistencia_profesor;
	}

	public void setAsistencia_profesor(boolean asistencia_profesor) {
		this.asistencia_profesor = asistencia_profesor;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getFk_grupo() {
		return fk_grupo;
	}

	public void setFk_grupo(int fk_grupo) {
		this.fk_grupo = fk_grupo;
	}
	
}
