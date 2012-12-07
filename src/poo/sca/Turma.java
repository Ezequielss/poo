package poo.sca;


import java.util.LinkedList;
import java.util.List;



public class Turma {
		
	private Disciplina disciplina;
	private List<Professor> professores;
	private String horario;
	private List<Curso> cursos;
	private int numero;
	private String periodo;
	
	public Turma(Disciplina disciplina, int numero, String periodo) {
		this.disciplina =disciplina;
		this.numero = numero;
		this.periodo = periodo;
		this.professores = new LinkedList<Professor>();
		this.cursos = new LinkedList<Curso>();
	}
	
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	public List<Professor> getProfessoresIterator() {
		return professores;
	}
	public void addProfessor(Professor professor) {
		this.professores.add(professor);
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public List<Curso> getCursosIterator() {
		return cursos;
	}
	public void addCurso(Curso curso) {
		this.cursos.add(curso);
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
	

}
