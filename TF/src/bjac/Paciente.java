package bjac;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
@PersistenceCapable
public class Paciente {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	@Persistent
	private String DNI;
	@Persistent
	private String nombre;
	@Persistent
	private String apellido;
	@Persistent
	private String correo;
	@Persistent
	private String telefono;
	@Persistent
	private String direccion;
	@Persistent
	private String genero;
	@Persistent
	private double peso;
	@Persistent
	private double talla;
	@Persistent
	private Historial historial;
	@Persistent
	private String tipoSangre;
	
	
	public Paciente(String DNI, String nombre, String apellido, String correo, String telefono, String direccion, String genero, double peso, double talla, String tipoSangre) {
		super();
		this.DNI = DNI;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.telefono = telefono;
		this.direccion = direccion;
		this.genero=genero;
		this.peso=peso;
		this.talla=talla;
		this.tipoSangre=tipoSangre;
	}

	

	public Key getKey() {
		return key;
	}



	public void setKey(Key key) {
		this.key = key;
	}



	public String getDNI() {
		return DNI;
	}



	public void setDNI(String dNI) {
		DNI = dNI;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public String getCorreo() {
		return correo;
	}



	public void setCorreo(String correo) {
		this.correo = correo;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public String getGenero() {
		return genero;
	}



	public void setGenero(String genero) {
		this.genero = genero;
	}



	public double getPeso() {
		return peso;
	}



	public void setPeso(double peso) {
		this.peso = peso;
	}



	public double getTalla() {
		return talla;
	}



	public void setTalla(double talla) {
		this.talla = talla;
	}



	public Historial getHistorial() {
		return historial;
	}



	public void setHistorial(Historial historial) {
		this.historial = historial;
	}



	public String getTipoSangre() {
		return tipoSangre;
	}



	public void setTipoSangre(String tipoSangre) {
		this.tipoSangre = tipoSangre;
	}

	public String getNombreCompleto() {
		return this.apellido+", "+this.nombre;
	}

	@Override
	public String toString() {
		return DNI + "\t" + nombre + "\t"+ apellido + "\t" + correo + "\t" + telefono+ "\t" + direccion + "\t" + genero+ "\t" + peso+ "\t" + talla;
	}
}