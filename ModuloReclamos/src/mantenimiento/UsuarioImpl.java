package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.UsuarioInterface;
import modelo.Cliente;
import modelo.Empleado;
import utilitario.MysqlConexion;


public class UsuarioImpl implements UsuarioInterface {

	@Override
	public ArrayList<Empleado> obtenerUsuario(String nombre) {
		// TODO Auto-generated method stub
		
		
		
		
		
		
		
		
		return null;
	}

	@Override
	public Empleado obtenerUsurio(int codigo_emp) {
		// TODO Auto-generated method stub
		Connection conexion  = null;
		ResultSet rs = null;
		PreparedStatement ps= null;
		String consulta = ""; 
		Empleado usuario = null;
		try {
			conexion = MysqlConexion.getConexion();
			ps = conexion.prepareStatement(consulta);
			ps.setInt(1, codigo_emp);
			rs = ps.executeQuery();
			while(rs.next()) {
				usuario = new Empleado();
				usuario.setCodigo_emp(rs.getInt(1));
				usuario.setApeMatEmp(rs.getString(2));
				usuario.setApePatemp(rs.getString(3));
				usuario.setNomEmp(rs.getString(4));
				usuario.setSucursal(rs.getInt(5));
				usuario.setPerfil(rs.getInt(6));
				usuario.setClavEmp(rs.getString(7));
				usuario.setResponActual(rs.getInt(8));
				usuario.setFechaActualizacion(rs.getDate(9));
				
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return usuario;
	}
	

	@Override
	public int modificarUsuario(Empleado us) {
		// TODO Auto-generated method stub
		String sentencia =" ";
		
		PreparedStatement ps= null;
		int resultado = -1;
		Connection cn =null;
		try {
			cn=MysqlConexion.getConexion();
			ps=cn.prepareStatement(sentencia);
			ps.setString(1,us.getApePatemp());
			ps.setString(2,us.getApeMatEmp());
			ps.setString(3,us.getNomEmp());
			ps.setInt(4,us.getSucursal());
			ps.setInt(5,us.getPerfil());
			ps.setString(6,us.getClavEmp());
			resultado = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				cn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return resultado;
	}

	@Override
	public int registrarUsuario(Empleado u) {
		// TODO Auto-generated method 
		int resultado = 0; 
		Connection cn = null;
		PreparedStatement ps = null;
		String sentencia="";
		try {
			cn =MysqlConexion.getConexion();
			ps=cn.prepareStatement(sentencia);
			ps.setString(1,u.getNomEmp());
			ps.setString(3,u.getApePatemp());
			ps.setString(4, u.getApeMatEmp());
	
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return 0;
	}
	
}
