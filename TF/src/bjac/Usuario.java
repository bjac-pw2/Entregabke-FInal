package bjac;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import servlet.PMF;
@PersistenceCapable
public class Usuario {
	
	@Persistent
	private String DNI;
	@Persistent
	private String password;
	@Persistent
	private String tipo;
	@Persistent
	private boolean hab;
	@Persistent
	private String add;
	
	public Usuario(String dNI, String password, String tipo, String add) {
		super();
		DNI = dNI;
		this.password = password;
		this.tipo = tipo;
		this.hab=true;
		this.add=add;
	}
	
	@SuppressWarnings("unchecked")
	public String getNombreUsuario(){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		if(this.tipo.equals("Paciente")){
			Query q = pm.newQuery(Paciente.class);
			List<Paciente> pacientes = (List<Paciente>) q.execute();

			for(Paciente a: pacientes){
				if(a.getDNI().equals(this.DNI)){
					return a.getNombre()+" "+a.getApellido();
				}
			}
		}

		if(this.tipo.equals("Medico")){
			Query q = pm.newQuery(Medico.class);
			List<Medico> medicos = (List<Medico>) q.execute();

			for(Medico a: medicos){
				if(a.getDni().equals(this.DNI)){
					return a.getNombre()+" "+a.getApellido();
				}
			}
		}
		if(this.tipo.equals("Administrador")){
			Query q = pm.newQuery(Administrador.class);
			List<Administrador> administradores = (List<Administrador>) q.execute();

			for(Administrador a: administradores){
				if(a.getDNI().equals(this.DNI)){
					return a.getNombre()+" "+a.getApellido();
				}
			}
		}
		
		String nFarma="";
		Query q = pm.newQuery(Farmaceutico.class);
		List<Farmaceutico> farmaceutico = (List<Farmaceutico>) q.execute();

		for(Farmaceutico a: farmaceutico){
			if(a.getDni().equals(this.DNI)){
				return a.getNombre()+" "+a.getApellido();
			}
		}
		
		return nFarma;
	}
	
	public String nombreCompleto(){
		return Metodos.nombre(this.DNI);
	}
	
	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}	
	@Override
	public String toString() {
		return "DNI=" + DNI + ", password=" + password + ", tipo="
				+ tipo;
	}
	
	public boolean getHab() {
		return hab;
	}
	
	public String addX(){
		return Metodos.nombre(this.add);
	}

	public void setHab() {
		this.hab = !(this.hab);
	}
	
}