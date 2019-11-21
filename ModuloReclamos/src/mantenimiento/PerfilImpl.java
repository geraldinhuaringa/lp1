package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.PerfilInterface;
import modelo.Perfil;
import utilitario.MysqlConexion;

public class PerfilImpl implements PerfilInterface {

	@Override
	public ArrayList<Perfil> listaPerfil() throws Exception {
		ArrayList<Perfil> perfiles = new ArrayList<Perfil>();
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		Perfil perfil = null;
		String consulta = "select  codigo_per, descripcion_per from perfil";
		try {
			con = MysqlConexion.getConexion();
			ps = con.prepareStatement(consulta);
			rs = ps.executeQuery();
			while(rs.next()) {
				perfil = new  Perfil();
				perfil.setCodigo(rs.getInt(1));
				perfil.setDescripcion(rs.getString(2));
				perfiles.add(perfil);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			ps.close();
			rs.close();
			con.close();
		}
		// TODO Auto-generated method stub
		return perfiles;
	}

}
