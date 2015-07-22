package servlet;
import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bjac.*;
@SuppressWarnings("serial")
public class Eleminar extends HttpServlet{
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String nombre = req.getParameter("dni");
		String contraseña = req.getParameter("password");
		String tipo = ""+req.getParameter("tipo");

		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q2 = pm.newQuery(Usuario.class);
		Query q;
		int cont=0;
		if(tipo.equals("Paciente")){
			q = pm.newQuery(Paciente.class);
		}else if(tipo.equals("Medico")){
			q = pm.newQuery(Medico.class);
		}else if(tipo.equals("Administrador")){
			q = pm.newQuery(Administrador.class);
		}else if(tipo.equals("Farmaceutico")){
			q = pm.newQuery(Farmaceutico.class);
		}else{
			cont=1;
			q = null;
		}
		if(cont==0){
			q.setFilter("DNI == DNIParam");
			q.declareParameters("String DNIParam");
			q2.setFilter("DNI == DNIParam");
			q2.declareParameters("String DNIParam");
			try{
				if(contraseña.equals("rootbjac")){
					if(tipo.equals("Paciente")){
						q.setFilter("DNI == DNIParam");
						q.declareParameters("String DNIParam");
						List<Paciente> personas = (List<Paciente>)q.execute(nombre);
						for(Paciente p: personas){
							pm.deletePersistent(p);
						}
					}else if(tipo.equals("Medico")){
						q.setFilter("dni == DNIParam");
						q.declareParameters("String DNIParam");
						List<Medico> personas = (List<Medico>)q.execute(nombre);
						for(Medico p: personas){
							pm.deletePersistent(p);
						}
					}else if(tipo.equals("Administrador")){
						q.setFilter("dni == DNIParam");
						q.declareParameters("String DNIParam");
						List<Administrador> personas = (List<Administrador>)q.execute(nombre);
						for(Administrador p: personas){
							pm.deletePersistent(p);
						}
					}else if(tipo.equals("Farmaceutico")){
						q.setFilter("dni == DNIParam");
						q.declareParameters("String DNIParam");
						List<Farmaceutico> personas = (List<Farmaceutico>)q.execute(nombre);
						for(Farmaceutico p: personas){
							pm.deletePersistent(p);
						}
					}
					List<Usuario> personas2 = (List<Usuario>)q2.execute(nombre);
					for(Usuario p: personas2){
						pm.deletePersistent(p);
					}
					
					if(tipo.equals("Paciente")){
						resp.sendRedirect("listaPaciente");
						return;
					}if(tipo.equals("Medico")){
						resp.sendRedirect("listaMedico");
						return;
					}if(tipo.equals("Administrador")){
						resp.sendRedirect("listaAdministrador");
						return;
					}if(tipo.equals("Farmaceutico")){
						resp.sendRedirect("listaFarmaceutico");
						return;
					}
				
				}else{
					resp.getWriter().print("No estas autorizado para esta operacion");
				}
				
			}catch(Exception e){
				resp.getWriter().print("error de copilacion"
						+ "\n"+e.getMessage());
			}finally{
				q.closeAll();
			}
		}
	}
}
