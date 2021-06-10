package clases;

public class Bungalow {
   private int    NumeroBungalow;
   private int    Categoria;
   private double PrecioPorDia;
   private int    Estado;
   
   public Bungalow(int num,int cat,double prec,int est){
	   this.NumeroBungalow = num;
	   this.Categoria      = cat;
	   this.PrecioPorDia   = prec;
	   this.Estado         = est;
   }

   public int getNumeroBungalow() {
	  return this.NumeroBungalow;
   }

   public void setNumeroBungalow(int numeroBungalow) {
	   this.NumeroBungalow = numeroBungalow;
   }

   public int getCategoria() {
	  return this.Categoria;
   }

   public void setCategoria(int categoria) {
	   this.Categoria = categoria;
    }

   public double getPrecioPorDia() {
	  return this.PrecioPorDia;
    }

   public void setPrecioPorDia(double precioPorDia) {
	   this.PrecioPorDia = precioPorDia;
    }

   public int getEstado() {
	   return this.Estado;
    }

   public void setEstado(int estado) {
	   this.Estado = estado;
    }
   
   
   
   
   
   
   
   
   
}
