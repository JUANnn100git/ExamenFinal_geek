package com.unmsm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.unmsm.entity.Articulo;
import com.unmsm.entity.Autor;
import com.unmsm.entity.AutorDto;
import com.unmsm.services.IArticuloService;
import com.unmsm.services.IAutorService;

@RestController
@RequestMapping("/api/autores")
public class AutorRestController {
	
	@Autowired
	private IAutorService autorService;
	
	@GetMapping("")
	public List<Autor> listar() {
		return autorService.findAll();
	}
	
	@GetMapping("/all")
	public List<AutorDto> findAllPageable(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
            						@RequestParam(value = "pageSize", required = false, defaultValue = "5") int pageSize){
		Pageable pageable = PageRequest.of(page, pageSize);
		Page<AutorDto> resultPage = autorService.findAllPageable(pageable);
		return resultPage.getContent();
	}
	
	
}
