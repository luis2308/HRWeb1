package mx.indexpro.hr.webapp.vo;

import java.io.Serializable;

public class PuestoVO implements Serializable{
	private String idPuesto;
	private String nomPuesto;
	private int minSalario;
	private int maxSalario;
	public String getIdPuesto() {
		return idPuesto;
	}
	public void setIdPuesto(String idPuesto) {
		this.idPuesto = idPuesto;
	}
	public String getNomPuesto() {
		return nomPuesto;
	}
	public void setNomPuesto(String nomPuesto) {
		this.nomPuesto = nomPuesto;
	}
	public int getMinSalario() {
		return minSalario;
	}
	public void setMinSalario(int minSalario) {
		this.minSalario = minSalario;
	}
	public int getMaxSalario() {
		return maxSalario;
	}
	public void setMaxSalario(int maxSalario) {
		this.maxSalario = maxSalario;
	}
	
	

}
