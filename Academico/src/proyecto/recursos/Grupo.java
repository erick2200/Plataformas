package proyecto.recursos;

public class Grupo {
	private int id_grupo;
	private int fk_cud;
	private String salon;
	
	public Grupo(int id_grupo, int fk_cud, String salon) {
		this.id_grupo = id_grupo;
		this.fk_cud = fk_cud;
		this.salon = salon;
	}

	public int getId_grupo() {
		return id_grupo;
	}

	public void setId_grupo(int id_grupo) {
		this.id_grupo = id_grupo;
	}

	public int getFk_cud() {
		return fk_cud;
	}

	public void setFk_cud(int fk_cud) {
		this.fk_cud = fk_cud;
	}

	public String getSalon() {
		return salon;
	}

	public void setSalon(String salon) {
		this.salon = salon;
	}
	
	
	
}
