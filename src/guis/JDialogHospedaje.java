package guis;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;

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

import com.toedter.calendar.JDateChooser;

import arreglos.ArregloBungalow;
import arreglos.ArregloHospedaje;
import arreglos.ArregloIngreso;
import clases.Bungalow;
import clases.Hospedaje;
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
	private JComboBox<Integer> cboIngreso;
	private JLabel lblCodigoDeBungalow;
	private JScrollPane scrollPane;
	private JTable tblHospedaje;
	private JComboBox<Integer> cboNumeroBungalow;
	private JLabel lblCodigoIngreso;
	private JComboBox<String> cboCategoriaBungalow;
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
		setResizable(false);
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
		btnAgregarConsumo.setBounds(789, 10, 134, 46);
		getContentPane().add(btnAgregarConsumo);
		
		lblCategoriaDeBungalow = new JLabel("Categoria de Bungalow :");
		lblCategoriaDeBungalow.setForeground(Color.DARK_GRAY);
		lblCategoriaDeBungalow.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblCategoriaDeBungalow.setBounds(10, 90, 158, 25);
		getContentPane().add(lblCategoriaDeBungalow);
		
		cboIngreso = new JComboBox<Integer>();
		cboIngreso.addActionListener(this);
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
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 339, 913, 240);
		getContentPane().add(scrollPane);
		
		tblHospedaje = new JTable();
		tblHospedaje.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		scrollPane.setViewportView(tblHospedaje);
		
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
		
		cboCategoriaBungalow = new JComboBox<String>();
		cboCategoriaBungalow.addActionListener(this);
		cboCategoriaBungalow.setModel(new DefaultComboBoxModel<String>(new String[] {"Simple", "Doble", "Familiar"}));
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
		dtFechaSalida.setDateFormatString("dd/MM/yyyy");
		dtFechaSalida.setForeground(Color.DARK_GRAY);
		dtFechaSalida.setFont(new Font("Segoe UI",Font.ITALIC, 13));
		
		txtHora = new JTextField();
		txtHora.addMouseListener(this);
		txtHora.setText("hh:mm");
		txtHora.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		txtHora.setColumns(10);
		txtHora.setBounds(180, 204, 183, 20);
		getContentPane().add(txtHora);
		
		txtCosto = new JTextField();
		txtCosto.setEditable(false);
		txtCosto.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		txtCosto.setColumns(10);
		txtCosto.setBounds(180, 250, 183, 20);
		getContentPane().add(txtCosto);
		
		cboEstado = new JComboBox();
		cboEstado.setEnabled(false);
		cboEstado.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 15));
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
		
		cabecera = tblHospedaje.getTableHeader();
		cabecera.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		VolcadoCodigosIngreso();
		ajustarAnchoColumnas();
		AñadirItems();
		Listar();
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboIngreso) {
			actionPerformedCboIngreso(e);
		}
		if (e.getSource() == cboCategoriaBungalow) {
			actionPerformedCboCategoriaBungalow(e);
		}
		if (e.getSource() == btnAgregarConsumo) {
			actionPerformedBtnAgregarConsumo(e);
		}
	}
	protected void actionPerformedBtnAgregarConsumo(ActionEvent e) {
	    Adicionar();      
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

	protected void actionPerformedCboIngreso(ActionEvent e) {
		Ingreso x = ai.BuscarCodigoIngreso(CapturarCodigoIngreso());
		txtCosto.setText(x.getCostoIngreso()+"");
	}
	
	void VolcadoCodigosIngreso() {
		for(int i=0;i<ai.Tamaño();i++) {
			Ingreso x = ai.Obtener(i);
			if(x.getEstado() == 0) {
			  cboIngreso.addItem(x.getCodigoIngreso());
			}
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
	
	/*Metodos principales*/
	
	void AñadirItems() {
		cboNumeroBungalow.removeAllItems();
		for(int i=0;i<ab.Tamaño();i++) {
			Bungalow x = ab.Obtener(i);
			if(x.getEstado() == 0 && x.getCategoria() == cboCategoriaBungalow.getSelectedIndex()) {
				cboNumeroBungalow.addItem(x.getNumeroBungalow());
			}
		}
	}
	
	void Adicionar() {
		try {
			String fecha = CapturarFecha();
			String horaSalida = CapturarHora();
			if(horaSalida.matches("(1[0-2]|0?[1-9]):([0-5][0-9])")) {
			    int codIngr    = CapturarCodigoIngreso();
			    Hospedaje objHospedaje = ah.BuscarCodigoHospedaje(codIngr);
			   if(objHospedaje == null) {
				   int codigoHos  = CapturarCodigoHospedaje();
				   int numeroBung = CapturarNumeroBungalow();
				   double costo   = CapturarCosto();
				   int    estado  = CapturarEstado();
				   ah.Adicionar(new Hospedaje(codigoHos,codIngr,numeroBung,fecha,horaSalida,costo,estado));
				   ah.GrabarHospedaje();
				   Listar(); 
			   }else {
				   mensaje("El socio ya esta hospedado");
			   }
			}else {
				mensaje("Debe colocar la hora con el formato hh:mm");
			}
		}catch(Exception e) {
			mensaje("Debe colocar la fecha con el formato dd/mm/yyyy");
			e.printStackTrace();
		}
	}
	void Consultar() {
		if(txtCodigoHospedaje.getText().equals("")) {
			int cod = CapturarCodigoHospedaje();
			Hospedaje x = ah.BuscarCodigoHospedaje(cod);
			if(x != null) {
				
			}else {
				mensaje("El codigo de hospedaje no existe");
			}
		}else {
			mensaje("Coloque un código a buscar");
		}
	}
	
	//Metodos de captura
	
	int CapturarCodigoHospedaje() {
		return Integer.parseInt(txtCodigoHospedaje.getText().trim());
	}
	
	int CapturarCodigoIngreso() {
		return Integer.parseInt(cboIngreso.getSelectedItem().toString());
	}
	int CapturarNumeroBungalow() {
		return Integer.parseInt(cboNumeroBungalow.getSelectedItem().toString());
	}
	String CapturarFecha() {
		return FormatoFecha(dtFechaSalida.getDate());
	}
	String CapturarHora() {
		return txtHora.getText();
	}
	double CapturarCosto() {
		return Double.parseDouble(txtCosto.getText());
	}
	int CapturarEstado() {
		return cboEstado.getSelectedIndex();
	}
	
	//Metodos complementarios
	
	void Listar() {
		modelo.setRowCount(0);
		for(int i=0;i<ah.Tamaño();i++) {
			Hospedaje x = ah.Obtener(i);
			Object[] fila = {x.getCodigoHospedaje(),
					         x.getCodigoIngreso(),
					         x.getNumeroBungalow(),
					         x.getFechaSalida(),
					         x.getHoraSalida(),
					         x.getCostoHospedaje(),
					         EstadoLetras(x.getEstado())};
			modelo.addRow(fila);
		}
	}
	
	String FormatoFecha(Date fecha) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(fecha)+"";
	}
	
    String EstadoLetras(int estado) {
    	switch(estado) {
    	case 0  : return "Pendiente";
    	default : return "Pagado";
    	}
    }
	
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
	
	void mensaje(String cad) {
		JOptionPane.showMessageDialog(this, cad);
	}
}
