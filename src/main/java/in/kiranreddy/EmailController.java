package in.kiranreddy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmailController {

  private MyEmailService emailService;

  @Autowired
  public EmailController(MyEmailService emailService) {
    this.emailService = emailService;
  }

  @GetMapping("/sendEmail")
  @ResponseBody
  public String sendEmail() {
    emailService.sendMail("belluccifranco@gmail.com", "Test subject", "Test mail");
    return "OK!";
  }
}
