package com.unmsm.models.dao;

import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.unmsm.entity.Articulo;


public interface IArticuloDao extends JpaRepository<Articulo, Long> {
	
	public Page<Articulo> findByFormato(String formato, Pageable pageable);
	
	public List<Articulo> findByFechaPublicacionGreaterThan(Date fechaPublicacion);
	
	public List<Articulo> findByFechaPublicacionBetween(Date fechaInicio, Date fechaFin);
	
	public Page<Articulo> findByFormatoAndFechaPublicacionBetween(String formato, Date fechaInicio, Date fechaFin, Pageable pageable);


}
