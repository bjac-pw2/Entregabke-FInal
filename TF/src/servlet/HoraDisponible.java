package servlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class HoraDisponible extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String fecha = req.getParameter("fecha");
		List<String> h = new ArrayList<String>();
		int mh=0;
		String hh="";
		int i=8;
		while(i<20){
			if(mh==0){
				hh = (i>9)?i+":00:00":"0"+i+":00:00";
				mh=1;
			}else{
				hh = (i>9)?i+":30:00":"0"+i+":30:00";
				mh=0;
				i++;
			}
			h.add(hh);
		}
		req.setAttribute("fecha", fecha);
		req.setAttribute("horasDisponibles", h);
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/horasDisponibles.jsp");
		rd.forward(req, resp);		
	}
}