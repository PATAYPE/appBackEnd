package com.example.service.impl;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.service.CommonService;



public class CommonServiceImpl<E, R extends CrudRepository<E, Integer>> implements CommonService<E, Integer>{

	@Autowired
	protected R repo;
	
	
	@Override
	public E save(E e) {
		return repo.save(e);
	}

	
	@Override
	@Transactional(readOnly = true)
	public Iterable<E> findAll() {
		return repo.findAll();
	}

	
	@Override
	@Transactional(readOnly = true)
	public Optional<E> findById(Integer id) {
		return repo.findById(id);
	}

	
	@Override
	public void delete(Integer id) {
		repo.deleteById(id);
		
	}

}
