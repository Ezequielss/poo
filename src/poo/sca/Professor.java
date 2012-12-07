package poo.sca;

public class Professor {
	
	private int matricula;
	private String nome;
	
	public Professor(String nome, int matricula) {
		this.matricula = matricula;
		this.nome = nome;
	}
	
	public int getMatricula() {
		return matricula;
	}
	
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
