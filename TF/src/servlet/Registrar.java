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

public class Registrar extends HttpServlet {
	@SuppressWarnings("unused")
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		// ...
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);
		MimeBodyPart htmlPart = new MimeBodyPart();
		Multipart mp = new MimeMultipart();
		
		if(!comprobarDatos(
				req.getParameter("dni"),
				req.getParameter("nombre") , 
				req.getParameter("apellidoPat")+" "+req.getParameter("apellidoMat"), 
				req.getParameter("email"), 
				req.getParameter("telefono"), 
				req.getParameter("genero"), 
				req.getParameter("peso"), 
				req.getParameter("talla"), 
				req.getParameter("tSangre") 
		)){
			String contenido="Su datos estan incorrectos, intente nuevamente.<br>"
					+ "Para Registrarse Nuevamente click <a href='registrar.jsp'>Aqui</a>";
			String titulo="Aviso";
			req.setAttribute("contenido", contenido);
			req.setAttribute("titulo", titulo);
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/mensaje.jsp");
			rd.forward(req, resp);
			return;
		}
		
		String datos ="Dni: "+req.getParameter("dni")+
					"<br>Nombre: "+req.getParameter("nombre")+
					"<br>Apellido Paterno: "+req.getParameter("apellidoPat")+
					"<br>Apellido Materno: "+req.getParameter("apellidoMat")+
					"<br>Email: "+req.getParameter("email")+
					"<br>Telefono: "+req.getParameter("telefono")+ 
					"<br>Direccion: "+req.getParameter("direccion")+
					"<br>Genero: "+req.getParameter("genero")+
					"<br>Peso: "+Double.parseDouble(req.getParameter("peso"))+
					"<br>Talla: "+Double.parseDouble(req.getParameter("talla"))+
					"<br>Sangre: "+req.getParameter("tSangre"); 
		
		String css=".entrada{"
				+"	border: 1px solid #099;"
				+"	color: #099;"
				+"	margin: 10px;"
				+"}"
				+".tituloEntrada{"
				+"	height: 25px;"
				+"	background: #099;"
				+"	padding-top: 5px;"
				+"	color: #fff;"
				+"	text-align: center;"
				+"}"
				+".cuerpoEntrada{"
				+"	padding: 5px 20px;"
				+"	color: #666;"
				+"}"
				+"input{"
				+"	border-style: none;"
				+"	border: 1px solid #666;"
				+"	padding: 3px;"
				+"	margin: 3px;"
				+"}"
				+"input:focus{"
				+"	border: 1px solid #099;"
				+"}"
				+"select{"
				+"	color:#666;"
				+"	background-color:#fff;"
				+"	border: 1px solid #666;"
				+"	padding: 3px;"
				+"	margin: 3px;"
				+"}"
				+".enviar{"
				+"	border: none;"
				+"	width: 10em;"
				+"	background-color: #099;" 
				+"}"
				+".enviar:hover{"
				+"	color: #fff;"
				+"}"
				+".lf{"
				+"	display: block;"
				+"}";
		String cuerpo =
				"<div class='entrada'>"
				+"<div class='tituloEntrada'>REGISTRARSE</div>"
				+"<div class='cuerpoEntrada'>"
				+"	<form action='http://bjac-pw2.appspot.com/regPaciente' class='receta' method='post' >"
				+"		<span class='lf'>DNI: </span><input required type='text' value="+req.getParameter("dni")+" name='dni' pattern='[0-9]{8}'><br/>"
				+"		<span class='lf'>Nombre: </span><input required type='text' value='"+req.getParameter("nombre")+"' name='nombre' pattern='[a-zA-Z]+'><br/>"
				+"		<span class='lf'>Apellido Paterno: </span><input required type='text' value='"+req.getParameter("apellidoPat")+"' name='apellidoPat' pattern='[a-zA-Z]+'><br/>"
				+"		<span class='lf'>Apellido Materno: </span><input required type='text' value='"+req.getParameter("apellidoMat")+"' name='apellidoMat' pattern='[a-zA-Z]+'><br/>"
				+"		<span class='lf' >Genero</span><input value="+req.getParameter("genero")+">"
				+"		<span class='lf'>Peso: </span><input required type='text' value='"+Double.parseDouble(req.getParameter("peso"))+"' name='peso' placeholder='kk.gg' pattern='[0-9]{1,3}(\\.)[\\d]{1,3}'><br>"
				+"		<span class='lf'>Talla: </span><input required type='text' value='"+Double.parseDouble(req.getParameter("talla"))+"' name='talla'placeholder='mm.cc' pattern='[0-9]{1,3}(\\.)[\\d]{1,3}'><br>"
				+"		<span class='lf'>Direccion: </span><input  required type='text' value='"+req.getParameter("direccion")+"' name='direccion' placeholder='calle,Av. o Jr./#'><br/>"
				+"		<span class='lf'>Correo electronico: </span><input type='text' value='"+req.getParameter("email")+"' name='email' pattern='^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,3})$' placeholder='ejemplo@ejemplo.com'><br/>"
				+"		<span class='lf'>Telefono: </span><input type='text' value='"+req.getParameter("telefono")+"' name='telefono' pattern='[0-9]{6}|[0-9]{9}'><br/>"
				+"		<span class='lf'>Tipo de sangre</span><input type='text' value='"+req.getParameter("tSangre")+"' name='tSangre' pattern='(A|B|AB|O){1}(\\+|-){1}' placeholder='Use solo mayúsculas'><br>"
				+"		<input class='enviar' type='submit' value='GUARDAR'>"
				+"	</form>"
				+"</div>"
				+"</div>";
		String msgAdministrador = "<!DOCTYPE html><html>"
				+ "<head>"
				+"<style>"+css+"</style>"
				+ "</head>"
				+ "<body>"
				+cuerpo
				+ "</body>"
				+"</html>";

		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("bjac.pw2@gmail.com", "CLINICA ULTIMA ESPERANZA"));
			msg.addRecipient(Message.RecipientType.TO,
					new InternetAddress("bjac.pw2@gmail.com", "Sr. Usuario"));
			msg.setSubject("Solicitud de Registro");
			htmlPart.setContent(msgAdministrador, "text/html");
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
		String contenido="Su Datos Personales ha sido enviando exitosamente a la Clinica Ultima Esperanza,"
				+"</b>Sus datos estan siendo procesados, por favor espera la notificacion que sera"
				+"enviado asu correo, en un plazo de 24 horas<br>"
				+"Gracias por registrarse a la Clinica Ultima Esperanza, esperamos ser de su agrado.<br>"
				+"Envienos sus sugerencias, dudas, problemas, preguntas,etc."
				+"<a href='contactenos.jsp'> aqui</a>";
		String titulo="aviso";
		req.setAttribute("contenido", contenido);
		req.setAttribute("titulo", titulo);
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/mensaje.jsp");
		rd.forward(req, resp);
	}
	
	protected boolean comprobarDatos(String DNI, String nombre, 
			String apellido, String correo, String telefono, 
			String genero, String peso, String talla, String tipoSangre){
		
//		Pattern patNombres=Pattern.compile("([a-zA-ZáéíóúÁÉÍÓÚñÑ]+[\\s]?[a-zA-ZáéíóúÁÉÍÓÚñÑ]*)");
//		Matcher matNombres=patNombres.matcher(nombre);
//		Matcher matApellido=patNombres.matcher(apellido);		

		String pDni="[\\d]{8}";
		String pCorreo="^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,3})$";
		String pTelefono="[0-9]{6}|[0-9]{9}";
		String pPeso="[0-9]{1,3}(\\.)[\\d]{1,3}";
		String pSangre="(A|B|AB|O){1}(\\+|-){1}";
		boolean pGen=(genero.equalsIgnoreCase("Masculino") || genero.equalsIgnoreCase("Femenino"));
		
		
		return(DNI.matches(pDni) && 
				correo.matches(pCorreo) && 
				telefono.matches(pTelefono) && 
				pGen && 
				peso.matches(pPeso) &&
				talla.matches(pPeso) &&
				tipoSangre.matches(pSangre)
				);
	}
	
}