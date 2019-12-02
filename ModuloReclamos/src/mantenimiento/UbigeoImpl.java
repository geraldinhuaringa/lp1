package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.UbigeoInterface;
import modelo.Cliente;
import modelo.Departamento;
import modelo.Distrito;
import modelo.Provincia;
import modelo.TipoComponente;
import utilitario.MysqlConexion;

public class UbigeoImpl implements UbigeoInterface {

	@Override
	public ArrayList<Departamento> listaDepartamento() throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<Departamento> lista  =new ArrayList<Departamento>();
		
		Departamento departamento= null;
		
		Connection cn = null;
		String consulta = "select codigo_dep, descripcion_dep from departamento";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			cn = MysqlConexion.getConexion();
			ps = cn.prepareStatement(consulta);
			rs = ps.executeQuery();
			while(rs.next()) {
				departamento = new Departamento();
				departamento.setCodigo(rs.getInt(1));
				departamento.setDescripcion(rs.getString(2));
				
				lista.add(departamento);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(ps!=null) ps.close();
			if(rs!=null) rs.close();
			if(cn!=null) cn.close();
		}
		return lista;
	}

	@Override
	public ArrayList<Provincia> listaProvincia(int codigoDepartamento) throws SQLException{
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		ArrayList<Provincia> lista  =new ArrayList<Provincia>();
		
		Provincia provincia= null;
		
		Connection cn = null;
		String consulta = "select codigo_pro, decripcion_pro from provincia where departamento = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			cn = MysqlConexion.getConexion();
			ps = cn.prepareStatement(consulta);
			ps.setInt(1, codigoDepartamento);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				provincia = new Provincia();
				provincia.setCodigo(rs.getInt(1));
				provincia.setDescripcion(rs.getString(2));
				
				lista.add(provincia);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(ps!=null) ps.close();
			if(rs!=null) rs.close();
			if(cn!=null) cn.close();
		}
		return lista;
	 }

	@Override
	public ArrayList<Distrito> listaDistrito(int codigoProvincia) throws SQLException{
		// TODO Auto-generated method stub
		ArrayList<Distrito> lista  =new ArrayList<Distrito>();
		Distrito distrito= null;
		Connection cn = null;
		String consulta = "select d.codigo_dis, d.descripcion_dis, e.codigo_est, "
				+ "e.descripcion_est from distrito d inner join estado e on d.estado "
				+ "= e.codigo_est where provincia = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			cn = MysqlConexion.getConexion();
			ps = cn.prepareStatement(consulta);
			ps.setInt(1, codigoProvincia);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				distrito = new Distrito();
				distrito.setCodigo(rs.getInt(1));
				distrito.setDescripcion(rs.getString(2));
				distrito.getEstado().setCodigo(rs.getInt(3));
				distrito.getEstado().setDescripcion(rs.getString(4));
				lista.add(distrito);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(ps!=null) ps.close();
			if(rs!=null) rs.close();
			if(cn!=null) cn.close();
		}
		return lista;
	}

	@Override
	public int crearDepartamento(String nombre) throws SQLException {
		int resultado = 0;
		Connection cn = null;
		PreparedStatement ps = null;
		String sentencia = "insert into departamento(descripcion_dep,codigo_dep) select ?, max(codigo_dep) + 1 from departamento";
		try {
			cn = MysqlConexion.getConexion();
			ps = cn.prepareStatement(sentencia);
			ps.setString(1, nombre);
			resultado = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(ps!=null) {ps.close();}
			if(cn!= null) {cn.close();}
		}
		// TODO Auto-generated method stub
		return resultado;
	}

	@Override
	public int crearProvincia(int codigoDepartamento,String nombre) throws SQLException {
		int resultado = 0;
		Connection cn = null;
		PreparedStatement ps = null;
		String sentencia = "insert into provincia(departamento, decripcion_pro,codigo_pro) select ?,?,max(codigo_pro)+1 from provincia";
		try {
			cn = MysqlConexion.getConexion();
			ps = cn.prepareStatement(sentencia);
			ps.setInt(1, codigoDepartamento);
			ps.setString(2, nombre);
			resultado = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(ps!=null) {ps.close();}
			if(cn!= null) {cn.close();}
		}
		// TODO Auto-generated method stub
		return resultado;
	}

	@Override
	public int crearDistrito(int codigoDepartamento, int codigoProvincia,String nombre, int estado) throws SQLException {
		int resultado = 0;
		Connection cn = null;
		PreparedStatement ps = null;
		String sentencia = "insert into distrito(departamento,provincia, descripcion_dis, estado,codigo_dis,empleado,fec_actualizacion) "
				+ " select  ?,?,?,?, max(codigo_dis) +1 , 11682, sysdate() from distrito";
		try {
			cn = MysqlConexion.getConexion();
			ps = cn.prepareStatement(sentencia);
			ps.setInt(1, codigoDepartamento);
			ps.setInt(2, codigoProvincia);
			ps.setString(3, nombre);
			ps.setInt(4, estado);
			resultado = ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(ps!=null) {ps.close();}
			if(cn!= null) {cn.close();}
		}
		// TODO Auto-generated method stub
		return resultado;
	}

}
