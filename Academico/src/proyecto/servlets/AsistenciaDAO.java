package proyecto.servlets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import proyecto.recursos.Alumno;
import proyecto.recursos.Asistencia;
import proyecto.recursos.Conexion;


public class AsistenciaDAO {

	private Conexion cn;
	private Connection conexion;
	private String sql;
	
	public AsistenciaDAO(String BaseDatos,String Password)
	{
		cn = new Conexion(BaseDatos,Password);
	}

	public List<Asistencia> obtenerAsistencia(String atributo,String x) throws SQLException
	{
		List<Asistencia> listaAsistencias = new ArrayList<Asistencia>();
		
		Asistencia asistencia = null;
		
		conexion = cn.conectar();
		PreparedStatement st;
		
		if(atributo == "" || atributo == null) 
		{
			sql = "SELECT * FROM ASISTENCIA";
			st = conexion.prepareStatement(sql);
		}
		else
		{
			sql = "SELECT * FROM ASISTENCIA WHERE ? = ? ";
			st = conexion.prepareStatement(sql);
			st.setString(1, atributo);
			st.setString(2, x);
		}
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next())
		{
			int id_asistencia = rs.getInt(1);
			int fk_grupo = rs.getInt(2);
			boolean asis_profesor = rs.getBoolean(3);
			String fecha = rs.getString(4);
			
			asistencia = new Asistencia(id_asistencia,fk_grupo,asis_profesor,fecha);
			listaAsistencias.add(asistencia);
		}
		
		if(conexion != null) conexion.close();
		if(st != null) st.close();
		if(rs != null) rs.close();
		
		return listaAsistencias;
		
	}
	
	public List<Alumno> obtenerAsisAlumnos(int id_asistencia) throws SQLException
	{
		List<Alumno> listaAlumnos = new ArrayList<Alumno>();
		
		Alumno alumno = null;
		conexion = cn.conectar();
		
		sql = "SELECT ALUMNO.CUI,ALUMNO.NOMBRE,ALUMNO.APELLIDOS,ALUMNO.EDAD,ALUMNO.SEXO FROM ALUMNO \n" + 
			  "INNER JOIN ASISTENCIA_ALUMNO \n" + 
			  "ON ASISTENCIA_ALUMNO.FK_CUI = ALUMNO.CUI\n" + 
		      "INNER JOIN ASISTENCIA\n" + 
			   "ON ASISTENCIA_ALUMNO.FK_ASISTENCIA = ASISTENCIA.ID_ASISTENCIA WHERE ASISTENCIA.ID_ASISTENCIA = ? ";
		
		PreparedStatement st = conexion.prepareStatement(sql);
		st.setInt(1, id_asistencia);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next())
		{
			int cui = rs.getInt(1);
			String nombre = rs.getString(2);
			String apellido = rs.getString(3);
			int edad = rs.getInt(4);
			String sexo = rs.getString(5);
			
			
			alumno = new Alumno(cui,nombre,apellido,edad,sexo);
			listaAlumnos.add(alumno);
		}
		
		if(conexion != null) conexion.close();
		if(st != null) st.close();
		if(rs != null) rs.close();
		
		return listaAlumnos;
	}
	
	public boolean insertarAsistencia(Asistencia asistencia) throws SQLException
	{
		boolean insertado = false;
		
		conexion = cn.conectar();
		sql = "INSERT INTO  ASISTENCIA(FK_GRUPO,ASISTENCIA_PROFESOR,FECHA) values (?,?,?)";
		PreparedStatement st = conexion.prepareStatement(sql);
		st.setInt(1, asistencia.getFk_grupo());
		st.setBoolean(2, asistencia.getAsistencia_profesor() );
		st.setString(3, asistencia.getFecha() );

		insertado = st.executeUpdate() > 0;
		
		st.close();
		conexion.close();
		
		return insertado;
	}
	
}
