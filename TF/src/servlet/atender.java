package servlet;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bjac.Cita;
@SuppressWarnings("serial")
public class atender extends HttpServlet{
	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query qcita = pm.newQuery(Cita.class);
		HttpSession sesion= req.getSession();
		String dniMedico=""+sesion.getAttribute("usuario");
		Date d = new Date();
		String fecha=""+d.getDate()+"/"+(d.getMonth()+1)+"/"+(1900+d.getYear());
		String hora = ""+((d.getHours()>9)?d.getHours():"0"+d.getHours())
				+":"+((d.getMinutes()>30)?"30":"00")+":00";
		try{
			qcita.setFilter("(fecha == '"+fecha+"')&&(hora == '"+hora+"')&&(dniMedico == '"+dniMedico+"')");
			List<Cita> citas = (List<Cita>)qcita.execute();
			if(citas.size()>=1){
				req.setAttribute("dni", citas.get(0).getDniPaciente());
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/atender.jsp");
				rd.forward(req, resp);
			}
		}catch(Exception e){
			System.out.println(e);
		}finally{
			 qcita.closeAll();
		}
		
	}
}