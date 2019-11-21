package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.EstadoInterface;
import modelo.Estado;
import utilitario.MysqlConexion;

public class EstadoImpl implements EstadoInterface{

	@Override
	public ArrayList<Estado> listaEstado() {
		Estado estado = null;
		ArrayList<Estado> estados = new ArrayList<Estado>();
		Connection cn = null;
		PreparedStatement ps  = null;
		ResultSet rs = null;
		String cs = "select codigo_est, descripcion_est from estado";
		try {
			cn = MysqlConexion.getConexion();
			ps = cn.prepareStatement(cs);
			rs = ps.executeQuery();
			while(rs.next()) {
				estado = new Estado();
				estado.setCodigo(rs.getInt(1));
				estado.setDescripcion(rs.getString(2));
				estados.add(estado);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();				
		}
		// TODO Auto-generated method stub
		return estados;
	}

}
