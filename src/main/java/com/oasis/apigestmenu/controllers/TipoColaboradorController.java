package com.oasis.apigestmenu.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
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
import org.springframework.web.bind.annotation.RestController;
import com.oasis.apigestmenu.dtos.TipoColaboradorDto;
import com.oasis.apigestmenu.models.TipoColaboradorModel;
import com.oasis.apigestmenu.services.TipoColaboradorService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/tipocolaborador")
public class TipoColaboradorController {

	final TipoColaboradorService tipocolaboradorservice;

	public TipoColaboradorController(TipoColaboradorService tipocolaboradorservice) {
		this.tipocolaboradorservice = tipocolaboradorservice;
	}

	@PostMapping
	public ResponseEntity<Object> saveTipoColaborador(@RequestBody @Valid TipoColaboradorDto tipoColaboradorDto) {

		var tipoolaboradorModel = new TipoColaboradorModel();
		BeanUtils.copyProperties(tipoColaboradorDto, tipoolaboradorModel);
		tipoolaboradorModel.setDataRegisto(LocalDateTime.now(ZoneId.of("UTC")));
		tipoolaboradorModel.setUtilizador("Samuel Lopes");

		return ResponseEntity.status(HttpStatus.CREATED).body(tipocolaboradorservice.save(tipoolaboradorModel));

	}

	@GetMapping
	public ResponseEntity<List<TipoColaboradorModel>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(tipocolaboradorservice.findAll());

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneTipoColaborador(@PathVariable(value="id") UUID id){
		Optional<TipoColaboradorModel> tipoColaboradorModelOptional = tipocolaboradorservice.findById(id);
		if(!tipoColaboradorModelOptional.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo de Colaborador Not Found.");
			
		}
		return ResponseEntity.status(HttpStatus.OK).body(tipoColaboradorModelOptional.get());
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteTipoColaborador(@PathVariable(value="id") UUID id){
		Optional<TipoColaboradorModel> tipoColaboradorModelOptional = tipocolaboradorservice.findById(id);
		if(!tipoColaboradorModelOptional.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo de Colaborador Not Found.");
			
		}
		
		tipocolaboradorservice.delete(tipoColaboradorModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Tipo de Colaborador deleted successfuly");
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateTipoColaborador(@PathVariable(value="id") UUID id, @RequestBody @Valid TipoColaboradorDto tipoColaboradorDto){
		Optional<TipoColaboradorModel> tipoColaboradorModelOptional = tipocolaboradorservice.findById(id);
		if(!tipoColaboradorModelOptional.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tipo de Colaborador Not Found.");
			
		}
		
		
		var tipoColaboradorModel = tipoColaboradorModelOptional.get(); 
		BeanUtils.copyProperties(tipoColaboradorDto, tipoColaboradorModel);
		/*
		hotelModel.setId(HotelModelOptional.get().getId());
		hotelModel.setDataRegisto(HotelModelOptional.get().getDataRegisto());
		hotelModel.setEstado(HotelModelOptional.get().getEstado());
		hotelModel.setUtilizadorReg(HotelModelOptional.get().getUtilizadorReg());
		
		*/
		
		return ResponseEntity.status(HttpStatus.OK).body(tipocolaboradorservice.save(tipoColaboradorModel));
		
	}

}
