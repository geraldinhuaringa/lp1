package interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Departamento;
import modelo.Distrito;
import modelo.Provincia;
import modelo.TipoComponente;

public interface UbigeoInterface {

	
	ArrayList<Departamento> listaDepartamento() throws SQLException;
	ArrayList<Provincia> listaProvincia(int codigoDepartamento) throws SQLException;
	ArrayList<Distrito> listaDistrito(int codigoProvincia) throws SQLException;
	int crearDepartamento(String nombre) throws SQLException;
	int crearProvincia(int codigoDepartamento, String nombre)  throws SQLException;
	int crearDistrito(int codigoDepartamento, int codigoProvincia, String nombre, int estado) throws SQLException;
	
}
