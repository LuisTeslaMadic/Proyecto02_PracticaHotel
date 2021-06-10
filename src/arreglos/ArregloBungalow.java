package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import clases.Bungalow;

public class ArregloBungalow {
    
	private ArrayList<Bungalow> bw;
	
	public ArregloBungalow(){
		bw = new ArrayList<Bungalow>();
		CargarBungalow();
	}
	
	public int Tamaño(){
		return bw.size();
	}
	
	public void Adicionar(Bungalow x){
		bw.add(x);
	}
	
	public Bungalow Obtener(int x){
		return bw.get(x);
	}
	
	public void Eliminar(Bungalow x){
		bw.remove(x);
	}
	
	public Bungalow Buscar(int NumBungalow){
		for(int i=0;i<Tamaño();i++){
		 Bungalow x = Obtener(i);	
			if(x.getNumeroBungalow() == NumBungalow){
				return x;
			}
		}
	 return null;	
	}
	
	public void GrabarBungalow(){
		try{
			PrintWriter pw;
			Bungalow    x;
			String      linea;
			pw = new PrintWriter(new FileWriter("Bungalow.txt"));
			
			for(int i=0;i<Tamaño();i++){
			   x = Obtener(i);	
			   linea = x.getNumeroBungalow() +";"+
			           x.getCategoria()      +";"+
					   x.getPrecioPorDia()   +";"+
			           x.getEstado()         ;
			   pw.println(linea); 
			}
		 pw.close();	
		}catch(Exception e){
			
		}
	}
	
	private void CargarBungalow(){
		try{
			BufferedReader bf;
			String[]       s;
			String linea ;
			int    NumeroBungalow,Categoria,Estado;
			double PrecioPorDia;
			bf = new BufferedReader(new FileReader("Bungalow.txt"));
			
			while((linea = bf.readLine()) != null){
				s = linea.split(";");
				NumeroBungalow = Integer.parseInt(s[0]);
				Categoria      = Integer.parseInt(s[1]);
				PrecioPorDia   = Double.parseDouble(s[2]);
				Estado         = Integer.parseInt(s[3]);
				
				Adicionar(new Bungalow(NumeroBungalow,Categoria,PrecioPorDia,Estado));
			}
			bf.close();
		}catch(Exception e){
			System.out.println(e+"Error");
		}
	}
	
	public int CodigoCorrelativo(){
		if(Tamaño() == 0){
			return 30001;
		}else{
			return Obtener(Tamaño()-1).getNumeroBungalow()+1;
		}
	}
	
	
}
