package guis;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Libreria.Fecha;
import arreglos.ArregloBungalow;
import arreglos.ArregloHospedaje;
import arreglos.ArregloIngreso;
import arreglos.ArregloSocio;
import clases.Bungalow;
import clases.Hospedaje;
import clases.Ingreso;
import clases.Socio;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JRViewer;
import reporte.GeneradorReporte;

public class JDialogPagoHospedaje extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JComboBox<Integer> cboHospedaje;
	private JLabel lblCodigoHospedaje;
	private JButton btnListarConsumo;
	private JButton btnPagar;
	ArregloHospedaje ah = new ArregloHospedaje();
	ArregloIngreso ai = new ArregloIngreso();
	ArregloSocio as = new ArregloSocio();
	ArregloBungalow ab = new ArregloBungalow();
	private JPanel ReporteHospedaje;

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
		setBounds(100, 100, 891, 610);
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
		btnListarConsumo.setBounds(723, 15, 142, 38);
		getContentPane().add(btnListarConsumo);

		btnPagar = new JButton("Pagar");
		btnPagar.addActionListener(this);
		btnPagar.setForeground(Color.DARK_GRAY);
		btnPagar.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnPagar.setBounds(723, 522, 142, 38);
		getContentPane().add(btnPagar);

		ReporteHospedaje = new JPanel();
		ReporteHospedaje.setBounds(10, 61, 855, 450);
		getContentPane().add(ReporteHospedaje);
		ReporteHospedaje.setLayout(new BorderLayout(0, 0));
		CargarHospedajes();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnPagar) {
			actionPerformedBtnPagar(e);
		}
		if (e.getSource() == btnListarConsumo) {
			actionPerformedBtnListarConsumo(e);
		}
	}

	protected void actionPerformedBtnListarConsumo(ActionEvent e) {
		int codHospedaje = CapturarCodigoHospedaje();
		Hospedaje h = ah.BuscarCodigoHospedaje(codHospedaje);
		Ingreso in = ai.BuscarCodigoIngreso(h.getCodigoIngreso());
		double CostoTotal = h.getCostoHospedaje() * Fecha.diasTranscurridos(in.getFechaIngreso(), Fecha.FechaActual());
		/* Reporte Hospedaje */

		HashMap<String, Object> param = new HashMap<>();
		List<Socio> asd = new ArrayList<Socio>();
		asd.add(as.BuscarCodigoSocio(in.getCodigoSocio()));
		
		// param.put("RutaImagen",
		// JDialogPagoHospedaje.class.getResource("/imagenes/LogoHilton.jpg"));
		param.put("RutaImagen", JDialogPagoHospedaje.class.getResource("/imagenes/LogoHilton.jpg"));
		param.put("FechaDeLlegada", in.getFechaIngreso());
		param.put("FechaDeSalida", Fecha.FechaActual());
		param.put("HoraDeSalida", Fecha.HoraActual());
		param.put("CostoTotal", CostoTotal);

		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(asd);
		String file = "ReportePagoHospedaje.jasper";
		JasperPrint jasperPrint = GeneradorReporte.genera(file, dataSource, param);
		JRViewer jRViewer = new JRViewer(jasperPrint);
		ReporteHospedaje.removeAll();
		ReporteHospedaje.add(jRViewer);
		ReporteHospedaje.repaint();
		ReporteHospedaje.revalidate();

	}
	protected void actionPerformedBtnPagar(ActionEvent e) {
		int codHospedaje = CapturarCodigoHospedaje();
		Hospedaje objHospedaje = ah.BuscarCodigoHospedaje(codHospedaje);
		Bungalow objBungalow = ab.Buscar(objHospedaje.getNumeroBungalow());
		objHospedaje.setEstado(1);
		objBungalow.setEstado(0);
		ah.GrabarHospedaje();
		ab.GrabarBungalow();
		CargarHospedajes();
		JOptionPane.showMessageDialog(this, "Hospedaje pagado correctamente");
	}

	/* Metodos de captura */
	int CapturarCodigoHospedaje() {
		return Integer.parseInt(cboHospedaje.getSelectedItem().toString());
	}

	/* Metodos complementarios */
	void CargarHospedajes() {
		for (int i = 0; i < ah.Tamaño(); i++) {
			Hospedaje x = ah.Obtener(i);
			if(x.getEstado() == 0) {
			 cboHospedaje.addItem(x.getCodigoHospedaje());
			}
		}
	}
	
}
