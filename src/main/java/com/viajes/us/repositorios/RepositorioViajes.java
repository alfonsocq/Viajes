package com.viajes.us.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.viajes.us.modelos.Gasto;

@Repository
public interface RepositorioViajes extends CrudRepository<Gasto, Long>{
	
	List<Gasto> findAll();
	List<Gasto> findById(long id);
	
	Gasto save(Gasto gasto);
	
	void deleteById(Long id);
}