package proyecto.servlets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import proyecto.recursos.Curso;
import proyecto.recursos.Conexion;

public class CursoDAO {

	private Conexion cn;
	private Connection conexion;
	private String sql;
	
	public CursoDAO(String BaseDatos,String Password)
	{
		cn = new Conexion(BaseDatos,Password);
	}
	
	public List<Curso> obtenerCursos(String atributo,String x) throws SQLException

	{
		List<Curso> listaCursos = new ArrayList<Curso>();
		
		Curso curso = null;
		
		conexion = cn.conectar();
		PreparedStatement st;
		
		if(atributo == "" || atributo == null) 
		{
			sql = "SELECT * FROM CURSO";
			st = conexion.prepareStatement(sql);
		}
		else
		{
			sql = "SELECT * FROM CURSO WHERE ? = ? ";
			st = conexion.prepareStatement(sql);
			st.setString(1, atributo);
			st.setString(2, x);
		}
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next())
		{
			int casi = rs.getInt(1);
			String nombre = rs.getString(2);
			int creditos = rs.getInt(3);
			String categoria = rs.getString(4);
			int hTeoricas = rs.getInt(4);
			int hPracticas = rs.getInt(5);
			String descripcion = rs.getString(6);
			
			curso = new Curso(casi,nombre,creditos,categoria,hTeoricas,hPracticas,descripcion);
			listaCursos.add(curso);
		}
		
		if(conexion != null) conexion.close();
		if(st != null) st.close();
		if(rs != null) rs.close();
		
		return listaCursos;
	}
	
    public List<Integer> obtenerPrerequisitos(int casi) throws SQLException
    {
    	List<Integer> listaPrerequisitos = new ArrayList<Integer>();
    	
    	sql = "SELECT * FROM HORA_ACADEMICA WHERE FK_HORARIO = ?";
    	
    	PreparedStatement st = conexion.prepareStatement(sql);
		st.setInt(1, casi);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next())
		{
			int cui = rs.getInt(1);
			
			listaPrerequisitos.add(cui);
		}
		
		if(conexion != null) conexion.close();
		if(st != null) st.close();
		if(rs != null) rs.close();
    	
    	return listaPrerequisitos;
    }
	
	public boolean insertarCurso(Curso curso) throws SQLException
	{
		boolean insertado = false;
		conexion = cn.conectar();
		sql = "INSERT INTO  CURSO(CASI,NOMBRE,CREDITOS,CATEGORIA,H_TEORICAS,H_PRACTICAS,DESCRIPCION) values (?,?,?,?,?,?,?)";
		PreparedStatement st = conexion.prepareStatement(sql);
		st.setInt(1, curso.getCasi());
		st.setString(2, curso.getNombre());
		st.setInt(3,curso.getCreditos());
		st.setString(4,curso.getCategoria());
		st.setInt(5, curso.getH_teoricas());
		st.setInt(6, curso.getH_practicas());
		st.setString(7, curso.getDescripcion());
		
		insertado = st.executeUpdate() > 0;
		
		st.close();
		conexion.close();
		
		return insertado;
	}

}
