package arreglos;

import clases.Socio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ArregloSocio {
    private ArrayList<Socio> sc;
    
    public ArregloSocio(){
    	sc      = new ArrayList<Socio>();
    	CargarSocio();
    }
    
    public int Tamaño(){
    	return sc.size();
    }
    
    public Socio Obtener(int i){
    	return sc.get(i);
    }
    
    public void Adicionar(Socio x){
    	sc.add(x);
    }
    
    public Socio BuscarCodigoSocio(int cod){
    	for(int i=0;i<Tamaño();i++){
    		if(Obtener(i).getCodigoSocio() == cod){
    			return Obtener(i);
    		}
    	}
    	return null;
    }
    public Socio BuscarDniSocio(String dni){
    	for(int i=0;i<Tamaño();i++){
    		if(Obtener(i).getDni().equals(dni)){
    			return Obtener(i);
    		}
    	}
     return null;	
    }
    
    public int PosicionSocio(Socio x){
    	for(int i=0 ; i< Tamaño();i++){
    		if(Obtener(i).equals(x)){
    			return i;
    		}
    	}
      return 0;	
    }
    
    public void Eliminar(Socio x){
    	sc.remove(x);
    }
    
    public void GrabarSocio(){
    	try{
    		PrintWriter pw;
    		Socio       x;
    		String      linea;
    		pw = new PrintWriter(new FileWriter("Socio.txt"));
    		for(int i=0;i<Tamaño();i++){
    			x = Obtener(i);
    			linea = x.getCodigoSocio()+";"+
    			        x.getNombre()     +";"+
    					x.getApellido()   +";"+
    			        x.getDni()        +";"+
    					x.getTelefono()   ;
    	      pw.println(linea);				
    		}
    	 pw.close();	
    	}catch(Exception e){
    		
    	}
    }
    
 
    
    private void CargarSocio(){
    	try{
    		BufferedReader bf;
    		String[]   s;
    		String linea,nombre,apellido,dni;
    		int    telefono,CodigoSocio;
    		bf = new BufferedReader(new FileReader("Socio.txt"));
    		while((linea = bf.readLine()) != null){
    			s = linea.split(";");
    			CodigoSocio = Integer.parseInt(s[0]);
    			nombre   = s[1];
    			apellido = s[2];
    			dni      = s[3];
    			telefono = Integer.parseInt(s[4]);
    			
    			Adicionar(new Socio(CodigoSocio,nombre,apellido,dni,telefono));
    			
    		}
    	  
    		bf.close();
    		 
    	}catch(Exception e){
    		
    	}
    }
    
   
    
    public int CodigoCorrelativo(){
    	if(Tamaño() == 0){
    		return 10001;
    	}else{
    		return Obtener(Tamaño()-1).getCodigoSocio() + 1;
    	}
    }
    
    public int ArchivoCorrelativoConsumo(){
    	if(Tamaño() == 0){
    		return 40001;
    	}else{
    		return 40001+1;
    	}
    }
    
}
