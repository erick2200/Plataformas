package proyecto.servlets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import proyecto.recursos.Conexion;
import proyecto.recursos.Docente;


public class DocenteDAO {

	private Conexion cn;
	private Connection conexion;
	private String sql;
	
	public DocenteDAO(String BaseDatos,String Password)
	{
		cn = new Conexion(BaseDatos,Password);
	}

	public List<Docente> obtenerDocentes(String atributo,String x) throws SQLException
	{
		List<Docente> listaDocentes = new ArrayList<Docente>();
		
		Docente docente = null;

		conexion = cn.conectar();
		PreparedStatement st;
		
		if(atributo == "" || atributo == null) 
		{
			sql = "SELECT * FROM DOCENTE";
			st = conexion.prepareStatement(sql);
		}
		else
		{
			sql = "SELECT * FROM DOCENTE WHERE ? = ? ";
			st = conexion.prepareStatement(sql);
			st.setString(1, atributo);
			st.setString(2, x);
		}
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next())
		{
			int cud = rs.getInt(1);
			String nombre = rs.getString(2);
			String apellido = rs.getString(3);
			String grado_academico = rs.getString(4);
			
			docente = new Docente(cud,nombre,apellido,grado_academico);
			listaDocentes.add(docente);
		}
		
		if(conexion != null) conexion.close();
		if(st != null) st.close();
		if(rs != null) rs.close();
		
		
		return listaDocentes;
		
	}
	
	public boolean insertarDocente(Docente docente) throws SQLException
	{
		boolean insertado = false;
		
		conexion = cn.conectar();
		sql = "INSERT INTO  DOCENTE(CUD,NOMBRE,APELLIDOS,GRADO_ACADEMICO) values (?,?,?,?)";
		
		PreparedStatement st = conexion.prepareStatement(sql);
		st.setInt(1, docente.getCud() );
		st.setString(2, docente.getNombre());
		st.setString(3, docente.getApellido() );
		st.setString(4, docente.getGrado_academico());

		insertado = st.executeUpdate() > 0;
		
		st.close();
		conexion.close();
		
		return insertado;
	}
	
}
