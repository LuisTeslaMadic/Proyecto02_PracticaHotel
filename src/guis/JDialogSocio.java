package guis;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import arreglos.ArregloSocio;
import clases.Socio;

import javax.swing.ImageIcon;
import DialogoPaneles.VentaPersonalizada;

public class JDialogSocio extends JDialog implements ActionListener {
	private JLabel lblCodigoSocio;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDni;
	private JLabel lblTelefono;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JTextField txtTelefono;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JScrollPane scrollPane;
	private JTable tblTabla;
	private JButton btnAceptar;
	private JButton btnVolver;
	private JButton btnSalir;
	private DefaultTableModel modelo;
	private JTableHeader       cabecera;
	private static final byte ADICIONAR = 0;
	private static final byte CONSULTAR = 1;
	private static final byte MODIFICAR = 2;
	private static final byte ELIMINAR  = 3;
	private static final byte VOLVER    = 4;
	private byte TipoOperacion;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JDialogSocio dialog = new JDialogSocio();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDialogSocio() {
		setForeground(Color.DARK_GRAY);
		getContentPane().setForeground(Color.GRAY);
		setBackground(Color.GRAY);
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		setBounds(100, 100, 593, 482);
		getContentPane().setLayout(null);
		
		lblCodigoSocio = new JLabel("Codigo Socio :");
		lblCodigoSocio.setForeground(Color.DARK_GRAY);
		lblCodigoSocio.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblCodigoSocio.setBounds(10, 20, 94, 25);
		getContentPane().add(lblCodigoSocio);
		
		lblNombre = new JLabel("Nombre        :");
		lblNombre.setForeground(Color.DARK_GRAY);
		lblNombre.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblNombre.setBounds(10, 70, 94, 25);
		getContentPane().add(lblNombre);
		
		lblApellido = new JLabel("Apellidos      :");
		lblApellido.setForeground(Color.DARK_GRAY);
		lblApellido.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblApellido.setBounds(10, 120, 94, 25);
		getContentPane().add(lblApellido);
		
		lblDni = new JLabel("Dni              :");
		lblDni.setForeground(Color.DARK_GRAY);
		lblDni.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblDni.setBounds(10, 170, 94, 25);
		getContentPane().add(lblDni);
		
		lblTelefono = new JLabel("Telefono      :");
		lblTelefono.setForeground(Color.DARK_GRAY);
		lblTelefono.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblTelefono.setBounds(10, 220, 94, 25);
		getContentPane().add(lblTelefono);
		
		txtCodigo = new JTextField();
		txtCodigo.setText(""+as.CodigoCorrelativo());
		txtCodigo.setEditable(false);
		txtCodigo.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		txtCodigo.setBounds(103, 23, 131, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		txtNombre.setBounds(103, 73, 131, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setEditable(false);
		txtApellido.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		txtApellido.setBounds(103, 123, 131, 20);
		getContentPane().add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setEditable(false);
		txtDni.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		txtDni.setBounds(102, 173, 132, 20);
		getContentPane().add(txtDni);
		txtDni.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setEditable(false);
		txtTelefono.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(102, 223, 132, 20);
		getContentPane().add(txtTelefono);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setIcon(new ImageIcon(JDialogSocio.class.getResource("/imagenes/plus.png")));
		btnAdicionar.setForeground(Color.DARK_GRAY);
		btnAdicionar.setBackground(Color.WHITE);
		btnAdicionar.addActionListener(this);
		btnAdicionar.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnAdicionar.setBounds(445, 18, 122, 30);
		getContentPane().add(btnAdicionar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setIcon(new ImageIcon(JDialogSocio.class.getResource("/imagenes/search.png")));
		btnConsultar.setForeground(Color.DARK_GRAY);
		btnConsultar.setBackground(Color.WHITE);
		btnConsultar.addActionListener(this);
		btnConsultar.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnConsultar.setBounds(445, 65, 122, 30);
		getContentPane().add(btnConsultar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setIcon(new ImageIcon(JDialogSocio.class.getResource("/imagenes/edit.png")));
		btnModificar.setForeground(Color.DARK_GRAY);
		btnModificar.setBackground(Color.WHITE);
		btnModificar.addActionListener(this);
		btnModificar.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnModificar.setBounds(445, 112, 122, 30);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(JDialogSocio.class.getResource("/imagenes/trash.png")));
		btnEliminar.setForeground(Color.DARK_GRAY);
		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.addActionListener(this);
		btnEliminar.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnEliminar.setBounds(445, 159, 122, 30);
		getContentPane().add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 257, 557, 175);
		getContentPane().add(scrollPane);
		
		tblTabla = new JTable();
		tblTabla.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
		tblTabla.setForeground(Color.DARK_GRAY);
		scrollPane.setViewportView(tblTabla);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setEnabled(false);
		btnAceptar.setIcon(new ImageIcon(JDialogSocio.class.getResource("/imagenes/check.png")));
		btnAceptar.setForeground(Color.DARK_GRAY);
		btnAceptar.setBackground(Color.WHITE);
		btnAceptar.addActionListener(this);
		btnAceptar.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnAceptar.setBounds(244, 18, 122, 30);
		getContentPane().add(btnAceptar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setIcon(new ImageIcon(JDialogSocio.class.getResource("/imagenes/arrow-right.png")));
		btnVolver.setForeground(Color.DARK_GRAY);
		btnVolver.setBackground(Color.WHITE);
		btnVolver.addActionListener(this);
		btnVolver.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnVolver.setBounds(244, 65, 122, 30);
		getContentPane().add(btnVolver);
		
		btnSalir = new JButton("Salir");
		btnSalir.setIcon(new ImageIcon(JDialogSocio.class.getResource("/imagenes/x.png")));
		btnSalir.addActionListener(this);
		btnSalir.setForeground(Color.DARK_GRAY);
		btnSalir.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setBounds(445, 206, 122, 30);
		getContentPane().add(btnSalir);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Codigo");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("Dni");
		modelo.addColumn("Telefono");
		
		tblTabla.setModel(modelo);
		
	    lblIngreseCodigo = new JLabel("Ingrese codigo a buscar");
	    lblIngreseCodigo.setVisible(false);
		lblIngreseCodigo.setIcon(new ImageIcon(JDialogSocio.class.getResource("/imagenes/arrow-left.png")));
		lblIngreseCodigo.setForeground(Color.DARK_GRAY);
		lblIngreseCodigo.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblIngreseCodigo.setBounds(244, 20, 176, 25);
		getContentPane().add(lblIngreseCodigo);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setIcon(new ImageIcon(JDialogSocio.class.getResource("/imagenes/search.png")));
		btnBuscar.setForeground(Color.DARK_GRAY);
		btnBuscar.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnBuscar.setEnabled(false);
		btnBuscar.setBackground(Color.WHITE);
		btnBuscar.setBounds(244, 112, 122, 30);
		btnBuscar.setVisible(false);
		getContentPane().add(btnBuscar);
		
		cabecera = tblTabla.getTableHeader();
		cabecera.setFont(new Font("Segoe UI",Font.BOLD | Font.ITALIC,13));
		cabecera.setForeground(Color.DARK_GRAY);
		
		
		Listar();
	}
	
	ArregloSocio as = new ArregloSocio();
	private JLabel lblIngreseCodigo;
	private JButton btnBuscar;
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(arg0);
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
		HabilitarEntradas(true);
		HabilitarBotones(false);
		txtCodigo.setText(""+as.CodigoCorrelativo());
		txtCodigo.setEditable(false);
		lblIngreseCodigo.setVisible(false);
		Limpiar();
	}
	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
		TipoOperacion = CONSULTAR;	
		HabilitarEntradas(false);
		HabilitarBotones(false);
		txtCodigo.setEditable(true);
		txtCodigo.selectAll();
		txtCodigo.requestFocus();
    	lblIngreseCodigo.setVisible(true);
    	lblIngreseCodigo.setBounds(244, 20, 176, 25);
		btnAceptar.setBounds(290, 65, 122, 30);
		btnVolver.setBounds(290, 112, 122, 30);
		btnBuscar.setVisible(false);
		
	/*	
		byte opcion = OpcionesBusqueda();
	    if(opcion == 1){
			HabilitarEntradas(false);
			HabilitarBotones(false);
			txtCodigo.setEditable(true);
			txtCodigo.setText("");
			txtCodigo.requestFocus();
	    	lblIngreseCodigo.setVisible(true);
	    	lblIngreseCodigo.setBounds(244, 20, 176, 25);
			btnAceptar.setBounds(290, 65, 122, 30);
			btnVolver.setBounds(290, 112, 122, 30);
			
	    }else if(opcion == 2){
	    	HabilitarBotones(false);
	    	txtDni.setEditable(true);
	    	lblIngreseCodigo.setText("Ingrese dni a buscar");
	    	lblIngreseCodigo.setVisible(true);
	    	lblIngreseCodigo.setBounds(244, 170, 176, 25);
	    	btnAceptar.setBounds(290, 65, 122, 30);
			btnVolver.setBounds(290, 112, 122, 30);
	    }	
	    */
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		TipoOperacion = MODIFICAR;
		 HabilitarEntradas(true);
		 HabilitarBotones(false);
		 btnBuscar.setVisible(true);
		 btnBuscar.setEnabled(true);
		 txtCodigo.requestFocus();
		 btnBuscar.setBounds(244, 18, 122, 30);
		 btnAceptar.setBounds(240, 65, 122, 30);
		 btnVolver.setBounds(240, 112, 122, 30);
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		TipoOperacion = ELIMINAR;
		btnBuscar.setVisible(true);
		btnBuscar.setEnabled(true);
		HabilitarBotones(false);
		txtCodigo.setEditable(true);
		txtCodigo.selectAll();
		txtCodigo.requestFocus();
		btnBuscar.setBounds(244, 18, 122, 30);
		btnAceptar.setBounds(240, 65, 122, 30);
		btnVolver.setBounds(240, 112, 122, 30);
		/*HabilitarBotones(false);
		txtCodigo.selectAll();
		btnBuscar.setVisible(true);
		txtCodigo.setEditable(true);
		btnBuscar.setBounds(244, 18, 122, 30);
		btnAceptar.setBounds(240, 65, 122, 30);
		btnVolver.setBounds(240, 112, 122, 30);*/
		
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		switch(TipoOperacion){
		    case 0: Adicionar();break;
		    case 1: Consultar();break;
		    case 2: Modificar();break;
		    case 3: Eliminar();break; 	     
		}
	}
	protected void actionPerformedBtnBuscar(ActionEvent arg0) {
		Consultar();
	}
	protected void actionPerformedBtnVolver(ActionEvent arg0) {
		TipoOperacion = VOLVER;
		HabilitarEntradas(false);
		HabilitarBotones(true);
		lblIngreseCodigo.setVisible(false);
		btnAceptar.setBounds(244, 18, 122, 30);
		btnVolver.setBounds(244, 65, 122, 30);
	}
	protected void actionPerformedBtnSalir(ActionEvent arg0) {
		dispose();
	}
	
	//Metodos a accionar en los botones
	
	void Adicionar(){
		int    cod    = CapturarCodigo();
		String nombre = CapturarNombre();
		
		if(nombre.length() > 0){
			String apellido = CapturarApellido();
			if(apellido.length() > 0){
				String dni = CapturarDni();
				if(dni.length() > 0){
					if(dni.length() == 8){
						try{
							int telefono = CapturarTelefono();
							String tel = String.valueOf(telefono);
							if(tel.length() == 9 || tel.length() == 7){
								telefono = Integer.parseInt(tel);
								as.Adicionar(new Socio (cod,nombre,apellido,dni,telefono));
								Listar();
								as.GrabarSocio();
								txtCodigo.setText(""+as.CodigoCorrelativo());
								Limpiar();
							}else{
								Error("Si es telefono de casa son 7 numero o si es telefono celular son 9 numeros",txtTelefono);
							}
						}catch(Exception e){
							Error("El campo telefono esta vacio",txtTelefono);
						}
					}else{
						Error("El campo dni tiene que tener 8 digitos",txtDni);
					}
				}else{
					Error("El campo dni esta vacio",txtDni);
				}
			}else{
				Error("El campo apellido esta vacio",txtApellido);
			}
		}else{
			Error("El campo nombre esta vacio",txtNombre);
		}
	}
	
	
	void Consultar(){
		try{
			int cod = CapturarCodigo();
			Socio x = as.BuscarCodigo(cod);
			if(x != null){
				txtNombre.setText(""+x.getNombre());
				txtApellido.setText(""+x.getApellido());
				txtDni.setText(""+x.getDni());
				txtTelefono.setText(""+x.getTelefono());
			}else{
				Mensaje("El codigo ingresado no existe");
			}
		}catch(Exception e){
			Error("Inserte codigo correctamente",txtCodigo);
		}
	}
	
	void Modificar(){
		try{
		 int cod = CapturarCodigo();	
		 String nombre = CapturarNombre();
	     if(nombre.length() > 0){
	    	 String apellido = CapturarApellido();
	    	 if(apellido.length() > 0){
	    		 String dni = CapturarDni();
	    		 if(dni.length() >0){
	    			 if(dni.length()==8){
	    				    String telefono = String.valueOf(CapturarTelefono());
	    				    Socio x = as.BuscarCodigo(cod);
	    				 if(telefono.length() == 9){
	    					 int tel = Integer.parseInt(telefono);
	    					 x.setNombre(nombre);
	    					 x.setApellido(apellido);
	    					 x.setDni(dni);
	    					 x.setTelefono(tel);
	    					 Listar();
	    				 }else{
	    					 Error("El telefono tiene minimo 9 numeros",txtTelefono);
	    				 }
	    			 }else{
	    				 Error("El campo dni tiene que tener 8 numeros",txtDni);
	    			 }
	    		 }else{
	    			 Error("El campo dni esta vacio",txtDni);
	    		 }
	    	 }else{
	    		 Error("El campo apellido esta vacio",txtApellido);
	    	 }
	     }else{
	    	 Error("El campo nombre esta vacio",txtNombre);
	     }
		}catch(Exception e){
			Error("Coloque el codigo correctamente",txtCodigo);
		}
	}
	void Eliminar(){
		try{
			int cod = CapturarCodigo();
			Socio x = as.BuscarCodigo(cod);
			if(x != null){
				int ok = confirmar("¿ Desea eliminar el registro ?");
				if(ok == 0){
					as.Eliminar(x);
					as.GrabarSocio();
					Listar();
					txtCodigo.setText("");
					txtNombre.setText("");
					txtApellido.setText("");
					txtDni.setText("");
					txtTelefono.setText("");
				}
			}else{
				Mensaje("El codigo no existe");
			}
		}catch(Exception e){
			Error("Ingrese correctamente el codigo a eliminar",txtCodigo);
		}
	}
	//Metodo Listar
	void Listar(){
		modelo.setRowCount(0);
		for(int i=0;i<as.Tamaño();i++){
			Socio x = as.Obtener(i);
			Object[] fila = {x.getCodigoSocio(),
					         x.getNombre(),
					         x.getApellido(),
					         x.getDni(),
					         x.getTelefono()};
		  modelo.addRow(fila);	
		}
	}
	//Metodos de captura
	
	int CapturarCodigo(){
		return Integer.parseInt(txtCodigo.getText().trim());
	}
	
	String CapturarNombre(){
		return txtNombre.getText().trim();
	}
	
	String CapturarApellido(){
		return txtApellido.getText().trim();
	}
	String CapturarDni(){
		return txtDni.getText().trim();
	}
	
	int CapturarTelefono(){
		return Integer.parseInt(txtTelefono.getText().trim());
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
		txtNombre.setEditable(sino);
		txtApellido.setEditable(sino);
		txtDni.setEditable(sino);
		txtTelefono.setEditable(sino);
	}
	
	void Error(String cad,JTextField txt){
		Mensaje(cad);
		txt.setText("");
		txt.requestFocus();
	}
	
	void Mensaje(String cad){
		JOptionPane.showMessageDialog(this, cad);
	}
	
	void Limpiar(){
		txtNombre.setText("");
		txtApellido.setText("");
		txtDni.setText("");
		txtTelefono.setText("");
	}
	/*
	byte OpcionesBusqueda(){
		byte opcion=0 ;
		
		String opciones = JOptionPane.showInputDialog("Escoga una se las opciones\n"+
                             "1. Buscar por codigo\n"+
                             "2. Buscar por dni").trim();
		if(opciones.length() > 0){
			opcion = Byte.parseByte(opciones);
		} 
	 
		
	  return opcion;	
	}
  */
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
	}
}
