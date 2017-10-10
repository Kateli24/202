package email;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

/**
 *
 * @author liji8162
 */
public class Text extends Thread {

	String path;

	@Override
	public void run() {

		try {
			// Create the attachment
			EmailAttachment attachment = new EmailAttachment();
			attachment.setPath(path);
			attachment.setDisposition(EmailAttachment.ATTACHMENT);
			attachment.setDescription("PDF version of the receipt");
			attachment.setName("Kate");
			// Create the email message
			MultiPartEmail email = new MultiPartEmail();
			email.setHostName("localhost");
			email.addTo("liji8162@student.otago.ac.nz");
			email.setFrom("liji8162@student.otago.ac.nz");
			email.setSubject("The receipt");
			email.setMsg("Here is the receipt you wanted");
			email.setSmtpPort(25);
			// add the attachment
			email.attach(attachment);
			// send the email
			email.send();
		} catch (EmailException ex) {
			throw new RuntimeException(ex);
		}
	}

	public Text(String path) {
		this.path = path;
	}
	
	public static void main(String[] args) {
		Text text = new Text("h:/lab11report/receipt.pdf");
		text.start();
	}
}
