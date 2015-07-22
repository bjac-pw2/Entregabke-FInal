package bjac;

import java.util.List;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Receta {
	@PrimaryKey
	@Persistent
	private String keyCita;
	@Persistent
	private String dniPaciente;
	@Persistent
	private String dniMedico;
	@Persistent
	private List<String> medicamentos;
	public Receta(String keyCita, String dniPaciente, String dniMedico,
			List<String> medicamentos) {
		super();
		this.keyCita = keyCita;
		this.dniPaciente = dniPaciente;
		this.dniMedico = dniMedico;
		this.medicamentos = medicamentos;
	}
	public String getKeyCita() {
		return keyCita;
	}
	public String getDniPaciente() {
		return dniPaciente;
	}
	public String getDniMedico() {
		return dniMedico;
	}
	public List<String> getMedicamentos() {
		return medicamentos;
	}
	@Override
	public String toString() {
		return "Receta [keyCita=" + keyCita + ", dniPaciente=" + dniPaciente
				+ ", dniMedico=" + dniMedico + ", medicamentos=" + medicamentos
				+ "]";
	}
}