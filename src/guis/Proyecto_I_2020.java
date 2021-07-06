package guis;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class Proyecto_I_2020 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuProyecto;
	private JMenu mnArchivo;
	private JMenuItem mntmSalir;
	private JMenu mnMantenimiento;
	private JMenu mnRegistro;
	private JMenu mnPago;
	private JMenu mnReporte;
	private JMenu mnBoleta;
	private JMenu mnAyuda;
	private JMenuItem mntmSocio;
	private JMenuItem mntmProducto;
	private JMenuItem mntmBungalow;
	private JMenuItem mntmIngreso;
	private JMenuItem mntmConsumo;
	private JMenuItem mntmHospedaje;
	private JMenuItem mntmIngresosConsumos;
	private JMenuItem mntmHospedajes;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_4;
	private JMenuItem mntmNewMenuItem_5;
	private JMenuItem mntmGenerarBoleta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Proyecto_I_2020 frame = new Proyecto_I_2020();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Proyecto_I_2020() {
		setResizable(false);
		setTitle("Tienda 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 763, 421);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menuProyecto = new JMenuBar();
		menuProyecto.setMargin(new Insets(0, 0, 0, 0));
		menuProyecto.setBackground(Color.WHITE);
		menuProyecto.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
		menuProyecto.setBounds(0, 0, 757, 43);
		contentPane.add(menuProyecto);
		
		mnArchivo = new JMenu("Archivo");
		mnArchivo.setBorder(BorderFactory.createCompoundBorder(mnArchivo.getBorder(),BorderFactory.createEmptyBorder(0, 10, 0,10)));
		mnArchivo.setForeground(Color.DARK_GRAY);
		mnArchivo.setIcon(new ImageIcon(Proyecto_I_2020.class.getResource("/imagenes/align-center (4).png")));
		mnArchivo.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		menuProyecto.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setIcon(new ImageIcon(Proyecto_I_2020.class.getResource("/imagenes/x.png")));
		mntmSalir.setBorder(BorderFactory.createCompoundBorder(mntmSalir.getBorder(),BorderFactory.createEmptyBorder(0, 20, 0,0)));
		mntmSalir.addActionListener(this);
		mntmSalir.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setBorder(BorderFactory.createCompoundBorder(mnMantenimiento.getBorder(),BorderFactory.createEmptyBorder(0, 10, 0,10)));
		mnMantenimiento.setIcon(new ImageIcon(Proyecto_I_2020.class.getResource("/imagenes/tool.png")));
		mnMantenimiento.setForeground(Color.DARK_GRAY);
		mnMantenimiento.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		menuProyecto.add(mnMantenimiento);
		
		mntmSocio = new JMenuItem("Socio");
		mntmSocio.addActionListener(this);
		mntmSocio.setIcon(new ImageIcon(Proyecto_I_2020.class.getResource("/imagenes/briefcase.png")));
		mntmSocio.setBorder(BorderFactory.createCompoundBorder(mntmSocio.getBorder(),BorderFactory.createEmptyBorder(0, 0, 0,0)));
		mntmSocio.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		mnMantenimiento.add(mntmSocio);
		
		mntmProducto = new JMenuItem("Producto");
		mntmProducto.addActionListener(this);
		mntmProducto.setIcon(new ImageIcon(Proyecto_I_2020.class.getResource("/imagenes/shopping-bag.png")));
		mntmProducto.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		mnMantenimiento.add(mntmProducto);
		
		mntmBungalow = new JMenuItem("Bungalow");
		mntmBungalow.addActionListener(this);
		mntmBungalow.setIcon(new ImageIcon(Proyecto_I_2020.class.getResource("/imagenes/home.png")));
		mntmBungalow.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		mnMantenimiento.add(mntmBungalow);
		
		mnRegistro = new JMenu("Registro");
		mnRegistro.setBorder(BorderFactory.createCompoundBorder(mnRegistro.getBorder(),BorderFactory.createEmptyBorder(0, 10, 0,10)));
		mnRegistro.setIcon(new ImageIcon(Proyecto_I_2020.class.getResource("/imagenes/edit.png")));
		mnRegistro.setForeground(Color.DARK_GRAY);
		mnRegistro.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		menuProyecto.add(mnRegistro);
		
		mntmIngreso = new JMenuItem("Ingreso");
		mntmIngreso.addActionListener(this);
		mntmIngreso.setIcon(new ImageIcon(Proyecto_I_2020.class.getResource("/imagenes/edit-2.png")));
		mntmIngreso.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		mntmIngreso.setBorder(BorderFactory.createCompoundBorder(mntmSocio.getBorder(),BorderFactory.createEmptyBorder(0, 0, 0,0)));
		mnRegistro.add(mntmIngreso);
		
		mntmConsumo = new JMenuItem("Consumo");
		mntmConsumo.addActionListener(this);
		mntmConsumo.setIcon(new ImageIcon(Proyecto_I_2020.class.getResource("/imagenes/trending-up.png")));
		mntmConsumo.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		mntmConsumo.setBorder(BorderFactory.createCompoundBorder(mntmSocio.getBorder(),BorderFactory.createEmptyBorder(0, 0, 0,0)));
		mnRegistro.add(mntmConsumo);
		
		mntmHospedaje = new JMenuItem("Hospedaje");
		mntmHospedaje.addActionListener(this);
		mntmHospedaje.setIcon(new ImageIcon(Proyecto_I_2020.class.getResource("/imagenes/home.png")));
		mntmHospedaje.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		mntmHospedaje.setBorder(BorderFactory.createCompoundBorder(mntmSocio.getBorder(),BorderFactory.createEmptyBorder(0, 0, 0,0)));
		mnRegistro.add(mntmHospedaje);
		
		mnPago = new JMenu("Pago");
		mnPago.setBorder(BorderFactory.createCompoundBorder(mnPago.getBorder(),BorderFactory.createEmptyBorder(0, 10, 0,10)));
		mnPago.setIcon(new ImageIcon(Proyecto_I_2020.class.getResource("/imagenes/dollar-sign.png")));
		mnPago.setForeground(Color.DARK_GRAY);
		mnPago.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		menuProyecto.add(mnPago);
		
		mntmIngresosConsumos = new JMenuItem("Ingresos y consumos");
		mntmIngresosConsumos.addActionListener(this);
		mntmIngresosConsumos.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		mnPago.add(mntmIngresosConsumos);
		
		mntmHospedajes = new JMenuItem("Hospedajes");
		mntmHospedajes.addActionListener(this);
		mntmHospedajes.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		mnPago.add(mntmHospedajes);
		
		mnReporte = new JMenu("Reporte");
		mnReporte.setBorder(BorderFactory.createCompoundBorder(mnReporte.getBorder(),BorderFactory.createEmptyBorder(0, 10, 0,10)));
		mnReporte.setIcon(new ImageIcon(Proyecto_I_2020.class.getResource("/imagenes/clipboard.png")));
		mnReporte.setForeground(Color.DARK_GRAY);
		mnReporte.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		menuProyecto.add(mnReporte);
		
		mntmNewMenuItem_2 = new JMenuItem("Ingresos y consumos pendientes");
		mnReporte.add(mntmNewMenuItem_2);
		
		mntmNewMenuItem_3 = new JMenuItem("Ingresos y consumos pagados");
		mnReporte.add(mntmNewMenuItem_3);
		
		mntmNewMenuItem_4 = new JMenuItem("Hospedajes pendientes");
		mnReporte.add(mntmNewMenuItem_4);
		
		mntmNewMenuItem_5 = new JMenuItem("Hospedajes pagados");
		mnReporte.add(mntmNewMenuItem_5);
		
		mnBoleta = new JMenu("Boleta");
		mnBoleta.setBorder(BorderFactory.createCompoundBorder(mnBoleta.getBorder(),BorderFactory.createEmptyBorder(0, 10, 0,10)));
		mnBoleta.setIcon(new ImageIcon(Proyecto_I_2020.class.getResource("/imagenes/file-text.png")));
		mnBoleta.setForeground(Color.DARK_GRAY);
		mnBoleta.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		menuProyecto.add(mnBoleta);
		
		mntmGenerarBoleta = new JMenuItem("Generar boleta");
		mntmGenerarBoleta.addActionListener(this);
		mntmGenerarBoleta.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		mnBoleta.add(mntmGenerarBoleta);
		
		mnAyuda = new JMenu("Ayuda");
		mnAyuda.setBorder(BorderFactory.createCompoundBorder(mnAyuda.getBorder(),BorderFactory.createEmptyBorder(0, 10, 0,10)));
		mnAyuda.setIcon(new ImageIcon(Proyecto_I_2020.class.getResource("/imagenes/help-circle.png")));
		mnAyuda.setForeground(Color.DARK_GRAY);
		mnAyuda.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		menuProyecto.add(mnAyuda);
		
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmGenerarBoleta) {
			actionPerformedMntmGenerarBoleta(arg0);
		}
		if (arg0.getSource() == mntmHospedajes) {
			actionPerformedMntmHospedajes(arg0);
		}
		if (arg0.getSource() == mntmIngresosConsumos) {
			actionPerformedMntmIngresosConsumos(arg0);
		}
		if (arg0.getSource() == mntmHospedaje) {
			actionPerformedMntmHospedaje(arg0);
		}
		if (arg0.getSource() == mntmConsumo) {
			actionPerformedMntmConsumo(arg0);
		}
		if (arg0.getSource() == mntmIngreso) {
			actionPerformedMntmIngreso(arg0);
		}
		if (arg0.getSource() == mntmBungalow) {
			actionPerformedMntmBungalow(arg0);
		}
		if (arg0.getSource() == mntmProducto) {
			actionPerformedMntmProducto(arg0);
		}
		if (arg0.getSource() == mntmSocio) {
			actionPerformedMntmSocio(arg0);
		}
		if (arg0.getSource() == mntmSalir) {
			actionPerformedMntmSalir(arg0);
		}
	}
	protected void actionPerformedMntmSalir(ActionEvent arg0) {
		dispose();
	}
	protected void actionPerformedMntmSocio(ActionEvent arg0) {
		JDialogSocio x = new JDialogSocio();
		x.setLocationRelativeTo(this);
		x.setVisible(true);
	}
	protected void actionPerformedMntmProducto(ActionEvent arg0) {
		JDialogProducto x = new JDialogProducto();
		x.setLocationRelativeTo(this);
		x.setVisible(true);
	}
	protected void actionPerformedMntmBungalow(ActionEvent arg0) {
		JDialogBungalow x = new JDialogBungalow();
		x.setLocationRelativeTo(this);
		x.setVisible(true);
	}
	protected void actionPerformedMntmIngreso(ActionEvent arg0) {
		JDialogIngreso x = new JDialogIngreso();
		x.setLocationRelativeTo(this);
		x.setVisible(true);
	}
	protected void actionPerformedMntmConsumo(ActionEvent arg0) {
		JDialogConsumo x = new JDialogConsumo();
		x.setLocationRelativeTo(this);
		x.setVisible(true);
	}
	protected void actionPerformedMntmHospedaje(ActionEvent arg0) {
		JDialogHospedaje x = new JDialogHospedaje();
		x.setLocationRelativeTo(this);
		x.setVisible(true);
	}
	protected void actionPerformedMntmIngresosConsumos(ActionEvent arg0) {
		JDialogPagoIngresosConsumos x = new JDialogPagoIngresosConsumos();
		x.setLocationRelativeTo(this);
		x.setVisible(true);
	}
	protected void actionPerformedMntmHospedajes(ActionEvent arg0) {
		JDialogPagoHospedaje x = new JDialogPagoHospedaje();
		x.setLocationRelativeTo(this);
		x.setVisible(true);
	}
	protected void actionPerformedMntmGenerarBoleta(ActionEvent arg0) {
		JDialogBoleta x = new JDialogBoleta();
		x.setLocationRelativeTo(this);
		x.setVisible(true);
	}
}
