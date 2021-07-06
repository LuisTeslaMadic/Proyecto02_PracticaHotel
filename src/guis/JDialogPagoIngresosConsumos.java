package guis;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import arreglos.ArregloConsumo;
import arreglos.ArregloIngreso;
import arreglos.ArregloSocio;
import clases.Consumo;
import clases.Ingreso;
import clases.Socio;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JRViewer;
import reporte.GeneradorReporte;

public class JDialogPagoIngresosConsumos extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JComboBox<Integer> cboIngreso;
	private JLabel lblNewLabel_1;
	private JButton btnListarConsumo;
	private JButton btnPagar;
	ArregloIngreso ai = new ArregloIngreso();
	ArregloSocio   as = new ArregloSocio();
	ArregloConsumo ac = new ArregloConsumo();
	private JPanel ReporteConsumo;

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
		setBounds(100, 100, 930, 591);
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
		lblNewLabel_1.setBounds(297, 15, 195, 21);
		getContentPane().add(lblNewLabel_1);
		
		btnListarConsumo = new JButton("Listar Consumo");
		btnListarConsumo.addActionListener(this);
		btnListarConsumo.setForeground(Color.DARK_GRAY);
		btnListarConsumo.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnListarConsumo.setBounds(762, 11, 142, 38);
		getContentPane().add(btnListarConsumo);
		
		btnPagar = new JButton("Pagar");
		btnPagar.addActionListener(this);
		btnPagar.setForeground(Color.DARK_GRAY);
		btnPagar.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnPagar.setBounds(762, 507, 142, 33);
		getContentPane().add(btnPagar);
		
		ReporteConsumo = new JPanel();
		ReporteConsumo.setBounds(10, 58, 894, 438);
		ReporteConsumo.setLayout(new BorderLayout(0,0));
		getContentPane().add(ReporteConsumo);
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
		ArregloConsumo.setAcTotal(0);
		if(objIngreso != null ) {
			Socio objSocio = as.BuscarCodigoSocio(objIngreso.getCodigoSocio());
			List<Consumo> lc = ac.CargarConsumo(objIngreso.getCodigoSocio());
      		/*Reporte Consumo*/
			
			
			
			HashMap<String,Object> param = new HashMap<>();
			param.put("RutaImagen", JDialogPagoHospedaje.class.getResource("/imagenes/LogoHilton.jpg"));
			param.put("CodigoSocio", objSocio.getCodigoSocio());
			param.put("NombreApellido", objSocio.getNombre()+" "+objSocio.getApellido());
			param.put("Dni", objSocio.getDni());
			param.put("CostoIngreso", objIngreso.getCostoIngreso());
			param.put("Deuda", ArregloConsumo.getAcTotal());
			
			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(lc);
			String file = "ReporteIngresosConsumos.jasper";
			JasperPrint jasperPrint = GeneradorReporte.genera(file, dataSource, param);
			JRViewer jRViewer = new JRViewer(jasperPrint);
			ReporteConsumo.removeAll();
			ReporteConsumo.add(jRViewer);
			ReporteConsumo.repaint();
			ReporteConsumo.revalidate();
		}
	}
	protected void actionPerformedBtnPagar(ActionEvent e) {
		Ingreso objIngreso = ai.BuscarCodigoIngreso(CapturarCodigoIngreso());
		objIngreso.setEstado(1);
		ai.GrabarIngreso();
		CargarIngresos();
		JOptionPane.showMessageDialog(this, "Consumos pagados correctamente");
	}
	
	/*Metodos principales*/
	
	int CapturarCodigoIngreso() {
		return Integer.parseInt(cboIngreso.getSelectedItem().toString());
	}
	
	/* Metodos complementarias */
	
	void CargarIngresos() {
		cboIngreso.removeAllItems();
		for (int i = 0; i < ai.Tamaño(); i++) {
		  Ingreso x = ai.Obtener(i);
		  if(x.getEstado() == 0) {
			 cboIngreso.addItem(x.getCodigoIngreso());   
		  } 
		}
	}
}
