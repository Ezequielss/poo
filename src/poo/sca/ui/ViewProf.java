package poo.sca.ui;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import poo.sca.Professor;
import poo.sca.SCAFacade;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;




public class ViewProf extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jLabelMatricula;
	private JTextField jTextFieldMat;
	private JLabel jLabelTotal;
	private JLabel jLabelReg;
	private JButton jButtonNext;
	private JButton jButtonReview;
	private JPanel jPanel;
	private JTextField jTextFieldNome;
	private JLabel jLabelNome;
	private SCAFacade scaFacade;
	private int size=0;
	private List<Professor> listProfs;
	
	ViewProf(SCAFacade scaFacade){
		this.scaFacade = scaFacade;
		this.listProfs = new ArrayList<>();
		setModal(true);
		setTitle("Cadastro de Professor");
		initGUI();
		preencheCampos();
		setLocationRelativeTo(null);
		setVisible(true);
		
		
		
		
	}

	private void initGUI() {
		try {
			FormListener formListener = new FormListener();
			
			
			{
				
				this.setLayout(null);
				{
					jPanel = new JPanel();
					AnchorLayout jPanelLayout = new AnchorLayout();
					getContentPane().add(jPanel);
					jPanel.setBounds(0, 0, 356, 159);
					jPanel.setLayout(jPanelLayout);
					jPanel.setBackground(new java.awt.Color(64,128,128));
					{
						jLabelReg = new JLabel();
						jPanel.add(jLabelReg, new AnchorConstraint(53, 950, 154, 830, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						jLabelReg.setText("Registros");
						jLabelReg.setPreferredSize(new java.awt.Dimension(43, 16));
						jLabelReg.setForeground(new java.awt.Color(192,192,192));
					}
					{
						jLabelTotal = new JLabel();
						jPanel.add(jLabelTotal, new AnchorConstraint(122, 964, 305, 860, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						jLabelTotal.setPreferredSize(new java.awt.Dimension(37, 29));
						jLabelTotal.setBackground(new java.awt.Color(0,0,0));
						jLabelTotal.setForeground(new java.awt.Color(255,255,255));
						jLabelTotal.setFont(new java.awt.Font("Segoe UI",1,16));
					}
					{
						jButtonReview = new JButton();
						jPanel.add(jButtonReview, new AnchorConstraint(732, 436, 896, 226, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						jButtonReview.setText("<<");
						jButtonReview.setPreferredSize(new java.awt.Dimension(75, 26));
						jButtonReview.addActionListener(formListener);
					}
					{
						jLabelMatricula = new JLabel();
						jPanel.add(jLabelMatricula, new AnchorConstraint(141, 254, 242, 35, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						jLabelMatricula.setText("Matricula");
						jLabelMatricula.setForeground(new java.awt.Color(255,255,255));
						jLabelMatricula.setFont(new java.awt.Font("Segoe UI",1,14));
						jLabelMatricula.setPreferredSize(new java.awt.Dimension(78, 16));
					}
					{
						jTextFieldMat = new JTextField();
						jPanel.add(jTextFieldMat, new AnchorConstraint(122, 796, 305, 226, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						jTextFieldMat.setPreferredSize(new java.awt.Dimension(203, 29));
						jTextFieldMat.setFont(new java.awt.Font("Segoe UI",0,16));

					}
					{
						jLabelNome = new JLabel();
						jPanel.add(jLabelNome, new AnchorConstraint(405, 206, 506, 35, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						jLabelNome.setText("Nome");
						jLabelNome.setForeground(new java.awt.Color(255,255,255));
						jLabelNome.setFont(new java.awt.Font("Segoe UI",1,14));
						jLabelNome.setPreferredSize(new java.awt.Dimension(61, 16));
					}
					{
						jTextFieldNome = new JTextField();
						jPanel.add(jTextFieldNome, new AnchorConstraint(380, 796, 556, 226, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						jTextFieldNome.setPreferredSize(new java.awt.Dimension(203, 28));
						jTextFieldNome.setFont(new java.awt.Font("Segoe UI",0,16));
					}
					{
						jButtonNext = new JButton();
						jPanel.add(jButtonNext, new AnchorConstraint(732, 796, 896, 580, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						jButtonNext.setText(">>");
						jButtonNext.setPreferredSize(new java.awt.Dimension(77, 26));
						jButtonNext.addActionListener(formListener);
					}
					jTextFieldMat.setEditable(false);
					jTextFieldNome.setEditable(false);
				}
				this.setSize(371, 197);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void preencheCampos(){
		Iterator<Professor> itProf = scaFacade.getProfessoresInterator();
		while(itProf.hasNext()){
			this.listProfs.add(itProf.next()); 
		
		}
		jButtonReview.setEnabled(false);
		jLabelTotal.setText(""+listProfs.size());
		if(listProfs.size()>0){
			jTextFieldMat.setText(""+listProfs.get(size).getMatricula());
			jTextFieldNome.setText(listProfs.get(size).getNome());
		}else jButtonNext.setEnabled(false);
	}
	
	
	private class FormListener implements java.awt.event.ActionListener {
		
	  
	    
	    public void actionPerformed(java.awt.event.ActionEvent evt) {
	    	
	    	
	        if (evt.getSource() == jButtonNext) {
	        	
	        		jButtonReview.setEnabled(true);
		        	if(size<listProfs.size()-1)
		        	{
		        		
		        		++size;
		        		if(size== listProfs.size()-1)
		        			 jButtonNext.setEnabled(false);
		        		
		        		jTextFieldMat.setText(""+listProfs.get(size).getMatricula());
		        		jTextFieldNome.setText(listProfs.get(size).getNome());
		        	}
		        	
		        	
	        
	        
	        }else if(evt.getSource() == jButtonReview){
	        	jButtonNext.setEnabled(true);
	        	if(size>0)
	        	{
	        		--size;
	        		if(size == 0)
	        			jButtonReview.setEnabled(false);
	        		
	        		jTextFieldMat.setText(""+listProfs.get(size).getMatricula());
	        		jTextFieldNome.setText(listProfs.get(size).getNome());
	        		
	        	}
	        }
	}

	}
}
