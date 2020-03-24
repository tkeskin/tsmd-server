package tr.com.tsmd.cengiz.service;


import javax.mail.MessagingException;
import tr.com.tsmd.cengiz.entity.TrademarkPreEntity;
import tr.com.tsmd.cengiz.util.Mail;

public interface EmailService {
  void sendSimpleMessage(Mail mail) throws Exception;

  void sendMimeMessage(Mail mail, TrademarkPreEntity trademarkPreEntity) throws MessagingException;
}
