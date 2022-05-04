package com.oasis.apigestmenu.dtos;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.NumberFormat;



public class ColaboradorDto {
	
	@NotBlank
	private String nomeColab;
	@NumberFormat
	private String telefoneColab;
	@NotBlank
	private String estensaoColab;
	@NotBlank
	@Email
	private String emailColab;
	@NotBlank
	private String enderecoColab;
	@NotBlank
	private String utilizador;
	@NotBlank
	private LocalDateTime dataRegisto;
	@NotBlank
	private String numeroRh;
	@NotBlank
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
	public String getNumeroRh() {
		return numeroRh;
	}
	public void setNumeroRh(String numeroRh) {
		this.numeroRh = numeroRh;
	}
	public String getHotel() {
		return hotel;
	}
	public void setHotel(String hotel) {
		this.hotel = hotel;
	}
	
	

}
