package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import clases.Hospedaje;

public class ArregloHospedaje {
   private ArrayList<Hospedaje> hp;
   
   
   public ArregloHospedaje(){
	   hp = new ArrayList<Hospedaje>();
	   CargarHospedaje();
   }
   
   public int Tamaño(){
	   return hp.size();
   }
   
   public Hospedaje Obtener(int x){
	   return hp.get(x);
   }
   
   public void Adicionar(Hospedaje x){
	   hp.add(x);
   }
   
   public Hospedaje CodigoHospedaje(int cod){
	   for(int i=0;i<Tamaño();i++){
		 Hospedaje  x = Obtener(i);   
		   if(x.getCodigoHospedaje() == cod){
			   return x;
		   }
	   }
	 return null;  
   }
   
   public Hospedaje CodigoIngreso(int cod){
	   for(int i=0;i<Tamaño();i++){
		   Hospedaje x = Obtener(i);
		   if(x.getCodigoIngreso() == cod){
			   return x;
		   }
	   }
	  return null; 
   }
   
   public void GrabarHospedaje(){
	   try{
		   PrintWriter pw;
		   Hospedaje   x;
		   String      linea;
		   pw = new PrintWriter(new FileWriter("Hospedaje.txt"));
		   
		   for(int i=0;i<Tamaño();i++){
			   x = Obtener(i);
			   linea = x.getCodigoHospedaje() +";"+
			           x.getCodigoIngreso()   +";"+
					   x.getNumeroBungalow()  +";"+
			           x.getFechaSalida()     +";"+
					   x.getHoraSalida()      +";"+
			           x.getCostoHospedaje()  +";"+
					   x.getEstado()          ;
			  pw.println(linea); 
		   }
		 pw.close();  
	   }catch(Exception e){
		   
	   }
   }
   
   private void CargarHospedaje(){
	   try{
		   BufferedReader bf;
		   String[]       s;
		   String         linea,FechaSalida,HoraSalida;
		   int            CodigoHospedaje,CodigoIngreso,NumeroBungalow,Estado;
		   double         CostoHospedaje;
		   bf = new BufferedReader(new FileReader("Hospedaje.txt"));
		   while((linea = bf.readLine()) != null){
			   s = linea.split(";");
			   CodigoHospedaje = Integer.parseInt(s[0]);
			   CodigoIngreso   = Integer.parseInt(s[1]);
			   NumeroBungalow  = Integer.parseInt(s[2]);
			   FechaSalida     = s[3];
			   HoraSalida      = s[4];
			   CostoHospedaje  = Double.parseDouble(s[5]);
               Estado          = Integer.parseInt(s[6]);
               Adicionar(new Hospedaje(CodigoHospedaje,CodigoIngreso,NumeroBungalow,
            		     FechaSalida,HoraSalida,CostoHospedaje,Estado));
		   }
		bf.close();   
	   }catch(Exception e){
		   
	   }
   }
   
   public int CodigoCorrelativo(){
	   if(Tamaño() == 0){
		   return 50001;
	   }else{
		   return Obtener(Tamaño()-1).getCodigoHospedaje() + 1;
	   }
   }
   
}
