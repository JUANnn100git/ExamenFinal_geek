package com.unmsm.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.unmsm.entity.Autor;
import com.unmsm.entity.AutorDto;

public interface IAutorDao extends JpaRepository<Autor, Long> {
	
	//@Query("SELECT a.nombres AS nombres, 23 AS total FROM Autor a")
	
	@Query(value="SELECT a.id as id, a.nombres as nombres, a.apellidos as apellidos, "
			   + "a.institucion as institucion, COUNT(aa.autor_id) as total "
			   + "FROM autor a LEFT JOIN articulo_autor aa ON aa.autor_id = a.id "
			   + "GROUP BY a.id, a.nombres, a.apellidos, a.institucion ", 
			   countQuery = "SELECT COUNT(1) FROM (SELECT a.id as id, a.nombres as nombres, a.apellidos as apellidos, " 
			   		+ "a.institucion as institucion, COUNT(aa.autor_id) as total "
			   		+ "FROM autor a LEFT JOIN articulo_autor aa ON aa.autor_id = a.id "
			   		+ "GROUP BY a.id, a.nombres, a.apellidos, a.institucion) AS T",
			nativeQuery = true)
	Page<AutorDto> findAllPageable(Pageable pageable);

}
