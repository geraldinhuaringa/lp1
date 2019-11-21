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
		String consulta = "SELECT codigo_dis, descripcion_dis FROM DISTRITO WHERE provincia = ?";
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

}
