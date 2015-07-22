package bjac;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Examen {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	@Persistent
	private String nombre;
	@Persistent
	private Paciente paciente;
	@Persistent
	private String resultado;
	
	public Examen(String nombre, Paciente paciente, String resultado) {
		super();
		this.nombre = nombre;
		this.paciente = paciente;
		this.resultado = resultado;
	}
}
