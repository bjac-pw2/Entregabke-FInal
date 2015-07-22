package bjac;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Cita{
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	@Persistent
	private String id;
	@Persistent
	private String dniMedico;
	
	@Persistent
	private String dniPaciente;
	
	@Persistent
	private String fecha;
	
	@Persistent
	private String hora;
	
	@Persistent
	private String asunto;
	
	@Persistent
	private  boolean atendido;
	

	public Cita(String id,String nombreDoctor,String dniPaciente, String fecha, String hora, String asunto) {
		super();
		this.atendido=false;
		this.id=id;
		this.dniMedico= nombreDoctor;
		this.dniPaciente= dniPaciente;
		this.fecha= fecha;
		this.hora = hora;
		this.asunto = asunto;
	}
	public boolean getAtendido() {
		return atendido;
	}
	public void setAtendido() {
		this.atendido = true;
	}
	public Key getKey(){
		return key;
	}
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id = id;
	}
	public String getDniDoctor(){
		return dniMedico;
	}
	public void setDniDoctor(String nombreDoctor){
		this.dniMedico = nombreDoctor;
	}
	public String getDniPaciente(){
		return dniPaciente;
	}
	public void setDniPaciente(String dniPaciente){
		this.dniPaciente = dniPaciente;
	}
	public String getfecha() {
		return fecha;
	}
	public void setFecha(String fecha){
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	@Override
	public String toString() {
		String resp = dniMedico + " : "+dniPaciente+ " : "+fecha+" : " + hora + " : " + asunto;  
		return resp;
	}
}
