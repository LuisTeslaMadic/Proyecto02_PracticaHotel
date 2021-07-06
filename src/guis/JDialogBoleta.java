package guis;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Libreria.Fecha;
import arreglos.ArregloBoleta;
import arreglos.ArregloConsumo;
import arreglos.ArregloHospedaje;
import arreglos.ArregloIngreso;
import clases.Boleta;
import clases.Consumo;
import clases.Hospedaje;
import clases.Ingreso;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JRViewer;
import reporte.GeneradorReporte;

public class JDialogBoleta extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblCodigoBoleta;
	private JLabel lblCodigosDeIngreso;
	private JTextField txtCodigoBoleta;
	private JComboBox<Integer> cboIngreso;
	private JButton btnAdicionar;
	private JPanel ReporteBoleta;
	ArregloIngreso  ai  = new ArregloIngreso();
	ArregloHospedaje ah = new ArregloHospedaje();	
	ArregloBoleta    ab = new ArregloBoleta();
	ArregloConsumo   ac = new ArregloConsumo();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JDialogBoleta dialog = new JDialogBoleta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDialogBoleta() {
		setBounds(100, 100, 877, 591);
		getContentPane().setLayout(null);
		
		lblCodigoBoleta = new JLabel("Codigo Boleta                         :");
		lblCodigoBoleta.setForeground(Color.DARK_GRAY);
		lblCodigoBoleta.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblCodigoBoleta.setBounds(10, 21, 195, 25);
		getContentPane().add(lblCodigoBoleta);
		
		lblCodigosDeIngreso = new JLabel("Codigos de Ingresos pagados :");
		lblCodigosDeIngreso.setForeground(Color.DARK_GRAY);
		lblCodigosDeIngreso.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblCodigosDeIngreso.setBounds(10, 71, 195, 25);
		getContentPane().add(lblCodigosDeIngreso);
		
		txtCodigoBoleta = new JTextField();
		txtCodigoBoleta.setText(ab.CodigoCorrelativo()+"");
		txtCodigoBoleta.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		txtCodigoBoleta.setEditable(false);
		txtCodigoBoleta.setColumns(10);
		txtCodigoBoleta.setBounds(205, 24, 131, 20);
		getContentPane().add(txtCodigoBoleta);
		
		cboIngreso = new JComboBox<Integer>();
		cboIngreso.setForeground(Color.BLACK);
		cboIngreso.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		cboIngreso.setBounds(205, 73, 131, 20);
		getContentPane().add(cboIngreso);
		
		btnAdicionar = new JButton("Generar Boleta");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setForeground(Color.DARK_GRAY);
		btnAdicionar.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnAdicionar.setBackground(Color.WHITE);
		btnAdicionar.setBounds(691, 21, 160, 36);
		getContentPane().add(btnAdicionar);
		
		ReporteBoleta = new JPanel();
		ReporteBoleta.setBounds(10, 116, 841, 425);
		getContentPane().add(ReporteBoleta);
		ReporteBoleta.setLayout(new BorderLayout(0,0));
		cargarIngresosConsumosPagados();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(e);
		}
	}
	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		int codIngreso = CapturarCodigoIngreso();
		int codBoleta  = CapturarCodigoBoleta();
		Hospedaje h = ah.BuscarCodigoHospedaje(CodigoHospedaje(codIngreso));
		Ingreso in = ai.BuscarCodigoIngreso(h.getCodigoIngreso());
		double CostoHospedaje = h.getCostoHospedaje() * Fecha.diasTranscurridos(in.getFechaIngreso(), Fecha.FechaActual());
		ArregloConsumo.setAcTotal(0);
		double CostoIngreso   = ArregloConsumo.getAcTotal();
		double total   = CostoHospedaje  + CostoIngreso;
		ab.Adicionar(new Boleta(codBoleta,codIngreso,total));
		ab.GrabarBoleta();
		List<Consumo> lc = ac.CargarConsumo(in.getCodigoSocio());
		List<Boleta> lb = CargarBoleta(codIngreso);
		HashMap<String,Object> param = new HashMap<>();
		param.put("RutaImagen", JDialogPagoHospedaje.class.getResource("/imagenes/LogoHilton.jpg"));
		param.put("PagoTotal", total);
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(lb);
		String file = "BoletaHotel.jasper";
		JasperPrint jasperPrint = GeneradorReporte.genera(file, dataSource, param);
		JRViewer jRViewer = new JRViewer(jasperPrint);
		ReporteBoleta.removeAll();
		ReporteBoleta.add(jRViewer);
		ReporteBoleta.repaint();
		ReporteBoleta.revalidate();
		txtCodigoBoleta.setText(ab.CodigoCorrelativo()+"");
	}
	
	
	/*Metodos de captura*/
	int CapturarCodigoIngreso() {
		return Integer.parseInt(cboIngreso.getSelectedItem().toString());
	}
	int CapturarCodigoBoleta() {
		return Integer.parseInt(txtCodigoBoleta.getText());
	}
	
	int CodigoHospedaje(int CodigoIngreso) {
		for(int i=0;i<ai.Tamaño();i++) {
			Hospedaje objHospedaje = ah.Obtener(i);
			if(objHospedaje.getCodigoIngreso() == CodigoIngreso) {
				return objHospedaje.getCodigoHospedaje();
			}
		}
	 return -1;	
	}
	List<Boleta> CargarBoleta(int CodigoIngreso) {
		ArrayList<Boleta> abc = new ArrayList<Boleta>();
		for(int i=0;i<ab.Tamaño();i++) {
			Boleta x = ab.Obtener(i);
			if(CodigoIngreso == x.getCodigoIngreso()) {
				abc.add(x);
			}
		}
	  return abc;	
	}
	
	
	void cargarIngresosConsumosPagados(){
		for(int i=0;i<ai.Tamaño();i++) {
			Ingreso   objIngreso = ai.Obtener(i);
			Hospedaje objHospedaje = ah.Obtener(i);
			if(objIngreso.getEstado() == 1 && objHospedaje.getEstado() == 1) {
				cboIngreso.addItem(objIngreso.getCodigoIngreso());
			}
		}
	}
}
