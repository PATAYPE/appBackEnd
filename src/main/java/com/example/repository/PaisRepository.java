package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.entity.Pais;

public interface PaisRepository extends CrudRepository<Pais, Integer> {

	
	@Query(value=" select * from fn_paislistall()" , nativeQuery = true)
	List<Pais> spfindAll();
	
	
	@Query(value=" select * from fn_paisfindbyid(:id)" , nativeQuery = true)
	Pais spfindById(Integer id);
	
	@Query(value="select * from fn_paisInsert(:nombre,:estado)" , nativeQuery = true)
	Pais spsavePais(@Param("nombre") String nombre,@Param("estado") Integer estado);
	
	@Query(value="select * from fn_paisUpdate(:idpais,:nombre,:estado)" , nativeQuery = true)
	Pais spupdatePais(@Param("idpais") Integer idpais, @Param("nombre") String nombre, @Param("estado") Integer estado);
	
}
