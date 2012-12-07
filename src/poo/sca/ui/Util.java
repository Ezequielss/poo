package poo.sca.ui;

import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import poo.sca.Curso;
import poo.sca.Disciplina;
import poo.sca.Professor;
import poo.sca.SCAFacade;
import poo.sca.Turma;

public class Util {
	
	public Util() {
		
	}
	
	
	
	
	public static boolean verificaString(String str){
		if(str == null || str.equals("")){
			alert("Campo não pode ser Vazio!");
			return false;
		}
		int cont=0;
		String caracter = "abcdefghijlmnopqrstuvxkwyzABCDEFGAIJLMNOPQRSTUVXZKWY";
		String numeros ="0123456789";
		for(int i = 0; i<str.length();i++){
			if(numeros.contains(String.valueOf(str.charAt(0)))){
				alert("Nome não pode iniciar com número!");
				return false;
			}
			else if(caracter.contains(String.valueOf(str.charAt(i)))){
				System.out.println(str.length()+"  "+str.charAt(i));
				++cont;
				
			}
			
		}
		if(cont >=3){
			
			return true;
		}else{
			alert("Campo deve conter mais de 2 letras"); 
			return false;
		}
		
	}
	
	
//	public static  void main(String[] args){
//		
//		verificaString(null);
//		verificaString("        ");
//		verificaString("234432");
//		
//	}
	
	public static void alert(String msg){
		JOptionPane.showMessageDialog(null,msg);
	}
	
	public static boolean novamente(){
		int result = JOptionPane.showConfirmDialog(null,"Deseja fazer novo cadastro ? ","Novo",JOptionPane.YES_NO_OPTION);  
        
        if (result == JOptionPane.YES_OPTION)  
          return true;  
         else  
          return false;
	}
	
	
	public static boolean validaInt(String num){
		String numeros ="0123456789";
		int cont=0;
		for(int i = 0; i<num.length();i++){
			if(numeros.contains(String.valueOf(num.charAt(i)))){
				++cont;
			}	
		}
		if((num.length()-1)>cont){
			alert("Campo numerico contém caracter inválido");
			return false;
		}
			
		
	return true;
	}
	
	
	
	public static void preencheCombDiscp(JComboBox<String> comb,SCAFacade scaFacade, List<Disciplina> listDisc){
		
		Iterator inte = scaFacade.getDisciplinasInterator();
		comb.addItem("Selecione uma Disciplina");
		while (inte.hasNext()) {
			Disciplina dic =(Disciplina) inte.next();
			listDisc.add(dic);
			comb.addItem(dic.getNome());
		}
    }
	/**
	 * 
	 * @param listaProfDisp
	 * @param scaFacade
	 */
	public static void preencheCombProf(DefaultListModel<String> listaProfDisp,SCAFacade scaFacade){
		Iterator inte = scaFacade.getProfessoresInterator();
		
		while (inte.hasNext()) {
			Professor p =(Professor) inte.next();
			listaProfDisp.addElement(p.getNome());
			
		}
    }
	
	public static void preencheCombCurso(DefaultListModel<String> listaCursoDisp,SCAFacade scaFacade){
		Iterator inte = scaFacade.getCursosInterator();
		
		while (inte.hasNext()) {
			Curso c =(Curso) inte.next();
			listaCursoDisp.addElement(c.getNome());
			
		}
    }
	public static void	insertCurso(DefaultListModel<String> listaCursoDisp,SCAFacade scaFacade,Turma turma){
		Iterator inte = scaFacade.getCursosInterator();
		
		while (inte.hasNext()) {
			Curso c =(Curso) inte.next();
			for(int i = 0;i< listaCursoDisp.getSize();i++){
				if(listaCursoDisp.get(i).equals(c.getNome())){
					turma.addCurso(c);
				}
			}
		}
    }
	
	public static void	insertProf(DefaultListModel<String> listaProfAdd,SCAFacade scaFacade,Turma turma){
		Iterator inte = scaFacade.getProfessoresInterator();
		
		while (inte.hasNext()) {
			Professor p =(Professor) inte.next();
			for(int i = 0;i< listaProfAdd.getSize();i++){
				if(listaProfAdd.get(i).equals(p.getNome())){
					turma.addProfessor(p);
				}
			}
		}
    }
}