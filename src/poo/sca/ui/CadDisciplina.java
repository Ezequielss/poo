package poo.sca.ui;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import poo.sca.Disciplina;
import poo.sca.SCAFacade;

import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;




public class CadDisciplina extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jLabelCodigo;
	private JTextField jTextFieldCod;
	private JButton jButtonSalvar;
	private JPanel jPanel;
	private JButton jButtonCancelar;
	private JTextField jTextFieldNome;
	private JLabel jLabelNome;
	private JDialog janela = this;
	private SCAFacade scaFacade;
	
	CadDisciplina(SCAFacade scaFacade){
		this.scaFacade = scaFacade;
		setModal(true);
		setTitle("Cadastro de Disciplina");
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
						jLabelCodigo = new JLabel();
						jPanel.add(jLabelCodigo, new AnchorConstraint(141, 254, 242, 35, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						jLabelCodigo.setText("Codigo");
						jLabelCodigo.setForeground(new java.awt.Color(255,255,255));
						jLabelCodigo.setFont(new java.awt.Font("Segoe UI",1,14));
						jLabelCodigo.setPreferredSize(new java.awt.Dimension(78, 16));
					}
					{
						jTextFieldCod = new JTextField();
						jPanel.add(jTextFieldCod, new AnchorConstraint(122, 796, 305, 226, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
						jTextFieldCod.setPreferredSize(new java.awt.Dimension(203, 29));
						jTextFieldCod.setFont(new java.awt.Font("Segoe UI",0,16));

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
	        	
		        	if(status && Util.validaInt(jTextFieldCod.getText()))
		        	{
		        		
		        		Disciplina discip = scaFacade.criarDisciplina(jTextFieldNome.getText(), Integer.parseInt(jTextFieldCod.getText()));
		        		Util.alert("Cadastro realizado com sucesso!\n"+discip.getCodigo()+"\n"
		        				+discip.getNome());
		        		if(!Util.novamente())
		        			janela.dispose();
		        	}
		        	
		        	jTextFieldNome.setText("");
		        	jTextFieldCod.selectAll();
		        	
		        	jTextFieldCod.requestFocus();
	        
	        
	        }else if(evt.getSource() == jButtonCancelar){
	        	janela.dispose();
	        }
	}

	}
}
