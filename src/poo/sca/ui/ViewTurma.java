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

import poo.sca.Curso;
import poo.sca.Disciplina;
import poo.sca.Professor;
import poo.sca.SCAFacade;
import poo.sca.Turma;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;


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
public class ViewTurma extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jLabelCodigo;
	private JTextField jTextFieldCod;
	private JButton jButtonNext;
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
	private JButton jButtonReview;
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
	private List<Turma> listTurma;
	private int size=0;
	
	
	ViewTurma(SCAFacade scaFacade){
		this.scaFacade = scaFacade;
		this.listTurma = new ArrayList<>();
		Iterator<Turma> itturm = scaFacade.getTurmasInterator();
		while(itturm.hasNext()){
			this.listTurma.add(itturm.next()); 
		
		}
		
		setModal(true);
		setTitle("Cadastro de Turma");
		initGUI();
		jButtonReview.setEnabled(false);
		preencheCampos();
		setLocationRelativeTo(null);
//		Util.preencheCombCurso(listaCursoDisp , scaFacade);
//		Util.preencheCombProf(listaProfDisp,scaFacade);
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
//						Util.preencheCombDiscp(jCombDisciplinas,scaFacade);
					}
					{
						jButtonRemoveCurso = new JButton();
						jPanel.add(jButtonRemoveCurso, new AnchorConstraint(710, 276, 769, 200, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						jButtonRemoveCurso.setText("<");
						jButtonRemoveCurso.setPreferredSize(new java.awt.Dimension(50, 23));
						jButtonRemoveCurso.setVisible(false);
						jButtonRemoveCurso.addActionListener(formListener);
					}
					{
						jButtonAddCurso = new JButton();
						jPanel.add(jButtonAddCurso, new AnchorConstraint(526, 276, 585, 200, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						jButtonAddCurso.setText(">");
						jButtonAddCurso.setPreferredSize(new java.awt.Dimension(50, 23));
						jButtonAddCurso.setVisible(false);
						jButtonAddCurso.addActionListener(formListener);
					}
					{
						
						jListCursosDisp = new JList<String>();
						
						jListCursosDisp.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);  
						jPanel.add(jListCursosDisp, new AnchorConstraint(470, 192, 871, 11, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						jListCursosDisp.setModel(listaCursoDisp);
						jListCursosDisp.setPreferredSize(new java.awt.Dimension(120, 157));
						jListCursosDisp.setEnabled(false);
						jListCursosDisp.setVisible(false);
					}
					{
						jLabelCursosDisp = new JLabel();
						jPanel.add(jLabelCursosDisp, new AnchorConstraint(414, 195, 455, 18, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						jLabelCursosDisp.setText("Cursos Disponíveis");
						jLabelCursosDisp.setPreferredSize(new java.awt.Dimension(117, 16));
						jLabelCursosDisp.setVisible(false);
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
						jButtonNext = new JButton();
						jPanel.add(jButtonNext, new AnchorConstraint(924, 651, 988, 512, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						jButtonNext.setText(">>");
						jButtonNext.setPreferredSize(new java.awt.Dimension(92, 25));
						jButtonNext.addActionListener(formListener);
					}
					{
						jButtonReview = new JButton();
						jPanel.add(jButtonReview, new AnchorConstraint(927, 415, 985, 283, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						jButtonReview.setText("<<");
						jButtonReview.setPreferredSize(new java.awt.Dimension(87, 23));
						jButtonReview.addActionListener(formListener);
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
						jListProfDisp.setVisible(false);
					}
					{
						jLabel3 = new JLabel();
						jPanel.add(jLabel3, new AnchorConstraint(414, 704, 455, 527, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						jLabel3.setText("Prof. Disponíveis");
						jLabel3.setPreferredSize(new java.awt.Dimension(117, 16));
						jLabel3.setVisible(false);
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
						jButtonAddProf.setVisible(false);
						jButtonAddProf.addActionListener(formListener);
					}
					{
						jButtonRemoveProf = new JButton();
						jPanel.add(jButtonRemoveProf, new AnchorConstraint(710, 790, 769, 722, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						jButtonRemoveProf.setText("<");
						jButtonRemoveProf.setPreferredSize(new java.awt.Dimension(45, 23));
						jButtonRemoveProf.setVisible(false);
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
	    	
	    	
	        if (evt.getSource() == jButtonNext) {
	        	
	        	jButtonReview.setEnabled(true);
	        	if(size<listTurma.size()-1)
	        	{
	        		
	        		++size;
	        		if(size== listTurma.size()-1)
	        			 jButtonNext.setEnabled(false);
	        		
	        		preencheCampos();
	        	}
	        	
	        	
	        
	        }else if(evt.getSource() == jButtonReview){
	        	jButtonNext.setEnabled(true);
	        	if(size>0)
	        	{
	        		--size;
	        		if(size == 0)
	        			jButtonReview.setEnabled(false);
	        		
	        		preencheCampos();
	        		
	        	}
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
    	//Util.preencheCombCurso(listaCursoDisp , scaFacade);
		//Util.preencheCombProf(listaProfDisp,scaFacade);
    	jTextFieldCod.requestFocus();
	}
	private void preencheCampos(){
		
		//jLabelTotal.setText(""+listTurma.size());
		if(listTurma.size()>0){
			if(listTurma.get(size)!=null){
				jCombDisciplinas.removeAllItems();
				jTextFieldCod.setText(""+listTurma.get(size).getNumero());
				jTextFieldHorario.setText(listTurma.get(size).getHorario());
				jTextFieldPeriodo.setText(listTurma.get(size).getPeriodo());
				jCombDisciplinas.addItem(listTurma.get(size).getDisciplina().getNome());
				listaProfAdd.clear();
				listaCursoAdd.clear();
				for(Curso curs : listTurma.get(size).getCursosIterator()){
					
					listaCursoAdd.addElement(curs.getNome());
				}
				for(Professor prof : listTurma.get(size).getProfessoresIterator()){
					
					listaProfAdd.addElement(prof.getNome());
				}
			}
			
		}
	}
	
	
	
	
	
	
}
