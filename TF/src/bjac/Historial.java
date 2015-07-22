package bjac;

import java.util.*;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
@PersistenceCapable
public class Historial {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	@Persistent
	private List<Cita> citas;
	@Persistent
	private List<Receta> recetas;
	@Persistent
	private List<Examen> examenes;
	@Persistent
	private List<String> alergias;
	@Persistent
	private String tipoSangre;
	
	public Historial(){
		
	}
	

}