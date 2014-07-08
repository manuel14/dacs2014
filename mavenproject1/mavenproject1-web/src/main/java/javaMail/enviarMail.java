package javaMail;


import java.util.Properties;
import javax.mail.Message;
import javax.mail.Transport;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;




/**
 *
 * @author VerÃ³nica
 */

public class enviarMail{
    String usuarioCorreo;
    String password;
    
    String rutaArchivo;
    String nombreArchivo;
    
    String destinatario;
    String asunto;
    String mensaje;
    
    public  enviarMail(String usuarioCorreo, String password, 
                       String destinatario,
                       String asunto,
                      String mensaje){
        this.usuarioCorreo = usuarioCorreo;
        this.password = password;
        this.destinatario = destinatario;
        this.asunto = asunto;
        this.mensaje = mensaje;
    }

    /**
     *
     * @return
     */
        public boolean sendMail(){
            try{
                Properties props = new Properties();
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.setProperty("mail.smtp.starttls.enable", "true");
                props.setProperty("mail.smtp.port", "587");
                props.setProperty("mail.smtp.user", usuarioCorreo);
                props.setProperty("mail.smtp.auth", "true");
                
                Session session = Session.getDefaultInstance(props, null);
                BodyPart texto = new MimeBodyPart();
                texto.setText(mensaje);
                
                
                
                MimeMessage message = new MimeMessage (session);
                message.setFrom(new InternetAddress(usuarioCorreo));
                message.addRecipient(
                        Message.RecipientType.TO,
                new InternetAddress(destinatario));
                message.setSubject(asunto);
               
                Transport t = session.getTransport("smtp");
                t.connect (usuarioCorreo, password);
                t.sendMessage(message, message.getAllRecipients());
                t.close();
                return true;
            }
            catch(MessagingException e){
                return false;
            }
        }
      
}