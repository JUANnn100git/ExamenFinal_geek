package com.unmsm.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name="articulo")

public class Articulo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "##[El titulo no puede ser nulo]##")
	private String titulo;
	
	@NotEmpty(message = "##[El formato no puede ser nulo]##")
	@Pattern(regexp="^(IEEE|ACM|APA)$",message="##[El formato solo permite (IEEE, ACM o APA)]##")
	private String formato;
	
	@NotNull(message = "##[La fecha de publicación no puede ser nula]##")
	@Column(name = "fecha_publicacion")
    @Temporal(TemporalType.DATE)
    private Date fechaPublicacion;
	

	@NotEmpty(message = "##[El autor(es) es obligatio]##")
	@ManyToMany(fetch = FetchType.LAZY,
	        cascade = {
	                CascadeType.MERGE,
	                CascadeType.REFRESH
	            })
    @JoinTable(name = "articulo_autor",
				joinColumns = @JoinColumn(name = "articulo_id", referencedColumnName = "id"), 
				inverseJoinColumns = @JoinColumn(name = "autor_id", referencedColumnName = "id"))
    private Set<Autor> autores;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public Set<Autor> getAutores() {
		return autores;
	}


	public void setAutores(Set<Autor> autores) {
		this.autores = autores;
	}


	public String getFormato() {
		return formato;
	}


	public void setFormato(String formato) {
		this.formato = formato;
	}


	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}


	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}





}


	
	