package modelo;

import java.util.Date;

public class Usuario {
	
	private  int codigo_emp  ;
	private String nomEmp ; 
	private String apePatemp ;
	private String apeMatEmp ;
	private String telfEmp ; 
	private String cargoEmp;
	private int perfil ;
	private String usuEmp;
	private String clavEmp ;
	private int sucursal;
	private boolean activo ;
	private Date fechaActualizacion;
	private int ResponActual;
	
	public int getResponActual() {
		return ResponActual;
	}
	public void setResponActual(int responActual) {
		ResponActual = responActual;
	}
	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}
	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	public int getCodigo_emp() {
		return codigo_emp;
	}
	public void setCodigo_emp(int codigo_emp) {
		this.codigo_emp = codigo_emp;
	}
	public String getNomEmp() {
		return nomEmp;
	}
	public void setNomEmp(String nomEmp) {
		this.nomEmp = nomEmp;
	}
	public String getApePatemp() {
		return apePatemp;
	}
	public void setApePatemp(String apePatemp) {
		this.apePatemp = apePatemp;
	}
	public String getApeMatEmp() {
		return apeMatEmp;
	}
	public void setApeMatEmp(String apeMatEmp) {
		this.apeMatEmp = apeMatEmp;
	}
	public String getTelfEmp() {
		return telfEmp;
	}
	public void setTelfEmp(String telfEmp) {
		this.telfEmp = telfEmp;
	}
	public String getCargoEmp() {
		return cargoEmp;
	}
	public void setCargoEmp(String cargoEmp) {
		this.cargoEmp = cargoEmp;
	}
	public int getPerfil() {
		return perfil;
	}
	public void setPerfil(int perfil) {
		this.perfil = perfil;
	}
	public String getUsuEmp() {
		return usuEmp;
	}
	public void setUsuEmp(String usuEmp) {
		this.usuEmp = usuEmp;
	}
	public String getClavEmp() {
		return clavEmp;
	}
	public void setClavEmp(String clavEmp) {
		this.clavEmp = clavEmp;
	}
	public int getSucursal() {
		return sucursal;
	}
	public void setSucursal(int sucursal) {
		this.sucursal = sucursal;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
