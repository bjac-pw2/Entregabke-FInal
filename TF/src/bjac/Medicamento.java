package bjac;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
@PersistenceCapable
public class Medicamento {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	@Persistent
	private float id;
	@Persistent
	private String nombre;
	@Persistent
	private String tipo;
	@Persistent
	private float stock;
	@Persistent
	private boolean estado;
	
	public Medicamento(float id, String nombre, String tipo, float stock) {
		super();
		this.id=id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.stock = stock;
		this.estado=true;
	}
	
	public void aumentarStock(float stock){
		this.stock+=stock;
	}
	
	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getStock() {
		return stock;
	}

	public void setStock(float stock) {
		this.stock = stock;
	}
	

	public float getId() {
		return id;
	}

	public void setId(float id) {
		this.id = id;
	}
	
	public int getEstado(){
		if(estado)
			return 1;
		return 0;
	}
	
	public void setEstado(){
			this.estado=!this.estado;
	}
	
	public String toString() {
		return nombre +"\t"+tipo +"\t"+stock;
	}
}
