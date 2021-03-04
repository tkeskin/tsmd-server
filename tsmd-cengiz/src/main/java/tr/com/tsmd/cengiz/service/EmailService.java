package tr.com.tsmd.cengiz.service;


import javax.mail.MessagingException;
import tr.com.tsmd.cengiz.entity.PatentPreEntity;
import tr.com.tsmd.cengiz.entity.TrademarkPreEntity;
import tr.com.tsmd.cengiz.util.Mail;

public interface EmailService {
  void sendSimpleMessage(Mail mail) throws Exception;

  String sendMimeMessage(Long id, Integer servicesType) throws MessagingException;
}
