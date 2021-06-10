package arreglos;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.util.ArrayList;
import clases.Ingreso;

public class ArregloIngreso {
    private ArrayList<Ingreso> ig;
    
    public ArregloIngreso(){
    	ig = new ArrayList<Ingreso>();
    	CargarIngreso();
    }
    
    public void Adicionar(Ingreso x){
      ig.add(x);
    }
    
    public int Tamaño(){
    	return ig.size();
    }
    
    public Ingreso Obtener(int i){
    	return ig.get(i);
    }
    
    public void Eliminar(Ingreso x){
    	ig.remove(x);
    }
    
    public Ingreso BuscarCodigoIngreso(int cod){
    	for(int i=0;i<Tamaño();i++){
    	 Ingreso x = Obtener(i);	
    		if(x.getCodigoIngreso() == cod){
    		  return x;	
    		}
    	}
      return null;	
    }
    
    public Ingreso BuscarCodigoSocio(int cod){
    	for(int i=0;i<Tamaño();i++){
    		Ingreso x = Obtener(i);
    		 if(x.getCodigoSocio() == cod){
    			 return x;
    		 }
    	}
      return null;	
    }
    
    public void GrabarIngreso(){
    	try{
    		PrintWriter pw;
    		Ingreso     x;
    		String      linea;
    		pw = new PrintWriter(new FileWriter("Ingreso.txt"));
    		for(int i=0;i<Tamaño();i++){
    			x = Obtener(i);
    			linea = x.getCodigoIngreso()  +";"+
    			        x.getCodigoSocio()    +";"+
    					x.getFechaIngreso()   +";"+
    			        x.getHoraIngreso()    +";"+
    					x.getNumeroInvitados()+";"+
    			        x.getCostoIngreso()   +";"+
    			        x.getEstado()         ;
    		 pw.println(linea);	
    		}
    	 pw.close();	
    	}catch(Exception e){
    		
    	}
    }
    
    private void CargarIngreso(){
    	try{
    		BufferedReader bf;
    		String[]       s;
    		String         linea,FechaIngreso,HoraIngreso;
    		int            NumeroInvitados,Estado,CodigoIngreso,CodigoSocio;
    		double         CostoIngreso;
    		bf = new BufferedReader(new FileReader("Ingreso.txt"));
    		while((linea = bf.readLine()) != null){
    			s = linea.split(";");
    			CodigoIngreso   = Integer.parseInt(s[0]);
    			CodigoSocio     = Integer.parseInt(s[1]);
    			FechaIngreso    = s[2];
    			HoraIngreso     = s[3];
    			NumeroInvitados = Integer.parseInt(s[4]);
    			CostoIngreso    = Double.parseDouble(s[5]);
    			Estado          = Integer.parseInt(s[6]);
    			Adicionar(new Ingreso(CodigoIngreso,CodigoSocio,FechaIngreso,
    					   HoraIngreso,NumeroInvitados,CostoIngreso,Estado));
    		}
    	 bf.close();		
    	}catch(Exception e){
    		
    	}
    }
    
    public int CodigoCorrelativo(){
    	if(Tamaño() == 0){
    		return 40001;
    	}else{
    		return Obtener(Tamaño()-1).getCodigoIngreso() + 1;
    	}
    }
    
    
    
}
