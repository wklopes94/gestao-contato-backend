package com.oasis.apigestmenu.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_departamento")
public class DepartamentoModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, updatable = false)
 	private UUID id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "data_registo")
	private LocalDateTime dataRegisto;
	@Column(name = "estado")
	private String estado;
	@Column(name = "utilizador")
	private String utilizador;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "tbl_hotel_id")
	private HotelModel hotelFk;
	@OneToMany(mappedBy = "departamentoFk")
	private List<ColaboradorModel> colaboradorModel = new ArrayList<>();
	@OneToMany(mappedBy = "departamentoFk")
	private List<ExtensaoModel> extensaoModel = new ArrayList<>();
	
	
	
	public List<ExtensaoModel> getExtensaoModel() {
		return extensaoModel;
	}

	public void setExtensaoModel(List<ExtensaoModel> extensaoModel) {
		this.extensaoModel = extensaoModel;
	}

	public List<ColaboradorModel> getColaboradorModel() {
		return colaboradorModel;
	}

	public void setColaboradorModel(List<ColaboradorModel> colaboradorModel) {
		this.colaboradorModel = colaboradorModel;
	}

	public DepartamentoModel() {
		super();
	}
	
	public DepartamentoModel(UUID id, String nome, LocalDateTime dataRegisto, String estado, String utilizador,
			HotelModel hotelFk) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataRegisto = dataRegisto;
		this.estado = estado;
		this.utilizador = utilizador;
		this.hotelFk = hotelFk;
	}

	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getUtilizador() {
		return utilizador;
	}
	public void setUtilizador(String utilizador) {
		this.utilizador = utilizador;
	}
	public HotelModel getHotelFk() {
		return hotelFk;
	}
	public void setHotelFk(HotelModel hotelFk) {
		this.hotelFk = hotelFk;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public LocalDateTime getDataRegisto() {
		return dataRegisto;
	}
	public void setDataRegisto(LocalDateTime dataRegisto) {
		this.dataRegisto = dataRegisto;
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
		DepartamentoModel other = (DepartamentoModel) obj;
		return Objects.equals(id, other.id);
	}
	

	
	

}
