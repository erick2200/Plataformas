package proyecto.servlets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import proyecto.recursos.Conexion;
import proyecto.recursos.Curso;
import proyecto.recursos.Matricula;

public class MatriculaDAO {

	private Conexion cn;
	private Connection conexion;
	private String sql;
	
	public MatriculaDAO(String BaseDatos,String Password)
	{
		cn = new Conexion(BaseDatos,Password);
	}
	
	public Matricula BuscarMatricula(int id_matri) throws SQLException
	{
		List<Matricula> listaMatriculas = new ArrayList<Matricula>();
		String argument = Integer.toString(id_matri);
		listaMatriculas = obtenerMatriculas("idMatricula",argument);
		return listaMatriculas.get(0);
	}
	
	public List<Curso> ObtenerCursos(int idMatricula) throws SQLException
	{
		List<Curso> listaCursos = new ArrayList<Curso>();
		Curso curso =  null;
		
		sql = "SELECT CURSO.CASI, CURSO.NOMBRE, CURSO.CREDITOS, CURSO.CATEGORIA , CURSO.H_TEORICAS , CURSO.H_PRACTICAS, CURSO.DESCRIPCION FROM CURSO\n" + 
			  "INNER JOIN CURSO_MATRICULA\n" + 
			  "ON CURSO_MATRICULA.FK_CURSO = CURSO.CASI\n" + 
			  "INNER JOIN MATRICULA\n" + 
			  "ON CURSO_MATRICULA.FK_MATRICULA = MATRICULA.ID_MATRICULA WHERE MATRICULA.ID_MATRICULA = ?";
		
		PreparedStatement st = conexion.prepareStatement(sql);
		st.setInt(1, idMatricula);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next())
		{
			int casi = rs.getInt(1);
			String nombre = rs.getString(2);
			int credito = rs.getInt(3);
			String categoria = rs.getString(4);
			int hTeoricas = rs.getInt(5);
			int hPracticas = rs.getInt(6);
			String descripcion = rs.getString(7);
			
			
			curso = new Curso(casi,nombre,credito,categoria,hTeoricas,hPracticas,descripcion);
			listaCursos.add(curso);
		}
		
		if(conexion != null) conexion.close();
		if(st != null) st.close();
		if(rs != null) rs.close();
		
		return listaCursos;
	}

	public List<Matricula> obtenerMatriculas(String atributo,String x) throws SQLException
	{
		List<Matricula> listaMatriculas = new ArrayList<Matricula>();
		
		Matricula matricula = null;
		
		conexion = cn.conectar();
		PreparedStatement st;
		
		if(atributo == "" || atributo == null) 
		{
			sql = "SELECT * FROM MATRICULA";
			st = conexion.prepareStatement(sql);
		}
		else
		{
			sql = "SELECT * FROM MATRICULA WHERE ? = ? ";
			st = conexion.prepareStatement(sql);
			st.setString(1, atributo);
			st.setString(2, x);
		}
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next())
		{
			int cod_matricula = rs.getInt(1);
			String fecha = rs.getString(2);
			int cui = rs.getInt(3);
			
			matricula = new Matricula(cod_matricula,fecha,cui);
			listaMatriculas.add(matricula);
		}
		
		if(conexion != null) conexion.close();
		if(st != null) st.close();
		if(rs != null) rs.close();
		
		return listaMatriculas;
	}

	public boolean insertarMatricula(Matricula matricula) throws SQLException
	{
		boolean insertado = false;
		conexion = cn.conectar();
		sql = "INSERT INTO  MATRICULA(FECHA,F_CUI) values (?,?)";
		PreparedStatement st = conexion.prepareStatement(sql);
		st.setString(1, matricula.getFecha());
		st.setInt(2, matricula.getFk_cui());

		insertado = st.executeUpdate() > 0;
		
		st.close();
		conexion.close();
		
		return insertado;
	}
	
	public boolean actualizarMatricula(Matricula matricula,int idMatricula) throws SQLException
	{
		boolean actualizada = false;
		conexion = cn.conectar();
		
		sql = "UPDATE MATRICULA SET FECHA=?,FK_CUI=?";
		
		PreparedStatement st = conexion.prepareStatement(sql);
		
		st.setString(1, matricula.getFecha());
		st.setInt(2, matricula.getFk_cui());
		
		actualizada = st.executeUpdate() > 0 ;
		
		if(conexion != null) conexion.close();
		if(st != null) st.close();
		
		return actualizada;
	}
	
	public boolean eliminarMatricula(int idMatricula) throws SQLException
	{
		boolean eliminado = false;
		sql = "DELETE FROM MATRICULA WHERE ID=?";
		conexion = cn.conectar();
		
		PreparedStatement st = conexion.prepareStatement(sql);
		
		st.setInt(1, idMatricula);
		
		eliminado = st.executeUpdate() >0;
		
		if(conexion != null) conexion.close();
		if(st != null) st.close();
		
		return eliminado;
	}
	
}
