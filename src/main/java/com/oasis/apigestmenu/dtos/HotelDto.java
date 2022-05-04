package com.oasis.apigestmenu.dtos;

import javax.validation.constraints.NotBlank;

public class HotelDto {
	

	@NotBlank
	private String nome;
	@NotBlank
	private String numeroFixo;

	

	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNumeroFixo() {
		return numeroFixo;
	}
	public void setNumeroFixo(String numeroFixo) {
		this.numeroFixo = numeroFixo;
	}

	

}
