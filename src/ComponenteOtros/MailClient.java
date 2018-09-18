/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponenteOtros;


import java.io.*;
import sun.net.smtp.*;

/**
 * @author miguel
 * 
 */
public class MailClient {

	protected SmtpClient sc;
	protected PrintStream ps;
	protected String toName = "";
	private String server, sender, adresses, adresses1, adresses2, adresses3,
			adresses4, message, subject;

	public MailClient() {
		server = "mail.nortfarma.net";
		adresses = "informatica@nortfarma.net";
		adresses1 = "pdelacruz@nortfarma.net";
		adresses2 = "sgarcia@nortfarma.net";
		adresses3 = "almacen@nortfarma.net";
		adresses4 = "szegarra@nortfarma.net";
	}

	public void sendMail(String de, String subj, String mensaje) {

		try {

			sender = de;
			subject = subj;
			message = mensaje;
			sc = new SmtpClient(server);
			sc.from(sender);
			sc.to(adresses);
			sc.to(adresses1);
			sc.to(adresses2);
			sc.to(adresses3);
			sc.to(adresses4);
			ps = sc.startMessage();
			ps.println("Subject: " + subject);
			ps.println();
			ps.println(message);
			sc.closeServer();

		} catch (Exception e) {
			System.out.println("ERRRO DE CORREO :" + e.getMessage());
			dialogMessage(" Some Error has occured while sending mail. ");
		}
	}

	public String dialogMessage(String str) {
		return str;
	}
}
