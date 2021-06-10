package clases;

public class Ingreso {
    private int    CodigoIngreso;
    private int    CodigoSocio;
    private String FechaIngreso;
    private String HoraIngreso;
    private int    NumeroInvitados;
    private double CostoIngreso;
    private int    Estado;
    
    public Ingreso(int codIn,int codSoc,String fechIn,String horaIn,int numIn,double cosIn ,
    		      int estado){
    	this.CodigoIngreso   = codIn;
    	this.CodigoSocio     = codSoc;
    	this.FechaIngreso    = fechIn;
    	this.HoraIngreso     = horaIn;
    	this.NumeroInvitados = numIn;
    	this.CostoIngreso    = cosIn;
    	this.Estado          = estado;
    	
    }

	public int getCodigoIngreso() {
		return this.CodigoIngreso;
	}

	public void setCodigoIngreso(int codigoIngreso) {
		this.CodigoIngreso = codigoIngreso;
	}

	public int getCodigoSocio() {
		return this.CodigoSocio;
	}

	public void setCodigoSocio(int codigoSocio) {
		this.CodigoSocio = codigoSocio;
	}

	public String getFechaIngreso() {
		return this.FechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.FechaIngreso = fechaIngreso;
	}

	public String getHoraIngreso() {
		return this.HoraIngreso;
	}

	public void setHoraIngreso(String horaIngreso) {
		this.HoraIngreso = horaIngreso;
	}

	public int getNumeroInvitados() {
		return this.NumeroInvitados;
	}

	public void setNumeroInvitados(int numeroInvitados) {
		this.NumeroInvitados = numeroInvitados;
	}

	public double getCostoIngreso() {
		return this.CostoIngreso;
	}

	public void setCostoIngreso(double costoIngreso) {
		this.CostoIngreso = costoIngreso;
	}

	public int getEstado() {
		return this.Estado;
	}

	public void setEstado(int estado) {
		this.Estado = estado;
	}
    
     
    
}
