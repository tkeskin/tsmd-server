package tr.com.tsmd.cengiz.service;


    import java.io.IOException;
    import javax.mail.MessagingException;
    import tr.com.tsmd.cengiz.util.Mail;

public interface EmailService {
  void sendSimpleMessage(Mail mail) throws Exception;

  String sendMimeMessage(Long id, Integer servicesType) throws MessagingException;

  String sendInformationMessage(String trackingNumber, Long id, Integer servicesType) throws MessagingException, IOException;
}
