package com.example.controller;



import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.service.CommonService;

import jakarta.validation.Valid;

public class CommonController<E, S extends CommonService<E , Integer>> {
	
	@Autowired
	protected S service;
	
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id){
		Optional<E> opEntity = service.findById(id);
		if (opEntity.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(opEntity.get());
	}
	
	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody E entity, BindingResult result){
		if (result.hasErrors()) {
			return validar(result);
		}
		E eDB = service.save(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(eDB);
	}
	
	protected ResponseEntity<?> validar(BindingResult result){
		
		Map<String, Object> errores = new HashMap<>();
		
		result.getFieldErrors().forEach( err -> {
			errores.put( err.getField() , "Alerta : "+err.getDefaultMessage() );
		} );
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errores);
	}
	/*
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}*/

}
