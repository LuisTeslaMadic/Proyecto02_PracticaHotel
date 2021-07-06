package guis;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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

import Libreria.Formatos;
import arreglos.ArregloConsumo;
import arreglos.ArregloIngreso;
import arreglos.ArregloProducto;
import arreglos.ArregloSocio;
import clases.Ingreso;
import clases.Producto;
import clases.Socio;

public class JDialogConsumo extends JDialog implements ActionListener {
	private JLabel lblCodigoConsumo;
	private JLabel lblCodigoSocio;
	private JTextField txtCodigoConsumo;
	private JComboBox<Integer> cboSocio;
	private JLabel lblProductos;
	private JLabel lblNombreSocio;
	private JTextField txtNombre;
	private JComboBox<String> cboProducto;
	private JButton btnRevisarProductos;
	private JButton btnAgregarConsumo;
	private JButton btnBorrarConsumo;
	private JLabel lblPrecioVenta;
	private JTextField txtPrecioVenta;
	private JLabel lblCantidad;
	private JButton btnBuscarConsumo;
	private JTextField txtCantidad;
	private JScrollPane scrollPane;
	private JTable tblConsumo;
	private DefaultTableModel modelo;
	private JTableHeader      cabecera;
	private JLabel lblTotal;
	private JTextField txtTotal;
	private JButton btnSalir;
	private static final byte ADICIONAR = 0;
	private static final byte ELIMINAR  = 1;
	private byte TipoOperacion;
	private JButton btnAceptar;
	private JButton btnVolver;
	ArregloConsumo   ac ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JDialogConsumo dialog = new JDialogConsumo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDialogConsumo() {
		setTitle("Consumo Socio");
		setBounds(100, 100, 793, 566);
		getContentPane().setLayout(null);
		
		lblCodigoConsumo = new JLabel("Codigo Consumo        :");
		lblCodigoConsumo.setForeground(Color.DARK_GRAY);
		lblCodigoConsumo.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblCodigoConsumo.setBounds(10, 26, 145, 25);
		getContentPane().add(lblCodigoConsumo);
		
		lblCodigoSocio = new JLabel("Codigo Socio              :");
		lblCodigoSocio.setForeground(Color.DARK_GRAY);
		lblCodigoSocio.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblCodigoSocio.setBounds(10, 75, 145, 25);
		getContentPane().add(lblCodigoSocio);
		
		txtCodigoConsumo = new JTextField();
		txtCodigoConsumo.setEditable(false);
		txtCodigoConsumo.setText("30001");
		txtCodigoConsumo.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		txtCodigoConsumo.setColumns(10);
		txtCodigoConsumo.setBounds(154, 27, 213, 20);
		getContentPane().add(txtCodigoConsumo);
		
		cboSocio = new JComboBox<Integer>();
		cboSocio.addActionListener(this);
		cboSocio.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		cboSocio.setBounds(154, 75, 214, 20);
		getContentPane().add(cboSocio);
		
		lblProductos = new JLabel("Productos                  :");
		lblProductos.setForeground(Color.DARK_GRAY);
		lblProductos.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblProductos.setBounds(10, 173, 145, 25);
		getContentPane().add(lblProductos);
		
		lblNombreSocio = new JLabel("Nombre Socio            :");
		lblNombreSocio.setForeground(Color.DARK_GRAY);
		lblNombreSocio.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblNombreSocio.setBounds(10, 124, 145, 25);
		getContentPane().add(lblNombreSocio);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(154, 124, 213, 20);
		getContentPane().add(txtNombre);
		
		cboProducto = new JComboBox<String>();
		cboProducto.addActionListener(this);
		cboProducto.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		cboProducto.setBounds(154, 173, 213, 20);
		getContentPane().add(cboProducto);
		
		btnRevisarProductos = new JButton("");
		btnRevisarProductos.addActionListener(this);
		btnRevisarProductos.setIcon(new ImageIcon(JDialogConsumo.class.getResource("/imagenes/clipboard (1).png")));
		btnRevisarProductos.setForeground(Color.DARK_GRAY);
		btnRevisarProductos.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnRevisarProductos.setBackground(Color.WHITE);
		btnRevisarProductos.setBounds(377, 172, 41, 22);
		getContentPane().add(btnRevisarProductos);
		
		btnAgregarConsumo = new JButton("Adicionar");
		btnAgregarConsumo.addActionListener(this);
		btnAgregarConsumo.setIcon(new ImageIcon(JDialogConsumo.class.getResource("/imagenes/plus.png")));
		btnAgregarConsumo.setForeground(Color.DARK_GRAY);
		btnAgregarConsumo.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnAgregarConsumo.setBackground(Color.WHITE);
		btnAgregarConsumo.setBounds(647, 23, 120, 30);
		getContentPane().add(btnAgregarConsumo);
		
		btnBorrarConsumo = new JButton("Borrar");
		btnBorrarConsumo.addActionListener(this);
		btnBorrarConsumo.setIcon(new ImageIcon(JDialogConsumo.class.getResource("/imagenes/x.png")));
		btnBorrarConsumo.setForeground(Color.DARK_GRAY);
		btnBorrarConsumo.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnBorrarConsumo.setBackground(Color.WHITE);
		btnBorrarConsumo.setBounds(647, 72, 120, 30);
		getContentPane().add(btnBorrarConsumo);
		
		lblPrecioVenta = new JLabel("Precio Venta       (S/.) :");
		lblPrecioVenta.setForeground(Color.DARK_GRAY);
		lblPrecioVenta.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblPrecioVenta.setBounds(10, 218, 145, 25);
		getContentPane().add(lblPrecioVenta);
		
		txtPrecioVenta = new JTextField();
		txtPrecioVenta.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		txtPrecioVenta.setEditable(false);
		txtPrecioVenta.setColumns(10);
		txtPrecioVenta.setBounds(154, 221, 213, 20);
		getContentPane().add(txtPrecioVenta);
		
		lblCantidad = new JLabel("Cantidad                   :");
		lblCantidad.setForeground(Color.DARK_GRAY);
		lblCantidad.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblCantidad.setBounds(10, 271, 145, 25);
		getContentPane().add(lblCantidad);
		
		btnBuscarConsumo = new JButton("");
		btnBuscarConsumo.setIcon(new ImageIcon(JDialogConsumo.class.getResource("/imagenes/search.png")));
		btnBuscarConsumo.setForeground(Color.DARK_GRAY);
		btnBuscarConsumo.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnBuscarConsumo.setBackground(Color.WHITE);
		btnBuscarConsumo.setBounds(378, 74, 41, 22);
		getContentPane().add(btnBuscarConsumo);
		
		txtCantidad = new JTextField();
		txtCantidad.setEditable(false);
		txtCantidad.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(154, 270, 213, 20);
		getContentPane().add(txtCantidad);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 305, 757, 181);
		getContentPane().add(scrollPane);
		
		tblConsumo = new JTable();
		tblConsumo.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
		scrollPane.setViewportView(tblConsumo);
		
		lblTotal = new JLabel("Suma Total :");
		lblTotal.setForeground(Color.DARK_GRAY);
		lblTotal.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblTotal.setBounds(373, 497, 86, 25);
		getContentPane().add(lblTotal);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setBackground(SystemColor.control);
		txtTotal.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		txtTotal.setColumns(10);
		txtTotal.setBounds(458, 499, 309, 20);
		getContentPane().add(txtTotal);
		
		btnSalir = new JButton("Salir");
		btnSalir.setIcon(new ImageIcon(JDialogConsumo.class.getResource("/imagenes/trending-up.png")));
		btnSalir.addActionListener(this);
		btnSalir.setForeground(Color.DARK_GRAY);
		btnSalir.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setBounds(647, 121, 120, 30);
		getContentPane().add(btnSalir);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Codigo Consumo");
		modelo.addColumn("Codigo Socio");
		modelo.addColumn("Producto");
		modelo.addColumn("Precio venta(S/)");
		modelo.addColumn("Cantidad");
		modelo.addColumn("Total(S/.)");
		
		tblConsumo.setModel(modelo);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setIcon(new ImageIcon(JDialogConsumo.class.getResource("/imagenes/check.png")));
		btnAceptar.setForeground(Color.DARK_GRAY);
		btnAceptar.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnAceptar.setBackground(Color.WHITE);
		btnAceptar.setBounds(425, 23, 120, 30);
		getContentPane().add(btnAceptar);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(this);
		btnVolver.setIcon(new ImageIcon(JDialogConsumo.class.getResource("/imagenes/arrow-right.png")));
		btnVolver.setForeground(Color.DARK_GRAY);
		btnVolver.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setBounds(425, 72, 120, 30);
		getContentPane().add(btnVolver);
		
		cabecera = tblConsumo.getTableHeader();
		
		cabecera.setFont(new Font("Segoe UI",Font.BOLD | Font.ITALIC,13));
		
		AgregarCodioSocios();
		AgregarProductos();
		PrecioProducto();
		ac = new ArregloConsumo();
		CargarConsumo(CapturarCodigoSocio());
	}
	
	ArregloSocio     as = new ArregloSocio();
	ArregloProducto  ap = new ArregloProducto();
	ArregloIngreso   ai = new ArregloIngreso();
	
	
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnVolver) {
			actionPerformedBtnVolver(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
		if (arg0.getSource() == cboSocio) {
			actionPerformedCboSocio(arg0);
		}
		if (arg0.getSource() == cboProducto) {
			actionPerformedCboProducto(arg0);
		}
		if (arg0.getSource() == btnRevisarProductos) {
			actionPerformedBtnRevisarProductos(arg0);
		}
		if (arg0.getSource() == btnSalir) {
			actionPerformedBtnSalir(arg0);
		}
		if (arg0.getSource() == btnBorrarConsumo) {
			actionPerformedBtnBorrarConsumo(arg0);
		}
		if (arg0.getSource() == btnAgregarConsumo) {
			actionPerformedBtnAgregarConsumo(arg0);
		}
	}
	protected void actionPerformedBtnAgregarConsumo(ActionEvent arg0) {
		txtCantidad.setEditable(true);
		txtCantidad.requestFocus();
		if(modelo.getRowCount() > 0) {
			txtCodigoConsumo.setText(""+CapturarCodigoTabla());
		}
	}
	protected void actionPerformedBtnBorrarConsumo(ActionEvent arg0) {
	}
	
	protected void actionPerformedBtnSalir(ActionEvent arg0) {
		dispose();
	}
	protected void actionPerformedBtnRevisarProductos(ActionEvent arg0) {
		JDialogProducto x = new JDialogProducto();
		x.setVisible(true);
		x.setLocationRelativeTo(this);
	}
	protected void actionPerformedCboProducto(ActionEvent arg0) {
		PrecioProducto();
	}
	protected void actionPerformedCboSocio(ActionEvent arg0){
		NombreSocio();
		int cod = CapturarCodigoSocio();
		CargarConsumo(cod);
		System.out.println(""+CapturarCodigoTabla());
		if(modelo.getRowCount() > 0) {
			txtCodigoConsumo.setText(""+CapturarCodigoTabla());
		}else {
			txtCodigoConsumo.setText(""+30001);
		}
		
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
	    Adicionar();
	}
	protected void actionPerformedBtnVolver(ActionEvent arg0) {
		
	}
	
	//Metodos de acción de los botones
	void Adicionar(){
		try{
			int CodigoConsumo = CapturarCodigoConsumo();	
			try{
				int CodigoSocio = CapturarCodigoSocio();
				String NombreSocio   = CapturarNombreSocio();
				if(NombreSocio.length() > 0){
					try{
					   String producto   = CapturarProducto().toString();
					   double PrecioVenta = CapturarPrecio();
						try{
							int cantidad   = CapturarCantidad();
							GrabarArchivo(CodigoConsumo,CodigoSocio,NombreSocio,producto,PrecioVenta,cantidad,ConsumoTotal());
							//if(modelo.getRowCount() > 0) {
								txtCodigoConsumo.setText(""+(CapturarCodigoTabla()+1));
							//}else {
							//	txtCodigoConsumo.setText(""+30001);
							//}
							CargarConsumo(CodigoSocio);
							//Mensaje("Adicionado");
						}catch(Exception e){
							Mensaje("Error en la cantidad");
						}
					}catch(Exception e){
					  Mensaje("Error con el producto");
					}
				}
			}catch(Exception e){
				Mensaje("Error codigo socio");
			}
		}catch(Exception e){
			Mensaje("Error en el codigo de consumo");
		}
	}
	
	
	
	//Metodos de Grabado y Escritura de archivos
	
	void GrabarArchivo(int CodigoConsumo,int CodigoSocio,String NombreSocio,String producto,double Precio,int Cantidad , double total){
		BufferedWriter pw = null;
		String      linea;
		try {
			pw = new BufferedWriter(new FileWriter((String.valueOf(CodigoSocio+30000))+".txt",true));
				linea = CodigoConsumo+";"+
				        CodigoSocio  +";"+
				        producto     +";"+
						Precio       +";"+
				        Cantidad     +";"+
						total        ;
			 
				pw.write(linea);
				pw.newLine();
		} catch (Exception e) {
			System.out.println(">>Error al crear el archivo 1204");
		}finally {
			if(pw != null) {
				try {
					pw.close();
				} catch (IOException e) {
					System.out.println(">>Error al cerrar 1107");
				}
			}
			
		}
		
	}
	
	
	
	void CargarConsumo(int Codigo)  {
		BufferedReader br = null;
		String linea ,CodigoConsumo,CodigoSocio,producto,cantidad;
		String[] s = null ;
		double total,precio,AcTotal = 0.0;
		modelo.setRowCount(0);
		try {
			br = new BufferedReader(new FileReader((Codigo+30000)+".txt"));
			while((linea = br.readLine()) != null) {
				s = linea.split(";");	
			 if(s.length ==6) {
					CodigoConsumo = s[0];
					CodigoSocio = s[1];
					producto    = s[2];
					precio      = Double.parseDouble(s[3]);
					cantidad    = s[4];
					total       = Double.parseDouble(s[5]);
					Object[] fila = {CodigoConsumo,
							         CodigoSocio,
							         producto,
							         Formatos.FormatoMoneda(precio),
							         cantidad,
							        Formatos.FormatoMoneda(total)};
					modelo.addRow(fila);
					AcTotal +=total;
			 }
			}
			txtTotal.setText(Formatos.FormatoMoneda(AcTotal));
			br.close();
		}catch(IOException e) {
			System.out.println(">> Error al abrir el archivo "+e);
		}
		
	}
	
	//Metodos complementarios
	int CapturarCodigoConsumo(){
		return Integer.parseInt(txtCodigoConsumo.getText().trim());
	}
	
	int CapturarCodigoSocio(){
		return Integer.parseInt(cboSocio.getSelectedItem().toString());
	}
	
	String CapturarNombreSocio(){
		return txtNombre.getText().trim();
	}
	
	String CapturarProducto(){
		return String.valueOf(cboProducto.getSelectedItem());
	}
	
	double ConsumoTotal() {
		return CapturarPrecio() * CapturarCantidad();
	}
	
	double CapturarPrecio(){
		String precio = txtPrecioVenta.getText();
		return Double.parseDouble(precio.replace(",","."));
	}
	
	int CapturarCantidad(){
		return Integer.parseInt(txtCantidad.getText().trim());
	}
	int CapturarCodigoTabla() {
		int NumFilas = modelo.getRowCount()+1;
		return 30000+NumFilas;
	}
	
	//Metodos complementarios
	
	void Mensaje(String cad){
		JOptionPane.showMessageDialog(this, cad);
	}
	
	void AgregarCodioSocios(){
		Ingreso x;
		BufferedWriter pw = null;
		for(int i=0;i<ai.Tamaño();i++){
			x = ai.Obtener(i);
			try {
				pw = new BufferedWriter(new FileWriter((String.valueOf(x.getCodigoSocio()+30000))+".txt",true));
			} catch (IOException e) {
               System.out.println(">> Error al momento de crear los archivos 1104");
			}finally {
				if(pw != null) {
					try {
						pw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			cboSocio.addItem(x.getCodigoSocio());
		}
	  
	}
	
	void AgregarProductos(){
		Producto x;
		for(int i=0;i<ap.Tamaño();i++){
			x = ap.Obtener(i);
			cboProducto.addItem(""+x.getDetalle());
		}
	}
	
	void PrecioProducto(){
		Producto x = ap.BuscarDetalle(String.valueOf(cboProducto.getSelectedItem()));
		if(x != null){
			txtPrecioVenta.setText(""+ajustar(x.getPrecioUnitario()));
		}
	}
	void NombreSocio(){
		Socio x = as.BuscarCodigoSocio(Integer.parseInt(String.valueOf(cboSocio.getSelectedItem())));
		if(x != null){
			txtNombre.setText(x.getNombre());
		}
	}
	
	String ajustar(double numero) {
		String num  = String.format("%.2f", numero);
		return num.replace(".", ",");
	}
	
	int CodigoConsumo(){
		if(as.Tamaño() == 0){
			return 30001;
		}else{
			return Integer.parseInt(txtCodigoConsumo.getText()) + 1 ;
		}
	}
	
	
}
