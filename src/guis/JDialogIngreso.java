package guis;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
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
import javax.swing.table.TableColumnModel;

import Libreria.Fecha;
import arreglos.ArregloIngreso;
import arreglos.ArregloSocio;
import clases.Ingreso;
import clases.Socio;

public class JDialogIngreso extends JDialog implements ActionListener {
	private JLabel lblCodigoIngreso;
	private JLabel lblCodigoSocio;
	private JLabel lblFechaIngreso;
	private JLabel lblNumeroInvitados;
	private JLabel lblEstado;
	private JLabel lblCostoIngreso;
	private JTextField txtCodigoIngreso;
	private JTextField txtFecha;
	private JTextField txtInvitados;
	private JTextField txtCosto;
	private JComboBox cboEstado;
	private JComboBox cboCodigoSocio;
	private JScrollPane scrollPane;
	private JButton btnIngresar;
	private JButton btnBuscarSocio;
	private JTable tblIngreso;
	private DefaultTableModel modelo;
	private JTableHeader      cabecera;
	private JButton btnSalir;
	Fecha   FechaHora = new Fecha();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JDialogIngreso dialog = new JDialogIngreso();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDialogIngreso() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(JDialogIngreso.class.getResource("/imagenes/edit-2.png")));
		setTitle("Ingreso Socio");
		setBounds(100, 100, 770, 557);
		getContentPane().setLayout(null);
		
		lblCodigoIngreso = new JLabel("Codigo Ingreso        :");
		lblCodigoIngreso.setForeground(Color.DARK_GRAY);
		lblCodigoIngreso.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblCodigoIngreso.setBounds(10, 20, 165, 25);
		getContentPane().add(lblCodigoIngreso);
		
		lblCodigoSocio = new JLabel("Codigo Socio            :");
		lblCodigoSocio.setForeground(Color.DARK_GRAY);
		lblCodigoSocio.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblCodigoSocio.setBounds(10, 70, 149, 25);
		getContentPane().add(lblCodigoSocio);
		
		lblFechaIngreso = new JLabel("Fecha Ingreso          :");
		lblFechaIngreso.setForeground(Color.DARK_GRAY);
		lblFechaIngreso.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblFechaIngreso.setBounds(10, 120, 149, 25);
		getContentPane().add(lblFechaIngreso);
		
		lblNumeroInvitados = new JLabel("Numero Invitados   :");
		lblNumeroInvitados.setForeground(Color.DARK_GRAY);
		lblNumeroInvitados.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblNumeroInvitados.setBounds(10, 170, 139, 25);
		getContentPane().add(lblNumeroInvitados);
		
		lblEstado = new JLabel("Estado                    :");
		lblEstado.setForeground(Color.DARK_GRAY);
		lblEstado.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblEstado.setBounds(10, 270, 139, 25);
		getContentPane().add(lblEstado);
		
		lblCostoIngreso = new JLabel("Costo Ingreso          :");
		lblCostoIngreso.setForeground(Color.DARK_GRAY);
		lblCostoIngreso.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblCostoIngreso.setBounds(10, 220, 128, 25);
		getContentPane().add(lblCostoIngreso);
		
		txtCodigoIngreso = new JTextField();
		txtCodigoIngreso.setText(ai.CodigoCorrelativo()+"");
		txtCodigoIngreso.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		txtCodigoIngreso.setEditable(false);
		txtCodigoIngreso.setColumns(10);
		txtCodigoIngreso.setBounds(146, 23, 131, 20);
		getContentPane().add(txtCodigoIngreso);
		
		txtFecha = new JTextField();
		txtFecha.setText(FechaHora.FechaActual());
		txtFecha.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		txtFecha.setColumns(10);
		txtFecha.setBounds(146, 123, 131, 20);
		getContentPane().add(txtFecha);
		
		txtInvitados = new JTextField();
		txtInvitados.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		txtInvitados.setColumns(10);
		txtInvitados.setBounds(146, 173, 131, 20);
		getContentPane().add(txtInvitados);
		
		txtCosto = new JTextField();
		txtCosto.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		txtCosto.setColumns(10);
		txtCosto.setBounds(146, 223, 131, 20);
		getContentPane().add(txtCosto);
		
		cboEstado = new JComboBox();
		cboEstado.setEnabled(false);
		cboEstado.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		cboEstado.setModel(new DefaultComboBoxModel(new String[] {"Pendiente", "Pagado"}));
		cboEstado.setBounds(146, 272, 131, 20);
		getContentPane().add(cboEstado);
		
		cboCodigoSocio = new JComboBox <String>();
		cboCodigoSocio.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		cboCodigoSocio.setBounds(146, 73, 131, 20);
		getContentPane().add(cboCodigoSocio);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 306, 734, 201);
		getContentPane().add(scrollPane);
		
		tblIngreso = new JTable();
		tblIngreso.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 12));
		scrollPane.setViewportView(tblIngreso);
		
		btnIngresar = new JButton("Ingresar Socio");
		btnIngresar.addActionListener(this);
		btnIngresar.setIcon(new ImageIcon(JDialogIngreso.class.getResource("/imagenes/edit-2.png")));
		btnIngresar.setForeground(Color.DARK_GRAY);
		btnIngresar.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnIngresar.setBackground(Color.WHITE);
		btnIngresar.setBounds(595, 26, 149, 37);
		getContentPane().add(btnIngresar);
		
		btnBuscarSocio = new JButton("Buscar Socio");
		btnBuscarSocio.addActionListener(this);
		btnBuscarSocio.setIcon(new ImageIcon(JDialogIngreso.class.getResource("/imagenes/search.png")));
		btnBuscarSocio.setForeground(Color.DARK_GRAY);
		btnBuscarSocio.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnBuscarSocio.setBackground(Color.WHITE);
		btnBuscarSocio.setBounds(595, 72, 149, 37);
		getContentPane().add(btnBuscarSocio);
		
		btnSalir = new JButton("Salir Ingreso");
		btnSalir.addActionListener(this);
		btnSalir.setIcon(new ImageIcon(JDialogIngreso.class.getResource("/imagenes/x.png")));
		btnSalir.setForeground(Color.DARK_GRAY);
		btnSalir.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setBounds(595, 125, 149, 37);
		getContentPane().add(btnSalir);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Codigo Ingreso");
		modelo.addColumn("Codigo Socio");
		modelo.addColumn("Fecha");
		modelo.addColumn("Hora");
		modelo.addColumn("Invitados");
		modelo.addColumn("Costo");
		modelo.addColumn("Estado");
		
		tblIngreso.setModel(modelo);
		
		cabecera = tblIngreso.getTableHeader();
		cabecera.setFont(new Font("Segoe UI",Font.BOLD | Font.ITALIC , 13));
		cabecera.setForeground(Color.DARK_GRAY);
		AjustarAnchoColumna();
		Listar();
		AgregarCodigos();
	}
	
	ArregloSocio   as = new ArregloSocio();
	ArregloIngreso ai = new ArregloIngreso();
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnSalir) {
			actionPerformedBtnSalir(arg0);
		}
		if (arg0.getSource() == btnBuscarSocio) {
			actionPerformedBtnBuscarSocio(arg0);
		}
		if (arg0.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(arg0);
		}
	}
	protected void actionPerformedBtnIngresar(ActionEvent arg0) {
		IngresarSocio();
	}
	protected void actionPerformedBtnBuscarSocio(ActionEvent arg0) {
		BuscarSocio();
	}
	protected void actionPerformedBtnSalir(ActionEvent arg0) {
		dispose();
	}
	
	void Listar(){
		modelo.setRowCount(0);
		for(int i=0;i<ai.Tamaño();i++){
			Ingreso x = ai.Obtener(i);
			Object[] fila = {x.getCodigoIngreso(),
					         x.getCodigoSocio(),
					         x.getFechaIngreso(),
					         x.getHoraIngreso(),
					         x.getNumeroInvitados(),
					         x.getCostoIngreso(),
					         Estado(x.getEstado())};
			modelo.addRow(fila);
			//txtCodigoIngreso.setText(""+(x.getCodigoIngreso()+1));
		}
	}
	
	void IngresarSocio(){
		int codigoIngreso = CapturarCodigoIngreso();
		int codigoSocio   = CapturarCodigoSocio();
		String fecha      = CapturarFechaIngreso();
		String hora       = CapturarHoraIngreso();
		if(fecha.length() > 0 ){
			if(fecha.length() == 10){
				try{
				   int numeroInvitados = CapturarNumeroInvitados();	
				   try{
					   double costo = CapturarCostoIngreso();
					   int estado   = CapturarEstado();
					   ai.Adicionar(new Ingreso(codigoIngreso,codigoSocio,fecha,hora,numeroInvitados,costo,estado));
					   ai.GrabarIngreso();
					   Listar();
					   txtCodigoIngreso.setText(""+ai.CodigoCorrelativo());
					   txtInvitados.setText("");
					   txtCosto.setText("");
				   }catch(Exception e){
					   Error("Escriba el costo correctamente");
				   }
				}catch(Exception e){
					Error("Escriba el numero de invitados correctamente");
				}
			}else{
				Error("La fecha no esta escrita correctamente");
			}
		}else{
			Error("El campo fecha esta vacio");
		}
	}
	
	void BuscarSocio(){
		try{
			String dni = JOptionPane.showInputDialog("Ingrese DNI del socio a buscar :").trim();
			Socio  x      = as.BuscarDni(dni);
			if(x != null){
				JOptionPane.showMessageDialog(this,"Encontrado correctamente!!");
				cboCodigoSocio.setSelectedIndex(as.PosicionSocio(x));
			}else{
				Error("El dni ingresado no coincide con ningun socio");
			}
		}catch(NullPointerException e){
			
		}catch(Exception e){
			Error("Escriba correctamente el dni");
		}
	}
	
	//Metodos de captura
	
	int CapturarCodigoIngreso(){
		return Integer.parseInt(txtCodigoIngreso.getText().trim());
	}
	int CapturarCodigoSocio(){
		return Integer.parseInt(String.valueOf(cboCodigoSocio.getSelectedItem()));
	}
	
	String CapturarFechaIngreso(){
		return txtFecha.getText().trim();
	}
	String CapturarHoraIngreso(){
		return Fecha.HoraActual();
	}
	int  CapturarNumeroInvitados(){
		return Integer.parseInt(txtInvitados.getText());
	}
	double CapturarCostoIngreso(){
		return Double.parseDouble(txtCosto.getText());
	}
	int   CapturarEstado(){
		return cboEstado.getSelectedIndex();
	}
	
	String Estado(int estado){
		if(estado == 0){
			return "Pendiente";
		}else{
			return "Pagado";
		}
	}
	
	
	//Metodos complementarios
	
	void AgregarCodigos(){
		Socio x;
		for(int i=0;i<as.Tamaño();i++){
			x = as.Obtener(i);
			cboCodigoSocio.addItem(""+x.getCodigoSocio());
		}
	}
	
	void AjustarAnchoColumna(){
		TableColumnModel tcm = tblIngreso.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(AnchoColumna(25));
		tcm.getColumn(1).setPreferredWidth(AnchoColumna(25));
		tcm.getColumn(2).setPreferredWidth(AnchoColumna(15));
		tcm.getColumn(3).setPreferredWidth(AnchoColumna(15));
		tcm.getColumn(4).setPreferredWidth(AnchoColumna(15));
		tcm.getColumn(5).setPreferredWidth(AnchoColumna(15));
		tcm.getColumn(6).setPreferredWidth(AnchoColumna(15));
	}
	
	void Error(String cad){
		JOptionPane.showMessageDialog(this,cad);
	}
	
	int AnchoColumna(int porcentaje){
		return porcentaje * scrollPane.getWidth()/100;
	}
	
}
