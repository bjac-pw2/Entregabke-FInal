package servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import bjac.Cita;
import bjac.Medicamento;
import bjac.Paciente;
@SuppressWarnings("serial")
public class cJMedic extends HttpServlet {
	@SuppressWarnings("deprecation")
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try {
			String option=req.getParameter("option");

			if(option.equals("1")){
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/indexMedico.jsp");
				rd.forward(req, resp);
			}

			if(option.equals("18")){
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/modPassword.jsp");
				rd.forward(req, resp);
			}
			if(option.equals("3")){
				
				PersistenceManager pm = PMF.get().getPersistenceManager();
				Query qcita = pm.newQuery(Cita.class);
				HttpSession sesion= req.getSession();
				String dniMedico=""+sesion.getAttribute("usuario");
				Date d = new Date();
				String fecha=""+d.getDate()+"/"+(d.getMonth()+1)+"/"+(1900+d.getYear());
				String horad = ""+((d.getHours()>9)?d.getHours():"0"+d.getHours())
							+":"+((d.getMinutes()>9)?d.getMinutes():"0"+d.getMinutes());
				String hora = ""+((d.getHours()>9)?d.getHours():"0"+d.getHours())
						+":"+((d.getMinutes()>30)?"30":"00")+":00";
				try{
					qcita.setFilter("(fecha == '"+fecha+"')&&(hora == '"+hora+"')&&(dniMedico == '"+dniMedico+"')");
					@SuppressWarnings("unchecked")
					List<Cita> citas = (List<Cita>)qcita.execute();
					if(citas.size()>=1){
						Query qPaciente = pm.newQuery(Paciente.class);
						qcita.setFilter("(DNI == '"+citas.get(0).getDniPaciente()+"')");
						@SuppressWarnings("unchecked")
						List<Paciente> pacientes = (List<Paciente>)qPaciente.execute();
						Query qMedicamento = pm.newQuery(Medicamento.class);
						@SuppressWarnings("unchecked")
						List<Medicamento> medicamentos = (List<Medicamento>)qMedicamento.execute();
						req.setAttribute("medicamentos", medicamentos);
						req.setAttribute("nombre", pacientes.get(0).getNombre()+" "+pacientes.get(0).getApellido());
						req.setAttribute("peso",  pacientes.get(0).getPeso());
						req.setAttribute("talla", pacientes.get(0).getTalla());
						req.setAttribute("tsangre", pacientes.get(0).getTipoSangre());
						req.setAttribute("genero", pacientes.get(0).getGenero());
						req.setAttribute("dniPaciente",citas.get(0).getDniPaciente());
						req.setAttribute("id",citas.get(0).getKey());
						req.setAttribute("fecha", fecha);
						req.setAttribute("hora", horad);
						RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/receta.jsp");
						rd.forward(req, resp);
					}
				}catch(Exception e){
					System.out.println(e);
				}finally{
					 qcita.closeAll();
				}
			}
			if(option.equals("4")){
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/atender.jsp");
				rd.forward(req, resp);
			}
			if(option.equals("5")){
				PersistenceManager pm = PMF.get().getPersistenceManager();
				Query qcita = pm.newQuery(Cita.class);
				HttpSession sesion= req.getSession();
				String dniMedico=""+sesion.getAttribute("usuario");
				Date d = new Date();
				String fecha=""+d.getDate()+"/"+(d.getMonth()+1)+"/"+(1900+d.getYear());
				String horad = ""+((d.getHours()>9)?d.getHours():"0"+d.getHours())
							+":"+((d.getMinutes()>9)?d.getMinutes():"0"+d.getMinutes());
				String hora = ""+((d.getHours()>9)?d.getHours():"0"+d.getHours())
						+":"+((d.getMinutes()>30)?"30":"00")+":00";
				try{
					qcita.setFilter("(fecha == '"+fecha+"')&&(hora == '"+hora+"')&&(dniMedico == '"+dniMedico+"')");
					@SuppressWarnings("unchecked")
					List<Cita> citas = (List<Cita>)qcita.execute();
					if(citas.size()>=1){
						Query qPaciente = pm.newQuery(Paciente.class);
						qcita.setFilter("(DNI == '"+citas.get(0).getDniPaciente()+"')");
						@SuppressWarnings("unchecked")
						List<Paciente> pacientes = (List<Paciente>)qPaciente.execute();
						Query qMedicamento = pm.newQuery(Medicamento.class);
						@SuppressWarnings("unchecked")
						List<Medicamento> medicamentos = (List<Medicamento>)qMedicamento.execute();
						req.setAttribute("medicamentos", medicamentos);
						req.setAttribute("nombre", pacientes.get(0).getNombre()+" "+pacientes.get(0).getApellido());
						req.setAttribute("peso",  pacientes.get(0).getPeso());
						req.setAttribute("talla", pacientes.get(0).getTalla());
						req.setAttribute("tsangre", pacientes.get(0).getTipoSangre());
						req.setAttribute("genero", pacientes.get(0).getGenero());
						req.setAttribute("dniPaciente",citas.get(0).getDniPaciente());
						req.setAttribute("id",citas.get(0).getKey());
						req.setAttribute("fecha", fecha);
						req.setAttribute("hora", horad);
						RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/examen.jsp");
						rd.forward(req, resp);
					}
				}catch(Exception e){
					System.out.println(e);
				}finally{
					 qcita.closeAll();
				}
			}
		}catch (ServletException e) {
			System.out.println(e.getMessage());
		}
	}
}