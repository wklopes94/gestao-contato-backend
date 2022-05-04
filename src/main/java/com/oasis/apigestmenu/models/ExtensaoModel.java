package com.oasis.apigestmenu.models;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_extensao")
public class ExtensaoModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, updatable = false)
	private UUID id;
	@Column(name = "numero")
	private Integer numero;
	@Column(name = "hotel")
	private String hotel;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "tbl_departamento_id")
	private DepartamentoModel departamentoFk;
	
	

	public ExtensaoModel() {
		super();
		
	}
	

	public ExtensaoModel(UUID id, Integer numero, String hotel, DepartamentoModel departamentoFk) {
		super();
		this.id = id;
		this.numero = numero;
		this.hotel = hotel;
		this.departamentoFk = departamentoFk;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	public DepartamentoModel getDepartamentoFk() {
		return departamentoFk;
	}

	public void setDepartamentoFk(DepartamentoModel departamentoFk) {
		this.departamentoFk = departamentoFk;
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
		ExtensaoModel other = (ExtensaoModel) obj;
		return Objects.equals(id, other.id);
	}

}
