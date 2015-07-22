package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.*;

import bjac.*;

@SuppressWarnings("serial")
public class regPaciente extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		try{
			
			String DNI=req.getParameter("dni");
			
			
			PersistenceManager pm1 = PMF.get().getPersistenceManager();
			Query q = pm1.newQuery(Usuario.class);
			@SuppressWarnings("unchecked")
			List<Usuario> usuario = (List<Usuario>) q.execute();
			
			for(Usuario a: usuario){
				if(a.getDNI().equalsIgnoreCase(DNI)){
					resp.sendRedirect("controlJSP?option=2");
					return;
				}
			}
			q.closeAll();
			pm1.close();
			
			if(!comprobarDatos(
					DNI,
					req.getParameter("nombre") , 
					req.getParameter("apellidoPat")+" "+req.getParameter("apellidoMat"), 
					req.getParameter("email"), 
					req.getParameter("telefono"), 
					req.getParameter("genero"), 
					req.getParameter("peso"), 
					req.getParameter("talla"), 
					req.getParameter("tSangre") 
			)){
				resp.sendRedirect("registrar.jsp");
				return;
			}
			
			Paciente pac=new Paciente(
					DNI,
					req.getParameter("nombre") , 
					req.getParameter("apellidoPat")+" "+req.getParameter("apellidoMat"), 
					req.getParameter("email"), 
					req.getParameter("telefono"), 
					req.getParameter("direccion"), 
					req.getParameter("genero"), 
					Double.parseDouble(req.getParameter("peso")), 
					Double.parseDouble(req.getParameter("talla")), 
					req.getParameter("tSangre") 
			);
			
			PersistenceManager pm = PMF.get().getPersistenceManager();
			pm.makePersistent(pac);
			
			String password=req.getParameter("nombre").substring(0, 1).toLowerCase()+req.getParameter("apellidoPat").toLowerCase();
			
			HttpSession sesion= req.getSession();
			String dniAdmin=(String) sesion.getAttribute("usuario");
			
			if(dniAdmin!=null){
				Usuario usu=new Usuario(DNI, password, "Paciente", dniAdmin);
				pm.makePersistent(usu);
				//----------------Envio de correo
				Metodos.enviarCorreo(req.getParameter("nombre") , req.getParameter("dni") , req.getParameter("email") , password);
				//------------------
				resp.sendRedirect("listaPaciente");
			}else{
				Usuario usu=new Usuario(DNI, password, "Paciente", "00000000");
				pm.makePersistent(usu);
				//----------------Envio de correo
				Metodos.enviarCorreo(req.getParameter("nombre") , req.getParameter("dni") , req.getParameter("email") , password);
				//------------------
				resp.sendRedirect("listaPaciente");
			}
			
			
			
		}catch(Exception e){
			resp.getWriter().println("Imposible Guardar");
			resp.getWriter().println(e.getMessage());
		}
	}
	
	protected boolean comprobarDatos(String DNI, String nombre, String apellido, String correo, String telefono, String genero, String peso, String talla, String tipoSangre){
		String pDni="[\\d]{8}";
		String pCorreo="^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,3})$";
		String pTelefono="[0-9]{6}|[0-9]{9}";
		String pPeso="[0-9]{1,3}(\\.)[\\d]{1,3}";
		ArrayList<String>sangres=new ArrayList<String>();
		sangres.add("O+");
		sangres.add("O-");
		sangres.add("A+");
		sangres.add("A-");
		sangres.add("B+");
		sangres.add("B-");
		sangres.add("AB+");
		sangres.add("AB-");

		boolean pGen=(genero.equalsIgnoreCase("Masculino") || genero.equalsIgnoreCase("Femenino"));
		
		return(	DNI.matches(pDni) && 
				correo.matches(pCorreo) && 
				telefono.matches(pTelefono) && 
				pGen && 
				peso.matches(pPeso) &&
				talla.matches(pPeso) &&
				sangres.contains(tipoSangre)
		);
	}
}