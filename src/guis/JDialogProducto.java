package guis;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JSplitPane;
import javax.swing.border.TitledBorder;
import javax.swing.DropMode;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import arreglos.ArregloProducto;
import clases.Producto;

public class JDialogProducto extends JDialog implements ActionListener {
	private JLabel lblCodigoProducto;
	private JLabel lblDetalleDelProducto;
	private JLabel lblPrecioUnitario;
	private JLabel lblStockDelProducto;
	private JTextField txtCodigo;
	private JTextField txtPrecio;
	private JTextField txtStock;
	private JScrollPane scrollPane_1;
	private JButton btnAceptar;
	private JButton btnVolver;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnSalir;
	private JTable tblTabla;
	private DefaultTableModel modelo;
	private JTableHeader cabecera;
	private JLabel lblIngreseCodigo;
	private static final byte ADICIONAR = 0;
	private static final byte CONSULTAR = 1;
	private static final byte MODIFICAR = 2;
	private static final byte ELIMINAR  = 3;
	private static final byte VOLVER    = 4;
    private int TipoOperacion;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JDialogProducto dialog = new JDialogProducto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDialogProducto() {
		getContentPane().setBackground(UIManager.getColor("CheckBox.light"));
		setBounds(100, 100, 703, 491);
		getContentPane().setLayout(null);
		
		lblCodigoProducto = new JLabel("Codigo Producto        :");
		lblCodigoProducto.setForeground(Color.DARK_GRAY);
		lblCodigoProducto.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblCodigoProducto.setBounds(10, 24, 145, 25);
		getContentPane().add(lblCodigoProducto);
		
		lblDetalleDelProducto = new JLabel("Detalle del producto :");
		lblDetalleDelProducto.setForeground(Color.DARK_GRAY);
		lblDetalleDelProducto.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblDetalleDelProducto.setBounds(10, 68, 145, 25);
		getContentPane().add(lblDetalleDelProducto);
		
		lblPrecioUnitario = new JLabel("Precio Unitario    (S/):");
		lblPrecioUnitario.setForeground(Color.DARK_GRAY);
		lblPrecioUnitario.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblPrecioUnitario.setBounds(10, 186, 145, 25);
		getContentPane().add(lblPrecioUnitario);
		
		lblStockDelProducto = new JLabel("Stock del producto   :");
		lblStockDelProducto.setForeground(Color.DARK_GRAY);
		lblStockDelProducto.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblStockDelProducto.setBounds(10, 234, 145, 25);
		getContentPane().add(lblStockDelProducto);
		
		txtCodigo = new JTextField();
		txtCodigo.setText(""+ap.CodigoCorrelativo());
		txtCodigo.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(153, 27, 213, 20);
		getContentPane().add(txtCodigo);
		
		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		txtPrecio.setEditable(false);
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(149, 189, 217, 20);
		getContentPane().add(txtPrecio);
		
		txtStock = new JTextField();
		txtStock.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		txtStock.setEditable(false);
		txtStock.setColumns(10);
		txtStock.setBounds(149, 234, 217, 20);
		getContentPane().add(txtStock);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 270, 667, 169);
		getContentPane().add(scrollPane_1);
		
		tblTabla = new JTable();
		tblTabla.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
		tblTabla.setFillsViewportHeight(true);
		scrollPane_1.setViewportView(tblTabla);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setIcon(new ImageIcon(JDialogProducto.class.getResource("/imagenes/check.png")));
		btnAceptar.setForeground(Color.DARK_GRAY);
		btnAceptar.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnAceptar.setEnabled(false);
		btnAceptar.setBackground(Color.WHITE);
		btnAceptar.setBounds(380, 24, 122, 30);
		getContentPane().add(btnAceptar);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(this);
		btnVolver.setIcon(new ImageIcon(JDialogProducto.class.getResource("/imagenes/arrow-right.png")));
		btnVolver.setForeground(Color.DARK_GRAY);
		btnVolver.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setBounds(380, 70, 122, 30);
		getContentPane().add(btnVolver);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setIcon(new ImageIcon(JDialogProducto.class.getResource("/imagenes/plus.png")));
		btnAdicionar.setForeground(Color.DARK_GRAY);
		btnAdicionar.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnAdicionar.setBackground(Color.WHITE);
		btnAdicionar.setBounds(555, 24, 122, 30);
		getContentPane().add(btnAdicionar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setIcon(new ImageIcon(JDialogProducto.class.getResource("/imagenes/search.png")));
		btnConsultar.setForeground(Color.DARK_GRAY);
		btnConsultar.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnConsultar.setBackground(Color.WHITE);
		btnConsultar.setBounds(555, 70, 122, 30);
		getContentPane().add(btnConsultar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setIcon(new ImageIcon(JDialogProducto.class.getResource("/imagenes/edit.png")));
		btnModificar.setForeground(Color.DARK_GRAY);
		btnModificar.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnModificar.setBackground(Color.WHITE);
		btnModificar.setBounds(555, 116, 122, 30);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setIcon(new ImageIcon(JDialogProducto.class.getResource("/imagenes/trash.png")));
		btnEliminar.setForeground(Color.DARK_GRAY);
		btnEliminar.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.setBounds(555, 162, 122, 30);
		getContentPane().add(btnEliminar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setIcon(new ImageIcon(JDialogProducto.class.getResource("/imagenes/x.png")));
		btnSalir.setForeground(Color.DARK_GRAY);
		btnSalir.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setBounds(555, 231, 122, 30);
		getContentPane().add(btnSalir);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Codigo");
		modelo.addColumn("Detalle de producto");
		modelo.addColumn("Precio unitario (S/)");
		modelo.addColumn("Stock");
		tblTabla.setModel(modelo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(153, 72, 213, 92);
		scrollPane.setBorder(new LineBorder(SystemColor.inactiveCaption));
		getContentPane().add(scrollPane);
		
		txtDetalle = new JTextArea();
		txtDetalle.setEditable(false);
		txtDetalle.setBackground(SystemColor.control);
		txtDetalle.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		scrollPane.setViewportView(txtDetalle);
		
		cabecera = tblTabla.getTableHeader();
		
		cabecera.setFont(new Font("Segoe UI",Font.BOLD | Font.ITALIC,13));
		cabecera.setForeground(Color.DARK_GRAY);
		
		lblIngreseCodigo = new JLabel("Ingrese codigo a buscar");
	    lblIngreseCodigo.setVisible(false);
		lblIngreseCodigo.setIcon(new ImageIcon(JDialogSocio.class.getResource("/imagenes/arrow-left.png")));
		lblIngreseCodigo.setForeground(Color.DARK_GRAY);
		lblIngreseCodigo.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblIngreseCodigo.setBounds(369, 26, 176, 25);
		getContentPane().add(lblIngreseCodigo);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setVisible(false);
		btnBuscar.setIcon(new ImageIcon(JDialogProducto.class.getResource("/imagenes/search.png")));
		btnBuscar.setForeground(Color.DARK_GRAY);
		btnBuscar.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnBuscar.setBackground(Color.WHITE);
		btnBuscar.setBounds(380, 116, 122, 30);
		getContentPane().add(btnBuscar);
		AjustarAnchoColumna();
		Listar();
	}
	
	ArregloProducto ap = new ArregloProducto();
	private JTextArea txtDetalle;
	private JScrollPane scrollPane;
	private JButton btnBuscar;
	
	public void actionPerformed(ActionEvent arg0) {
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
		if (arg0.getSource() == btnSalir) {
			actionPerformedButtonSalir(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
		if (arg0.getSource() == btnVolver) {
			actionPerformedBtnVolver(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
	}
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		    TipoOperacion = ADICIONAR;
		    HabilitarEntradas(true);
		    HabilitarBotones(false);
		    txtCodigo.setEditable(false);
		    txtDetalle.setBackground(Color.WHITE);
		    scrollPane.setBorder(new LineBorder(SystemColor.gray));
		    txtCodigo.setText(""+ap.CodigoCorrelativo());
		    txtDetalle.requestFocus();
	}
	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
	        TipoOperacion = CONSULTAR;
	        lblIngreseCodigo.setVisible(true);
	        btnAceptar.setBounds(415, 70, 122, 30);
	        btnVolver.setBounds(415,116,122,30);
	        HabilitarBotones(false);
	        txtCodigo.setEditable(true);
	        txtCodigo.requestFocus();
	        txtCodigo.selectAll();
	        
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		TipoOperacion = MODIFICAR;
		btnBuscar.setVisible(true);
		btnBuscar.setBounds(380,24,122,30);
		btnAceptar.setBounds(380, 70,122,30);
		btnVolver.setBounds(380,116,122,30);
		txtDetalle.setBackground(Color.WHITE);
	    scrollPane.setBorder(new LineBorder(SystemColor.gray));
		txtCodigo.requestFocus();
		txtCodigo.selectAll();
		HabilitarBotones(false);
		HabilitarEntradas(true);
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		TipoOperacion = ELIMINAR;
		btnBuscar.setVisible(true);
		btnBuscar.setBounds(380,24,122,30);
		btnAceptar.setBounds(380, 70,122,30);
		btnVolver.setBounds(380,116,122,30);
		HabilitarBotones(false);
		txtCodigo.setEditable(true);
        txtCodigo.selectAll();
        txtCodigo.requestFocus();
	}
	protected void actionPerformedButtonSalir(ActionEvent arg0) {
		dispose();
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		switch(TipoOperacion){
		  case 0:Adicionar();break;
		  case 1:Consultar();break;
		  case 2:Modificar();break;
		  case 3:Eliminar();break;
		}
	}
	protected void actionPerformedBtnVolver(ActionEvent arg0) {
		TipoOperacion = VOLVER;
		txtDetalle.setBackground(SystemColor.control);
		scrollPane.setBorder(new LineBorder(SystemColor.inactiveCaption));
		lblIngreseCodigo.setVisible(false);
		btnBuscar.setVisible(false);
        btnAceptar.setBounds(380, 24, 122, 30);
        btnVolver.setBounds(380,70,122,30);
		HabilitarBotones(true);
		HabilitarEntradas(false);
		Limpiar();
	}
	protected void actionPerformedBtnBuscar(ActionEvent arg0) {
		Consultar();
	}
	//Metodos principales
	
	void Adicionar(){
		String detalle = CapturarDetalle();
		int    cod     = CapturarCodigo();
		
		if(detalle.length() > 0){
		  try{	
			  double precio = CapturarPrecio();
			  try{
				  int stock = CapturarStock();
				  ap.Adicionar(new Producto(cod,detalle,precio,stock));
				  ap.GrabarProducto();
				  Listar();
				  txtCodigo.setText(""+ap.CodigoCorrelativo());
				  Limpiar();
			  }catch(Exception e){
				  Error("Coloque el stock correctamente",txtStock);
			  }
		  }catch(Exception e){
			  Error("Coloque el precio correctamente",txtPrecio);
		  }
			
		}else{
			Mensaje("El campo esta vacio");
		}
		
	}
	
	void Consultar(){
		try{
			int cod = CapturarCodigo();
			Producto x = ap.BuscarCodigo(cod);
			if( x != null){
				txtDetalle.setText(""+x.getDetalle());
				txtPrecio.setText(""+ajustar(x.getPrecioUnitario()));
				txtStock.setText(""+x.getStock());
			}else{
				Mensaje("El codigo ingresado no existe");
			}
		}catch(Exception e){
			Error("Coloque correctamente el codigo",txtCodigo);
		}
	}
	
	void Modificar(){
		try{
			int cod = CapturarCodigo();
			Producto x = ap.BuscarCodigo(cod);
			if(x != null){
				String detalle = CapturarDetalle();
				if(detalle.length() > 0){
				   try{
					   double precio = CapturarPrecio();
					   try{
						   int stock = CapturarStock();
						   x.setDetalle(detalle);
						   x.setPrecioUnitario(precio);
						   x.setStock(stock);
						   Listar();
					   }catch(Exception e){
						   Error("Coloque el stock correctamente",txtStock);
					   }
				   }catch(Exception e){
					   Error("Coloque el precio correctamente",txtPrecio);
				   } 
				}else{
					Mensaje("El campo parece estar vacio");
				}
			}else{
				Mensaje("El codigo no existe , coloque correctamente el codigo ");
			}
		}catch(Exception e){
			Error("Coloque el codigo correctamente",txtCodigo);
		}
	}
	
	void Eliminar(){
		try{
			int cod = CapturarCodigo();
			Producto x = ap.BuscarCodigo(cod);
			if(x != null){
				int ok = confirmar("¿ Desea eliminar el registro ?");
				if(ok == 0){
					ap.Eliminar(x);
					ap.GrabarProducto();
					Listar();
					txtCodigo.setText("");
					txtDetalle.setText("");
					txtPrecio.setText("");
					txtStock.setText("");
				}
			}else{
				Error("El codigo no existe",txtCodigo);
			}
		}catch(Exception e){
			
		}
	}
	
	//Metodo Listar
	
	void Listar(){
		modelo.setRowCount(0);
		for(int i=0;i<ap.Tamaño();i++){
			Producto x = ap.Obtener(i);
			Object[] fila = {x.getCodigoProducto(),
					         x.getDetalle(),
					         "S/ "+ajustar(x.getPrecioUnitario()),
					         x.getStock()};
		  modelo.addRow(fila);	
		}
	}
	//Metodos de captura
	
	int CapturarCodigo(){
		return Integer.parseInt(txtCodigo.getText().trim());
	}
	 
	String CapturarDetalle(){
		return txtDetalle.getText().trim();
	}
	
	double CapturarPrecio(){
		return Double.parseDouble(txtPrecio.getText().trim());
	}
	
	int CapturarStock(){
		return Integer.parseInt(txtStock.getText().trim());
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
		txtCodigo.setEditable(sino);
		txtDetalle.setEditable(sino);
		txtPrecio.setEditable(sino);
		txtStock.setEditable(sino);
	}
	
	void AjustarAnchoColumna(){
		TableColumnModel tcm = tblTabla.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(AnchoColumna(20));//Codigo
		tcm.getColumn(1).setPreferredWidth(AnchoColumna(40));//Detalle producto
		tcm.getColumn(2).setPreferredWidth(AnchoColumna(20));//Precio unitario
		tcm.getColumn(3).setPreferredWidth(AnchoColumna(20));//Stock
		
	}
	
	int AnchoColumna(int porcentaje){
		return porcentaje*scrollPane_1.getWidth()/100;
	}
	
	void Error(String cad,JTextField txt){
		Mensaje(cad);
		txt.requestFocus();
		
	}
	
	void Mensaje(String cad){
		JOptionPane.showMessageDialog(this, cad);
	}
	void Limpiar(){
		txtDetalle.setText("");
		txtPrecio.setText("");
		txtStock.setText("");
	}
	String ajustar(double numero) {
		String num  = String.format("%.2f", numero);
		return num.replace(".", ",");
	}
	int confirmar(String cad) {
		return JOptionPane.showConfirmDialog(this, cad, "Alerta", 0, 1, null);
	}
	
}
