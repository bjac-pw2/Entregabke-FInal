package servlet;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;

import bjac.Asistente;
import bjac.Metodos;
import bjac.Usuario;

@SuppressWarnings("serial")
public class registroAsistente extends HttpServlet {
	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		try{

			String dni=req.getParameter("dni");
			PersistenceManager pm1 = PMF.get().getPersistenceManager();
			Query q = pm1.newQuery(Usuario.class);
			q.setFilter("DNI == DNIParam");
			q.declareParameters("String DNIParam");
			List<Usuario> usuario = (List<Usuario>) q.execute(dni);
			
			if(usuario.size()!=0){
				req.setAttribute("titulo", "Mensaje");
				req.setAttribute("contenido", "Ya se encuentra un usuario registrado con este DNI");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/mensaje.jsp");
				rd.forward(req, resp);
			}else{
				Asistente asis= new Asistente(dni, 
						req.getParameter("nombre"),
						req.getParameter("apellidoPat")+" "+req.getParameter("apellidoMat"),
						req.getParameter("genero"),
						req.getParameter("email"),
						req.getParameter("direccion"),
						req.getParameter("telefono")
						);
				PersistenceManager pm = PMF.get().getPersistenceManager();
				pm.makePersistent(asis);
				String password=req.getParameter("nombre").substring(0, 1).toLowerCase()+req.getParameter("apellidoPat").toLowerCase();
				
				HttpSession sesion= req.getSession();
				String dniAdmin=(String) sesion.getAttribute("usuario");
				
				Usuario usu=new Usuario(dni, password, "Asistente", dniAdmin);
				pm.makePersistent(usu);
				pm1.close();
				q.closeAll();
				//----------------Envio de correo
				Metodos.enviarCorreo(req.getParameter("nombre") , req.getParameter("dni") , req.getParameter("email") , password);
				//------------------
				resp.sendRedirect("listaAsistente");
				return;
			}	
		}catch(Exception e){
			resp.getWriter().println("Imposible Guardar");
			resp.getWriter().println(e.getMessage());
		}
	}
}