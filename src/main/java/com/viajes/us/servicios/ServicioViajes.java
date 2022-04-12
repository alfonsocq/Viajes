package com.viajes.us.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.viajes.us.modelos.Gasto;
import com.viajes.us.repositorios.RepositorioViajes;

@Service
public class ServicioViajes {
	
	private final RepositorioViajes repositorio;
	
	public ServicioViajes(RepositorioViajes repo) {
		this.repositorio = repo;
	}
	
	public List<Gasto> get_gastos(){
		return repositorio.findAll();
	}
	
	public Gasto find_gasto(Long id) {
		Optional<Gasto> optionalGasto = repositorio.findById(id);
		if(optionalGasto.isPresent()) {
			return optionalGasto.get();
		}else {
			return null;
		}
	}
	
	public Gasto save_gasto(Gasto gasto) {
		return repositorio.save(gasto);
	}
	
	public void delete_gasto(Long id) {
		repositorio.deleteById(id);
	}
	
	
}