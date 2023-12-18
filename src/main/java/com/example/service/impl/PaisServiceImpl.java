package com.example.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Pais;
import com.example.repository.PaisRepository;
import com.example.service.PaisService;

@Service
public class PaisServiceImpl extends CommonServiceImpl<Pais, PaisRepository> implements PaisService {

	@Override
	public List<Pais> spfindAll() {
		return this.repo.spfindAll();
	}

	@Override
	public Pais spfindById(Integer id) {
		return this.repo.spfindById(id);
	}

	@Override
	public Pais spsavePais(String nombre, Integer estado) {
		return this.repo.spsavePais(nombre, estado);
	}

	@Override
	public Pais spupdatePais(Integer idpais, String nombre, Integer estado) {
		return this.repo.spupdatePais(idpais, nombre, estado);
	}

}
