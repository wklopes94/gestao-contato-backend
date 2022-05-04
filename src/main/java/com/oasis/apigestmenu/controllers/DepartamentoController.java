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

import com.oasis.apigestmenu.dtos.DepartamentoDto;

import com.oasis.apigestmenu.models.DepartamentoModel;

import com.oasis.apigestmenu.services.DepartamentoService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/departamento")
public class DepartamentoController {

	@Autowired
	private DepartamentoService service;

	@GetMapping
	public ResponseEntity<List<DepartamentoModel>> getAllDepartamento() {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());

	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneHotel(@PathVariable(value = "id") UUID id) {
		Optional<DepartamentoModel> departamentoModelOptional = service.findById(id);
		if (!departamentoModelOptional.isPresent()) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hotel Not Found.");

		}
		return ResponseEntity.status(HttpStatus.OK).body(departamentoModelOptional.get());

	}

	@PostMapping
	public ResponseEntity<DepartamentoModel> create(@RequestParam(value = "hotelFk", defaultValue = "0") UUID id_hotel,
			@RequestBody DepartamentoModel departamentoModel) {
		DepartamentoModel newObj = service.save(id_hotel, departamentoModel);

		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/departamento/{id}")
				.buildAndExpand(newObj.getId()).toUri();

		return ResponseEntity.created(uri).build();

	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateDepartamento(@PathVariable(value = "id") UUID id,
			@RequestBody @Valid DepartamentoDto departamentoDto) {
		Optional<DepartamentoModel> departamentoModelOptional = service.findById(id);
		if (!departamentoModelOptional.isPresent()) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Departamento Not Found.");

		}

		var departamentoModel = departamentoModelOptional.get();
		BeanUtils.copyProperties(departamentoDto, departamentoModel);
		return ResponseEntity.status(HttpStatus.OK).body(service.saves(departamentoModel));

	}

}