package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class cJAsist extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
try {
			
			String option=req.getParameter("option");
			HttpSession sesion= req.getSession();
			String tipo = (String) sesion.getAttribute("tipo");
			
			if(tipo.equalsIgnoreCase("Asistente")){
				
				if(option.equals("1")){
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/indexAsistente.jsp");
					rd.forward(req, resp);
				}
				
				if(option.equals("2")){
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/actDatos.jsp");
					rd.forward(req, resp);
				}
				
			}else{
				req.setAttribute("titulo", "ACCESO DENEGADO");
				req.setAttribute("contenido", "El usuario no cuenta con el permiso necesario.");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/mensaje.jsp");
				rd.forward(req, resp);
			}
			
		}catch (ServletException e) {
			System.out.println(e.getMessage());
		}
	}
}