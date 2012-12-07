package poo.sca.ui;

import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import poo.sca.Disciplina;
import poo.sca.SCAFacade;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class Sca extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JMenu jMenuCadastro;
	private JMenu jMenuExibir;
	private JMenuBar jMenuBar;
	private JMenuItem cadDiscplina;
	private JMenuItem cadTurma;
	private JMenuItem cadProfessor;
	private JMenuItem cadCurso;
	private JMenuItem exibDiscplina;
	private JMenuItem exibTurma;
	private JMenuItem exibProfessor;
	private JMenuItem exibCurso;
	private SCAFacade scaFacade;
	
	
	
	
	
	
	public Sca() {
		scaFacade = new SCAFacade();
		initComponents();
	}
	
	
	
	private void initComponents() {
		{
			FormListener formListener = new FormListener();
			//this.setPreferredSize(new java.awt.Dimension(583, 358));
			this.setSize(583, 358);
			
			{
				jMenuBar = new JMenuBar();
				setJMenuBar(jMenuBar);
				{
					jMenuCadastro = new JMenu();
					jMenuBar.add(jMenuCadastro);
					jMenuCadastro.setText("Cadastrar");
				}
				{
					
					jMenuExibir = new JMenu();
					jMenuBar.add(jMenuExibir);
					jMenuExibir.setText("Exibir");
				}
				
				cadCurso = new JMenuItem();
				cadCurso.setText("Curso");
				cadCurso.addActionListener(formListener);
				jMenuCadastro.add(cadCurso);
				
				cadDiscplina = new JMenuItem();
				cadDiscplina.setText("Disciplina");
				cadDiscplina.addActionListener(formListener);
				jMenuCadastro.add(cadDiscplina);
				
				cadProfessor = new JMenuItem();
				cadProfessor.setText("Professor");
				cadProfessor.addActionListener(formListener);
				jMenuCadastro.add(cadProfessor);
				
				cadTurma = new JMenuItem();
				cadTurma.setText("Turma");
				cadTurma.addActionListener(formListener);
				jMenuCadastro.add(cadTurma);
				
				
			}
			{
				exibCurso = new JMenuItem();
				exibCurso.setText("Curso");
				exibCurso.addActionListener(formListener);
				jMenuExibir.add(exibCurso);
				
				exibDiscplina = new JMenuItem();
				exibDiscplina.setText("Disciplina");
				exibDiscplina.addActionListener(formListener);
				jMenuExibir.add(exibDiscplina);
				
				exibProfessor = new JMenuItem();
				exibProfessor.setText("Professor");
				exibProfessor.addActionListener(formListener);
				jMenuExibir.add(exibProfessor);
				
				exibTurma = new JMenuItem();
				exibTurma.setText("Turma");
				exibTurma.addActionListener(formListener);
				jMenuExibir.add(exibTurma);
			}
		}


        
    }  
	
	public static void main(String []ars){
		
		Sca sca = new Sca();
		
		sca.setLocationRelativeTo(null);
		sca.setVisible(true);
		sca.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	private class FormListener implements java.awt.event.ActionListener {
		
        FormListener() {}
        
        public void actionPerformed(java.awt.event.ActionEvent evt) {
        	
        	
            if (evt.getSource() == cadProfessor) {
            	
            	  new CadProfessor(scaFacade);
                
            }else if(evt.getSource() == cadDiscplina){
            	new CadDisciplina(scaFacade);
            }
            else if(evt.getSource() == cadCurso){
            	new CadCurso(scaFacade);
            	
            }else if(evt.getSource() == cadTurma){
            	new CadTurma(scaFacade);
            	
            }else if(evt.getSource() == exibProfessor){
            	new ViewProf(scaFacade);
            }else if(evt.getSource() == exibTurma){
            	new ViewTurma(scaFacade);
            }
            
            
        }

	}
	
	
	
}

