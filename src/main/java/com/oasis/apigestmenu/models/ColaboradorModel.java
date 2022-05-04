package com.oasis.apigestmenu.models;

import java.io.Serializable;
import java.time.LocalDateTime;
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
@Table(name = "tbl_colaborador")
public class ColaboradorModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, updatable = false)
	private UUID id;


	@Column(name = "nome_colab")
	private String nomeColab;
	@Column(name = "telefone_colab")
	private String telefoneColab;
	@Column(name = "estensao_colab")
	private String estensaoColab;
	@Column(name = "email_colab")
	private String emailColab;
	@Column(name = "endereco_colab")
	private String enderecoColab;
	@Column(name = "utilizador")
	private String utilizador;
	@Column(name = "data_registo")
	private LocalDateTime dataRegisto;
	@ManyToOne
	@JoinColumn(name = "extensao_fk")
	private ExtensaoModel extensaofk;
	@Column(name = "id_foto")
	private String idFoto;
	@Column(name = "cni")
	private String cni;
	@Column(name = "nif")
	private String nif;
	@Column(name = "numero_rh")
	private String numeroRh;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "tipo_colab_fk")
	private TipoColaboradorModel tipoColabFk;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "tbl_departamento_id")
	private DepartamentoModel departamentoFk;
	
	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getId() {
		return id;
	}

	public ColaboradorModel() {
		super();

	}

	public DepartamentoModel getDepartamentoFk() {
		return departamentoFk;
	}

	public void setDepartamentoFk(DepartamentoModel departamentoFk) {
		this.departamentoFk = departamentoFk;
	}

	@Column(name = "hotel")
	private String hotel;

	
	public String getNomeColab() {
		return nomeColab;
	}

	public void setNomeColab(String nomeColab) {
		this.nomeColab = nomeColab;
	}

	public String getTelefoneColab() {
		return telefoneColab;
	}

	public void setTelefoneColab(String telefoneColab) {
		this.telefoneColab = telefoneColab;
	}

	public String getEstensaoColab() {
		return estensaoColab;
	}

	public void setEstensaoColab(String estensaoColab) {
		this.estensaoColab = estensaoColab;
	}

	public String getEmailColab() {
		return emailColab;
	}

	public void setEmailColab(String emailColab) {
		this.emailColab = emailColab;
	}

	public String getEnderecoColab() {
		return enderecoColab;
	}

	public void setEnderecoColab(String enderecoColab) {
		this.enderecoColab = enderecoColab;
	}

	public String getUtilizador() {
		return utilizador;
	}

	public void setUtilizador(String utilizador) {
		this.utilizador = utilizador;
	}

	public LocalDateTime getDataRegisto() {
		return dataRegisto;
	}

	public void setDataRegisto(LocalDateTime dataRegisto) {
		this.dataRegisto = dataRegisto;
	}

	public ExtensaoModel getExtensaofk() {
		return extensaofk;
	}

	public void setExtensaofk(ExtensaoModel extensaofk) {
		this.extensaofk = extensaofk;
	}

	public String getIdFoto() {
		return idFoto;
	}

	public void setIdFoto(String idFoto) {
		this.idFoto = idFoto;
	}

	public String getCni() {
		return cni;
	}

	public void setCni(String cni) {
		this.cni = cni;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNumeroRh() {
		return numeroRh;
	}

	public void setNumeroRh(String numeroRh) {
		this.numeroRh = numeroRh;
	}

	public TipoColaboradorModel getTipoColabFk() {
		return tipoColabFk;
	}

	public void setTipoColabFk(TipoColaboradorModel tipoColabFk) {
		this.tipoColabFk = tipoColabFk;
	}

	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
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
		ColaboradorModel other = (ColaboradorModel) obj;
		return Objects.equals(id, other.id);
	}

}
