package interfaces;

import java.util.ArrayList;


import modelo.Cliente;
import modelo.Empleado;

public interface UsuarioInterface {
	 
	ArrayList<Empleado> obtenerUsuario(String nombre);
	Empleado obtenerUsurio(int codigo_emp);
	int modificarUsuario(Empleado us);
	 int registrarUsuario(Empleado u);
	
}
