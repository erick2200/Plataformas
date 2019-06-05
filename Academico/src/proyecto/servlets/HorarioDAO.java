package proyecto.servlets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import proyecto.recursos.Conexion;
import proyecto.recursos.HoraAcademica;
import proyecto.recursos.Horario;

public class HorarioDAO {

	private Conexion cn;
	private Connection conexion;
	private String sql;
	
	public HorarioDAO(String BaseDatos,String Password)
	{
		cn = new Conexion(BaseDatos,Password);
	}

	public List<Horario> obtenerHorarios(String atributo,String x) throws SQLException
	{
		List<Horario> listaHorarios = new ArrayList<Horario>();
	
		Horario horario= null;
		
		conexion = cn.conectar();
		PreparedStatement st;
		
		if(atributo == "" || atributo == null) 
		{
			sql = "SELECT * FROM HORARIO";
			st = conexion.prepareStatement(sql);
		}
		else
		{
			sql = "SELECT * FROM HORARIO WHERE ? = ? ";
			st = conexion.prepareStatement(sql);
			st.setString(1, atributo);
			st.setString(2, x);
		}
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next())
		{
			int id_horario = rs.getInt(1);
			int fk_grupo = rs.getInt(2);
			
			horario = new Horario(id_horario,fk_grupo);
			listaHorarios.add(horario);
		}
		
		if(conexion != null) conexion.close();
		if(st != null) st.close();
		if(rs != null) rs.close();
		
		return listaHorarios;
	}
	
	public List<HoraAcademica> obtenerHorasAcademicas(int id_Horario) throws SQLException
	{
		List<HoraAcademica> listaHoras = new ArrayList<HoraAcademica>();
		HoraAcademica horaAcademica = null;
		
		sql = "SELECT * FROM HORA_ACADEMICA WHERE FK_HORARIO = ?" ;
		
		PreparedStatement st = conexion.prepareStatement(sql);
		st.setInt(1, id_Horario);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next())
		{
			int idHorario = rs.getInt(1);
			String dia = rs.getString(3);
			int horaInicio = rs.getInt(4);
			int minInicio = rs.getInt(5);
			int horaFin = rs.getInt(6);
			int minFin = rs.getInt(7);
			
			
			horaAcademica = new HoraAcademica(idHorario,id_Horario,dia,horaInicio,minInicio,horaFin,minFin);
			listaHoras.add(horaAcademica);
		}
		
		if(conexion != null) conexion.close();
		if(st != null) st.close();
		if(rs != null) rs.close();
		
		return listaHoras;
	}
	
	public boolean insertarHorario(Horario horario) throws SQLException
	{
		boolean insertado = false;
		
		conexion = cn.conectar();
		sql = "INSERT INTO  HORARIO(FK_GRUPO) values (?)";
		PreparedStatement st = conexion.prepareStatement(sql);
		
		st.setInt(1, horario.getFk_grupo() );
		
		st.close();
		conexion.close();
		
		return insertado;
	}
	
}
