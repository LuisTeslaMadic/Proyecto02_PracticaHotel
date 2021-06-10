package guis;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import com.toedter.calendar.JDateChooser;

import arreglos.ArregloBungalow;
import arreglos.ArregloHospedaje;
import arreglos.ArregloIngreso;
import clases.Bungalow;
import clases.Ingreso;

public class JDialogHospedaje extends JDialog implements ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblCodigoHospedaje;
	private JTextField txtCodigoHospedaje;
	private JButton btnAgregarConsumo;
	private JLabel lblCategoriaDeBungalow;
	private JComboBox<String> cboIngreso;
	private JLabel lblCodigoDeBungalow;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JScrollPane scrollPane;
	private JTable tblHospedaje;
	private JButton btnConsultar;
	private JComboBox<Integer> cboNumeroBungalow;
	private JLabel lblCodigoIngreso;
	private JComboBox<Integer> cboCategoriaBungalow;
	private JLabel lblFechaDeSalida;
	private JLabel lblHoraDeSalida;
	private JLabel lblCosto;
	private JLabel lblEstado;
	private JDateChooser dtFechaSalida;
	private JTextField txtHora;
	private JTextField txtCosto;
	private JComboBox<String> cboEstado;
	private DefaultTableModel modelo;
	private JTableHeader cabecera;
	private JButton btnAceptar;
	private JButton btnVolver;
	private JButton btnBuscar;
	ArregloHospedaje ah = new ArregloHospedaje();
    ArregloIngreso   ai = new ArregloIngreso();
    ArregloBungalow  ab = new ArregloBungalow();
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(JDialogHospedaje.class.getResource("/imagenes/home.png")));
		setTitle("Hospedaje Socio");
		setBounds(100, 100, 949, 629);
		getContentPane().setLayout(null);
		
		lblCodigoHospedaje = new JLabel("Codigo Hospedaje          :");
		lblCodigoHospedaje.setForeground(Color.DARK_GRAY);
		lblCodigoHospedaje.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblCodigoHospedaje.setBounds(10, 10, 167, 25);
		getContentPane().add(lblCodigoHospedaje);
		
		txtCodigoHospedaje = new JTextField();
		txtCodigoHospedaje.setEditable(false);
		txtCodigoHospedaje.setText(""+ah.CodigoCorrelativo());
		txtCodigoHospedaje.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		txtCodigoHospedaje.setColumns(10);
		txtCodigoHospedaje.setBounds(180, 12, 183, 20);
		getContentPane().add(txtCodigoHospedaje);
		
		btnAgregarConsumo = new JButton("Adicionar");
		btnAgregarConsumo.addActionListener(this);
		btnAgregarConsumo.setIcon(new ImageIcon(JDialogHospedaje.class.getResource("/imagenes/plus.png")));
		btnAgregarConsumo.setForeground(Color.DARK_GRAY);
		btnAgregarConsumo.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnAgregarConsumo.setBackground(Color.WHITE);
		btnAgregarConsumo.setBounds(792, 7, 120, 30);
		getContentPane().add(btnAgregarConsumo);
		
		lblCategoriaDeBungalow = new JLabel("Categoria de Bungalow :");
		lblCategoriaDeBungalow.setForeground(Color.DARK_GRAY);
		lblCategoriaDeBungalow.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblCategoriaDeBungalow.setBounds(10, 90, 158, 25);
		getContentPane().add(lblCategoriaDeBungalow);
		
		cboIngreso = new JComboBox<String>();
		cboIngreso.setBackground(Color.WHITE);
		cboIngreso.setForeground(Color.BLACK);
		cboIngreso.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		cboIngreso.setBounds(180, 52, 183, 20);
		getContentPane().add(cboIngreso);
		
		lblCodigoDeBungalow = new JLabel("Numero de Bungalow   :");
		lblCodigoDeBungalow.setForeground(Color.DARK_GRAY);
		lblCodigoDeBungalow.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblCodigoDeBungalow.setBounds(10, 130, 167, 25);
		getContentPane().add(lblCodigoDeBungalow);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setIcon(new ImageIcon(JDialogHospedaje.class.getResource("/imagenes/edit.png")));
		btnModificar.setForeground(Color.DARK_GRAY);
		btnModificar.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnModificar.setBackground(Color.WHITE);
		btnModificar.setBounds(792, 87, 120, 30);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setIcon(new ImageIcon(JDialogHospedaje.class.getResource("/imagenes/x.png")));
		btnEliminar.setForeground(Color.DARK_GRAY);
		btnEliminar.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.setBounds(792, 127, 120, 30);
		getContentPane().add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 339, 913, 240);
		getContentPane().add(scrollPane);
		
		tblHospedaje = new JTable();
		scrollPane.setViewportView(tblHospedaje);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setIcon(new ImageIcon(JDialogHospedaje.class.getResource("/imagenes/search.png")));
		btnConsultar.setForeground(Color.DARK_GRAY);
		btnConsultar.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnConsultar.setBackground(Color.WHITE);
		btnConsultar.setBounds(792, 47, 120, 30);
		getContentPane().add(btnConsultar);
		
		cboNumeroBungalow = new JComboBox();
		cboNumeroBungalow.setBackground(Color.WHITE);
		cboNumeroBungalow.setForeground(Color.BLACK);
		cboNumeroBungalow.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		cboNumeroBungalow.setBounds(180, 129, 183, 20);
		getContentPane().add(cboNumeroBungalow);
		
		lblCodigoIngreso = new JLabel("Codigo Ingreso              :");
		lblCodigoIngreso.setForeground(Color.DARK_GRAY);
		lblCodigoIngreso.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblCodigoIngreso.setBounds(10, 50, 167, 25);
		getContentPane().add(lblCodigoIngreso);
		
		cboCategoriaBungalow = new JComboBox();
		cboCategoriaBungalow.addActionListener(this);
		cboCategoriaBungalow.setModel(new DefaultComboBoxModel(new String[] {"Simple", "Doble", "Familiar"}));
		cboCategoriaBungalow.setBackground(Color.WHITE);
		cboCategoriaBungalow.setForeground(Color.BLACK);
		cboCategoriaBungalow.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		cboCategoriaBungalow.setBounds(180, 90, 183, 20);
		getContentPane().add(cboCategoriaBungalow);
		
		lblFechaDeSalida = new JLabel("Fecha de Salida           :");
		lblFechaDeSalida.setForeground(Color.DARK_GRAY);
		lblFechaDeSalida.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblFechaDeSalida.setBounds(10, 170, 158, 25);
		getContentPane().add(lblFechaDeSalida);
		
		lblHoraDeSalida = new JLabel("Hora de Salida            :");
		lblHoraDeSalida.setForeground(Color.DARK_GRAY);
		lblHoraDeSalida.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblHoraDeSalida.setBounds(10, 210, 158, 25);
		getContentPane().add(lblHoraDeSalida);
		
		lblCosto = new JLabel("Costo                          :");
		lblCosto.setForeground(Color.DARK_GRAY);
		lblCosto.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblCosto.setBounds(10, 250, 158, 25);
		getContentPane().add(lblCosto);
		
		lblEstado = new JLabel("Estado                        :");
		lblEstado.setForeground(Color.DARK_GRAY);
		lblEstado.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblEstado.setBounds(10, 290, 158, 25);
		getContentPane().add(lblEstado);
		
		dtFechaSalida = new JDateChooser();
		dtFechaSalida.setBounds(180, 166, 183, 20);
		getContentPane().add(dtFechaSalida);
		
		txtHora = new JTextField();
		txtHora.addMouseListener(this);
		txtHora.setText("hh:mm");
		txtHora.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		txtHora.setColumns(10);
		txtHora.setBounds(180, 204, 183, 20);
		getContentPane().add(txtHora);
		
		txtCosto = new JTextField();
		txtCosto.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		txtCosto.setColumns(10);
		txtCosto.setBounds(180, 250, 183, 20);
		getContentPane().add(txtCosto);
		
		cboEstado = new JComboBox();
		cboEstado.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		cboEstado.setModel(new DefaultComboBoxModel(new String[] {"Pendiente", "Pagado"}));
		cboEstado.setBackground(Color.WHITE);
		cboEstado.setBounds(180, 288, 183, 22);
		getContentPane().add(cboEstado);
		modelo = new DefaultTableModel();
		modelo.addColumn("Código Hospedaje");
		modelo.addColumn("Código Ingreso");
		modelo.addColumn("Numero de Bungalow");
		modelo.addColumn("Fecha de Salida");
		modelo.addColumn("Hora de Salida");
		modelo.addColumn("Costo");
		modelo.addColumn("Estado");
		tblHospedaje.setModel(modelo);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setIcon(new ImageIcon(JDialogHospedaje.class.getResource("/imagenes/check (1).png")));
		btnAceptar.setForeground(Color.DARK_GRAY);
		btnAceptar.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnAceptar.setEnabled(false);
		btnAceptar.setBackground(Color.WHITE);
		btnAceptar.setBounds(392, 12, 122, 30);
		getContentPane().add(btnAceptar);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(this);
		btnVolver.setIcon(new ImageIcon(JDialogHospedaje.class.getResource("/imagenes/arrow-right.png")));
		btnVolver.setForeground(Color.DARK_GRAY);
		btnVolver.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setBounds(392, 52, 122, 30);
		getContentPane().add(btnVolver);
		
		btnBuscar = new JButton(" Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setIcon(new ImageIcon(JDialogHospedaje.class.getResource("/imagenes/search.png")));
		btnBuscar.setForeground(Color.DARK_GRAY);
		btnBuscar.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnBuscar.setBackground(Color.WHITE);
		btnBuscar.setBounds(392, 110, 122, 30);
		getContentPane().add(btnBuscar);
		
		cabecera = tblHospedaje.getTableHeader();
		cabecera.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		VolcadoCodigosIngreso();
		ajustarAnchoColumnas();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboCategoriaBungalow) {
			actionPerformedCboCategoriaBungalow(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		if (e.getSource() == btnVolver) {
			actionPerformedBtnVolver(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
		
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
		if (e.getSource() == btnAgregarConsumo) {
			actionPerformedBtnAgregarConsumo(e);
		}
	}
	protected void actionPerformedBtnAgregarConsumo(ActionEvent e) {
	}
	protected void actionPerformedBtnConsultar(ActionEvent e) {
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
	}
	
	protected void actionPerformedBtnAceptar(ActionEvent e) {
	}
	protected void actionPerformedBtnVolver(ActionEvent e) {
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == txtHora) {
			mouseClickedTxtHora(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedTxtHora(MouseEvent e) {
		txtHora.selectAll();
		txtHora.requestFocus();
	}
	
	
	void VolcadoCodigosIngreso() {
		for(int i=0;i<ai.Tamaño();i++) {
			Ingreso x = ai.Obtener(i);
			cboIngreso.addItem(x.getCodigoIngreso()+"");;
		}
	}
	protected void actionPerformedCboCategoriaBungalow(ActionEvent e) {
		cboNumeroBungalow.removeAllItems();
		for(int i=0;i<ab.Tamaño();i++) {
			Bungalow x = ab.Obtener(i);
			if(x.getEstado() == 0 && x.getCategoria() == cboCategoriaBungalow.getSelectedIndex()) {
				cboNumeroBungalow.addItem(x.getNumeroBungalow());
			}
		}
	}
	
	//Metodos complementarios
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblHospedaje.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(35));  
		tcm.getColumn(1).setPreferredWidth(anchoColumna(30));  
		tcm.getColumn(2).setPreferredWidth(anchoColumna(40));  
		tcm.getColumn(3).setPreferredWidth(anchoColumna(30));  
		tcm.getColumn(4).setPreferredWidth(anchoColumna(30));
		tcm.getColumn(5).setPreferredWidth(anchoColumna(25));  
		tcm.getColumn(6).setPreferredWidth(anchoColumna(25));  
	}
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
}
