package com.sbs;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sbs.entities.Aluno;
import com.sbs.entities.Curso;
import com.sbs.entities.Matricula;
import com.sbs.entities.Professor;
import com.sbs.repositories.AlunoRepository;
import com.sbs.repositories.CursoRepository;
import com.sbs.repositories.MatriculaRepository;
import com.sbs.repositories.ProfessorRepository;

@SpringBootApplication
public class UnesApplication implements CommandLineRunner {

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private CursoRepository cursoRepository;

	@Autowired
	private ProfessorRepository professorRepository;

	@Autowired
	private MatriculaRepository matriculaRepository;

	public static void main(String[] args) {
		SpringApplication.run(UnesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Professor prof1 = new Professor(null, "Nina Maria");
		Professor prof2 = new Professor(null, "Jose Inacio");
		Professor prof3 = new Professor(null, "Alessandro Wingerter");
		Professor prof4 = new Professor(null, "Marcelo Onuki");
		Professor prof5 = new Professor(null, "Simone Viana");
		Professor prof6 = new Professor(null, "Alexandre Stucchi");
		Professor prof7 = new Professor(null, "Agenor campos");
		Professor prof8 = new Professor(null, "Mario Rocha");
		Professor prof9 = new Professor(null, "Robson Escotiel");
		Professor prof10 = new Professor(null, "Julio Oliveira");

		professorRepository
				.saveAll(Arrays.asList(prof1, prof2, prof3, prof4, prof5, prof6, prof7, prof8, prof9, prof10));

		Curso curso1 = new Curso(null, "Administração", "ADM", prof7);
		Curso curso2 = new Curso(null, "Nutrição", "NUT", prof8);
		Curso curso3 = new Curso(null, "Pedagogia", "PED", prof2);
		Curso curso4 = new Curso(null, "Fisioterapia", "FSO", prof1);
		Curso curso5 = new Curso(null, "Educação Fisica", "EDF", prof6);

		cursoRepository.saveAll(Arrays.asList(curso1, curso2, curso3, curso4, curso5));

		Aluno alu1 = new Aluno(null, "Michele Silva");
		Aluno alu2 = new Aluno(null, "Julia Costa");
		Aluno alu3 = new Aluno(null, "Mayara Silveira");
		Aluno alu4 = new Aluno(null, "Bob Brown");
		Aluno alu5 = new Aluno(null, "Margaret Tatcher");
		Aluno alu6 = new Aluno(null, "Barack Obama");
		Aluno alu7 = new Aluno(null, "Lucious Lopez");

		alunoRepository.saveAll(Arrays.asList(alu1, alu2, alu3, alu4, alu5, alu6, alu7));

		LocalDate hoje = LocalDate.now();

		Matricula mat1 = new Matricula(null, alu1, curso1, hoje);
		Matricula mat2 = new Matricula(null, alu1, curso2, hoje);
		Matricula mat3 = new Matricula(null, alu2, curso3, hoje);
		Matricula mat4 = new Matricula(null, alu2, curso4, hoje);
		Matricula mat5 = new Matricula(null, alu3, curso5, hoje);
		Matricula mat6 = new Matricula(null, alu3, curso4, hoje);

		matriculaRepository.saveAll(Arrays.asList(mat1, mat2, mat3, mat4, mat5, mat6));

	}

}
