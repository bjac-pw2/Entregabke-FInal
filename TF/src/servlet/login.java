package servlet;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;;	

@SuppressWarnings("serial")
public class login extends HttpServlet{	

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		HttpSession sesion= req.getSession();
		
		if(sesion.getAttribute("nombre").equals(null)){
			resp.sendRedirect("index.jsp");	
		}else{
			if(sesion.getAttribute("tipo").toString().equals("Medico")){
				resp.sendRedirect("cJMedic?option=1");
			}
			if(sesion.getAttribute("tipo").toString().equals("Paciente")){
				resp.sendRedirect("cJPacient?option=1");
			}
			if(sesion.getAttribute("tipo").toString().equals("Administrador")){
				resp.sendRedirect("cJAdmin?option=1");
			}
			if(sesion.getAttribute("tipo").toString().equals("Farmaceutico")){
				resp.sendRedirect("cJFarma?option=1");
			}
		}
	}	
}