package com.sbs.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sbs.dto.ProfessorDto;
import com.sbs.entities.Professor;
import com.sbs.services.ProfessorService;

@RestController
public class ProfessorResource {

	@Autowired
	private ProfessorService professorService;

	@GetMapping("/professores/{id}")
	public ResponseEntity<Professor> findById(@PathVariable Integer id) {
		Professor obj = professorService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping("/professores")
	public ResponseEntity<List<Professor>> findAll() {
		List<Professor> list = professorService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@PutMapping("/professores/{id}")
	public ResponseEntity<Void> update(@RequestBody ProfessorDto objDto, @PathVariable Integer id) {
		Professor obj = professorService.fromDto(objDto);
		obj.setId(id);
		obj = professorService.update(obj);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/professores")
	public ResponseEntity<Void> insert(@RequestBody ProfessorDto objNewDto) {
		Professor obj = professorService.fromDto(objNewDto);
		obj = professorService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping("/professores/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		professorService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
