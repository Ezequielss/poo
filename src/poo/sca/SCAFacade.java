package poo.sca;

import java.util.Iterator;
import java.util.List;

import poo.sca.io.SCAPersistencia;
import poo.sca.io.SCAPersistenciaArquivo;
import poo.sca.io.SCAPersistenciaMemoria;

public class SCAFacade {
	
	private SCAPersistencia persistencia;
	
	public SCAFacade(){
		persistencia = new SCAPersistenciaArquivo();
	}

	public Disciplina criarDisciplina(String nome, int codigo) {
		Disciplina disciplina = new Disciplina(nome,codigo);
		persistencia.salvar(disciplina);
		return disciplina;
	}
	
	public Curso criarCurso(String nome, int codigo) {
		Curso curso = new Curso(nome,codigo);
		persistencia.salvar(curso);
		return curso;
	}
	
	public Professor criarProfessor(String nome, int matricula) {
		Professor professor = new Professor(nome,matricula);
		persistencia.salvar(professor);
		return professor;
	}
	
	public Turma criarTurma( String periodo,Disciplina disciplina, int numero) {
		Turma turma = new Turma(disciplina, numero, periodo);
		//persistencia.salvar(turma);
		return turma;
	}
	
	public Turma getTurma( String periodo,int codDisciplina, int numero) {
		
		for(Turma turma:persistencia.recuperarTurmas()){
			if(turma.getPeriodo().equals(periodo)&& turma.getDisciplina().getCodigo()== codDisciplina &&
					turma.getNumero()== numero){
				return turma;
			}
		}
		
		return null;
	}

	
		public Turma removerTurma( String periodo,int codDisciplina, int numero) {
				
				for(Turma turma:persistencia.recuperarTurmas()){
					if(turma.getPeriodo().equals(periodo)&& turma.getDisciplina().getCodigo()== codDisciplina &&
							turma.getNumero()== numero){
						persistencia.recuperarTurmas().remove(turma);
						
						return turma;
					}
				}
				
				return null;
			}
		
		public Iterator<Turma> getTurmasInterator() {
				
				return persistencia.recuperarTurmas().iterator();
			}
		
		public Iterator<Curso> getCursosInterator() {
			
			return persistencia.recuperarCursos().iterator();
		}
		
		public Iterator<Professor> getProfessoresInterator() {
			
			return persistencia.recuperarProfessores().iterator();
		}
		
		public Iterator<Disciplina> getDisciplinasInterator() {
			
			return persistencia.recuperarDisciplinas().iterator();
		}
		public void salvar(Turma turma) {
			persistencia.salvar(turma);
			
		}
			
		
}
