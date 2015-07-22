package servlet;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.*;

import bjac.Medicamento;


@SuppressWarnings("serial")
public class registroMedicamento extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try{
			
			String nombre=req.getParameter("nombre");
			String tipo=req.getParameter("tipo");
			
			PersistenceManager pm1 = PMF.get().getPersistenceManager();
			Query q = pm1.newQuery(Medicamento.class);
			@SuppressWarnings("unchecked")
			List<Medicamento> medicamentos = (List<Medicamento>) q.execute();
			
			for(Medicamento a: medicamentos){
				if(a.getTipo().equalsIgnoreCase(tipo)){
					if(a.getNombre().equalsIgnoreCase(nombre)){
						resp.sendRedirect("controlJSP?option=14");
						return;
					}
				}
			}
			q.closeAll();
			pm1.close();
			
			float id=medicamentos.size()+1;
			
			Medicamento med=new Medicamento(id, req.getParameter("nombre"), req.getParameter("tipo"), Float.parseFloat(req.getParameter("stock")));
			PersistenceManager pm = PMF.get().getPersistenceManager();
			pm.makePersistent(med);
			resp.sendRedirect("listaMedicamento");
		}catch(Exception e){
			resp.getWriter().println("Imposible Guardar");
			resp.getWriter().println(e.getMessage());
		}
	}
}