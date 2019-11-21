package interfaces;

import java.util.ArrayList;


import modelo.Cliente;
import modelo.Usuario;

public interface UsuarioInterface {
	 
	ArrayList<Usuario> obtenerUsuario(String nombre);
	Usuario obtenerUsurio(int codigo_emp);
	int modificarUsuario(Usuario us);
	 int registrarUsuario(Usuario u);
	
}
