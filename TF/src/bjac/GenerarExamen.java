package bjac;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
@PersistenceCapable
public class GenerarExamen {
	@PrimaryKey
	@Persistent
	String keyCita;
	@Persistent
	private String dniPaciente;
	@Persistent
	private String dniMedico;
	@Persistent
	private String dniMedicoExamen;
	@Persistent
	private String descripcion;
	@Persistent
	private String fecha;
	@Persistent
	private String hora;
	
	/**
	 * @return the keyCita
	 */
	public String getKeyCita() {
		return keyCita;
	}

	/**
	 * @return the dniPaciente
	 */
	public String getDniPaciente() {
		return dniPaciente;
	}

	/**
	 * @return the dniMedico
	 */
	public String getDniMedico() {
		return dniMedico;
	}

	/**
	 * @return the dniMedicoExamen
	 */
	public String getDniMedicoExamen() {
		return dniMedicoExamen;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * @return the hora
	 */
	public String getHora() {
		return hora;
	}

	public GenerarExamen(String keyCita, String dniPaciente, String dniMedico,
			String dniMedicoExamen, String descripcion, String fecha,
			String hora) {
		this.keyCita = keyCita;
		this.dniPaciente = dniPaciente;
		this.dniMedico = dniMedico;
		this.dniMedicoExamen = dniMedicoExamen;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.hora = hora;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GenerarExamen [keyCita=" + keyCita + ", dniPaciente="
				+ dniPaciente + ", dniMedico=" + dniMedico
				+ ", dniMedicoExamen=" + dniMedicoExamen + ", descripcion="
				+ descripcion + ", fecha=" + fecha + ", hora=" + hora + "]";
	}
	
	
}
