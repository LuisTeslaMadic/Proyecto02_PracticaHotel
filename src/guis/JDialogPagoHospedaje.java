package guis;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Libreria.Fecha;
import arreglos.ArregloHospedaje;
import arreglos.ArregloIngreso;
import arreglos.ArregloSocio;
import clases.Hospedaje;
import clases.Ingreso;
import clases.Socio;

public class JDialogPagoHospedaje extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JComboBox<Integer> cboHospedaje;
	private JLabel lblCodigoHospedaje;
	private JButton btnListarConsumo;
	private JTextArea txtS;
	private JScrollPane scrollPane;
	private JButton btnPagar;
	ArregloHospedaje ah = new ArregloHospedaje();
	ArregloIngreso ai = new ArregloIngreso();
	ArregloSocio     as = new ArregloSocio();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JDialogPagoHospedaje dialog = new JDialogPagoHospedaje();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDialogPagoHospedaje() {
		setBounds(100, 100, 802, 610);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Escoga un c\u00F3digo ingreso ");
		lblNewLabel.setIcon(new ImageIcon(JDialogPagoHospedaje.class.getResource("/imagenes/arrow-left.png")));
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel.setBounds(297, 15, 195, 18);
		getContentPane().add(lblNewLabel);
		
		cboHospedaje = new JComboBox<Integer>();
		cboHospedaje.setBounds(145, 11, 142, 22);
		getContentPane().add(cboHospedaje);
		
		lblCodigoHospedaje = new JLabel("Codigo Hospedaje  :");
		lblCodigoHospedaje.setForeground(Color.DARK_GRAY);
		lblCodigoHospedaje.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblCodigoHospedaje.setBounds(10, 11, 122, 21);
		getContentPane().add(lblCodigoHospedaje);
		
		btnListarConsumo = new JButton("Listar Consumo");
		btnListarConsumo.addActionListener(this);
		btnListarConsumo.setForeground(Color.DARK_GRAY);
		btnListarConsumo.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnListarConsumo.setBounds(634, 15, 142, 38);
		getContentPane().add(btnListarConsumo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 68, 766, 441);
		getContentPane().add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 14));
		scrollPane.setViewportView(txtS);
		
		btnPagar = new JButton("Pagar");
		btnPagar.setForeground(Color.DARK_GRAY);
		btnPagar.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnPagar.setBounds(634, 522, 142, 38);
		getContentPane().add(btnPagar);
		CargarHospedajes();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnListarConsumo) {
			actionPerformedBtnListarConsumo(e);
		}
	}
	protected void actionPerformedBtnListarConsumo(ActionEvent e) {
		 int codHospedaje = CapturarCodigoHospedaje();
		 Hospedaje h  = ah.BuscarCodigoHospedaje(codHospedaje);
		 Ingreso   in = ai.BuscarCodigoIngreso(h.getCodigoIngreso());
		 Socio     s  = as.BuscarCodigoSocio(in.getCodigoSocio());
		 double CostoTotal = h.getCostoHospedaje()*Fecha.diasTranscurridos(in.getFechaIngreso(), Fecha.FechaActual());
		 txtS.setText("Gastos totales               \n");
		 txtS.append("===============================\n");
		 txtS.append("Codigo Socio                 : "+s.getCodigoSocio()+"\n");
		 txtS.append("Nombre y apellido            : "+s.getNombre() +" "+s.getApellido()+"\n");
		 txtS.append("Dni                          : "+s.getDni()+"\n");
		 txtS.append("Costo por hospedaje          : "+h.getCostoHospedaje()+"\n");
		 txtS.append("Fecha de llegada             : "+in.getFechaIngreso()+"\n");
		 txtS.append("Fecha de salida              : "+Fecha.FechaActual()+"\n");
		 txtS.append("Hora de salida               : "+Fecha.HoraActual()+"\n");
		 txtS.append("Costo total                  : "+CostoTotal+"\n");

	}
	
	/*Metodos de captura*/
	int CapturarCodigoHospedaje() {
		return Integer.parseInt(cboHospedaje.getSelectedItem().toString());
	}
	
	/*Metodos complementarios*/
	void CargarHospedajes() {
		for(int i=0;i<ah.Tamaño();i++) {
			Hospedaje x = ah.Obtener(i);
			cboHospedaje.addItem(x.getCodigoHospedaje());
		}
	}
}
