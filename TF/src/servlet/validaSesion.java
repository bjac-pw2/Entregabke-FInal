package servlet;
import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bjac.Usuario;
import bjac.Administrador;

@SuppressWarnings("serial")
public class validaSesion extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String usuario= req.getParameter("usuario");
		String password = req.getParameter("password");
		PersistenceManager pm1 = PMF.get().getPersistenceManager();
		Query q = pm1.newQuery(Usuario.class);
		@SuppressWarnings("unchecked")
		List<Usuario> usuarios = (List<Usuario>) q.execute();
		if(usuarios.size()==0){
			PersistenceManager pm2 = PMF.get().getPersistenceManager();
			Usuario u = new Usuario("00000000","root","Administrador","");
			Administrador a = new Administrador("00000000", "BJAC", "pw2", "", "bjac.pw2@gmail.com", "", "episunsa");
			try{
				pm2.makePersistent(a);
				pm1.makePersistent(u);
			}catch(Exception e){
				System.out.println(e);
				resp.getWriter().println("Ocurrió un error, <a href='index.jsp'>vuelva a intentarlo</a>");
			}
		}
		try{
			for(Usuario a: usuarios){
				if(a.getDNI().equals(usuario) && a.getPassword().equals(password)){
					if(a.getHab()){
						if(a.getTipo().equals("Paciente")){
							HttpSession sesion= req.getSession(true);
							sesion.setAttribute("usuario",a.getDNI());
							sesion.setAttribute("nombre", a.getNombreUsuario());
							sesion.setAttribute("tipo", "Paciente");
							resp.sendRedirect("controlJSP?option=1");
							return;
						}
						if(a.getTipo().equals("Medico")){
							HttpSession sesion= req.getSession(true);
							sesion.setAttribute("usuario",a.getDNI());
							sesion.setAttribute("nombre", a.getNombreUsuario());
							sesion.setAttribute("tipo", "Medico");
							resp.sendRedirect("controlJSP?option=6");
							return;
						}
						if(a.getTipo().equals("Administrador")){
							HttpSession sesion= req.getSession(true);
							sesion.setAttribute("usuario",a.getDNI());
							sesion.setAttribute("nombre", a.getNombreUsuario());
							sesion.setAttribute("tipo", "Administrador");
							resp.sendRedirect("controlJSP?option=7");
							return;
						}
						
						if(a.getTipo().equals("Farmaceutico")){
							HttpSession sesion= req.getSession(true);
							sesion.setAttribute("usuario",a.getDNI());
							sesion.setAttribute("nombre", a.getNombreUsuario());
							sesion.setAttribute("tipo", "Farmaceutico");
							resp.sendRedirect("controlJSP?option=22");
							return;
						}
					}else{
						req.setAttribute("titulo", "Error de acceso");
						req.setAttribute("contenido", "Este usuario se encuentra deshabilitado para ingresar al sistema.<br>"
													+ "Para volver a utilizar nuestros servicios envienos su DNI desde <a href='contactenos.jsp'>aquí</a>.");
						RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/mensaje.jsp");
						rd.forward(req, resp);
					}
				}
			}
			req.setAttribute("titulo", "Datos incorrectos");
			req.setAttribute("contenido", "Los datos ingresados no se encuentran en nuestra base de datos.");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/mensaje.jsp");
			rd.forward(req, resp);
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		q.closeAll();
	}	
}