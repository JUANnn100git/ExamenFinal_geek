package com.unmsm.controllers;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.unmsm.entity.Articulo;
import com.unmsm.services.IArticuloService;

@RestController
@RequestMapping("/api/articulos")
public class ArticuloRestController {
	
	@Autowired
	private IArticuloService articuloService;
	
	@GetMapping("")
	public List<Articulo> listar(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
    		                     @RequestParam(value = "pageSize", required = false, defaultValue = "5") int pageSize) {
		Pageable pageable = PageRequest.of(page, pageSize);
		Page<Articulo> resultPage = articuloService.findAll(pageable);
		return resultPage.getContent();
	}
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Articulo crear(@Valid @RequestBody Articulo articulo) {
			return articuloService.save(articulo);
	}
	
	@GetMapping("/{formato}")
	public List<Articulo> obtenerPorFormato(@PathVariable String formato,
											@RequestParam(value = "page", required = false, defaultValue = "0") int page,
								            @RequestParam(value = "pageSize", required = false, defaultValue = "5") int pageSize){
		Pageable pageable = PageRequest.of(page, pageSize);
		Page<Articulo> resultPage = articuloService.findByFormato(formato, pageable);
		return resultPage.getContent();
	}
	
	@GetMapping("/fecha/{fechaPublicacion}")
	public List<Articulo> obtenerPorFechaPublicacion(@PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") Date fechaPublicacion ){
		return articuloService.findByFechaPublicacionGreaterThan(fechaPublicacion);
	}
	
	@GetMapping("/fechas/{fechaInicio}/{fechaFin}")
	public List<Articulo> obtenerPorFechasPublicacion(@PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") Date fechaInicio, @PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") Date fechaFin ){
		return articuloService.findByFechaPublicacionBetween(fechaInicio, fechaFin);
	}
	
	@GetMapping("/formato/{formato}/fechaPublicacion/{fechaInicio}/{fechaFin}")
	public List<Articulo> obtenerPorFortamoYFechasPublicacion(@PathVariable String formato,
			                                                  @PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") Date fechaInicio,
			                                                  @PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") Date fechaFin,
			                                                  @RequestParam(value = "page", required = false, defaultValue = "0") int page,
			                     		                      @RequestParam(value = "pageSize", required = false, defaultValue = "5") int pageSize){
		Pageable pageable = PageRequest.of(page, pageSize);
		Page<Articulo> resultPage = articuloService.findByFormatoAndFechaPublicacionBetween(formato, fechaInicio, fechaFin, pageable);
		return resultPage.getContent();
	}



}
