package clases;

public class Consumo {
	private int codigoSocio;
	private String nombreSocio;
	private String producto;
	private double precio;
	private int cantidad;
	

	public Consumo(int codigoSocio, String nombreSocio, String producto, double precio, int cantidad) {
		this.codigoSocio = codigoSocio;
		this.nombreSocio = nombreSocio;
		this.producto = producto;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public Consumo() {

	}

	public int getCodigoSocio() {
		return codigoSocio;
	}

	public void setCodigoSocio(int codigoSocio) {
		this.codigoSocio = codigoSocio;
	}

	public String getNombreSocio() {
		return nombreSocio;
	}

	public void setNombreSocio(String nombreSocio) {
		this.nombreSocio = nombreSocio;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getTotal() {
		return precio * cantidad;
	}

	

	public double ConsumoTotal() {
		double total = precio * cantidad;
		return total;
	}
}
