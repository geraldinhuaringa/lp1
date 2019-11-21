package utilitario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConexion {
	public static Connection getConexion(){
		Connection con =  null; 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/forsedapal";
			String usuario = "root";
			String clave = "root";
			
			con=DriverManager.getConnection(url, usuario, clave);
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
	}
}
