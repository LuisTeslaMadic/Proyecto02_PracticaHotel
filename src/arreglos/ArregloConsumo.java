package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import clases.Consumo;


public class ArregloConsumo {
    
	private ArrayList<Consumo> cs;
	private static double AcTotal;
	
	static {
		setAcTotal(0);
	}
	
	
	
	public ArregloConsumo(){
		cs = new ArrayList<Consumo>();
		
	}
	
	public int Tamaño(){
		return cs.size();
	}
	
	public Consumo Obtener(int x){
		return cs.get(x);
	}
	
	public void Adicionar(Consumo x){
		cs.add(x);
	}
	
    public void Eliminar(Consumo x){
    	cs.remove(x);
    }
    public List<Consumo> CargarConsumo(int CodigoSocio)  {
		BufferedReader br = null;
		ArrayList<Consumo> ac = new ArrayList<Consumo>();
		String linea ,producto;
		int cantidad;
		String[] s = null ;
		double precio,total;
		try {
			br = new BufferedReader(new FileReader((CodigoSocio+30000)+".txt"));
			while((linea = br.readLine()) != null) {
				s = linea.split(";");	
			 if(s.length ==6) {
					producto    = s[2];
					precio      = Double.parseDouble(s[3]);
					cantidad    = Integer.parseInt(s[4]);
					total       = Double.parseDouble(s[5]);
					Consumo x = new Consumo();
					x.setProducto(producto);
					x.setCantidad(cantidad);
					x.setPrecio(precio);
					AcTotal+=total;
					ac.add(x);
			 }
			}
	      //txtTotal.setText(Formatos.FormatoMoneda(AcTotal));
			br.close();
		}catch(IOException e) {
			System.out.println(">> Error al abrir el archivo "+e);
		}
	 return ac;	
		
	}
   
    public Consumo Buscar(int CodigoSocio){
		for(int i=0;i<Tamaño();i++){
		 Consumo x = Obtener(i);	
			if(x.getCodigoSocio()== CodigoSocio){
				return x;
			}
		}
	 return null;	
	}

	public static double getAcTotal() {
		return AcTotal;
	}

	public static void setAcTotal(double acTotal) {
		AcTotal = acTotal;
	}

}
