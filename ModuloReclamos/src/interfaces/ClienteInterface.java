package interfaces;

import java.util.ArrayList;

import modelo.Cliente;

public interface ClienteInterface {

	 
	ArrayList<Cliente> obtenerCliente(String dni, String nombre,String apellido, String suministro);
	Cliente obtenerCliente(String suministro);
	int actualizarCliente(Cliente cliente);
}
