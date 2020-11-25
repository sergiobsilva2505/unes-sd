package com.sbs.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sbs.dto.MatriculaDto;
import com.sbs.dto.MatriculaNewDto;
import com.sbs.entities.Matricula;
import com.sbs.services.MatriculaService;

@RestController
public class MatriculaResource {

	@Autowired
	private MatriculaService matriculaService;

	@GetMapping("/matriculas")
	public ResponseEntity<List<MatriculaDto>> findAll() {
		List<Matricula> list = matriculaService.findAll();
		List<MatriculaDto> listDto = list.stream().map(obj -> new MatriculaDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
//	@GetMapping("/matriculas/{id}")
//	public ResponseEntity<Matricula> finById(@PathVariable Integer id) {
//		Matricula obj = matriculaService.findById(id);
//		//MatriculaDto> listDto = list.stream().map(obj -> new MatriculaDto(obj)).collect(Collectors.toList());
//		return ResponseEntity.ok().body(obj);
//	}
	
	@GetMapping("/matriculas/{id}")
	public ResponseEntity<MatriculaDto> finById(@PathVariable Integer id) {
		Matricula obj = matriculaService.findById(id);
		MatriculaDto objDto = matriculaService.fromDto(obj);
		return ResponseEntity.ok().body(objDto);
	}
	
	@PostMapping("/matriculas")
	public ResponseEntity<Void> insert(@RequestBody MatriculaNewDto objNewDto) {
		Matricula obj = matriculaService.fromNewDto(objNewDto);
		obj = matriculaService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
}
