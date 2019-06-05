package proyecto.servlets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import proyecto.recursos.Conexion;
import proyecto.recursos.Silabo;


public class SilaboDAO {

	private Conexion cn;
	private Connection conexion;
	private String sql;
	
	public SilaboDAO(String BaseDatos,String Password)
	{
		cn = new Conexion(BaseDatos,Password);
	}

	public List<Silabo> obtenerSilabos(String atributo,String x) throws SQLException
	{
		List<Silabo> listaSilabos = new ArrayList<Silabo>();
		
		Silabo silabo = null;
		
		conexion = cn.conectar();
		PreparedStatement st;
		
		if(atributo == "" || atributo == null) 
		{
			sql = "SELECT * FROM SILABO";
			st = conexion.prepareStatement(sql);
		}
		else
		{
			sql = "SELECT * FROM SILABO WHERE ? = ? ";
			st = conexion.prepareStatement(sql);
			st.setString(1, atributo);
			st.setString(2, x);
		}
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next())
		{
			int id_silabo = rs.getInt(1);
			int fk_casi = rs.getInt(2);
			String contenido = rs.getString(3);
			String fecha = rs.getString(4);
			
			silabo = new Silabo(id_silabo,fk_casi,contenido,fecha);
			listaSilabos.add(silabo);
		}
		
		if(conexion != null) conexion.close();
		if(st != null) st.close();
		if(rs != null) rs.close();
		
		return listaSilabos;
	}
	
	public boolean insertarSilabo(Silabo silabo) throws SQLException
	{
		boolean insertado = false;
		
		conexion = cn.conectar();
		sql = "INSERT INTO  SILABO(FK_CASI,CONTENIDO,FECHA) values (?,?,?)";
		PreparedStatement st = conexion.prepareStatement(sql);
		st.setInt(1, silabo.getFk_casi() );
		st.setString(2, silabo.getContenido() );
		st.setString(3, silabo.getFecha() );
		
		insertado = st.executeUpdate() > 0;
		
		st.close();
		conexion.close();
		
		return insertado ;
		
		
	}
	
}
