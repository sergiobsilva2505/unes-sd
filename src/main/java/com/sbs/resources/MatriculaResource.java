package com.sbs.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sbs.dto.MatriculaDto;
import com.sbs.dto.MatriculaNewDto;
import com.sbs.entities.Matricula;
import com.sbs.services.MatriculaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="API REST Unes-SD")
@RestController
@RequestMapping(value = "/unes-sd")
public class MatriculaResource {

	@Autowired
	private MatriculaService matriculaService;

	@ApiOperation(value = "Retorna todas as matriculas. (select *)")
	@GetMapping(value = "/matriculas", produces = "application/json")
	public ResponseEntity<List<MatriculaDto>> findAll() {
		List<Matricula> list = matriculaService.findAll();
		List<MatriculaDto> listDto = list.stream().map(obj -> new MatriculaDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
//	@ApiOperation(value = "Retorna matricula por id. (select by id)")
//	@GetMapping(value = "/matriculas/{id}", produces = "application/json")
//	@GetMapping("/matriculas/{id}")
//	public ResponseEntity<Matricula> finById(@PathVariable Integer id) {
//		Matricula obj = matriculaService.findById(id);
//		//MatriculaDto> listDto = list.stream().map(obj -> new MatriculaDto(obj)).collect(Collectors.toList());
//		return ResponseEntity.ok().body(obj);
//	}
	
	@ApiOperation(value = "Retorna matricula por id. (select by id)")
	@GetMapping(value = "/matriculas/{id}", produces = "application/json")
	public ResponseEntity<MatriculaDto> finById(@PathVariable Integer id) {
		Matricula obj = matriculaService.findById(id);
		MatriculaDto objDto = matriculaService.fromDto(obj);
		return ResponseEntity.ok().body(objDto);
	}
	
	@ApiOperation(value = "Salva matrícula. (insert)")
	@PostMapping(value = "/matriculas", produces = "application/json")
	public ResponseEntity<Void> insert(@RequestBody MatriculaNewDto objNewDto) {
		Matricula obj = matriculaService.fromNewDto(objNewDto);
		obj = matriculaService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation(value = "Deleta matricula. (delete)")
	@DeleteMapping(value = "matriculas/{id}", produces = "application/json")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		matriculaService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
