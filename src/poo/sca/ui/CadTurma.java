package poo.sca.ui;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import poo.sca.Disciplina;
import poo.sca.SCAFacade;
import poo.sca.Turma;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;

public class CadTurma extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jLabelCodigo;
	private JTextField jTextFieldCod;
	private JButton jButtonSalvar;
	private JButton jButtonRemoveProf;
	private JButton jButtonAddProf;
	private JButton jButtonRemoveCurso;
	private JButton jButtonAddCurso;
	private JLabel jLabel4;
	private JLabel jLabel3;
	private JList<String> jListProfDisp;
	private JLabel jLabel5;
	private JTextField jTextFieldHorario;
	private JList<String> jListProfAdd;
	private JLabel jLabel2;
	private JList<String> jListCusosAdd;
	private JList<String> jListCursosDisp;
	private JLabel jLabelCursosDisp;
	private JLabel jLabel1;
	private JPanel jPanel;
	private JButton jButtonCancelar;
	private JTextField jTextFieldPeriodo;
	private JLabel jLabelDisciplina;
	private JDialog janela = this;
	private SCAFacade scaFacade;
	private FormListener formListener ;
	private DefaultListModel<String> listaProfAdd ;
	private DefaultListModel<String> listaProfDisp ;
	private DefaultListModel<String> listaCursoAdd;
	private DefaultListModel<String> listaCursoDisp ;
	JComboBox<String> jCombDisciplinas ;
	private List<Disciplina> listaDisciplina;
	
	
	CadTurma(SCAFacade scaFacade){
		this.scaFacade = scaFacade;
		this.listaDisciplina = new ArrayList<>();
		setModal(true);
		setTitle("Cadastro de Turma");
		initGUI();
		setLocationRelativeTo(null);
		Util.preencheCombCurso(listaCursoDisp , scaFacade);
		Util.preencheCombProf(listaProfDisp,scaFacade);
		setVisible(true);
		
	}

	private void initGUI() {
		try {
			
			listaProfAdd = new DefaultListModel<String>();
			listaProfDisp = new DefaultListModel<String>();
			listaCursoAdd = new DefaultListModel<String>();
		    listaCursoDisp = new DefaultListModel<String>();
			  
			formListener = new FormListener();
			

			
			{
				
				this.setLayout(null);
				{
					jPanel = new JPanel();
					AnchorLayout jPanelLayout = new AnchorLayout();
					getContentPane().add(jPanel);
					jPanel.setBounds(0, 0, 661, 392);
					jPanel.setLayout(jPanelLayout);
					jPanel.setBackground(new java.awt.Color(64,128,128));
					{
						jCombDisciplinas = new JComboBox(); 
						jCombDisciplinas.setBounds(79, 112, 231, 25);
//						jCombDisciplinas.setSelectedIndex(4);
						jPanel.add(jCombDisciplinas);
						jCombDisciplinas.addActionListener(formListener); 
						Util.preencheCombDiscp(jCombDisciplinas,scaFacade,listaDisciplina);
					}
					{
						jButtonRemoveCurso = new JButton();
						jPanel.add(jButtonRemoveCurso, new AnchorConstraint(710, 276, 769, 200, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						jButtonRemoveCurso.setText("<");
						jButtonRemoveCurso.setPreferredSize(new java.awt.Dimension(50, 23));
						jButtonRemoveCurso.addActionListener(formListener);
					}
					{
						jButtonAddCurso = new JButton();
						jPanel.add(jButtonAddCurso, new AnchorConstraint(526, 276, 585, 200, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						jButtonAddCurso.setText(">");
						jButtonAddCurso.setPreferredSize(new java.awt.Dimension(50, 23));
						jButtonAddCurso.addActionListener(formListener);
					}
					{
						
						jListCursosDisp = new JList<String>();
						
						jListCursosDisp.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);  
						jPanel.add(jListCursosDisp, new AnchorConstraint(470, 192, 871, 11, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						jListCursosDisp.setModel(listaCursoDisp);
						jListCursosDisp.setPreferredSize(new java.awt.Dimension(120, 157));
					}
					{
						jLabelCursosDisp = new JLabel();
						jPanel.add(jLabelCursosDisp, new AnchorConstraint(414, 195, 455, 18, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						jLabelCursosDisp.setText("Cursos Disponíveis");
						jLabelCursosDisp.setPreferredSize(new java.awt.Dimension(117, 16));
					}
					{
						jLabelCodigo = new JLabel();
						jPanel.add(jLabelCodigo, new AnchorConstraint(126, 132, 225, 26, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						jLabelCodigo.setText("Número");
						jLabelCodigo.setForeground(new java.awt.Color(255,255,255));
						jLabelCodigo.setFont(new java.awt.Font("Segoe UI",1,14));
						jLabelCodigo.setPreferredSize(new java.awt.Dimension(70, 39));
					}
					{
						jTextFieldCod = new JTextField();
						jPanel.add(jTextFieldCod, new AnchorConstraint(144, 342, 200, 121, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						jTextFieldCod.setPreferredSize(new java.awt.Dimension(146, 22));
						jTextFieldCod.setFont(new java.awt.Font("Segoe UI",0,16));

					}
					{
						jLabelDisciplina = new JLabel();
						jPanel.add(jLabelDisciplina, new AnchorConstraint(287, 127, 364, 20, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						jLabelDisciplina.setText("Disciplina");
						jLabelDisciplina.setForeground(new java.awt.Color(255,255,255));
						jLabelDisciplina.setFont(new java.awt.Font("Segoe UI",1,14));
						jLabelDisciplina.setPreferredSize(new java.awt.Dimension(67, 26));
					}
					{
						jTextFieldPeriodo = new JTextField();
						jPanel.add(jTextFieldPeriodo, new AnchorConstraint(144, 911, 200, 537, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						jTextFieldPeriodo.setPreferredSize(new java.awt.Dimension(247, 22));
						jTextFieldPeriodo.setFont(new java.awt.Font("Segoe UI",0,16));
					}
					{
						jButtonSalvar = new JButton();
						jPanel.add(jButtonSalvar, new AnchorConstraint(886, 970, 973, 831, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						jButtonSalvar.setText("Salvar");
						jButtonSalvar.setPreferredSize(new java.awt.Dimension(92, 34));
						jButtonSalvar.addActionListener(formListener);
					}
					{
						jButtonCancelar = new JButton();
						jPanel.add(jButtonCancelar, new AnchorConstraint(886, 814, 970, 683, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						jButtonCancelar.setText("Cancelar");
						jButtonCancelar.setPreferredSize(new java.awt.Dimension(87, 33));
						jButtonCancelar.addActionListener(formListener);
					}
					{
						jLabel1 = new JLabel();
						jPanel.add(jLabel1, new AnchorConstraint(126, 545, 225, 439, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						jLabel1.setText("Periodo");
						jLabel1.setForeground(new java.awt.Color(255,255,255));
						jLabel1.setFont(new java.awt.Font("Segoe UI",1,14));
						jLabel1.setPreferredSize(new java.awt.Dimension(70, 39));
					}
					{
						
						jListCusosAdd = new JList<String>();
						jListCusosAdd.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);  
						jPanel.add(jListCusosAdd, new AnchorConstraint(470, 466, 871, 283, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						jListCusosAdd.setModel(listaCursoAdd);
						jListCusosAdd.setPreferredSize(new java.awt.Dimension(121, 157));
					}
					{
						jLabel2 = new JLabel();
						jPanel.add(jLabel2, new AnchorConstraint(414, 460, 455, 283, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						jLabel2.setText("Cursos Adicionados");
						jLabel2.setPreferredSize(new java.awt.Dimension(117, 16));
					}
					{
						
						jListProfAdd = new JList<String>();
						jListProfAdd.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);  
						jPanel.add(jListProfAdd, new AnchorConstraint(470, 984, 871, 801, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						jListProfAdd.setModel(listaProfAdd);
						jListProfAdd.setPreferredSize(new java.awt.Dimension(121, 157));
					}
					{
						
						jListProfDisp = new JList<String>();
						jListProfDisp.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);  
						jPanel.add(jListProfDisp, new AnchorConstraint(470, 704, 871, 512, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						jListProfDisp.setModel(listaProfDisp);
						jListProfDisp.setPreferredSize(new java.awt.Dimension(127, 157));
					}
					{
						jLabel3 = new JLabel();
						jPanel.add(jLabel3, new AnchorConstraint(414, 704, 455, 527, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						jLabel3.setText("Prof. Disponíveis");
						jLabel3.setPreferredSize(new java.awt.Dimension(117, 16));
					}
					{
						jLabel4 = new JLabel();
						jPanel.add(jLabel4, new AnchorConstraint(414, 978, 455, 801, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						jLabel4.setText("Profrs. Adicionados");
						jLabel4.setPreferredSize(new java.awt.Dimension(117, 16));
					}
					{
						jButtonAddProf = new JButton();
						jPanel.add(jButtonAddProf, new AnchorConstraint(526, 791, 585, 722, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						jButtonAddProf.setText(">");
						jButtonAddProf.setPreferredSize(new java.awt.Dimension(46, 23));
						jButtonAddProf.addActionListener(formListener);
					}
					{
						jButtonRemoveProf = new JButton();
						jPanel.add(jButtonRemoveProf, new AnchorConstraint(710, 790, 769, 722, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						jButtonRemoveProf.setText("<");
						jButtonRemoveProf.setPreferredSize(new java.awt.Dimension(45, 23));
						jButtonRemoveProf.addActionListener(formListener);
					}
					{
						jTextFieldHorario = new JTextField();
						jPanel.add(jTextFieldHorario, new AnchorConstraint(286, 911, 350, 605, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						jTextFieldHorario.setFont(new java.awt.Font("Segoe UI",0,16));
						jTextFieldHorario.setPreferredSize(new java.awt.Dimension(202, 25));
					}
					{
						jLabel5 = new JLabel();
						jPanel.add(jLabel5, new AnchorConstraint(264, 618, 363, 512, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						jLabel5.setText("Horário");
						jLabel5.setForeground(new java.awt.Color(255,255,255));
						jLabel5.setPreferredSize(new java.awt.Dimension(70, 39));
						jLabel5.setFont(new java.awt.Font("Segoe UI",1,14));
					}

				}
				this.setSize(677, 431);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private class FormListener implements java.awt.event.ActionListener {
		
	  
	    
	    public void actionPerformed(java.awt.event.ActionEvent evt) {
	    	
	    	
	        if (evt.getSource() == jButtonSalvar) {
	        	
//	        	boolean status = Util.verificaString(jTextFieldPeriodo.getText());
	        	
		        	if(Util.validaInt(jTextFieldCod.getText())
		        			&& jCombDisciplinas.getSelectedIndex()>0)
		        	{
		        		
		        		Turma turma= scaFacade.criarTurma(jTextFieldPeriodo.getText(),listaDisciplina.get(jCombDisciplinas.getSelectedIndex()-1), Integer.parseInt(jTextFieldCod.getText()));
		        		turma.setHorario(jTextFieldHorario.getText());
			        			
        				if(listaCursoAdd.getSize()>0){
        					Util.insertCurso(listaCursoAdd, scaFacade, turma);
        					
        				}if(listaProfAdd.getSize()>0){
        					Util.insertProf(listaProfAdd, scaFacade, turma);
        					
        				}
        				
        				scaFacade.salvar(turma);
        				if(!Util.novamente()){
		        			janela.dispose();
		        		}else{
		        			limpaCampos();
		        		}
		        			
		        	}else{
		        		Util.alert("Selcione uma diciplina!");
		        		limpaCampos();
		        	}
	        
	        }else if(evt.getSource() == jButtonCancelar){
	        	janela.dispose();
	        }
		    else if(evt.getSource() == jButtonAddCurso){
		    	
		    	if(jListCursosDisp.getSelectedIndex()>=0){
		    		listaCursoAdd.addElement(listaCursoDisp.remove(jListCursosDisp.getSelectedIndex()));
	        	}
	        }
		    else if(evt.getSource() == jButtonRemoveCurso){
		    	if(jListCusosAdd.getSelectedIndex()>=0){
		    		listaCursoDisp.addElement(listaCursoAdd.remove(jListCusosAdd.getSelectedIndex()));
	        	}
		    }else if(evt.getSource() == jButtonAddProf){
		    	if(jListProfDisp.getSelectedIndex()>=0){
		    		listaProfAdd.addElement(listaProfDisp.remove(jListProfDisp.getSelectedIndex()));
		    	}
		    }
		    else if(evt.getSource() == jButtonRemoveProf){
		    	
		    	if(jListProfAdd.getSelectedIndex()>=0){
		    		listaProfDisp.addElement(listaProfAdd.remove(jListProfAdd.getSelectedIndex()));
	        	}
		    }
	    }
	}
	
	private void limpaCampos(){
		jTextFieldPeriodo.setText("");
		jTextFieldHorario.setText("");
    	jTextFieldCod.setText("");
    	listaProfAdd.removeAllElements();
    	listaCursoAdd.removeAllElements();
    	listaCursoDisp.removeAllElements();
    	listaProfDisp.removeAllElements();
    	Util.preencheCombCurso(listaCursoDisp , scaFacade);
		Util.preencheCombProf(listaProfDisp,scaFacade);
    	jTextFieldCod.requestFocus();
	}
	
	
	
	
	
}
