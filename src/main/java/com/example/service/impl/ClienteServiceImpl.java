package com.example.service.impl;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.entity.Cliente;
import com.example.repository.ClienteRepository;
import com.example.service.ClienteService;



@Service
public class ClienteServiceImpl extends CommonServiceImpl<Cliente, ClienteRepository> implements ClienteService {

	@Override
	public Page<Cliente> findAllPagination(Pageable page) {
		
		return this.repo.findAll(page);
	}

	


	

}
