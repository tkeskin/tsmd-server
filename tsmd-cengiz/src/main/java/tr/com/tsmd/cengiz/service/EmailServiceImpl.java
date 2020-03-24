package tr.com.tsmd.cengiz.service;

import com.sun.istack.ByteArrayDataSource;
import java.nio.charset.StandardCharsets;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import tr.com.tsmd.cengiz.entity.TrademarkPreEntity;
import tr.com.tsmd.cengiz.util.Mail;


@SuppressWarnings("PMD.TooManyFields")
@Service
public class EmailServiceImpl implements EmailService {

  @Autowired
  private JavaMailSender emailSender;

  /**
   * @param mail .
   */
  public void sendSimpleMessage(Mail mail) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setSubject(mail.getSubject());
    message.setText(mail.getContent());
    message.setTo(mail.getTo());
    message.setFrom(mail.getFrom());
    emailSender.send(message);
  }

  @Override
  public void sendMimeMessage(Mail mail, TrademarkPreEntity trademarkPreEntity) throws MessagingException {
    MimeMessage message = emailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message,
        MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
        StandardCharsets.UTF_8.name());
    try {
      ByteArrayDataSource bds = new ByteArrayDataSource(trademarkPreEntity.getTrademarkimagebyte(), "image/jpeg");

      helper.addAttachment("logo.png", bds);
      String inlineImage = "<img src=\"cid:logo.png\"></img><br/>";

      helper.setText(inlineImage + mail.getContent(), true);
      helper.setSubject(mail.getSubject());
      helper.setTo(mail.getTo());
      helper.setFrom(mail.getFrom());
    } catch (MessagingException e){
      e.getLocalizedMessage();
    }
    emailSender.send(message);
  }
}
