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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.oasis.apigestmenu.dtos.ColaboradorDto;
import com.oasis.apigestmenu.models.ColaboradorModel;
import com.oasis.apigestmenu.services.ColaboradorService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/colaborador")
public class ColaboradorController {
	
	@Autowired
	private ColaboradorService service;

	@GetMapping
	public ResponseEntity<List<ColaboradorModel>> getAllColaborador() {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());

	}
	
	@PostMapping
	public ResponseEntity<ColaboradorModel> create(@RequestParam(value = "departamentoFk", defaultValue = "0") UUID id_departamento,
			@RequestParam(value = "tipoColabFk", defaultValue = "0") UUID id_tipo_colab,
			@RequestBody ColaboradorModel colaboradorModel) {
		ColaboradorModel newObj = service.save(id_departamento, id_tipo_colab, colaboradorModel);

		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/colaborador")
				.buildAndExpand(newObj.getId()).toUri();

		return ResponseEntity.created(uri).build();

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateColaborador(@PathVariable(value = "id") UUID id,
			@RequestBody @Valid ColaboradorDto colaboradorDto) {
		Optional<ColaboradorModel> colaboradorModelOptional = service.findById(id);
		if (!colaboradorModelOptional.isPresent()) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Colaborador Not Found.");

		}

		var colaboradorModel = colaboradorModelOptional.get();
		BeanUtils.copyProperties(colaboradorDto, colaboradorModel);
		return ResponseEntity.status(HttpStatus.OK).body(service.saves(colaboradorModel));

	}

}
