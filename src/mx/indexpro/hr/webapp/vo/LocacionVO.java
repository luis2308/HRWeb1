package mx.indexpro.hr.webapp.vo;

public class LocacionVO {
	private int idLocacion;
	private String direccion;
	private String codigo;
	private String ciudad;
	private String estado;
	private String pais;
	public int getIdLocacion() {
		return idLocacion;
	}
	public void setIdLocacion(int idLocacion) {
		this.idLocacion = idLocacion;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}


}
