package clases;

public class Boleta {
    private int    codigoBoleta;
    private int    codigoIngreso;
    private double pagoTotal;
    
	public Boleta(int codBo,int codIn,double pagTo){
    	this.codigoBoleta  = codBo;
    	this.codigoIngreso = codIn;
    	this.pagoTotal     = pagTo;
    }
	
	public int getCodigoBoleta() {
		return codigoBoleta;
	}

	public void setCodigoBoleta(int codigoBoleta) {
		this.codigoBoleta = codigoBoleta;
	}

	public int getCodigoIngreso() {
		return codigoIngreso;
	}

	public void setCodigoIngreso(int codigoIngreso) {
		this.codigoIngreso = codigoIngreso;
	}

	public double getPagoTotal() {
		return pagoTotal;
	}

	public void setPagoTotal(double pagoTotal) {
		this.pagoTotal = pagoTotal;
	}
    
    
}
