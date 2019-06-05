package proyecto.servlets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import proyecto.recursos.Conexion;
import proyecto.recursos.Grupo;


public class GrupoDAO {

	private Conexion cn;
	private Connection conexion;
	private String sql;
	
	public GrupoDAO(String BaseDatos,String Password)
	{
		cn = new Conexion(BaseDatos,Password);
	}

	public List<Grupo> obtenerCursos(String atributo,String x) throws SQLException
	{
		List<Grupo> listaGrupos = new ArrayList<Grupo>();
		
		Grupo grupo = null;
		
		conexion = cn.conectar();
		PreparedStatement st;
		
		if(atributo == "" || atributo == null) 
		{
			sql = "SELECT * FROM GRUPO";
			st = conexion.prepareStatement(sql);
		}
		else
		{
			sql = "SELECT * FROM GRUPO WHERE ? = ? ";
			st = conexion.prepareStatement(sql);
			st.setString(1, atributo);
			st.setString(2, x);
		}
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next())
		{
			int id_grupo = rs.getInt(1);
			int fk_cud = rs.getInt(2);
			String salon = rs.getString(3);
			
			grupo = new Grupo(id_grupo,fk_cud,salon);
			listaGrupos.add(grupo);
		}
		
		if(conexion != null) conexion.close();
		if(st != null) st.close();
		if(rs != null) rs.close();
		
		return listaGrupos;
	}
	
	public boolean insertarGrupo(Grupo grupo) throws SQLException
	{
		boolean insertado = false;
		
		conexion = cn.conectar();
		sql = "INSERT INTO  GRUPO(FK_CUD,SALON) values (?,?)";
		PreparedStatement st = conexion.prepareStatement(sql);
		
		st.setInt(1, grupo.getFk_cud() );
		st.setString(2, grupo.getSalon() );
		
		insertado = st.executeUpdate() > 0;
		
		st.close();
		conexion.close();
		
		return insertado;
		
	}
		
	
}
