package servlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;

import bjac.Receta;
@SuppressWarnings("serial")
public class guardarReceta  extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String id = req.getParameter("id");
		String dniMedico = req.getParameter("dnip");
		String dniPaciente = req.getParameter("dnim");
		String [] dia =req.getParameterValues("dia");
		String [] can = req.getParameterValues("can");
		String [] med = req.getParameterValues("med");
		String [] dos = req.getParameterValues("dos");
		List<String> meds = new ArrayList<String>();
		for (int i = 0; i < dos.length; i++) {
			meds.add(dia[i]+" : "+med[i]+" : "+can[i]+" : "+dos[i]);
		}
		Receta r = new Receta(id,dniMedico,dniPaciente,meds);
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			pm.makePersistent(r);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/indexPaciente.jsp");
			rd.forward(req, resp);
		}catch(Exception e){
			System.out.println(e);
			resp.getWriter().println("Ocurrió un error, <a href='index.jsp'>vuelva a intentarlo</a>");
		}finally{
			pm.close();
		}
	}
}