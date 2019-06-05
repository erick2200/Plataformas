package proyecto.recursos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Conexion {

	private Connection conexion;
	private final String Controlador = "com.mysql.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:3306/";
	private final String Usuario = "root";
	
	private String BaseDatos;
	private String Password;

	
	public Conexion(String BaseDatos,String Password) {
		this.BaseDatos = BaseDatos;
		this.Password = Password;
	}
	
	public Connection conectar() {
		
		conexion = null;
		
		try{
			
			Class.forName(Controlador);
			conexion = DriverManager.getConnection(URL + BaseDatos,Usuario,Password);
			System.out.println("Conexion OKEY");
		}
		
		catch(ClassNotFoundException e) {
			System.out.println("Error en controlador");
			e.printStackTrace();
		} 
		
		catch(SQLException e) {
			System.out.println("Error en conexion");
			e.printStackTrace();
		}
		
		return conexion;
	}
	
	public void desconectar() {
		
		if(conexion == null)
			return;
		try {
			conexion.close();
			System.out.println("Desconectado");
		} catch(SQLException e){
			System.out.println("Error cerrando la conexion");
			e.printStackTrace();
		}
		
	}
	
}