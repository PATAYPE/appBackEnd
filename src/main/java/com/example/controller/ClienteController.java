package com.example.controller;

import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import com.example.entity.Cliente;
import com.example.service.ClienteService;

import jakarta.validation.Valid;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/cliente")
public class ClienteController extends CommonController<Cliente, ClienteService>{

	
	@PutMapping("/{id}")
	public ResponseEntity<?> modificarCliente(@Valid @RequestBody Cliente cli, BindingResult result, @PathVariable Integer id){
		
		if (result.hasErrors()) {
			return this.validar(result);
		}
		Optional<Cliente> op = this.service.findById(id);
		if (op.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		Cliente dbCliente = op.get();
		dbCliente.setNombres(cli.getNombres());
		dbCliente.setApellidos(cli.getApellidos());
		dbCliente.setNroDocumento(cli.getNroDocumento());
		dbCliente.setEmail(cli.getEmail());
		dbCliente.setEstado(cli.getEstado());
		dbCliente.setPais(cli.getPais());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCliente));
	}
	
	@PutMapping("/eliminar-cliente/{id}")
	public ResponseEntity<?> eliminarCliente(@Valid @RequestBody Cliente cli, BindingResult result, @PathVariable Integer id){
		
		if (result.hasErrors()) {
			return this.validar(result);
		}
		
		Optional<Cliente> op = this.service.findById(id);
		
		if (op.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		Cliente dbCliente = op.get();
		dbCliente.setNombres(cli.getNombres());
		dbCliente.setApellidos(cli.getApellidos());
		dbCliente.setNroDocumento(cli.getNroDocumento());
		dbCliente.setEmail(cli.getEmail());
		dbCliente.setEstado(cli.getEstado());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCliente));
	}
	
	@GetMapping("/pagination-params")
	public ResponseEntity<?> listClienteByPage(@RequestParam(name = "page", defaultValue = "0") int page,
												@RequestParam(name = "size", defaultValue = "3") int size){
		PageRequest pageRequest = PageRequest.of(page, size);
		Page<Cliente> p = this.service.findAllPagination(pageRequest);
		return ResponseEntity.status(HttpStatus.OK).body(p);
	}
}
