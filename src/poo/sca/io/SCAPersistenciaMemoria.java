package poo.sca.io;

import java.util.LinkedList;
import java.util.List;

import poo.sca.Curso;
import poo.sca.Disciplina;
import poo.sca.Professor;
import poo.sca.Turma;

public class SCAPersistenciaMemoria implements SCAPersistencia {

	private List<Disciplina> disciplinas;
	private List<Curso> cursos;
	private List<Professor> professores;
	private List<Turma> turmas;
	
	public SCAPersistenciaMemoria(){
		this.cursos = new LinkedList<Curso>();
		this.professores = new LinkedList<Professor>();
		this.turmas = new LinkedList<Turma>();
		this.disciplinas = new LinkedList<Disciplina>();
	}
	@Override
	public void salvar(Disciplina disciplina) {
		this.disciplinas.add(disciplina);
	}
	@Override
	public List<Disciplina> recuperarDisciplinas() {
		return disciplinas;
	}
	@Override
	public void salvar(Curso curso) {
		this.cursos.add(curso);
		
	}
	@Override
	public List<Curso> recuperarCursos() {
		return cursos;
	}
	@Override
	public void salvar(Professor professor) {
		this.professores.add(professor);
	}
	@Override
	public List<Professor> recuperarProfessores() {
		return professores;
	}
	@Override
	public void salvar(Turma turma) {
		this.turmas.add(turma);
	}
	@Override
	public List<Turma> recuperarTurmas() {
		
		return turmas;
	}

}
