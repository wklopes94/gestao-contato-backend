package com.oasis.apigestmenu.dtos;

import javax.validation.constraints.NotBlank;



import com.oasis.apigestmenu.models.HotelModel;

public class DepartamentoDto {
	

	@NotBlank
	private String nome;
	/*@NotBlank
	//private HotelModel hotelFk;

	public HotelModel getHotelFk() {
		return hotelFk;
	}

	public void setHotelFk(HotelModel hotelFk) {
		this.hotelFk = hotelFk;
	}
*/
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

	
}
