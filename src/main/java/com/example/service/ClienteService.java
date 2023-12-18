package com.example.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.entity.Cliente;

public interface ClienteService extends CommonService<Cliente,Integer>{

	
	Page<Cliente> findAllPagination(Pageable page);
}
