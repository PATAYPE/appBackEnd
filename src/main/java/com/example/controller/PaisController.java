package com.example.controller;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.Pais;
import com.example.service.PaisService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/pais")
public class PaisController extends CommonController<Pais, PaisService> {
	
	
	@Override
	@GetMapping("/procedure")
	public ResponseEntity<?> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(this.service.spfindAll());
	}

	@Override
	@GetMapping("/procedure/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(this.service.spfindById(id));
	}
	

	@PutMapping("/{id}")
	public ResponseEntity<?> modificarPais(@Valid @RequestBody Pais pais, BindingResult result, @PathVariable Integer id){
		
		if (result.hasErrors()) {
			return this.validar(result);
		}
		Optional<Pais> op = this.service.findById(id);
		if (op.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		Pais dbPais = op.get();
		dbPais.setNombre(pais.getNombre());
		dbPais.setEstado(pais.getEstado());		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbPais));
	}
	
	@PutMapping("/eliminar-pais/{id}")
	public ResponseEntity<?> eliminarPais(@Valid @RequestBody Pais pais, BindingResult result, @PathVariable Integer id){
		if (result.hasErrors()) {
			return this.validar(result);
		}	
		Optional<Pais> op = this.service.findById(id);
		if (op.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		Pais dbPais = op.get();
		dbPais.setEstado(pais.getEstado());		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbPais));
	}
	
}
