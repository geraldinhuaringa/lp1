package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.ClienteInterface;
import modelo.Cliente;
import utilitario.MysqlConexion;

public class ClienteImpl implements ClienteInterface {

	@Override
	public ArrayList<Cliente> obtenerCliente(String dni, String nombre,
			String apellido, String suministro) {
		// TODO Auto-generated method stub
		if(nombre!= null) nombre="%"+nombre.toLowerCase()+"%";
		if(apellido!= null) apellido="%"+apellido.toLowerCase()+"%";
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		Connection conexion  = null;
		ResultSet rs = null;
		PreparedStatement ps= null;
		String consulta = "select c.NumSuministro_cli,c.nombre_cli, "+
				"c.ape_pat_cli,c.ape_mat_cli,c.documento_cli,c.RazonSoc_cli, "+
				"c.telefono_cli,c.celular_cli,c.email_cli, "+
				"concat( e.nombre_emp, ' ' ,  e.ape_pat_emp , ' ' ,e.ape_mat_emp) as nomCompleto, "+
				"c.fec_actualizacion,c.direccion_cli,c.fec_inscripcion, e.codigo_emp "+
				"from cliente c inner join empleado  e on c.empleado = e.codigo_emp   "+
				"where (c.documento_cli = ?)  or  (lower(c.nombre_cli)  "+
				"like ?) or (lower(c.ape_pat_cli) like ? or  "+
				"lower(c.ape_mat_cli) like ?) or (c.NumSuministro_cli  = ?) "; 
		Cliente cliente = null;
		try {
			conexion = MysqlConexion.getConexion();
			ps = conexion.prepareStatement(consulta);
			ps.setString(1, dni);
			ps.setString(2, nombre);
			ps.setString(3, apellido);
			ps.setString(4, apellido);
			ps.setString(5, suministro);
			rs = ps.executeQuery();
			while(rs.next()) {
				cliente = new Cliente();
				cliente.setSuministroId(rs.getInt(1));
				cliente.setNombre(rs.getString(2));
				cliente.setApellidoPaterno(rs.getString(3));
				cliente.setApellidoMaterno(rs.getString(4));
				cliente.setDocumento(rs.getString(5));
				cliente.setRazonSocial(rs.getString(6));
				cliente.setTelefono(rs.getString(7));
				cliente.setCelular(rs.getString(8));
				cliente.setEmail(rs.getString(9));
				cliente.getEmpleado().setNomEmp(rs.getString(10));
				cliente.setFechaActualizacion(rs.getDate(11));
				cliente.setDireccion(rs.getString(12));
				cliente.setFechaInscripcion(rs.getDate(13));
				cliente.getEmpleado().setCodigo_emp(rs.getInt(14));
				clientes.add(cliente);
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
		
		return clientes;
	}

	@Override
	public Cliente obtenerCliente(String suministro) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Connection conexion  = null;
		ResultSet rs = null;
		PreparedStatement ps= null;
		String consulta = "select c.NumSuministro_cli, c.nombre_cli, "+
				"c.ape_pat_cli, c.ape_mat_cli,c.documento_cli, c.RazonSoc_cli, "+ 
				"c.telefono_cli,c.celular_cli,c.email_cli, "+
				"concat( e.nombre_emp, ' ' ,  e.ape_pat_emp , ' ' ,e.ape_mat_emp) as nomCompleto, "+
				"c.fec_actualizacion,c.direccion_cli,c.fec_inscripcion, e.codigo_emp  "+
				"from cliente c inner join empleado  e on c.empleado = e.codigo_emp "+
				"where trim(c.documento_cli)  = trim(?)"; 
		Cliente cliente = null;
		try {
			conexion = MysqlConexion.getConexion();
			ps = conexion.prepareStatement(consulta);
			ps.setString(1, suministro);
			rs = ps.executeQuery();
			while(rs.next()) {
				cliente = new Cliente();
				cliente.setSuministroId(rs.getInt(1));
				cliente.setNombre(rs.getString(2));
				cliente.setApellidoPaterno(rs.getString(3));
				cliente.setApellidoMaterno(rs.getString(4));
				cliente.setDocumento(rs.getString(5));
				cliente.setRazonSocial(rs.getString(6));
				cliente.setTelefono(rs.getString(7));
				cliente.setCelular(rs.getString(8));
				cliente.setEmail(rs.getString(9));
				cliente.getEmpleado().setNomEmp(rs.getString(10));
				cliente.setFechaActualizacion(rs.getDate(11));
				cliente.setDireccion(rs.getString(12));
				cliente.setFechaInscripcion(rs.getDate(13));
				cliente.getEmpleado().setCodigo_emp(rs.getInt(14));
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
		
		return cliente;
	}

	@Override
	public int actualizarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		String sentencia =" update cliente " + 
				"        set NumSuministro_cli = ?," + 
				"        documento_cli = ?, " + 
				"        nombre_cli = ?," + 
				"		ape_pat_cli = ?," + 
				"        ape_mat_cli = ?," + 
				"        direccion_cli = ?," + 
				"        telefono_cli = ?," + 
				"        celular_cli= ?,email_cli = ?," +
				" 		fec_actualizacion = sysdate()"+
				"        where trim(documento_cli) = trim(?)";
		
		PreparedStatement ps= null;
		int resultado = -1;
		Connection cn =null;
		try {
			cn=MysqlConexion.getConexion();
			ps=cn.prepareStatement(sentencia);
			ps.setInt(1, cliente.getSuministroId());
			ps.setString(2, cliente.getDocumento());
			ps.setString(3,cliente.getNombre());
			ps.setString(4,cliente.getApellidoPaterno());
			ps.setString(5, cliente.getApellidoMaterno());
			ps.setString(6,cliente.getDireccion());
			ps.setString(7, cliente.getTelefono());
			ps.setString(8, cliente.getCelular());
			ps.setString(9, cliente.getEmail());
			ps.setString(10, cliente.getDocumentoAntiguo());
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

}
