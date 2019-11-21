package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.SucursalInterface;
import modelo.Sucursal;
import utilitario.MysqlConexion;

public class SucursalImpl implements SucursalInterface{

	@Override
	public ArrayList<Sucursal> listaSucursal() throws Exception{
		// TODO Auto-generated method stub
		ArrayList<Sucursal>sucursales = new ArrayList<Sucursal>();
		Sucursal sucursal = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String consulta = "select codigo_suc, descripcion_suc from sucursal";
		try {
			con = MysqlConexion.getConexion();
			ps = con.prepareStatement(consulta);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				sucursal = new Sucursal();
				sucursal.setCodigo(rs.getInt(1));
				sucursal.setDescripcion(rs.getString(2));
				sucursales.add(sucursal);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			ps.close();
			rs.close();
			con.close();
		}
		System.out.println(sucursales.size());
		
		return sucursales;
	}

}
