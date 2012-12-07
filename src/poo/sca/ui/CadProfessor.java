package poo.sca.ui;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import poo.sca.Professor;
import poo.sca.SCAFacade;

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
public class CadProfessor extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jLabelMatricula;
	private JTextField jTextFieldMat;
	private JButton jButtonSalvar;
	private JPanel jPanel;
	private JButton jButtonCancelar;
	private JTextField jTextFieldNome;
	private JLabel jLabelNome;
	private JDialog janela = this;
	private SCAFacade scaFacade;
	
	CadProfessor(SCAFacade scaFacade){
		this.scaFacade = scaFacade;
		setModal(true);
		setTitle("Cadastro de Professor");
		initGUI();
		setLocationRelativeTo(null);
		setVisible(true);
		
		
		
		
	}

	private void initGUI() {
		try {
			FormListener formListener = new FormListener();
			
			
			{
				//this.setPreferredSize(new java.awt.Dimension(371, 197));
				
				this.setLayout(null);
				{
					jPanel = new JPanel();
					AnchorLayout jPanelLayout = new AnchorLayout();
					getContentPane().add(jPanel);
					jPanel.setBounds(0, 0, 356, 159);
					jPanel.setLayout(jPanelLayout);
					jPanel.setBackground(new java.awt.Color(64,128,128));
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
						jButtonSalvar = new JButton();
						jPanel.add(jButtonSalvar, new AnchorConstraint(682, 950, 889, 686, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						jButtonSalvar.setText("Salvar");
						jButtonSalvar.setPreferredSize(new java.awt.Dimension(94, 33));
						jButtonSalvar.addActionListener(formListener);
					}
					{
						jButtonCancelar = new JButton();
						jPanel.add(jButtonCancelar, new AnchorConstraint(688, 625, 883, 369, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						jButtonCancelar.setText("Cancelar");
						jButtonCancelar.setPreferredSize(new java.awt.Dimension(91, 31));
						jButtonCancelar.addActionListener(formListener);
					}
				}
				this.setSize(371, 197);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private class FormListener implements java.awt.event.ActionListener {
		
	  
	    
	    public void actionPerformed(java.awt.event.ActionEvent evt) {
	    	
	    	
	        if (evt.getSource() == jButtonSalvar) {
	        	boolean status = Util.verificaString(jTextFieldNome.getText());
	        	
		        	if(status && Util.validaInt(jTextFieldMat.getText()))
		        	{
		        		
		        		Professor prof = scaFacade.criarProfessor(jTextFieldNome.getText(), Integer.parseInt(jTextFieldMat.getText()));
//		        		Util.alert("Cadastro realizado com sucesso!\n"+prof.getMatricula()+"\n"
//		        				+prof.getNome());
		        		if(!Util.novamente())
		        			janela.dispose();
		        	}
		        	
		        	jTextFieldNome.setText("");
		        	jTextFieldMat.selectAll();
		        	
		        	jTextFieldMat.requestFocus();
	        
	        
	        }else if(evt.getSource() == jButtonCancelar){
	        	janela.dispose();
	        }
	}

	}
}
