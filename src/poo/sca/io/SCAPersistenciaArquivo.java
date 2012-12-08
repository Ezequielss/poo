package poo.sca.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import poo.sca.Curso;
import poo.sca.Disciplina;
import poo.sca.Professor;
import poo.sca.Turma;
import poo.sca.ui.Util;

public class SCAPersistenciaArquivo implements SCAPersistencia {
	
	private List<Disciplina> disciplinas;
	private List<Curso> cursos;
	private List<Professor> professores;
	private List<Turma> turmas;
	
	public SCAPersistenciaArquivo(){
		
		this.cursos = new LinkedList<Curso>();
		this.professores = new LinkedList<Professor>();
		this.turmas = new LinkedList<Turma>();
		this.disciplinas = new LinkedList<Disciplina>();
	}
	@Override
	public void salvar(Disciplina disciplina) {
		String arq="";
		recuperarDisciplinas();
		this.disciplinas.add(disciplina);
		
		
		for(Disciplina dis:disciplinas){
			arq+=dis.getNome()+";"+dis.getCodigo()+"\n";
			System.out.println("Professor :"+dis.getNome());
		}
		
		salvar("Disciplina.txt",arq);
		
	
	}
	@Override
	public List<Disciplina> recuperarDisciplinas() {
		
		disciplinas.clear();
		try {
			FileInputStream in = new FileInputStream("Disciplina.txt");
		
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String strLine;
	 
		  while((strLine = reader.readLine())!= null){
			  
			  StringTokenizer str = new StringTokenizer(strLine,";");
			 
			  while(str.hasMoreTokens()){
				  Disciplina disc = new Disciplina(str.nextToken(),Integer.parseInt(str.nextToken()) );
				  disciplinas.add(disc);
			  }
		  } 
		  reader.close();
		} catch (NumberFormatException | IOException e) {
			
			Util.alert("Erro ao ler arquivo \n"+e.getMessage());
		}
		
		return disciplinas;
	}
	@Override
	public void salvar(Curso curso) {
		
		String arq="";
		recuperarCursos();
		this.cursos.add(curso);
		for(Curso cur:cursos){
			arq+=cur.getNome()+";"+cur.getCodigo()+"\n";
		}
		
		salvar("Curso.txt",arq);
		
		
	}
	@Override
	public List<Curso> recuperarCursos() {
		
		cursos.clear();
		try {
			FileInputStream in = new FileInputStream("Curso.txt");
		
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String strLine;
	 
		  while((strLine = reader.readLine())!= null){
			  
			  StringTokenizer str = new StringTokenizer(strLine,";");
			 
			  while(str.hasMoreTokens()){
				  Curso curs = new Curso(str.nextToken(),Integer.parseInt(str.nextToken()) );
				  cursos.add(curs);
			  }
			 
		  } 
		  reader.close();
		} catch (NumberFormatException | IOException e) {
			
			Util.alert("Erro ao ler arquivo \n"+e.getMessage());
		}
		return cursos;
	}
	@Override
	public void salvar(Professor professor) {
		
		String arq="";
		recuperarProfessores();
		this.professores.add(professor);
		for(Professor pro:professores){
			arq+=pro.getNome()+";"+pro.getMatricula()+"\n";
		}
		
		salvar("Professor.txt",arq);
		
	}
	@Override
	public List<Professor> recuperarProfessores() {
			professores.clear();
			try {
				FileInputStream in = new FileInputStream("Professor.txt");
			
				BufferedReader reader = new BufferedReader(new InputStreamReader(in));
				String strLine;
		 
			  while((strLine = reader.readLine())!= null){
				  
				  StringTokenizer str = new StringTokenizer(strLine,";");
				 
				  while(str.hasMoreTokens()){
					  Professor prof = new Professor(str.nextToken(),Integer.parseInt(str.nextToken()) );
					  professores.add(prof);
				  }
				 
			  } 
			  reader.close();
			} catch (NumberFormatException | IOException e) {
				
				Util.alert("Erro ao ler arquivo \n"+e.getMessage());
			}
		return professores;
	}
	@Override
	public  void salvar(Turma turm) {
		this.turmas=recuperarTurmas();
		this.turmas.add(turm);
		String arq="";
		for(Turma turma:turmas){
			
			arq += turma.getNumero()+";"+turma.getDisciplina().getCodigo()+";"
					+turma.getHorario()+";"+turma.getPeriodo()+";";
			for(Curso crs : turma.getCursosIterator())
				arq+=crs.getCodigo()+";";
			
			arq+=":";	
			for(Professor prof : turma.getProfessoresIterator())
				arq+= prof.getMatricula()+";";
			
			arq+="\n";
		}
		salvar("Turma.txt", arq);
	
	}
	
	@Override
	public List<Turma> recuperarTurmas() {
		
		return buscarTurma("Turma.txt");
	}
	
	 private void salvar(String arquivo, String conteudo){

				  FileWriter fw;
				try {
					fw = new FileWriter(arquivo);
					fw.write(conteudo);
					 fw.close();
				} catch (IOException e) {
					Util.alert("Não foi possivel salvar arquivo \n "+e.getMessage());
				}
		
				Util.alert("Salvo com sucesso");
		
	}
	
	
	List<Turma> buscarTurma(String arq){
		List<Turma> turmList  = new LinkedList<>();
		try{
			  
			  recuperarCursos();
			  recuperarDisciplinas();
			  recuperarProfessores();
			  FileInputStream in = new FileInputStream(arq);
			  BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  boolean cntinua = true;
			  int cont=0;
			  Turma turma = null;
			  while((strLine = reader.readLine())!= null){
				  StringTokenizer str = new StringTokenizer(strLine,";");
				  String mesg;
				  
				  while(str.hasMoreTokens() ){
					  mesg=str.nextToken();
					  char inm =':';
					  if( inm == mesg.charAt(0)){
						  StringTokenizer nova = new StringTokenizer(mesg,":");
						  mesg= nova.nextToken();
						  cntinua = false;
					  }
					  if(cont==0){
						  String disc = str.nextToken();
						  
						  Disciplina disciplina=null;
						  for(Disciplina dic : disciplinas){
							  if(dic.getCodigo()== Integer.parseInt(disc))
								  disciplina=dic;
						  }
						  String hora=str.nextToken();
						  turma = new Turma(disciplina, Integer.parseInt(mesg), str.nextToken());
						  turma.setHorario(hora);
						  cont++;
					  }
					  else if( cntinua ){
						 
						  for(Curso curs :cursos){
							  if(curs.getCodigo()== Integer.parseInt(mesg)){
								  turma.addCurso(curs);
							  }
						  }
						  
					  }else{
						  for(Professor prof :professores){
							  if(prof.getMatricula()== Integer.parseInt(mesg)){
								  turma.addProfessor(prof);
							  }
						  }
					  }
				  }
				  if(turma != null)
					  turmList.add(turma);
				  cont=0;
				  cntinua = true;
			  }
			  reader.close();
			}catch(Exception e){
			  Util.alert(e.getMessage());
			}
		return turmList;
	}

}
