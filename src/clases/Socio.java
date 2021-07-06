package clases;

public class Socio {
    private int    codigoSocio;
    private String Nombre;
    private String Apellido;
    private String nombreApellido;
    private String dni;
    private int    Telefono;
    
    public Socio(int cod,String nom,String ape,String dni,int tel){
    	this.codigoSocio = cod;
    	this.Nombre      = nom;
    	this.Apellido    = ape;
    	this.dni         = dni;
    	this.Telefono    = tel;
    	
    }

	

	public int getCodigoSocio() {
		return codigoSocio;
	}



	public void setCodigoSocio(int codigoSocio) {
		this.codigoSocio = codigoSocio;
	}



	public String getNombreApellido() {
		return Nombre+" "+Apellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
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
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getTelefono() {
		return this.Telefono;
	}

	public void setTelefono(int telefono) {
		this.Telefono = telefono;
	}
    
    
   
    
    
}
