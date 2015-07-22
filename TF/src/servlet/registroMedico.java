package servlet;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.*;

import bjac.Medico;
import bjac.Metodos;
import bjac.Usuario;

@SuppressWarnings("serial")
public class registroMedico extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		try{
			
			String DNI=req.getParameter("dni");
			PersistenceManager pm1 = PMF.get().getPersistenceManager();
			Query q = pm1.newQuery(Usuario.class);
			@SuppressWarnings("unchecked")
			List<Usuario> usuario = (List<Usuario>) q.execute();
			
			for(Usuario a: usuario){
				if(a.getDNI().equalsIgnoreCase(DNI)){
					resp.sendRedirect("controlJSP?option=4");
					return;
				}
			}
			q.closeAll();
			
			
			Medico med= new Medico(DNI, req.getParameter("nombre"), req.getParameter("apellidoPat")+" "+req.getParameter("apellidoMat"), 
					req.getParameter("genero"), req.getParameter("email"), req.getParameter("especialidad"), 
					req.getParameter("telefono"), req.getParameter("direccion"));
			PersistenceManager pm = PMF.get().getPersistenceManager();
			pm.makePersistent(med);
			
			String password=req.getParameter("nombre").substring(0, 1).toLowerCase()+req.getParameter("apellidoPat").toLowerCase();
			
			HttpSession sesion= req.getSession();
			String dniAdmin=(String) sesion.getAttribute("usuario");
			
			Usuario usu=new Usuario(DNI, password, "Medico", dniAdmin);
			pm.makePersistent(usu);
			//----------------Envio de correo
			Metodos.enviarCorreo(req.getParameter("nombre") , req.getParameter("dni") , req.getParameter("email") , password);
			//------------------
			resp.sendRedirect("listaMedico");
			
			
		}catch(Exception e){
			resp.getWriter().println("Imposible Guardar");
			resp.getWriter().println(e.getMessage());
		}
	}
}