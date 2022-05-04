package com.oasis.apigestmenu.services;

import org.springframework.stereotype.Service;
import com.oasis.apigestmenu.repositories.ColaboradorRepository;

@Service
public class ColaboradorService {
	final ColaboradorRepository colaboradorrepository;
	
	public ColaboradorService(ColaboradorRepository colaboradorrepository) {
		this.colaboradorrepository = colaboradorrepository;
	}

}
