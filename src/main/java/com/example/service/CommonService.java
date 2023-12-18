package com.example.service;

import java.util.Optional;

public interface CommonService <E, Integer>{

	E save (E t);
	
	Iterable<E> findAll();
	
	Optional<E> findById(Integer id);
	
	void delete(Integer id);	
}
