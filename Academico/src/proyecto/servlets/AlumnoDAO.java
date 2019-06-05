package proyecto.servlets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import proyecto.recursos.Alumno;
import proyecto.recursos.Conexion;



public class AlumnoDAO {

	private Conexion cn;
	private Connection conexion;
	private String sql;
	
	public AlumnoDAO(String BaseDatos,String Password)
	{
		cn = new Conexion(BaseDatos,Password);
	}
	
	public Alumno BuscarAlumno(int cui) throws SQLException
	{
		
		List<Alumno> listaAlumnos = new ArrayList<Alumno>();
		String argument = Integer.toString(cui);
		listaAlumnos = obtenerAlumnos("CUI",argument);
		return listaAlumnos.get(0);
		
	}
	
	public List<Alumno> obtenerAlumnos(String atributo,String x) throws SQLException

	{
		List<Alumno> listaAlumnos = new ArrayList<Alumno>();
		
		Alumno alumno = null;
		
		conexion = cn.conectar();
		PreparedStatement st;
		
		if(atributo == "" || atributo == null) 
		{
			sql = "SELECT * FROM ALUMNO";
			st = conexion.prepareStatement(sql);
		}
		else
		{
			sql = "SELECT * FROM ALUMNO WHERE ? = ? ";
			st = conexion.prepareStatement(sql);
			st.setString(1, atributo);
			st.setString(2, x);
		}
		
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
	
	public boolean insertarAlumno(Alumno alumno) throws SQLException
	{
		boolean insertado = false;
		conexion = cn.conectar();
		sql = "INSERT INTO  ALUMNO(CUI,NOMBRE,APELLIDO,EDAD,SEXO) values (?,?,?,?,?)";
		PreparedStatement st = conexion.prepareStatement(sql);
		st.setInt(1, alumno.getCui());
		st.setString(2, alumno.getNombre());
		st.setString(3,alumno.getApellido());
		st.setInt(4,alumno.getEdad());
		st.setString(5, alumno.getSexo());
		insertado = st.executeUpdate() > 0;
		
		st.close();
		conexion.close();
		
		return insertado;
	}

	public boolean actualizarAlumno(Alumno alumno,int cui) throws SQLException
	{
		boolean Actualizado = false;
		sql = "UPDATE ALUMNO SET CUI=?,NOMBRE=?,APELLIDO=?,EDAD=?, SEXO=? WHERE id=?";
		conexion = cn.conectar();
		PreparedStatement st = conexion.prepareStatement(sql);
		
		st.setInt(1, alumno.getCui());
		st.setString(2, alumno.getNombre());
		st.setString(3, alumno.getApellido());
		st.setInt(4, alumno.getEdad());
		st.setString(5, alumno.getSexo());
		st.setInt(6, cui );
 
		Actualizado = st.executeUpdate() > 0;
		
		if(conexion != null) conexion.close();
		if(st != null) st.close();
		
		return Actualizado;
	}

	public boolean eliminarAlumno(int cui) throws SQLException
	{
		boolean eliminado = false;
		sql = "DELETE FROM ALUMNO WHERE ID=?";
		conexion = cn.conectar();
		
		PreparedStatement st = conexion.prepareStatement(sql);
		
		st.setInt(1, cui);
		
		eliminado = st.executeUpdate() >0;
		
		if(conexion != null) conexion.close();
		if(st != null) st.close();
		
		return eliminado;
	}
	
}