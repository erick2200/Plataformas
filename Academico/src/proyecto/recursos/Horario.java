package proyecto.recursos;

public class Horario {
	private int id_horario;
	private int fk_grupo;
	
	public Horario(int id_horario, int fk_grupo) {
		super();
		this.id_horario = id_horario;
		this.fk_grupo = fk_grupo;
	}

	public int getId_horario() {
		return id_horario;
	}

	public void setId_horario(int id_horario) {
		this.id_horario = id_horario;
	}

	public int getFk_grupo() {
		return fk_grupo;
	}

	public void setFk_grupo(int fk_grupo) {
		this.fk_grupo = fk_grupo;
	}
	
	
	
}