package com.oasis.apigestmenu.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;

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

import com.oasis.apigestmenu.dtos.HotelDto;
import com.oasis.apigestmenu.models.HotelModel;
import com.oasis.apigestmenu.services.HotelService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/hotel")
public class HotelController {
	
	final HotelService hotelservice;

	public HotelController(HotelService hotelservice) {
		this.hotelservice = hotelservice;
	}
	
	@PostMapping
	public ResponseEntity<Object> saveHotel(@RequestBody @Valid HotelDto hotelDto){
		
	  var hotelModel = new HotelModel();
	  BeanUtils.copyProperties(hotelDto, hotelModel);
	  hotelModel.setDataRegisto(LocalDateTime.now(ZoneId.of("UTC")));
	  hotelModel.setEstado("a");
	  hotelModel.setUtilizadorReg("Samuel Lopes");
	  
	  return ResponseEntity.status(HttpStatus.CREATED).body(hotelservice.save(hotelModel));
		
		
	}
	
	@GetMapping
	public ResponseEntity<List<HotelModel>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(hotelservice.findAll());
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneHotel(@PathVariable(value="id") UUID id){
		Optional<HotelModel> HotelModelOptional = hotelservice.findById(id);
		if(!HotelModelOptional.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hotel Not Found.");
			
		}
		return ResponseEntity.status(HttpStatus.OK).body(HotelModelOptional.get());
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteHotel(@PathVariable(value="id") UUID id){
		Optional<HotelModel> HotelModelOptional = hotelservice.findById(id);
		if(!HotelModelOptional.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hotel Not Found.");
			
		}
		
		hotelservice.delete(HotelModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Hotel deleted successfuly");
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateHotel(@PathVariable(value="id") UUID id, @RequestBody @Valid HotelDto hotelDto){
		Optional<HotelModel> HotelModelOptional = hotelservice.findById(id);
		if(!HotelModelOptional.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hotel Not Found.");
			
		}
		
		
		var hotelModel = HotelModelOptional.get(); 
		BeanUtils.copyProperties(hotelDto, hotelModel);
		/*
		hotelModel.setId(HotelModelOptional.get().getId());
		hotelModel.setDataRegisto(HotelModelOptional.get().getDataRegisto());
		hotelModel.setEstado(HotelModelOptional.get().getEstado());
		hotelModel.setUtilizadorReg(HotelModelOptional.get().getUtilizadorReg());
		
		*/
		
		return ResponseEntity.status(HttpStatus.OK).body(hotelservice.save(hotelModel));
		
	}
	
	
	
	

}
