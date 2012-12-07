package poo.sca.io;

import java.util.List;

import poo.sca.Curso;
import poo.sca.Disciplina;
import poo.sca.Professor;
import poo.sca.Turma;

public interface SCAPersistencia {

	public void salvar(Disciplina disciplina);
	public List<Disciplina> recuperarDisciplinas();
	
	public void salvar(Curso curso);
	public List<Curso> recuperarCursos();

	public void salvar(Professor professor);
	public List<Professor> recuperarProfessores();

	public void salvar(Turma turma);
	public List<Turma> recuperarTurmas();


}
