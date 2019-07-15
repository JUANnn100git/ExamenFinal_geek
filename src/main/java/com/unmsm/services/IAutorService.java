package com.unmsm.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.unmsm.entity.Autor;
import com.unmsm.entity.AutorDto;

public interface IAutorService {

	public List<Autor> findAll();

	public Page<AutorDto> findAllPageable(Pageable pageable);
	

	
}
