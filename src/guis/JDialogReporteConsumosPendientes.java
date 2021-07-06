package guis;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import arreglos.ArregloIngreso;

public class JDialogReporteConsumosPendientes extends JDialog implements ActionListener{
	private JButton btnGenerar;
	private JPanel panel;
	ArregloIngreso ai = new ArregloIngreso();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JDialogReporteConsumosPendientes dialog = new JDialogReporteConsumosPendientes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDialogReporteConsumosPendientes() {
		setTitle("Consumos Pendientes");
		setBounds(100, 100, 877, 549);
		getContentPane().setLayout(null);
	    btnGenerar = new JButton("Generar");
	    btnGenerar.addActionListener(this);
		btnGenerar.setForeground(Color.DARK_GRAY);
		btnGenerar.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnGenerar.setBackground(Color.WHITE);
		btnGenerar.setBounds(319, 11, 217, 46);
		getContentPane().add(btnGenerar);
		
		panel = new JPanel();
		panel.setBounds(10, 68, 841, 431);
		getContentPane().add(panel);
		
	}

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGenerar) {
			actionPerformedBtnGenerar(e);
		}
	}
	protected void actionPerformedBtnGenerar(ActionEvent e) {
		
		
	}
}
