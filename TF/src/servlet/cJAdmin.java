package servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class cJAdmin extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try {
			
			String option=req.getParameter("option");
			
			if(option.equals("1")){
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/indexAdministrador.jsp");
				rd.forward(req, resp);
			}
			if(option.equals("2")){
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/paciente.jsp");
				rd.forward(req, resp);
			}
			
			if(option.equals("3")){
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/listarPaciente.jsp");
				rd.forward(req, resp);
			}
			
			if(option.equals("4")){
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/medico.jsp");
				rd.forward(req, resp);
			}
			if(option.equals("5")){
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/listarMedico.jsp");
				rd.forward(req, resp);
			}
			
			if(option.equals("6")){
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/listarFarmaceutico.jsp");
				rd.forward(req, resp);
			}
			
			if(option.equals("7")){
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/farmaceutico.jsp");
				rd.forward(req, resp);
			}
			
			if(option.equals("8")){
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/administrador.jsp");
				rd.forward(req, resp);
			}
			
			if(option.equals("9")){
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/listarAdministrador.jsp");
				rd.forward(req, resp);
			}
			
			if(option.equals("10")){
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/listarAsistente.jsp");
				rd.forward(req, resp);
			}
			
			if(option.equals("11")){
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/asistente.jsp");
				rd.forward(req, resp);
			}
			
			if(option.equals("12")){
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/listarUsuario.jsp");
				rd.forward(req, resp);
			}
			
			if(option.equals("18")){
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/modPassword.jsp");
				rd.forward(req, resp);
			}
			
			if(option.equals("19")){
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/bloquearUsuario.jsp");
				rd.forward(req, resp);
			}
			if(option.equals("20")){
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/eliminar.jsp");
				rd.forward(req, resp);
			}
			
		}catch (ServletException e) {
			System.out.println(e.getMessage());
		}
	}
}