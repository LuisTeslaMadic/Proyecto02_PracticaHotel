package guis;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JDialogReporteConsumosPagados extends JDialog implements ActionListener {
	private JPanel panel;
	private JButton btnGenerar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JDialogReporteConsumosPagados dialog = new JDialogReporteConsumosPagados();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDialogReporteConsumosPagados() {
		setBounds(100, 100, 916, 552);
		getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBounds(10, 68, 880, 431);
		getContentPane().add(panel);

		btnGenerar = new JButton("Generar");
		btnGenerar.addActionListener(this);
		btnGenerar.setForeground(Color.DARK_GRAY);
		btnGenerar.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnGenerar.setBackground(Color.WHITE);
		btnGenerar.setBounds(335, 11, 217, 46);
		getContentPane().add(btnGenerar);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGenerar) {
			actionPerformedBtnGenerar(e);
		}
	}
	protected void actionPerformedBtnGenerar(ActionEvent e) {
	}
}
