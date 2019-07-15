package com.unmsm.services;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.unmsm.entity.Articulo;

public interface IArticuloService {

	public Page<Articulo> findAll(Pageable pageable);
	
	public Articulo save(Articulo articulo);
	
	public Page<Articulo> findByFormato(String formato, Pageable pageable);
	
	public List<Articulo> findByFechaPublicacionGreaterThan(Date fechaPublicacion);
	
	public List<Articulo> findByFechaPublicacionBetween(Date fechaInicio, Date fechaFin);
	
	public Page<Articulo> findByFormatoAndFechaPublicacionBetween(String formato, Date fechaInicio, Date fechaFin, Pageable pageable);
	


	
}
