package clases;

public class Consumo{
	 private int    CodigoSocio;
     private String NombreSocio;
     private String Producto;
     private double Precio;
     private int    Cantidad;
     
     public Consumo(int CodigoSocio,String NombreSocio,String Producto,double Precio, int Cantidad){
    	 this.CodigoSocio   = CodigoSocio;
    	 this.NombreSocio   = NombreSocio;
    	 this.Producto      = Producto;
    	 this.Precio        = Precio;
    	 this.Cantidad      = Cantidad;
     }
     
 	public int getCodigoSocio() {
 		return CodigoSocio;
 	}

 	public void setCodigoSocio(int codigoSocio) {
 		CodigoSocio = codigoSocio;
 	}

 	public String getNombreSocio() {
 		return NombreSocio;
 	}

 	public void setNombreSocio(String nombreSocio) {
 		NombreSocio = nombreSocio;
 	}

 	public String getProducto() {
 		return Producto;
 	}

 	public void setProducto(String producto) {
 		Producto = producto;
 	}

 	public double getPrecio() {
 		return Precio;
 	}

 	public void setPrecio(double precio) {
 		Precio = precio;
 	}

 	public int getCantidad() {
 		return Cantidad;
 	}

 	public void setCantidad(int cantidad) {
 		Cantidad = cantidad;
 	}

     public double ConsumoTotal(){
    	 double total = Precio * Cantidad;
    	 return total;
     }
}
