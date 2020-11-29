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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sbs.dto.AlunoDto;
import com.sbs.dto.AlunoNewDto;
import com.sbs.entities.Aluno;
import com.sbs.services.AlunoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API REST Unes-SD")
@RestController
@RequestMapping("/unes-sd")
public class AlunoResource {

	@Autowired
	private AlunoService alunoService;

	@ApiOperation(value = "Retorna um aluno por Id.")
	@GetMapping(value = "/alunos/{id}", produces = "application/json")
	public ResponseEntity<Aluno> findById(@PathVariable Integer id) {
		Aluno obj = alunoService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@ApiOperation(value = "Retorna uma lista de alunos,")
	@GetMapping(value = "/alunos", produces = "application/json")
	public ResponseEntity<List<Aluno>> findAll() {
		List<Aluno> list = alunoService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@ApiOperation(value = "Atualiza aluno.")
	@PutMapping(value = "/alunos/{id}", produces = "application/json")
	public ResponseEntity<Void> update(@RequestBody AlunoDto objDto, @PathVariable Integer id) {
		Aluno obj = alunoService.fromDto(objDto);
		obj.setId(id);
		obj = alunoService.update(obj);
		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "Salva um aluno.")
	@PostMapping(value = "/alunos")
	public ResponseEntity<Void> insert(@RequestBody AlunoNewDto objNewDto) {
		Aluno obj = alunoService.fromNewDto(objNewDto);
		obj = alunoService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
