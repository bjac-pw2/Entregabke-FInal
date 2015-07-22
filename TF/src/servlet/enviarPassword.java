package servlet;
import java.util.List;
import java.util.Properties;
import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.mail.Multipart;

import bjac.Medico;
import bjac.Paciente;
import bjac.Usuario;
import bjac.Administrador;
import bjac.Farmaceutico;;
@SuppressWarnings("serial")
public class enviarPassword extends HttpServlet {
	public void doGet(HttpServletRequest req,
			HttpServletResponse resp) throws IOException, ServletException {
		// ...
		String DNI = req.getParameter("dni");
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Usuario.class);
		
		int temp=0;
		String contenido = "";
		String correo="";
		
		try{
			q.setFilter("DNI == '"+DNI+"'");
			@SuppressWarnings("unchecked")
			List<Usuario> u = (List<Usuario>)q.execute();
			if(u.size()>=0){
				if(u.get(0).getTipo().equals("Paciente")){
					Query q2 = pm.newQuery(Paciente.class);
					q2.setFilter("DNI == '"+DNI+"'");
					@SuppressWarnings("unchecked")
					List<Paciente> u2 = (List<Paciente>)q2.execute();
					correo = u2.get(0).getCorreo();
				}
				if(u.get(0).getTipo().equals("Medico")){
					Query q2 = pm.newQuery(Medico.class);
					q2.setFilter("dni == '"+DNI+"'");
					@SuppressWarnings("unchecked")
					List<Medico>u2 = (List<Medico>)q2.execute();
					correo = u2.get(0).getEmail();
				}
				if(u.get(0).getTipo().equals("Administrador")){
					Query q2 = pm.newQuery(Administrador.class);
					q2.setFilter("dni == '"+DNI+"'");
					@SuppressWarnings("unchecked")
					List<Administrador> u2 = (List<Administrador>)q2.execute();
					correo = u2.get(0).getEmail();
				}
				if(u.get(0).getTipo().equals("Farmaceutico")){
					Query q2 = pm.newQuery(Farmaceutico.class);
					q2.setFilter("dni == '"+DNI+"'");
					@SuppressWarnings("unchecked")
					List<Farmaceutico> u2 = (List<Farmaceutico>)q2.execute();
					correo = u2.get(0).getEmail();
				}
				temp=1;
				contenido="Su contraseña es: <b>"+u.get(0).getPassword()+"</b><br>Puede ingresar desde <a href='http://goo.gl/Xh2YkU'>aqui</a>";
				
			}
		}catch(Exception e){
			
		}finally{
			 q.closeAll();
		}
		if(temp==1){
			Properties props = new Properties();
			Session session = Session.getDefaultInstance(props, null);
			MimeBodyPart htmlPart = new MimeBodyPart();
			Multipart mp = new MimeMultipart();
			String msgBody = "<div style='min-height:150px;background:#white;color:#666;'>"
					+ "<div style='min-height:40px;background:#099;color:#fff;padding:0px 10px'>"
					+ "<h1>Clinica Ultima Esperanza</h1></div><div style='padding:0px 10px;min-height:110px;'>"
					+ contenido+"</div>"
					+ "</div>";
			try {
				Message msg = new MimeMessage(session);
				msg.setFrom(new InternetAddress("bjac.pw2@gmail.com", "Ultimo Esperanza"));
				msg.addRecipient(Message.RecipientType.TO,
						new InternetAddress(correo, "Sr. Usuario"));
				msg.setSubject("Reenvio de password");
				htmlPart.setContent(msgBody, "text/html");
				mp.addBodyPart(htmlPart);
				msg.setContent(mp);
				Transport.send(msg);
			} catch (AddressException e) {
				// ...
				resp.getWriter().println("error");
			} catch (MessagingException e) {
				// ...
				resp.getWriter().println("error");
			}
			String cont="Su contraseña ha sido enviado correctamente a su correo, Estamos a su servicio.";
			String titulo="Aviso";
			req.setAttribute("contenido", cont);
			req.setAttribute("titulo", titulo);
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/mensaje.jsp");
			rd.forward(req, resp);
			
		}else{
			String cont="Usuario no existente, intente nuevamente";
			String titulo="Aviso";
			req.setAttribute("contenido", cont);
			req.setAttribute("titulo", titulo);
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/mensaje.jsp");
			rd.forward(req, resp);
		}
		resp.sendRedirect("/index.jsp");
	}
}