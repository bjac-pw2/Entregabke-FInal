package servlet;

import java.io.IOException;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bjac.Usuario;

@SuppressWarnings("serial")
public class bloquearUsuario extends HttpServlet{
	
	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		resp.setContentType("text/html");
		String dni=req.getParameter("dni");
		if(dni.length()!=0){
			
			PersistenceManager pm = PMF.get().getPersistenceManager();
			Query q = pm.newQuery(Usuario.class);
			q.setFilter("DNI == DNIParam");
			q.declareParameters("String DNIParam");
			List<Usuario> personas = (List<Usuario>) q.execute(dni);
			
			if(personas.size()!=0){
				String tipo=personas.get(0).getTipo();
				resp.getWriter().print("<h2>Cambiará el estado de</h2></br>"
										+ "<h2>"+personas.get(0).getNombreUsuario()+"</h2></br>"
										+ "<h3>Del tipo : "+tipo+"</br>"
										+ "Estado actual: "+((personas.get(0).getHab())?"Habilitado":"Desabilitado")+"</h3>"
										+ ""
										+ "<input type='submit' value='Confirmar'>");
				
			}else{
				resp.getWriter().print("<h2>DNI no registrado</h2>");
			}
		}else{
			resp.getWriter().print("<h2>DNI invalido</h2>");
		}
	}
}