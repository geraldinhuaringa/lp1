package modelo;

public class Distrito extends TipoComponente {
	private Estado estado;

	
	public Distrito() {
		super();
		this.estado = new Estado();
	
	}
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
	
}
