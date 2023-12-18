package com.example.service;

import java.util.List;

import com.example.entity.Pais;


public interface PaisService extends CommonService<Pais, Integer>{

	
	List<Pais> spfindAll();
	
	Pais spfindById(Integer id);
	
	Pais spsavePais(String nombre, Integer estado);
	
	Pais spupdatePais(Integer idpais, String nombre, Integer estado);
	
}
