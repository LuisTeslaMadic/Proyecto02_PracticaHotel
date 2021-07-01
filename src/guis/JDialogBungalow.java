package guis;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import arreglos.ArregloBungalow;
import clases.Bungalow;

public class JDialogBungalow extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblNumeroDeBungalow;
	private JLabel lblCategoria;
	private JLabel lblPrecio;
	private JLabel lblEstado;
	private JTextField txtNumero;
	private JTextField txtPrecio;
	private JComboBox<String> cboCategoria;
	private JComboBox<String> cboEstado;
	private JButton btnAceptar;
	private JButton btnVolver;
	private JButton btnBuscar;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnSalir;
	private JScrollPane scrollPane;
	private JTable tblTabla;
	private static final byte ADICIONAR = 0;
	private static final byte CONSULTAR = 1;
	private static final byte MODIFICAR = 2;
	private static final byte ELIMINAR  = 3;
	private byte TipoOperacion;
	private DefaultTableModel modelo;
	private JTableHeader      cabecera;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JDialogBungalow dialog = new JDialogBungalow();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDialogBungalow() {
		getContentPane().setForeground(Color.DARK_GRAY);
		setBackground(Color.DARK_GRAY);
		setBounds(100, 100, 635, 495);
		getContentPane().setLayout(null);
		
		lblNumeroDeBungalow = new JLabel("Numero de Bungalow  :");
		lblNumeroDeBungalow.setForeground(Color.DARK_GRAY);
		lblNumeroDeBungalow.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblNumeroDeBungalow.setBounds(10, 24, 152, 25);
		getContentPane().add(lblNumeroDeBungalow);
		
		lblCategoria = new JLabel("Categoria                    :");
		lblCategoria.setForeground(Color.DARK_GRAY);
		lblCategoria.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblCategoria.setBounds(10, 80, 152, 25);
		getContentPane().add(lblCategoria);
		
		lblPrecio = new JLabel("Precio por dia(S/)        :");
		lblPrecio.setForeground(Color.DARK_GRAY);
		lblPrecio.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblPrecio.setBounds(10, 134, 162, 25);
		getContentPane().add(lblPrecio);
		
		lblEstado = new JLabel("Estado                        :");
		lblEstado.setForeground(Color.DARK_GRAY);
		lblEstado.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblEstado.setBounds(10, 188, 144, 25);
		getContentPane().add(lblEstado);
		
		txtNumero = new JTextField();
		txtNumero.setText(""+ab.CodigoCorrelativo());
		txtNumero.setEditable(false);
		txtNumero.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		txtNumero.setColumns(10);
		txtNumero.setBounds(161, 27, 131, 20);
		getContentPane().add(txtNumero);
		
		txtPrecio = new JTextField();
		txtPrecio.setText("100.0");
		txtPrecio.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		txtPrecio.setEditable(false);
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(161, 137, 131, 20);
		getContentPane().add(txtPrecio);
		
		cboCategoria = new JComboBox<String>();
		cboCategoria.setForeground(Color.BLACK);
		cboCategoria.addActionListener(this);
		cboCategoria.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		cboCategoria.setModel(new DefaultComboBoxModel<String>(new String[] {"Simple", "Doble", "Familiar"}));
		cboCategoria.setBounds(161, 83, 131, 20);
		getContentPane().add(cboCategoria);
		
		cboEstado = new JComboBox<String>();
		cboEstado.setBorder(null);
		cboEstado.setFocusable(false);
		cboEstado.setEnabled(false);
		cboEstado.setBackground(Color.WHITE);
		cboEstado.setForeground(Color.DARK_GRAY);
		cboEstado.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 15));
		cboEstado.setModel(new DefaultComboBoxModel<String>(new String[] {"Libre", "Ocupado"}));
		cboEstado.setBounds(162, 188, 130, 23);
		getContentPane().add(cboEstado);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setIcon(new ImageIcon(JDialogBungalow.class.getResource("/imagenes/check.png")));
		btnAceptar.setForeground(Color.DARK_GRAY);
		btnAceptar.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnAceptar.setEnabled(false);
		btnAceptar.setBackground(Color.WHITE);
		btnAceptar.setBounds(302, 25, 122, 30);
		getContentPane().add(btnAceptar);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(this);
		btnVolver.setIcon(new ImageIcon(JDialogBungalow.class.getResource("/imagenes/arrow-right.png")));
		btnVolver.setForeground(Color.DARK_GRAY);
		btnVolver.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setBounds(302, 80, 122, 30);
		getContentPane().add(btnVolver);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setVisible(false);
		btnBuscar.setIcon(new ImageIcon(JDialogBungalow.class.getResource("/imagenes/search.png")));
		btnBuscar.setForeground(Color.DARK_GRAY);
		btnBuscar.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnBuscar.setBackground(Color.WHITE);
		btnBuscar.setBounds(302, 135, 122, 30);
		getContentPane().add(btnBuscar);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setIcon(new ImageIcon(JDialogBungalow.class.getResource("/imagenes/plus.png")));
		btnAdicionar.setForeground(Color.DARK_GRAY);
		btnAdicionar.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnAdicionar.setBackground(Color.WHITE);
		btnAdicionar.setBounds(487, 25, 122, 30);
		getContentPane().add(btnAdicionar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setIcon(new ImageIcon(JDialogBungalow.class.getResource("/imagenes/search.png")));
		btnConsultar.setForeground(Color.DARK_GRAY);
		btnConsultar.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnConsultar.setBackground(Color.WHITE);
		btnConsultar.setBounds(487, 80, 122, 30);
		getContentPane().add(btnConsultar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setIcon(new ImageIcon(JDialogBungalow.class.getResource("/imagenes/edit.png")));
		btnModificar.setForeground(Color.DARK_GRAY);
		btnModificar.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnModificar.setBackground(Color.WHITE);
		btnModificar.setBounds(487, 135, 122, 30);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setIcon(new ImageIcon(JDialogBungalow.class.getResource("/imagenes/trash.png")));
		btnEliminar.setForeground(Color.DARK_GRAY);
		btnEliminar.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.setBounds(487, 190, 122, 30);
		getContentPane().add(btnEliminar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setIcon(new ImageIcon(JDialogBungalow.class.getResource("/imagenes/x.png")));
		btnSalir.setForeground(Color.DARK_GRAY);
		btnSalir.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setBounds(487, 241, 122, 30);
		getContentPane().add(btnSalir);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 282, 599, 163);
		getContentPane().add(scrollPane);
		
		tblTabla = new JTable();
		tblTabla.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
		tblTabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTabla);
		
		modelo = new DefaultTableModel();
		
		modelo.addColumn("Numero Bungalow");
		modelo.addColumn("Categoria");
		modelo.addColumn("Precio por dia S/");
		modelo.addColumn("Estado");
		
		tblTabla.setModel(modelo);
		
		lblIngreseCodigoA = new JLabel("Ingrese codigo a buscar");
		lblIngreseCodigoA.setVisible(false);
		lblIngreseCodigoA.setIcon(new ImageIcon(JDialogBungalow.class.getResource("/imagenes/arrow-left.png")));
		lblIngreseCodigoA.setForeground(Color.DARK_GRAY);
		lblIngreseCodigoA.setBackground(Color.WHITE);
		lblIngreseCodigoA.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblIngreseCodigoA.setBounds(301, 24, 176, 25);
		getContentPane().add(lblIngreseCodigoA);
		
		cabecera = tblTabla.getTableHeader();
		
		cabecera.setFont(new Font("Segoe UI",Font.BOLD | Font.ITALIC,13));
		cabecera.setForeground(Color.DARK_GRAY);
		
		Listar();
	}
	
	ArregloBungalow ab = new ArregloBungalow();
	private JLabel lblIngreseCodigoA;
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == cboCategoria) {
			actionPerformedCboCategoria(arg0);
		}
		if (arg0.getSource() == btnSalir) {
			actionPerformedBtnSalir(arg0);
		}
		if (arg0.getSource() == btnVolver) {
			actionPerformedBtnVolver(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
		if (arg0.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
	}
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		  TipoOperacion = ADICIONAR;
		  txtNumero.setText(""+ab.CodigoCorrelativo());
		  HabilitarEntradas(true);
		  HabilitarBotones(false);
	}
	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
		 TipoOperacion = CONSULTAR;
		 lblIngreseCodigoA.setVisible(true);
		 btnAceptar.setBounds(345, 80, 122, 30);
		 btnVolver.setBounds(342, 135, 122, 30);
		 HabilitarBotones(false);
		 txtNumero.setEditable(true);
		 txtNumero.requestFocus();
		 txtNumero.selectAll();
		 
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		TipoOperacion = MODIFICAR;
		btnBuscar.setVisible(true);
		btnBuscar.setBounds(302, 25, 122, 30);
		btnAceptar.setBounds(302, 80, 122, 30);
		btnVolver.setBounds(302, 135, 122, 30);
		txtNumero.setEditable(true);
		txtNumero.setText("");
		txtNumero.requestFocus();
		HabilitarEntradas(true);
		HabilitarBotones(false);
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		TipoOperacion = ELIMINAR;
		btnBuscar.setVisible(true);
		btnBuscar.setBounds(302, 25, 122, 30);
		btnAceptar.setBounds(302, 80, 122, 30);
		btnVolver.setBounds(302, 135, 122, 30);
		txtNumero.setEditable(true);
		HabilitarBotones(false);
	}
	protected void actionPerformedBtnBuscar(ActionEvent arg0) {
		Consultar();
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		switch(TipoOperacion){
		case 0: Adicionar();break; 
		case 1: Consultar();break;
		case 2: Modificar();break;
		case 3: Eliminar();break;
		}
	}
	protected void actionPerformedBtnVolver(ActionEvent arg0) {
		lblIngreseCodigoA.setVisible(false);
		btnBuscar.setVisible(false);
		btnAceptar.setBounds(302, 25, 122, 30);
		btnVolver.setBounds(302,  80, 122, 30);
		txtNumero.setEditable(false);
		HabilitarEntradas(false);
		HabilitarBotones(true);
	}
	protected void actionPerformedBtnSalir(ActionEvent arg0) {
		dispose();
	}
	protected void actionPerformedCboCategoria(ActionEvent arg0) {
		int cat = CapturarCategoria();
		PrecioPorDia(cat);
	}
	
	//Metodo listar
	
	void Listar(){
		modelo.setRowCount(0);
		for(int i=0;i<ab.Tamaño();i++){
			Bungalow x = ab.Obtener(i);
			Object[] fila = {x.getNumeroBungalow(),
					         TipoCategoria(x.getCategoria()),
					         "S/"+formato(x.getPrecioPorDia()),
					         TipoEstado(x.getEstado())};
			modelo.addRow(fila);
		}
	}
	
	//Metodos de accion en los botones
	
	void Adicionar(){
	     int     cod = CapturarNumeroBungalow();
		 int     categoria = CapturarCategoria();
		 double  Precio = CapturarPrecio();
		 int     Estado = CapturarEstado();
		 ab.Adicionar(new Bungalow(cod,categoria,Precio,Estado));
		 ab.GrabarBungalow();
		 Listar();
		 txtNumero.setText(""+ab.CodigoCorrelativo());
		 Limpiar();
		 
	}
	void Consultar(){
		try{
			int cod = CapturarNumeroBungalow();
			Bungalow x = ab.Buscar(cod);
			if(x != null){
				cboCategoria.setSelectedIndex(x.getCategoria());
				txtPrecio.setText(""+x.getPrecioPorDia());
				cboEstado.setSelectedIndex(x.getEstado());
			}
		}catch(Exception e){
			
		}
	}
	
	void Modificar(){
		try{
			int cod = CapturarNumeroBungalow();
			Bungalow x = ab.Buscar(cod);
			if(x != null){
				int     categoria   = CapturarCategoria();
				double  precio      = CapturarPrecio();
				int     Estado      = CapturarEstado();
				x.setCategoria(categoria);
				x.setPrecioPorDia(precio);
				x.setEstado(Estado);
				ab.GrabarBungalow();
				Listar();
			}else{
				Error("El codigo no existe",txtNumero);
			}
		}catch(Exception e){
			Mensaje("Coloque correctamente el codigo");
		}
	}
	
	void Eliminar(){
		try{
			int cod = CapturarNumeroBungalow();
			Bungalow x = ab.Buscar(cod);
			if(x != null){
				int ok = ConfirmarDialogo("¿ Desea eliminar el registro ?");
				if(ok == 0){
					ab.Eliminar(x);
					ab.GrabarBungalow();
					Listar();
					txtNumero.setText("");
					Limpiar();
				}
			}
		}catch(Exception e){
			
		}
	}
	
	//Metodos de captura
	
	int CapturarNumeroBungalow(){
		return Integer.parseInt(txtNumero.getText().trim());
	}
	
	int CapturarCategoria(){
		return cboCategoria.getSelectedIndex();
	}
	
	double CapturarPrecio(){
		return Double.parseDouble(txtPrecio.getText().trim());
	}
	
	int CapturarEstado(){
		return cboEstado.getSelectedIndex();
	}
	//Metodos complementarios
	
	void HabilitarBotones(boolean sino){
		btnAceptar.setEnabled(!sino);
		btnAdicionar.setEnabled(sino);
		btnConsultar.setEnabled(sino);
		btnModificar.setEnabled(sino);
		btnEliminar.setEnabled(sino);
	}
	void HabilitarEntradas(boolean sino){
		cboCategoria.setEnabled(sino);
		cboEstado.setEnabled(sino);
	}
	
	String TipoCategoria(int cat){
		String  Tipo = "";
		switch(cat){
		  case 0: Tipo = "Simple";break;
		  case 1: Tipo = "Doble";break;
		  default: Tipo = "Familiar";break;
		}
	 return Tipo;	
	}
	
	String TipoEstado(int est){
		if(est == 0){
			return "Libre";
		}else{
			return "Ocupado";
		}
			
	}
	
	void PrecioPorDia(int cat){
		if(cat == 0){
			txtPrecio.setText(""+100.0);
		}else if(cat == 1){
			txtPrecio.setText(""+200.0);
		}else{
			txtPrecio.setText(""+500.0);
		}
	}
	void Limpiar(){
		cboCategoria.setSelectedIndex(0);
		cboEstado.setSelectedIndex(0);
	}
	
	void Error(String cad,JTextField txt){
		Mensaje(cad);
		txt.selectAll();
		txt.requestFocus();
	}
	
	void Mensaje(String cad){
		JOptionPane.showMessageDialog(this, cad);
	}
	int ConfirmarDialogo(String cad){
		return JOptionPane.showConfirmDialog(this, cad, "Alerta", 0, 1, null);
	}
	String formato(double num){
		String numero = String.valueOf(num);
		return numero.replace(".", ",");
	}
}
