package clases;

public class Hospedaje {
    private int    CodigoHospedaje;
    private int    CodigoIngreso;
    private int    NumeroBungalow;
    private String FechaSalida;
    private String HoraSalida;
    private double CostoHospedaje;
    private int    Estado;
    
    public Hospedaje(int codHos,int codIn,int numBun,String fechSa,String HorSa,double CosHos,int Estado){
    	this.CodigoHospedaje = codHos;
    	this.CodigoIngreso   = codIn;
    	this.NumeroBungalow  = numBun;
    	this.FechaSalida     = fechSa;
    	this.HoraSalida      = HorSa;
    	this.CostoHospedaje  = CosHos;
    	this.Estado          = Estado;
    }

	public int getCodigoHospedaje() {
		return CodigoHospedaje;
	}

	public void setCodigoHospedaje(int codigoHospedaje) {
		CodigoHospedaje = codigoHospedaje;
	}

	public int getCodigoIngreso() {
		return CodigoIngreso;
	}

	public void setCodigoIngreso(int codigoIngreso) {
		CodigoIngreso = codigoIngreso;
	}

	public int getNumeroBungalow() {
		return NumeroBungalow;
	}

	public void setNumeroBungalow(int numeroBungalow) {
		NumeroBungalow = numeroBungalow;
	}

	public String getFechaSalida() {
		return FechaSalida;
	}

	public void setFechaSalida(String fechaSalida) {
		FechaSalida = fechaSalida;
	}

	public String getHoraSalida() {
		return HoraSalida;
	}

	public void setHoraSalida(String horaSalida) {
		HoraSalida = horaSalida;
	}

	public double getCostoHospedaje() {
		return CostoHospedaje;
	}

	public void setCostoHospedaje(double costoHospedaje) {
		CostoHospedaje = costoHospedaje;
	}

	public int getEstado() {
		return Estado;
	}

	public void setEstado(int estado) {
		Estado = estado;
	}
    
}
