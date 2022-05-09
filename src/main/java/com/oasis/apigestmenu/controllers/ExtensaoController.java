package com.oasis.apigestmenu.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.oasis.apigestmenu.dtos.ExtensaoDto;
import com.oasis.apigestmenu.models.ExtensaoModel;
import com.oasis.apigestmenu.services.ExtensaoService;
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/extensao")
public class ExtensaoController {

	@Autowired
	private ExtensaoService service;

	@GetMapping
	public ResponseEntity<List<ExtensaoModel>> getAllExtensao() {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());

	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneExtensao(@PathVariable(value = "id") UUID id) {
		Optional<ExtensaoModel> extensaoModelOptional = service.findById(id);
		if (!extensaoModelOptional.isPresent()) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hotel Not Found.");

		}
		return ResponseEntity.status(HttpStatus.OK).body(extensaoModelOptional.get());

	}

	@PostMapping
	public ResponseEntity<ExtensaoModel> create(
			@RequestParam(value = "departamentoFk", defaultValue = "0") UUID id_departamento,
			@RequestBody ExtensaoModel extensaoModel) {
		ExtensaoModel newObj = service.save(id_departamento, extensaoModel);

		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/extensao/{id}")
				.buildAndExpand(newObj.getId()).toUri();

		return ResponseEntity.created(uri).build();

	}
	
	/*Neste Update eu coloquie como atribuito o model so para enviar o numero autualizado*/

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateExtensao(@PathVariable(value = "id") UUID id,
			@RequestBody @Valid ExtensaoDto extensaoDto) {
		Optional<ExtensaoModel> extensaoModelOptional = service.findById(id);
		if (!extensaoModelOptional.isPresent()) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Extensão Not Found.");

		}

		var extensaoModel = extensaoModelOptional.get();
		BeanUtils.copyProperties(extensaoDto, extensaoModel);
		  
		return ResponseEntity.status(HttpStatus.OK).body(service.saves(extensaoModel));

	}
	

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteExtensao(@PathVariable(value = "id") UUID id) {
		Optional<ExtensaoModel> ExtensaoModelOptional = service.findById(id);
		if (!ExtensaoModelOptional.isPresent()) {
	
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Extensão Not Found.");
	
		}
	
		service.delete(ExtensaoModelOptional.get());
		
		return ResponseEntity.status(HttpStatus.OK).body("Extensão deleted successfuly");
	
	}
}
