package com.oasis.apigestmenu.dtos;

import javax.validation.constraints.NotBlank;

public class ExtensaoDto {
	
	@NotBlank
	private Integer numero;

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	

}
