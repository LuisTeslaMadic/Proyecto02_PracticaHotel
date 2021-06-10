package guis;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class JDialogHospedaje extends JDialog {
	private JLabel lblCodigoHospedaje;
	private JTextField textField;
	private JButton btnAgregarConsumo;
	private JLabel lblCategoriaDeBungalow;
	private JComboBox cboCategoria;
	private JLabel lblCodigoDeBungalow;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JScrollPane scrollPane;
	private JTable tblHospedaje;
	private JButton btnConsultar;
	private JComboBox cboCategoria_1;
	private JLabel lblCodigoIngreso;
	private JComboBox cboCategoria_2;
	private JLabel lblFechaDeSalida;
	private JLabel lblHoraDeSalida;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JDialogHospedaje dialog = new JDialogHospedaje();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDialogHospedaje() {
		setTitle("Hospedaje Socio");
		setBounds(100, 100, 750, 585);
		getContentPane().setLayout(null);
		
		lblCodigoHospedaje = new JLabel("Codigo Hospedaje :");
		lblCodigoHospedaje.setForeground(Color.DARK_GRAY);
		lblCodigoHospedaje.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblCodigoHospedaje.setBounds(10, 11, 167, 25);
		getContentPane().add(lblCodigoHospedaje);
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		textField.setColumns(10);
		textField.setBounds(169, 13, 183, 20);
		getContentPane().add(textField);
		
		btnAgregarConsumo = new JButton("Adicionar");
		btnAgregarConsumo.setForeground(Color.DARK_GRAY);
		btnAgregarConsumo.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnAgregarConsumo.setBackground(Color.WHITE);
		btnAgregarConsumo.setBounds(604, 11, 120, 30);
		getContentPane().add(btnAgregarConsumo);
		
		lblCategoriaDeBungalow = new JLabel("Categoria de Bungalow :");
		lblCategoriaDeBungalow.setForeground(Color.DARK_GRAY);
		lblCategoriaDeBungalow.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblCategoriaDeBungalow.setBounds(10, 82, 158, 25);
		getContentPane().add(lblCategoriaDeBungalow);
		
		cboCategoria = new JComboBox();
		cboCategoria.setForeground(Color.BLACK);
		cboCategoria.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		cboCategoria.setBounds(169, 47, 183, 20);
		getContentPane().add(cboCategoria);
		
		lblCodigoDeBungalow = new JLabel("Numero de Bungalow :");
		lblCodigoDeBungalow.setForeground(Color.DARK_GRAY);
		lblCodigoDeBungalow.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblCodigoDeBungalow.setBounds(10, 118, 158, 25);
		getContentPane().add(lblCodigoDeBungalow);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setForeground(Color.DARK_GRAY);
		btnModificar.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnModificar.setBackground(Color.WHITE);
		btnModificar.setBounds(604, 94, 120, 30);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(Color.DARK_GRAY);
		btnEliminar.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.setBounds(604, 135, 120, 30);
		getContentPane().add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 283, 714, 252);
		getContentPane().add(scrollPane);
		
		tblHospedaje = new JTable();
		scrollPane.setViewportView(tblHospedaje);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setForeground(Color.DARK_GRAY);
		btnConsultar.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnConsultar.setBackground(Color.WHITE);
		btnConsultar.setBounds(604, 52, 120, 30);
		getContentPane().add(btnConsultar);
		
		cboCategoria_1 = new JComboBox();
		cboCategoria_1.setForeground(Color.BLACK);
		cboCategoria_1.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		cboCategoria_1.setBounds(169, 120, 183, 20);
		getContentPane().add(cboCategoria_1);
		
		lblCodigoIngreso = new JLabel("Codigo Ingreso :");
		lblCodigoIngreso.setForeground(Color.DARK_GRAY);
		lblCodigoIngreso.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblCodigoIngreso.setBounds(10, 43, 167, 25);
		getContentPane().add(lblCodigoIngreso);
		
		cboCategoria_2 = new JComboBox();
		cboCategoria_2.setForeground(Color.BLACK);
		cboCategoria_2.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		cboCategoria_2.setBounds(169, 84, 183, 20);
		getContentPane().add(cboCategoria_2);
		
		lblFechaDeSalida = new JLabel("Fecha de Salida :");
		lblFechaDeSalida.setForeground(Color.DARK_GRAY);
		lblFechaDeSalida.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblFechaDeSalida.setBounds(10, 168, 158, 25);
		getContentPane().add(lblFechaDeSalida);
		
		lblHoraDeSalida = new JLabel("Hora de Salida :");
		lblHoraDeSalida.setForeground(Color.DARK_GRAY);
		lblHoraDeSalida.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblHoraDeSalida.setBounds(10, 203, 158, 25);
		getContentPane().add(lblHoraDeSalida);
	}
}
