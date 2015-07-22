package bjac;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Properties;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import servlet.PMF;

public class Metodos {
	public static void enviarCorreo(String nombre, String dni, String correo, String password) throws UnsupportedEncodingException{
		String contenido = "Hola, "+nombre+
				"<br> Su registro a sido exitoso, puede ingresar con los siguientes datos: <br> &nbsp;&nbsp;&nbsp;&nbsp; Usuario: "+dni+
				"<br>"+"&nbsp;&nbsp;&nbsp;&nbsp; Contraseña:"+password+"<br>Gracias por confiar en nosotros, puede ingresar desde <a href='bjac-pw2.appspot.com'>aqui</a>";
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);
		MimeBodyPart htmlPart = new MimeBodyPart();
		Multipart mp = new MimeMultipart();
		String msgBody = "<div style='min-height:150px;background:#white;color:#666;'>"
				+ "<div style='min-height:40px;background:#099;color:#fff;padding:0px 10px'>"
				+ "<h1>Ultima Esperanza</h1></div><div style='padding:0px 10px;min-height:110px;'>"
				+ contenido+"</div>"
				+ "</div>";
		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("bjac.pw2@gmail.com", "Ultimo Esperanza"));
			msg.addRecipient(Message.RecipientType.TO,
					new InternetAddress(correo, "Sr. Usuario"));
			msg.setSubject("Codigo de confirmacion");
			htmlPart.setContent(msgBody, "text/html");
			mp.addBodyPart(htmlPart);
			msg.setContent(mp);
			Transport.send(msg);
		} catch (AddressException e) {
			// ...
		} catch (MessagingException e) {
			// ...
		}
	}

	@SuppressWarnings("unchecked")
	public static String nombre(String dni){
		String nombre="";
		PersistenceManager pm1 = PMF.get().getPersistenceManager();
		Query r = pm1.newQuery(Usuario.class);
		r.setFilter("DNI == DNIParam");
		r.declareParameters("String DNIParam");	
		List<Usuario> usuarios= (List<Usuario>) r.execute(dni);
		if(usuarios.size()!=0){
			
			String tipo=usuarios.get(0).getTipo();
			if(tipo.equalsIgnoreCase("paciente")){
				Query t = pm1.newQuery(Paciente.class);
				t.setFilter("DNI == DNIParam");
				t.declareParameters("String DNIParam");
				List<Paciente> pac= (List<Paciente>) t.execute(dni);
				return pac.get(0).getNombreCompleto();
			}
			
			if(tipo.equalsIgnoreCase("Medico")){
				Query t = pm1.newQuery(Medico.class);
				t.setFilter("dni == DNIParam");
				t.declareParameters("String DNIParam");
				List<Medico> med= (List<Medico>) t.execute(dni);
				return med.get(0).getNombreCompleto();
			}
		
			if(tipo.equalsIgnoreCase("farmaceutico")){
				Query t = pm1.newQuery(Farmaceutico.class);
				t.setFilter("dni == DNIParam");
				t.declareParameters("String DNIParam");
				List<Farmaceutico> farma= (List<Farmaceutico>) t.execute(dni);
				return farma.get(0).getNombreCompleto();
			}
			
			if(tipo.equalsIgnoreCase("asistente")){
				Query t = pm1.newQuery(Asistente.class);
				t.setFilter("dni == DNIParam");
				t.declareParameters("String DNIParam");
				List<Asistente> asis= (List<Asistente>) t.execute(dni);
				return asis.get(0).getNombreCompleto();
			}
			
			if(tipo.equalsIgnoreCase("administrador")){
				Query t = pm1.newQuery(Administrador.class);
				t.setFilter("dni == DNIParam");
				t.declareParameters("String DNIParam");
				List<Administrador> med= (List<Administrador>) t.execute(dni);
				return med.get(0).getNombreCompleto();
			}
			
		}
		return nombre;
		
	}
	
}