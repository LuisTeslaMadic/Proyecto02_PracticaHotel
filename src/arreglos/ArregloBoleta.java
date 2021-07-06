package arreglos;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import clases.Boleta;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public class ArregloBoleta {
    private ArrayList<Boleta> bl;
    
    public ArregloBoleta(){
    	bl = new ArrayList<Boleta>();
    	CargarBoleta();
    }
    
    public int Tamaño(){
    	return bl.size();
    }
    
    public void Adicionar(Boleta i){
    	bl.add(i);
    }
    
    public Boleta Obtener(int i){
    	return bl.get(i);
    }
    
    public void Eliminar(Boleta i){
    	bl.remove(i);
    }
    
    public Boleta Buscar(int cod){
    	for(int i=0;i<Tamaño();i++){
    		if(Obtener(i).getCodigoBoleta() == cod){
    			return Obtener(i);
    		}
    	}
    	return null;
    }
    
    
    
    public void GrabarBoleta(){
      try{	
    	 PrintWriter pw;
    	 Boleta      x;
    	 String      linea;
    	 
    	 pw = new PrintWriter(new FileWriter("Boleta.txt"));
    	 for(int i=0;i<Tamaño();i++){
    		 x = Obtener(i);
    		 linea = x.getCodigoBoleta() +";"+
    		         x.getCodigoIngreso()+";"+
    				 x.getPagoTotal();
    		 pw.println(linea);
    	 }
    	 pw.close();
      }catch(Exception e){
    	  JOptionPane.showMessageDialog(null, this, "No se puede crear archivo", 0);
      }
    }
    public void CargarBoleta(){
    	try{
    		BufferedReader bf;
    		String[] s;
    		String linea;
    		int CodigoBoleta,CodigoIngreso,PagoTotal;
    		bf = new BufferedReader(new FileReader("Boleta.txt"));
    		while((linea = bf.readLine()) != null){
    			s = linea.split(";");
    			CodigoBoleta  = Integer.parseInt(s[0]);
    			CodigoIngreso = Integer.parseInt(s[1]);
    			PagoTotal     = Integer.parseInt(s[2]);
    			Adicionar(new Boleta(CodigoBoleta,CodigoIngreso,PagoTotal));
     		}
    		bf.close();
    	}catch(Exception e){
    		//JOptionPane.showMessageDialog(null, this, "Ah ocurrido un error ups!!", 0);
    	}
    }
    
    public int CodigoCorrelativo(){
    	if(Tamaño() == 0){
    		return 60001;
    	}else{
    		return Obtener(Tamaño()- 1).getCodigoBoleta() + 1 ;
    	}
    }
    
    
    
}
