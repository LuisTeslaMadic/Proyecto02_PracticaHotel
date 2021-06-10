package clases;

public class Socio {
    private int    CodigoSocio;
    private String Nombre;
    private String Apellido;
    private String Dni;
    private int    Telefono;
    
    public Socio(int cod,String nom,String ape,String dni,int tel){
    	this.CodigoSocio = cod;
    	this.Nombre      = nom;
    	this.Apellido    = ape;
    	this.Dni         = dni;
    	this.Telefono    = tel;
    }

	public int getCodigoSocio() {
		return this.CodigoSocio;
	}

	public void setCodigoSocio(int codigoSocio) {
		this.CodigoSocio = codigoSocio;
	}

	public String getNombre() {
		return this.Nombre;
	}

	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}

	public String getApellido() {
		return this.Apellido;
	}

	public void setApellido(String apellido) {
		this.Apellido = apellido;
	}

	public String getDni() {
		return this.Dni;
	}

	public void setDni(String dni) {
		this.Dni = dni;
	}

	public int getTelefono() {
		return this.Telefono;
	}

	public void setTelefono(int telefono) {
		this.Telefono = telefono;
	}
    
    
   
    
    
}
