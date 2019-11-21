package modelo;

import java.util.Date;

public class Cliente {

	
	private Integer suministroId;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno; 
	private String documento;  
	private String razonSocial; 
	private String telefono;  
	private String celular;  
	private String email;  
	private Usuario empleado;  
	private Date fechaActualizacion;  
	private String direccion; 
	private Date fechaInscripcion;
	private String documentoAntiguo;
	private boolean activo;
	
	public Cliente() {
		
	}
	
	public Integer getSuministroId() {
		return suministroId;
	}


	public void setSuministroId(Integer suministroId) {
		this.suministroId = suministroId;
	}


	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Usuario getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Usuario empleado) {
		this.empleado = empleado;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}
	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Date getFechaInscripcion() {
		return fechaInscripcion;
	}
	public void setFechaInscripcion(Date fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}


	public String getDocumentoAntiguo() {
		return documentoAntiguo;
	}


	public void setDocumentoAntiguo(String documentoAntiguo) {
		this.documentoAntiguo = documentoAntiguo;
	}
	
	
}
