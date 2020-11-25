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

import com.sbs.dto.AlunoDto;
import com.sbs.dto.AlunoNewDto;
import com.sbs.entities.Aluno;
import com.sbs.services.AlunoService;

@RestController
public class AlunoResource {

	@Autowired
	private AlunoService alunoService;

	@GetMapping("/alunos/{id}")
	public ResponseEntity<Aluno> findById(@PathVariable Integer id) {
		Aluno obj = alunoService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping("/alunos")
	public ResponseEntity<List<Aluno>> findAll() {
		List<Aluno> list = alunoService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@PutMapping("/alunos/{id}")
	public ResponseEntity<Void> update(@RequestBody AlunoDto objDto, @PathVariable Integer id) {
		Aluno obj = alunoService.fromDto(objDto);
		obj.setId(id);
		obj = alunoService.update(obj);
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/alunos")
	public ResponseEntity<Void> insert(@RequestBody AlunoNewDto objNewDto) {
		Aluno obj = alunoService.fromNewDto(objNewDto);
		obj = alunoService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping("/alunos/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		alunoService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
