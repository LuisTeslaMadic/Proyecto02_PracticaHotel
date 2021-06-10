package arreglos;

import java.util.ArrayList;
import clases.Producto;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public class ArregloProducto {
    private ArrayList<Producto> pr;
    
    public ArregloProducto(){
    	pr = new ArrayList<Producto>();
    	CargarProducto();
    }
    
    public int Tamaño(){
    	return pr.size();
    }
    
    public Producto Obtener(int i){
    	return pr.get(i);
    }
    
    public void Adicionar(Producto x){
    	pr.add(x);
    }
    
    public void Eliminar(Producto x){
    	pr.remove(x);
    }
    
    public Producto BuscarCodigo(int cod){
    	for(int i=0;i<Tamaño();i++){
    	 Producto x = Obtener(i);	
    		if(x.getCodigoProducto() == cod){
    			return x;
    		}
    	}
      return null;	
    }
    
    public Producto BuscarDetalle(String detalle){
    	for(int i=0;i<Tamaño();i++){
    		Producto x = Obtener(i);
    		if(x.getDetalle().equals(detalle)){
    			return x;
    		}
    	}
     return null;	
    }
    
    public void GrabarProducto(){
    	try{
    		PrintWriter pw;
    		Producto x;
    		String linea;
    		pw = new PrintWriter(new FileWriter("Producto.txt"));
    		for(int i=0;i<Tamaño();i++){
    		  x = Obtener(i);
    		  linea = x.getCodigoProducto()+ ";" +
    				  x.getDetalle()       + ";" +
    				  x.getPrecioUnitario()+ ";" +
    				  x.getStock() ;
    		  pw.println(linea);
    		}
    	 pw.close();	
    	}catch(Exception e){
    		
    	}
    }
    
    private void CargarProducto(){
    	try{
    		BufferedReader bf;
    		String[]       s;
    		String        linea,detalle;
    		int           CodigoProducto,Stock;
    		double        PrecioUnitario;
    		bf = new BufferedReader(new FileReader("Producto.txt"));
    		
    		while((linea = bf.readLine()) != null){
    			s = linea.split(";");
    		   CodigoProducto = Integer.parseInt(s[0]);
    		   detalle        = s[1];
    		   PrecioUnitario = Double.parseDouble(s[2]);
    		   Stock          = Integer.parseInt(s[3]);
    		   
    		   Adicionar(new Producto(CodigoProducto,detalle,PrecioUnitario,Stock));
    		}
    	 bf.close();	
    	}catch(Exception e){
    		System.out.println(e);
    	}
    }
    
    
    public int CodigoCorrelativo(){
    	if(Tamaño() == 0){
    		return 20001;
    	}else{
    		return Obtener(Tamaño()-1).getCodigoProducto() + 1;
    	}
    }
}
