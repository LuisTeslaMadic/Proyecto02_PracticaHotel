package clases;

public class Producto {
     private int    CodigoProducto;
     private String Detalle;
     private double PrecioUnitario;
     private int    Stock;
      
    public Producto(int cod,String det,double prec,int stock){
    	  this.CodigoProducto = cod;
    	  this.Detalle        = det;
    	  this.PrecioUnitario = prec;
    	  this.Stock          = stock;
    }

	public int getCodigoProducto() {
		return this.CodigoProducto;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.CodigoProducto = codigoProducto;
	}

	public String getDetalle() {
		return this.Detalle;
	}

	public void setDetalle(String detalle) {
		this.Detalle = detalle;
	}

	public double getPrecioUnitario() {
		return this.PrecioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.PrecioUnitario = precioUnitario;
	}

	public int getStock() {
		return this.Stock;
	}

	public void setStock(int stock) {
		this.Stock = stock;
	}
      
      
      
}
