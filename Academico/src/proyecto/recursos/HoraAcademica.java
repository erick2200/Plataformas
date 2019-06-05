package proyecto.recursos;

public class HoraAcademica {
	private int id_hora_academica;
	private int fk_horario;
	private String dia;
	private int hora_inicio;
	private int minuto_inicio;
	private int hora_final;
	private int minuto_final;
	public HoraAcademica(int id_hora_academica,int fk_horario, String dia, int hora_inicio, int minuto_inicio, int hora_final,int minuto_final) {
		this.id_hora_academica = id_hora_academica;
		this.fk_horario=fk_horario;
		this.dia = dia;
		this.hora_inicio = hora_inicio;
		this.minuto_inicio = minuto_inicio;
		this.hora_final = hora_final;
		this.minuto_final = minuto_final;
	}
	public int getId_hora_academica() {
		return id_hora_academica;
	}
	public void setId_hora_academica(int id_hora_academica) {
		this.id_hora_academica = id_hora_academica;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public int getHora_inicio() {
		return hora_inicio;
	}
	public void setHora_inicio(int hora_inicio) {
		this.hora_inicio = hora_inicio;
	}
	public int getMinuto_inicio() {
		return minuto_inicio;
	}
	public void setMinuto_inicio(int minuto_inicio) {
		this.minuto_inicio = minuto_inicio;
	}
	public int getHora_final() {
		return hora_final;
	}
	public void setHora_final(int hora_final) {
		this.hora_final = hora_final;
	}
	public int getMinuto_final() {
		return minuto_final;
	}
	public void setMinuto_final(int minuto_final) {
		this.minuto_final = minuto_final;
	}
	
	public int getFk_horario() {
		return fk_horario;
	}
	public void setFk_horario(int fk_horario) {
		this.fk_horario = fk_horario;
	}
}