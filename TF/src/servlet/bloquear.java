package servlet;
import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bjac.Usuario;

@SuppressWarnings("serial")
public class bloquear extends HttpServlet{

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		resp.setContentType("text/html");
		String dni=req.getParameter("dni");

		if(dni.length()==8){
			
			PersistenceManager pm = PMF.get().getPersistenceManager();
			Query q = pm.newQuery(Usuario.class);
			q.setFilter("DNI == DNIParam");
			q.declareParameters("String DNIParam");
			List<Usuario> personas = (List<Usuario>) q.execute(dni);
			
			if(personas.size()==1){
				personas.get(0).setHab();
				req.setAttribute("titulo", "Mensaje");
				req.setAttribute("contenido", "El estado del usuario "+personas.get(0).getNombreUsuario()+" ha sido cambiado.");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/mensaje.jsp");
				rd.forward(req, resp);
			}else	
				resp.getWriter().println("DNI no registrado");
			
		}else	
			resp.getWriter().print("DNI inválido");
	}
}