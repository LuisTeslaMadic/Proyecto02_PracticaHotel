package Libreria;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Fecha {
	
	public static String FechaActual(){
		//int dd,mm,yy;
		Calendar c = new GregorianCalendar();
		/*
		dd = c.get(c.DATE);
		mm = c.get(c.MONTH) + 1;
		yy = c.get(c.YEAR);
		*/
		return FormatoFecha(c.getTime(),"dd/MM/yyyy");
	}
	
	public static String HoraActual(){
		Calendar c = new GregorianCalendar();
		return FormatoFecha(c.getTime(),"hh:mm:ss");
	}
	
    
	public static String FormatoFecha(Date fecha,String formato){
		SimpleDateFormat spf = new SimpleDateFormat(formato);
		return spf.format(fecha);
	}
	
	public static String enTextoFecha(String fecha){
		String[] s = fecha.split("/");
		if(s.length == 3){
			return s[0] + " de " + ObtenerMes(s[1]) + " del "+s[2];
		}else{
			return "";
		}
	}
	
	public static String ObtenerMes(String mes){
		 switch(mes){
		  case "01": return "Enero";
		  case "02": return "Febrero";
		  case "03": return "Marzo";
		  case "04": return "Abril";
		  case "05": return "Mayo";
		  case "06": return "Junio";
		  case "07": return "Julio";
		  case "08": return "Agosto";
		  case "09": return "Septiembre";
		  case "10": return "Octubre";
		  case "11": return "Noviembre";
		  default: return "Diciembre";
		 }
	}
	
	public static int DiasTrascurridos(String FechaInicial,String FechaFinal){
	     try{
	    	 SimpleDateFormat adt= new SimpleDateFormat("dd/MM/yyyy");
	    	 Date  fi = adt.parse(FechaInicial),ff = adt.parse(FechaFinal);
	    	 //getTime te esta devolviendo el tiempo en milisegundos 
	    	 return (int) (ff.getTime() - fi.getTime()) / 86400000;
	     }catch(Exception e){
	    	 return 0;
	     }
	}
}
