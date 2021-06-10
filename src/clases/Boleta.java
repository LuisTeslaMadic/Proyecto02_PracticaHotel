package clases;

public class Boleta {
    private int    CodigoBoleta;
    private int    CodigoIngreso;
    private double PagoTotal;
    
    public Boleta(int codBo,int codIn,double pagTo){
    	this.CodigoBoleta  = codBo;
    	this.CodigoIngreso = codIn;
    	this.PagoTotal     = pagTo;
    }
    
	public int getCodigoBoleta() {
		return CodigoBoleta;
	}

	public void setCodigoBoleta(int codigoBoleta) {
		CodigoBoleta = codigoBoleta;
	}

	public int getCodigoIngreso() {
		return CodigoIngreso;
	}

	public void setCodigoIngreso(int codigoIngreso) {
		CodigoIngreso = codigoIngreso;
	}

	public double getPagoTotal() {
		return PagoTotal;
	}

	public void setPagoTotal(double pagoTotal) {
		PagoTotal = pagoTotal;
	}
    
     
    
    
    
    
    
}
