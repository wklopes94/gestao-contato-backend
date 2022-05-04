package com.oasis.apigestmenu.services;


import org.springframework.stereotype.Service;

import com.oasis.apigestmenu.repositories.TipoColaboradorRepository;

@Service
public class TipoColaboradorService {
	final TipoColaboradorRepository tipocolaboradorrepository;
	
	public TipoColaboradorService(TipoColaboradorRepository tipocolaboradorrepository) {
		this.tipocolaboradorrepository = tipocolaboradorrepository;
	}

}
