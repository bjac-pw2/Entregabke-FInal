package servlet;
import java.util.Properties;
import java.io.IOException;

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
@SuppressWarnings("serial")

public class EnviarComentario extends HttpServlet {
	public void doGet(HttpServletRequest req,
			HttpServletResponse resp) throws IOException, ServletException {
		// ...
		String email = req.getParameter("email");
		String contenido = req.getParameter("contenido");
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);
		MimeBodyPart htmlPart = new MimeBodyPart();
		Multipart mp = new MimeMultipart();
		String msgBody = "<div style='min-height:150px;background:#white;color:#666;'>"
				+ "<div style='min-height:40px;background:#099;color:#fff;padding:0px 10px'>"
				+ "<h1>Ultima Esperanza</h1></div><div style='padding:0px 10px;min-height:110px;'>"
				+ contenido+"<br>atte:"+email+"</div>"
				+ "</div>";
		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("bjac.pw2@gmail.com", "Usuarios"));
			msg.addRecipient(Message.RecipientType.TO,
					new InternetAddress("bjac.pw2@gmail.com", "Sr. Usuario"));
			msg.setSubject("Sugerencias");
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
		String cont="Su comentario a sido enviado corretamente, gracias por su opinion.";
		String titulo="Aviso";
		req.setAttribute("contenido", cont);
		req.setAttribute("titulo", titulo);
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/mensaje.jsp");
		rd.forward(req, resp);
	}
}