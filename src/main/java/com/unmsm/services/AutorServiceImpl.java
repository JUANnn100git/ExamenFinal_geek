package com.unmsm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unmsm.entity.Autor;
import com.unmsm.entity.AutorDto;
import com.unmsm.models.dao.IAutorDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class AutorServiceImpl implements IAutorService {

	@Autowired
	private IAutorDao autorDao;
	

	public List<Autor> findAll() {
		// TODO Auto-generated method stub
		return autorDao.findAll();
	}


	@Override
	public Page<AutorDto> findAllPageable(Pageable pageable) {
		// TODO Auto-generated method stub
		return autorDao.findAllPageable(pageable);
	}

	


}
