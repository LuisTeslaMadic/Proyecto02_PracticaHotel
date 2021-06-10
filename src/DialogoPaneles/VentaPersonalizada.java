package DialogoPaneles;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class VentaPersonalizada extends JDialog implements ActionListener {
	private JLabel lblModificarPor;
	private JLabel lblModificarPor_1;
	public static JTextField txtRespuesta;
	private JButton btnAceptar;
	private JButton btnCancelar;
    public  static int  respuesta = 0;
    private JLabel lblEscogaUnaDe;
    
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentaPersonalizada dialog = new VentaPersonalizada();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentaPersonalizada() {
		setTitle("Buscar");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentaPersonalizada.class.getResource("/imagenes/search.png")));
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 390, 268);
		getContentPane().setLayout(null);
		
		lblModificarPor = new JLabel("1. Buscar por codigo ");
		lblModificarPor.setForeground(Color.DARK_GRAY);
		lblModificarPor.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblModificarPor.setBounds(10, 60, 156, 25);
		getContentPane().add(lblModificarPor);
		
		lblModificarPor_1 = new JLabel("2. Buscar por dni");
		lblModificarPor_1.setForeground(Color.DARK_GRAY);
		lblModificarPor_1.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblModificarPor_1.setBounds(10, 96, 156, 25);
		getContentPane().add(lblModificarPor_1);
		
		txtRespuesta = new JTextField();
		txtRespuesta.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		txtRespuesta.setBounds(10, 132, 358, 33);
		getContentPane().add(txtRespuesta);
		txtRespuesta.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setForeground(Color.DARK_GRAY);
		btnAceptar.setBackground(Color.WHITE);
		btnAceptar.setIcon(new ImageIcon(VentaPersonalizada.class.getResource("/imagenes/check.png")));
		btnAceptar.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnAceptar.setBounds(10, 176, 156, 44);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setForeground(Color.DARK_GRAY);
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setIcon(new ImageIcon(VentaPersonalizada.class.getResource("/imagenes/x.png")));
		btnCancelar.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnCancelar.setBounds(212, 176, 156, 44);
		getContentPane().add(btnCancelar);
		
		lblEscogaUnaDe = new JLabel("Escoga una de las opciones :");
		lblEscogaUnaDe.setForeground(Color.DARK_GRAY);
		lblEscogaUnaDe.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblEscogaUnaDe.setBounds(10, 24, 190, 25);
		getContentPane().add(lblEscogaUnaDe);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
		if (arg0.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(arg0);
		}
	}
	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
	  dispose();
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		 try{
			 respuesta = Integer.parseInt(txtRespuesta.getText());
		 }catch(Exception e){
			 
		 }
		 dispose();
	}
	
}
