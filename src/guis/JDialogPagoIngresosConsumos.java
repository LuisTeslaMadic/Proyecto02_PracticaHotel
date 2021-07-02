package guis;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import arreglos.ArregloConsumo;
import arreglos.ArregloIngreso;
import arreglos.ArregloSocio;
import clases.Consumo;
import clases.Ingreso;
import clases.Socio;

public class JDialogPagoIngresosConsumos extends JDialog implements ActionListener {
	private JLabel lblNewLabel;
	private JComboBox<Integer> cboIngreso;
	private JLabel lblNewLabel_1;
	private JButton btnListarConsumo;
	private JButton btnPagar;
	ArregloIngreso ai = new ArregloIngreso();
	ArregloSocio   as = new ArregloSocio();
	ArregloConsumo ac = new ArregloConsumo();
	private JTextArea txtS;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JDialogPagoIngresosConsumos dialog = new JDialogPagoIngresosConsumos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDialogPagoIngresosConsumos() {
		setBounds(100, 100, 841, 591);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Codigo Ingreso  :");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel.setBounds(10, 11, 113, 21);
		getContentPane().add(lblNewLabel);
		
		cboIngreso = new JComboBox<Integer>();
		cboIngreso.setBounds(133, 11, 142, 22);
		getContentPane().add(cboIngreso);
		
		lblNewLabel_1 = new JLabel("Escoga un c\u00F3digo ingreso ");
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setIcon(new ImageIcon(JDialogPagoIngresosConsumos.class.getResource("/imagenes/arrow-left.png")));
		lblNewLabel_1.setBounds(297, 15, 195, 14);
		getContentPane().add(lblNewLabel_1);
		
		btnListarConsumo = new JButton("Listar Consumo");
		btnListarConsumo.addActionListener(this);
		btnListarConsumo.setForeground(Color.DARK_GRAY);
		btnListarConsumo.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnListarConsumo.setBounds(673, 11, 142, 38);
		getContentPane().add(btnListarConsumo);
		
		btnPagar = new JButton("Pagar");
		btnPagar.addActionListener(this);
		btnPagar.setForeground(Color.DARK_GRAY);
		btnPagar.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnPagar.setBounds(662, 507, 142, 33);
		getContentPane().add(btnPagar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 64, 805, 433);
		getContentPane().add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 14));
		scrollPane.setViewportView(txtS);
		CargarIngresos();
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnPagar) {
			actionPerformedBtnPagar(e);
		}
		if (e.getSource() == btnListarConsumo) {
			actionPerformedBtnListar(e);
		}
	}
	protected void actionPerformedBtnListar(ActionEvent e) {
		Ingreso objIngreso = ai.BuscarCodigoIngreso(CapturarCodigoIngreso());
		if(objIngreso != null) {
			Socio objSocio = as.BuscarCodigoSocio(objIngreso.getCodigoSocio());
			txtS.setText("Pagos pendientes : \n");
			txtS.append("Codigo Socio                 : "+objSocio.getCodigoSocio()+"\n");
			txtS.append("Nombre y apellido            : "+objSocio.getNombre() +" "+objSocio.getApellido()+"\n");
			txtS.append("Dni                          : "+objSocio.getDni()+"\n");
			txtS.append("Costo por derecho de ingreso : "+objIngreso.getCostoIngreso()+"\n");
			List<Consumo> lc = ac.CargarConsumo(objIngreso.getCodigoSocio());
			for(int i=0;i<lc.size();i++) {
				Consumo x = lc.get(i);
				txtS.append("==================================\n");
				txtS.append("Producto : "+x.getProducto()+"\n");
				txtS.append("Precio   : "+x.getPrecio()+"\n");
				txtS.append("Cantidad : "+x.getCantidad()+"\n");
				txtS.append("==================================\n");
				
			}
		}
	}
	protected void actionPerformedBtnPagar(ActionEvent e) {
	}
	
	/*Metodos principales*/
	
	void Listar() {
		
	}
	
	int CapturarCodigoIngreso() {
		return Integer.parseInt(cboIngreso.getSelectedItem().toString());
	}
	
	/* Metodos complementarias */
	
	void CargarIngresos() {
		cboIngreso.removeAllItems();
		for (int i = 0; i < ai.Tamaño(); i++) {
		  Ingreso x = ai.Obtener(i);	
          cboIngreso.addItem(x.getCodigoIngreso());    
		}
	}
}
