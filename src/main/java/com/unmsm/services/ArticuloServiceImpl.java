package com.unmsm.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.unmsm.entity.Articulo;
import com.unmsm.models.dao.IArticuloDao;

@Service
public class ArticuloServiceImpl implements IArticuloService {

	@Autowired
	private IArticuloDao articuloDao;

	public Page<Articulo> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return articuloDao.findAll(pageable);
	}

	@Override
	public Articulo save(Articulo articulo) {
		// TODO Auto-generated method stub
		return articuloDao.save(articulo);
	}

	@Override
	public Page<Articulo> findByFormato(String formato, Pageable pageable) {
		// TODO Auto-generated method stub
		return articuloDao.findByFormato(formato, pageable);
	}

	@Override
	public List<Articulo> findByFechaPublicacionGreaterThan(Date fechaPublicacion) {
		// TODO Auto-generated method stub
		return articuloDao.findByFechaPublicacionGreaterThan(fechaPublicacion);
	}

	@Override
	public List<Articulo> findByFechaPublicacionBetween(Date fechaInicio, Date fechaFin) {
		// TODO Auto-generated method stub
		return articuloDao.findByFechaPublicacionBetween(fechaInicio, fechaFin);
	}

	@Override
	public Page<Articulo> findByFormatoAndFechaPublicacionBetween(String formato, Date fechaInicio, Date fechaFin, Pageable pageable) {
		// TODO Auto-generated method stub
		return articuloDao.findByFormatoAndFechaPublicacionBetween(formato, fechaInicio, fechaFin, pageable);
	}


}
