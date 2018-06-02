package in.kiranreddy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MyEmailService {

  private JavaMailSender javaMailSender;

  @Autowired
  public MyEmailService(JavaMailSender javaMailSender) {
    this.javaMailSender = javaMailSender;
  }

  @Async
  public void sendMail(String toEmail, String subject, String message) throws MailException {
    SimpleMailMessage mailMessage = new SimpleMailMessage();
    mailMessage.setTo(toEmail);
    mailMessage.setSubject(subject);
    mailMessage.setText(message);
    mailMessage.setFrom("ventas@globodistribuciones.com");
    javaMailSender.send(mailMessage);
  }
}
