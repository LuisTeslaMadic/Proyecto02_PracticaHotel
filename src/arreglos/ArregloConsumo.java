package arreglos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Consumo;


public class ArregloConsumo {
    
	private ArrayList<Consumo> cs;
	
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
	/*
    public void GrabarArchivo(int CodigoSocio){
		BufferedWriter pw = null;
		String      linea;
		Socio x;
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
    */
}
