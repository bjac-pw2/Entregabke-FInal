package servlet;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@SuppressWarnings("serial")
public class cerrarSesion extends HttpServlet{	

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession misesion= req.getSession();
		misesion.invalidate();
		resp.sendRedirect("contactenos.jsp");
	}	
}