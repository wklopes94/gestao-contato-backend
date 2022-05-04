package com.oasis.apigestmenu.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_tipo_colaborador")
public class TipoColaboradorModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, updatable = false)
 	private UUID id;
	@Column(name = "tipo_colaborador")
	private String tipoColaborador;
	@Column(name = "utilizador")
	private String utilizador;
	@Column(name = "data_registo")
	private String dataRegisto;
	
	@OneToMany(mappedBy = "tipoColabFk")
	private List<ColaboradorModel> colaboradorModel = new ArrayList<>();
	
	
	public TipoColaboradorModel(UUID id, String tipoColaborador, String utilizador, String dataRegisto) {
		super();
		this.id = id;
		this.tipoColaborador = tipoColaborador;
		this.utilizador = utilizador;
		this.dataRegisto = dataRegisto;
	}
	public TipoColaboradorModel() {
		super();
		
	}
	public List<ColaboradorModel> getColaboradorModel() {
		return colaboradorModel;
	}
	public void setColaboradorModel(List<ColaboradorModel> colaboradorModel) {
		this.colaboradorModel = colaboradorModel;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getTipoColaborador() {
		return tipoColaborador;
	}
	public void setTipoColaborador(String tipoColaborador) {
		this.tipoColaborador = tipoColaborador;
	}
	public String getUtilizador() {
		return utilizador;
	}
	public void setUtilizador(String utilizador) {
		this.utilizador = utilizador;
	}
	public String getDataRegisto() {
		return dataRegisto;
	}
	public void setDataRegisto(String dataRegisto) {
		this.dataRegisto = dataRegisto;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoColaboradorModel other = (TipoColaboradorModel) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	

}
