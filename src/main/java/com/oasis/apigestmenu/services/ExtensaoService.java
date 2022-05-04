package com.oasis.apigestmenu.services;


import org.springframework.stereotype.Service;

import com.oasis.apigestmenu.repositories.ExtensaoRepository;

@Service
public class ExtensaoService {
	final ExtensaoRepository extensaorepository;
	
	public ExtensaoService(ExtensaoRepository extensaorepository) {
		this.extensaorepository = extensaorepository;
	}

}
