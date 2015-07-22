package servlet;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;

import bjac.*;

@SuppressWarnings("serial")
public class modPassword extends HttpServlet {
	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		try{
			String pActual=req.getParameter("pActual");
			String pNuevo=req.getParameter("pNuevo");
			
			PersistenceManager pm1 = PMF.get().getPersistenceManager();
			
			HttpSession sesion= req.getSession();
			String dni=(String) sesion.getAttribute("usuario");
			Query q = pm1.newQuery(Usuario.class);
			
			q.setFilter("DNI == DNIParam");
			q.declareParameters("String DNIParam");	
			
			List<Usuario> usuario = (List<Usuario>) q.execute(dni);
			
			
			if(usuario.size()==0){
				req.setAttribute("titulo", "Mensaje");
				req.setAttribute("contenido", "Error");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/mensaje.jsp");
				rd.forward(req, resp);
			}else{
				if(usuario.get(0).getPassword().equals(pActual)){
					usuario.get(0).setPassword(pNuevo);
					req.setAttribute("titulo", "Mensaje");
					req.setAttribute("contenido", "Cambio de contraseña exitoso");
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/mensaje.jsp");
					rd.forward(req, resp);
				}else{
					req.setAttribute("titulo", "Mensaje");
					req.setAttribute("contenido", "Contraseña actual es inválida");
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/mensaje.jsp");
					rd.forward(req, resp);
				}
				
			}
			q.closeAll();
			pm1.close();
			
		}catch(Exception e){
			resp.getWriter().println("Imposible Guardar");
			resp.getWriter().println(e.getMessage());
		}
	}
}