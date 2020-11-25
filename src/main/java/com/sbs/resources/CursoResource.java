package com.sbs.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sbs.dto.CursoNewDto;
import com.sbs.entities.Curso;
import com.sbs.services.CursoService;

@RestController
public class CursoResource {
	
	@Autowired
	private CursoService cursoService;

	@GetMapping("/cursos/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Curso obj = cursoService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping("/cursos")
	public ResponseEntity<List<Curso>> findAll(){
		List<Curso> list = cursoService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PutMapping("/cursos{id}")
	public ResponseEntity<Void> update(@RequestBody CursoNewDto objDto, @PathVariable Integer id){
		Curso obj = cursoService.fromDto(objDto);
		obj.setId(id);
		obj = cursoService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/cursos")
	public ResponseEntity<Void> insert(@RequestBody CursoNewDto objNewDto) {
		Curso obj = cursoService.fromNewDto(objNewDto);
		cursoService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
		
	

}
