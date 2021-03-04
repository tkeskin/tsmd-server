package tr.com.tsmd.cengiz.service;

import com.sun.istack.ByteArrayDataSource;
import java.nio.charset.StandardCharsets;
import java.util.List;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import tr.com.tsmd.cengiz.entity.ActivityAnalysisEntity;
import tr.com.tsmd.cengiz.entity.ActivityAnalysisPicturesEntity;
import tr.com.tsmd.cengiz.entity.InvalidationAssessmentEntity;
import tr.com.tsmd.cengiz.entity.PatentPreEntity;
import tr.com.tsmd.cengiz.entity.PatentPreRelatedPicturesEntity;
import tr.com.tsmd.cengiz.entity.PatentPreTableEntity;
import tr.com.tsmd.cengiz.entity.TrademarkPreEntity;
import tr.com.tsmd.cengiz.entity.ValuationPatentEntity;
import tr.com.tsmd.cengiz.entity.ValuationTrademarkEntity;
import tr.com.tsmd.cengiz.repository.ActivityAnalysisPicturesRepository;
import tr.com.tsmd.cengiz.repository.ActivityAnalysisRepository;
import tr.com.tsmd.cengiz.repository.InvalidationAssessmentRepository;
import tr.com.tsmd.cengiz.repository.PatentPreRelatedPicturesRepository;
import tr.com.tsmd.cengiz.repository.PatentPreRepository;
import tr.com.tsmd.cengiz.repository.PatentPreTableRepository;
import tr.com.tsmd.cengiz.repository.TrademarkPreRepository;
import tr.com.tsmd.cengiz.repository.ValuationPatentRepository;
import tr.com.tsmd.cengiz.repository.ValuationTrademarkRepository;
import tr.com.tsmd.cengiz.util.Mail;


@SuppressWarnings("PMD.TooManyFields")
@Service
public class EmailServiceImpl implements EmailService {

  @Autowired
  private JavaMailSender emailSender;

  @Autowired
  TrademarkPreRepository trademarkPreRepository;

  @Autowired
  PatentPreRepository patentPreRepository;

  @Autowired
  PatentPreTableRepository patentPreTableRepository;

  @Autowired
  PatentPreRelatedPicturesRepository patentPreRelatedPicturesRepository;

  @Autowired
  ValuationPatentRepository valuationPatentRepository;

  @Autowired
  ValuationTrademarkRepository valuationTrademarkRepository;

  @Autowired
  ActivityAnalysisRepository activityAnalysisRepository;

  @Autowired
  ActivityAnalysisPicturesRepository activityAnalysisPicturesRepository;

  @Autowired
  InvalidationAssessmentRepository invalidationAssessmentRepository;


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
  public String sendMimeMessage(Long id, Integer servicesType) throws MessagingException {
    String trackingNumber=null;
    MimeMessage message = emailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message,
        MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
        StandardCharsets.UTF_8.name());
    if (servicesType == 1) {
      TrademarkPreEntity trademarkPreEntity= trademarkPreRepository.getById(id);
      trackingNumber = trademarkPreEntity.getTrackingNumber();
      try {
        String inlineImage = "";
        if (trademarkPreEntity.getTrademarkimagebyte() != null){
          ByteArrayDataSource bds = new ByteArrayDataSource(trademarkPreEntity.getTrademarkimagebyte(), trademarkPreEntity.getTrademarkimageFileType());
          String markaOrnegiIsim = attachmentNameControl("marka_ornegi",trademarkPreEntity.getTrademarkimageFileType());
          helper.addAttachment(markaOrnegiIsim, bds);
          inlineImage = "<img src=\"cid:"+markaOrnegiIsim+"\"></img><br/>";
        }

        String dekontName = attachmentNameControl("dekont",trademarkPreEntity.getDekontFileType());
        helper.addAttachment(dekontName, new ByteArrayResource(trademarkPreEntity.getDekont()));
        String contentHtml="<h1 style=\"font-weight: bold;color: white;background-color: #d32f2f\">Marka Ön Araştırma Talebi </h1>\n"
            + "<div style=\"font-weight: bold;color: white;background-color: #6c757d\">Ad Soyad/Ticaret Unvanı</div>\n"
            + "<div>"+trademarkPreEntity.getName_surname()+"</div>\n"
            + "<div style=\"font-weight: bold;color: white;background-color: #6c757d\">T.C. Kimlik No/Vergi D./Vergi No</div>\n"
            + "<div>"+trademarkPreEntity.getTc()+"</div>\n"
            +"<div style=\"font-weight: bold;color: white;background-color: #6c757d\">İletişim Kurulacak Kişi (Talepte Bulunan Tüzel"
            + " Kişi ise)</div>\n";
            if (trademarkPreEntity.getLegalPerson() != null) {
              contentHtml+="<div>" + trademarkPreEntity.getLegalPerson() + "</div>\n";
            }
        contentHtml+= "<div style=\"font-weight: bold;color: white;background-color: #6c757d\"> Adres</div>\n"
            + "<div>"+trademarkPreEntity.getAddress()+"</div>\n"
            + "<div style=\"font-weight: bold;color: white;background-color: #6c757d\">Telefon</div>\n"
            + "<div>"+trademarkPreEntity.getTel()+"</div>\n"
            + "<div style=\"font-weight: bold;color: white;background-color: #6c757d\">E-posta</div>\n"
            + "<div>"+trademarkPreEntity.getEmail()+"</div>\n"
            + "<div style=\"font-weight: bold;color: white;background-color: #6c757d\">Marka Tipi</div>\n";
        if (trademarkPreEntity.getTrademarktype() != null && trademarkPreEntity.getTrademarktype().equals("1")){
          contentHtml+= "<div>Sadece kelime</div>\n";
        }else if (trademarkPreEntity.getTrademarktype() != null && trademarkPreEntity.getTrademarktype().equals("2")){
          contentHtml+= "<div>Kelime+Şekil</div>\n";
        }else if (trademarkPreEntity.getTrademarktype() != null && trademarkPreEntity.getTrademarktype().equals("3")){
          contentHtml+= "<div>Sadece şekil</div>\n";
        }else if (trademarkPreEntity.getTrademarktype() != null && trademarkPreEntity.getTrademarktype().equals("4")){
          contentHtml+= "<div>Renk</div>\n";
        }

        contentHtml += "<div style=\"font-weight: bold;color: white;background-color: #6c757d\">Marka Örneği</div>\n";
        if (inlineImage != null) {
          contentHtml+= "<div>" + inlineImage + "</div>\n";
        }else {
          contentHtml+= "<div></div>\n";
        }
        contentHtml += "<div style=\"font-weight: bold;color: white;background-color: #6c757d\">Marka Yazılı İfade Edilişi</div>\n";
        if (trademarkPreEntity.getTrademarktext() != null) {
          contentHtml += "<div>" + trademarkPreEntity.getTrademarktext() + "</div>\n";
        } else {
          contentHtml+= "<div></div>\n";
        }
            contentHtml+="<div style=\"font-weight: bold;color: white;background-color: #6c757d\">Mal/Hizmet Sınıfları</div>\n"
            + "<div>"+trademarkPreEntity.getTrademarkclass()+"</div>";
        contentHtml+="<div style=\"font-weight: bold;color: white;background-color: #6c757d\">Eşya Listesi</div>\n";
        if (trademarkPreEntity.getTrademarktext() != null) {
          contentHtml+= "<div>" + trademarkPreEntity.getTrademarkItemList() + "</div>";
        }else {
          contentHtml+= "<div></div>\n";
        }
        helper.setText(contentHtml, true);
        helper.setSubject("Marka Ön Araştırma Raporu Talebi"+"("+trademarkPreEntity.getTrackingNumber()+")");

      } catch (MessagingException e){
        e.getLocalizedMessage();
      }



    } else if (servicesType == 2) {
      PatentPreEntity patentPreEntity = patentPreRepository.getById(id);
      List<PatentPreTableEntity> patentPreTableEntity = patentPreTableRepository.getByPatentPreId(id);
      List<PatentPreRelatedPicturesEntity> patentPreRelatedPicturesEntities = patentPreRelatedPicturesRepository.getByPatentPreId(id);
      trackingNumber = patentPreEntity.getTrackingNumber();

      String[] relatedPicturesImg = null;
      if (patentPreRelatedPicturesEntities.size()>0){
        ByteArrayDataSource[] relatedPictures = new ByteArrayDataSource[patentPreRelatedPicturesEntities.size()];
         relatedPicturesImg = new String[patentPreRelatedPicturesEntities.size()];

         for (int i=0;i<patentPreRelatedPicturesEntities.size();i++){
           relatedPictures[i] = new ByteArrayDataSource(
               patentPreRelatedPicturesEntities.get(i).getPicture(), patentPreRelatedPicturesEntities.get(i).getFileType());
           String ilgiliResimIsim = attachmentNameControl("ilgiliGorsel"+i,patentPreRelatedPicturesEntities.get(i).getFileType());
           helper.addAttachment(ilgiliResimIsim, relatedPictures[i]);
           relatedPicturesImg[i] = "<img src=\"cid:"+ilgiliResimIsim+"\"></img><br/>";

         }
      }

      String dakontName = attachmentNameControl("dekont",patentPreEntity.getDekontFileType());
      helper.addAttachment(dakontName, new ByteArrayResource(patentPreEntity.getDekont()));

      String contentHtml="<h1 style=\"font-weight: bold;color: white;background-color: #d32f2f\">Patent Ön Araştırma Talebi </h1>\n"
          +"<br>"
          + "<h3 style=\"font-weight: bold;color: white;background-color: #d32f2f\">1. BAŞVURU SAHİBİ </h3>\n"
          + "<div style=\"font-weight: bold;color: white;background-color: #6c757d\">Ad Soyad/Ticaret Unvanı</div>\n"
          + "<div>"+patentPreEntity.getName_surname()+"</div>\n"
          + "<div style=\"font-weight: bold;color: white;background-color: #6c757d\">T.C. Kimlik No/Vergi D./Vergi No</div>\n"
          + "<div>"+patentPreEntity.getTc()+"</div>\n"
          +"<div style=\"font-weight: bold;color: white;background-color: #6c757d\">İletişim Kurulacak Kişi (Talepte Bulunan Tüzel Kişi ise)</div>\n";
      if (patentPreEntity.getLegalPerson() != null) {
       contentHtml += "<div>" + patentPreEntity.getLegalPerson() + "</div>\n";
      }else {
        contentHtml += "<div></div>\n";
      }
         contentHtml += "<div style=\"font-weight: bold;color: white;background-color: #6c757d\"> Adres</div>\n"
          + "<div>"+patentPreEntity.getAddress()+"</div>\n"
          + "<div style=\"font-weight: bold;color: white;background-color: #6c757d\">Telefon</div>\n"
          + "<div>"+patentPreEntity.getTel()+"</div>\n"
          + "<div style=\"font-weight: bold;color: white;background-color: #6c757d\">E-posta</div>\n"
          + "<div>"+patentPreEntity.getEmail()+"</div>\n"
          +"<div style=\"font-weight: bold;color: white;background-color: #6c757d\">Tercih Edilen Rapor Türü</div>\n";
      if (patentPreEntity.getReporttype() != null && patentPreEntity.getReporttype().equals("8")){
        contentHtml+= "<div>Standart</div>\n";
      }else if (patentPreEntity.getReporttype() != null && patentPreEntity.getReporttype().equals("9")){
        contentHtml+= "<div>Detaylı</div>\n";
      }

       contentHtml+= "<h3 style=\"font-weight: bold;color: white;background-color: #d32f2f\">2. BULUŞA İLİŞKİN BİLGİLER </h3>\n"
           +"<br>"
           + "<h4 style=\"font-weight: bold;color: white;background-color: #000\">2.1. İSTENEN KORUMA TÜRÜ</h4>\n";
      if (patentPreEntity.getProtectiontype() != null && patentPreEntity.getProtectiontype().equals("5")){
        contentHtml+= "<div>Standart</div>\n";
      }else if (patentPreEntity.getProtectiontype() != null && patentPreEntity.getProtectiontype().equals("6")){
        contentHtml+= "<div>Faydalı Model</div>\n";
      }else if (patentPreEntity.getProtectiontype() != null && patentPreEntity.getProtectiontype().equals("7")){
        contentHtml+= "<div>Rapor Sonrasında Belirleyeceğim</div>\n";
      }
      contentHtml+= "<h4 style=\"font-weight: bold;color: white;background-color: #000\">2.2. BULUŞUN İLGİLİ OLDUĞU TEKNİK ALAN/ALANLAR</h4>\n";
      if (patentPreEntity.getComputerarea() != null && patentPreEntity.getComputerarea().equals(true)){
        contentHtml+= "<div>Bilgisayar</div>\n";
      }
      if (patentPreEntity.getElectricityarea() != null && patentPreEntity.getElectricityarea().equals(true)){
        contentHtml+= "<div>Elektrik/Elektronik</div>\n";
      }
      if (patentPreEntity.getElectronicarea() != null && patentPreEntity.getElectronicarea().equals(true)){
        contentHtml+= "<div>Elektronik ve Haberleşme</div>\n";
      }
      if (patentPreEntity.getMachinearea() != null && patentPreEntity.getMachinearea().equals(true)){
        contentHtml+= "<div>Makine</div>\n";
      }
      if (patentPreEntity.getMachinearea() != null && patentPreEntity.getMedicinearea().equals(true)){
        contentHtml+= "<div>İlaç</div>\n";
      }
      if (patentPreEntity.getAutomotivearea() != null && patentPreEntity.getAutomotivearea().equals(true)){
        contentHtml+= "<div>Otomotiv</div>\n";
      }
      if (patentPreEntity.getMetallurgyarea() != null && patentPreEntity.getMetallurgyarea().equals(true)){
        contentHtml+= "<div>Metalurji</div>\n";
      }
      if (patentPreEntity.getBiomedicalarea() != null && patentPreEntity.getBiomedicalarea().equals(true)){
        contentHtml+= "<div>Biyomedikal</div>\n";
      }
      if (patentPreEntity.getChemistryarea() != null && patentPreEntity.getChemistryarea().equals(true)){
        contentHtml+= "<div>Kimya</div>\n";
      }
      if (patentPreEntity.getFoodarea() != null && patentPreEntity.getFoodarea().equals(true)){
        contentHtml+= "<div>Gıda</div>\n";
      }
      if (patentPreEntity.getBuildarea() != null && patentPreEntity.getBiomedicalarea().equals(true)){
        contentHtml+= "<div>İnşaat</div>\n";
      }
      if (patentPreEntity.getOtherarea() != null){
        contentHtml+= "<div>"+patentPreEntity.getOtherarea()+"</div>\n";
      }
      contentHtml+= "<h4 style=\"font-weight: bold;color: white;background-color: #000\">2.3. BULUŞA İLİŞKİN BAŞVURULAR </h4><span>(Buluşa ilişkin gerçekleştirilmiş bir başvuru mevcut mudur? Mevcut ise başvuru numarasını belirtiniz.)</span>\n"
          + "<div>"+patentPreEntity.getAppNo()+"</div>\n";
          contentHtml+= "<h4 style=\"font-weight: bold;color: white;background-color: #000\">2.4. BULUŞ BAŞLIĞI </h4><span>(Birkaç kelime ile buluşu kısaca tanımlayan bir başlık yazınız.)</span>\n"
          + "<div>"+patentPreEntity.getTitle()+"</div>\n"
          + "<h4 style=\"font-weight: bold;color: white;background-color: #000\">2.5. ANAHTAR KELİME ÖNERİLERİ </h4><span>(Türkçe/İngilizce)</span>\n";
           if(patentPreEntity.getPatentkeyword() != null) {
             contentHtml+="<div>" + patentPreEntity.getPatentkeyword() + "</div>\n";
           }else {
            contentHtml+= "<div></div>\n";
           }
          contentHtml+= "<h4 style=\"font-weight: bold;color: white;background-color: #000\">2.6. TEKNİĞİN BİLİNEN DURUMUNDA YER ALAN UYGULAMALAR</h4><span>(Mevcutta var olan uygulamalar, patent, makale, internet siteleri, youtube videoları vb. görsel ve yazılı kaynakları belirtiniz.)</span>\n";
      if(patentPreEntity.getPatentapplication() != null) {
        contentHtml+="<div>" + patentPreEntity.getPatentapplication() + "</div>\n";
      }else{
        contentHtml+="<div></div>\n";
      }
          contentHtml+= "<h4 style=\"font-weight: bold;color: white;background-color: #000\">2.7. BULUŞUN SAĞLADIĞI AVANTAJLAR</h4><span>(Buluşun sağladığı kolaylıkları, iyileştirmeleri, teknik soruna çözümleri belirtiniz.)</span>\n";
         if(patentPreEntity.getAdvantage() != null){
          contentHtml+= "<div>"+patentPreEntity.getAdvantage()+"</div>\n";
         }else{
           contentHtml+="<div></div>\n";
         }
          contentHtml+= "<h4 style=\"font-weight: bold;color: white;background-color: #000\">2.8. TARAFINIZCA YAPILMIŞ / YAPILMASI PLANLANAN YAYINLAR*</h4><span>(Buluşun sözlü ya da yazılı açıklaması daha önce bir yerde yapıldı ise lütfen belirtiniz. Örneğin; makale, haber, sergi, youtube vb. Bu kısımla ilgili kılavuzu incelemeniz önem arz etmektedir.)</span>\n";
              if(patentPreEntity.getPublications()!=null){
              contentHtml+= "<div>"+patentPreEntity.getPublications()+"</div>\n";
              }else{
                contentHtml+="<div></div>\n";
              }
          contentHtml+= "<h3 style=\"font-weight: bold;color: white;background-color: #d32f2f\">3. BULUŞUN AYRINTILI AÇIKLAMASI</h3>\n"
          + "<h4 style=\"font-weight: bold;color: white;background-color: #000\">3.1. BULUŞUNUZLA MEVCUT SİSTEMLER / ÜRÜNLER / YÖNTEMLER ARASINDAKİ FARKLILIKLAR </h4><span>(Buluşunuzun korumayı amaçladığınız özelliklerini belirterek o özellik ilgili teknik alanda mevcut mu, yeni bir özellik mi bir işaret ile belirtiniz.)</span>\n"
          + "<div>\n";
           if(patentPreTableEntity != null) {
             contentHtml += "<table style=\"width:100%\" style=\"border: 1px solid black;\">\n"
                 + "<thead>\n"
                 + "<tr style=\"border: 1px solid black;\">\n"
                 + "<th style=\"border: 1px solid black;\">No</th>\n"
                 + "<th style=\"border: 1px solid black;\">Özellik</th>\n"
                 + "<th style=\"border: 1px solid black;\">İlgili Teknik Alan Mevcut mu?</th>\n"
                 + "</tr>\n"
                 + "</thead>\n"
                 + "<tbody>\n";
             for (int i=0; i<patentPreTableEntity.size();i++) {
               contentHtml+="<tr style=\"border: 1px solid black;\">\n"
                   + "<td style=\"border: 1px solid black;\">"+patentPreTableEntity.get(i).getDeferenceno()+"</td>\n"
                   + "<td style=\"border: 1px solid black;\">"+patentPreTableEntity.get(i).getDeferencepriority()+"</td>\n"
                   + "<td style=\"border: 1px solid black;\">"+patentPreTableEntity.get(i).getDeferencechoose()+"</td>\n"
                   + "</tr>\n";
             }
                contentHtml+= "</tbody>\n"
                 + "</table></div>\n";
           }
          contentHtml+= "<h4 style=\"font-weight: bold;color: white;background-color: #000\">3.2. BULUŞUN AYRINTILI AÇIKLAMASI*</h4>\n";
              if(patentPreEntity.getDetailexplain() != null){
          contentHtml+= "<div>"+patentPreEntity.getDetailexplain()+"</div>\n";
              }else{
                contentHtml+="<div></div>\n";
              }
          contentHtml+= "<h3 style=\"font-weight: bold;color: white;background-color: #d32f2f\">4. BULUŞLA İLGİLİ GÖRSELLER</h3>\n"
          + "<div>(Buluşunuzun özellikle bir sistem/aparat/ürün/mekanizma olması durumunda buluşa ilişkin görsellerin eklenmesi önerilmektedir.)</div>\n";
              if(patentPreEntity.getPicture() != null){
          contentHtml+="<div>" + patentPreEntity.getPicture() + "</div>\n";
              }else{
                contentHtml+="<div></div>\n";
              }
           if (patentPreRelatedPicturesEntities.size()>0) {
             for (int i=0;i<relatedPicturesImg.length;i++) {
               contentHtml += "<div>" + relatedPicturesImg[i] + "</div>\n"
                   +"<br>\n";
             }
           }
          contentHtml+= "<h3 style=\"font-weight: bold;color: white;background-color: #d32f2f\">5. BELİRTMEK İSTEDİĞİNİZ DİĞER HUSUSLAR</h3>\n"
          + "<div>(Buluşunuza ilişkin araştırmamıza katkı sağlayacağını düşündüğünüz başka hususlar varsa belirtiniz.)</div>\n";
      if(patentPreEntity.getOtherpoint() != null){
        contentHtml+="<div>" + patentPreEntity.getOtherpoint() + "</div>\n";
      }else{
        contentHtml+="<div></div>\n";
      }

      helper.setText(contentHtml, true);
      helper.setSubject("Patent Ön Araştırma Talebi"+"("+patentPreEntity.getTrackingNumber()+")");


    } else if (servicesType == 3) {
      ValuationPatentEntity valuationPatentEntity = valuationPatentRepository.getById(id);
      trackingNumber = valuationPatentEntity.getTrackingNumber();
//      helper.addAttachment("dekont.jpeg", new ByteArrayResource(valuationPatentEntity.getDekont()));
      String contentHtml="<h1 style=\"font-weight: bold;color: white;background-color: #d32f2f\">Patent Değerleme Talebi </h1>\n"
          + "<br>\n"
          + "<h3 style=\"font-weight: bold;color: white;background-color: #d32f2f\">BAŞVURU SAHİBİ </h3>\n"
          + "<div style=\"font-weight: bold;color: white;background-color: #6c757d\">Ad Soyad/Ticaret Unvanı</div>\n"
          + "<div>"+valuationPatentEntity.getName_surname()+"</div>\n"
          + "<div style=\"font-weight: bold;color: white;background-color: #6c757d\">T.C. Kimlik No/Vergi D./Vergi No</div>\n"
          + "<div>"+valuationPatentEntity.getTc()+"</div>\n"
          +"<div style=\"font-weight: bold;color: white;background-color: #6c757d\">İletişim Kurulacak Kişi (Talepte Bulunan Tüzel Kişi ise)</div>\n";
      if (valuationPatentEntity.getLegalPerson() != null) {
        contentHtml += "<div>" + valuationPatentEntity.getLegalPerson() + "</div>\n";
      }else {
        contentHtml += "<div></div>\n";
      }
      contentHtml += "<div style=\"font-weight: bold;color: white;background-color: #6c757d\"> Adres</div>\n"
          + "<div>"+valuationPatentEntity.getAddress()+"</div>\n"
          + "<div style=\"font-weight: bold;color: white;background-color: #6c757d\">Telefon</div>\n"
          + "<div>"+valuationPatentEntity.getTel()+"</div>\n"
          + "<div style=\"font-weight: bold;color: white;background-color: #6c757d\">E-posta</div>\n"
          + "<div>"+valuationPatentEntity.getEmail()+"</div>\n"
          + "<h3 style=\"font-weight: bold;color: white;background-color: #d32f2f\">BULUŞA İLİŞKİN GENEL BİLGİLER</h3>\n"
          + "<div>\n"
          + "<table>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">BULUŞ HAKKI SAHİBİ/ADRESİ</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getAddress()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Patent değerlemesi talebinizdeki amacınız nedir?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getPatentpurpose()+"</td></tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Değerlenmesi\n"
          + "istenen patent için patent başvurusunda bulunulmuş mudur? Bulunulduysa dosya numarası nedir?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getPatentappno()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Buluşunuzu hangi ülke/ülkelerde kullanmakta/kullanmayı amaçlamaktasınız?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getPatentcountry()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Değerlemesi\n"
          + "amaçlanan buluş piyasaya sürülmüş müdür?</td>\n";
      if (valuationPatentEntity.getPatentmarketchoose() != "0"){
        contentHtml +=  "<td style=\"width: 70%;border: 1px solid black;\">Evet</td></tr>\n";
      }else {
        contentHtml += "<td style=\"width: 70%;border: 1px solid black;\">Hayır</td></tr>\n";
      }

      contentHtml+=  "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Piyasaya ne zaman sürülmüştür?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getPatentmarkettime()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Buluşunuz piyasaya sürülmediyse\n"
          + " piyasaya sürmeyi amaçlamakta mısnız? Ne zaman sürmeyi planlamaktasınız?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getPatentmarkettimeplan()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">İlgili buluş konusu bir ürünün parçası"
          + " bir parçası ise ürünün genelinde kullanım oranı yüzde cinsinden ne kadardır?"
          + "  (Buluş ürünün kendisi ise %100 olarak cevaplayınız. Buluş bir yöntem ise"
          + "   yöntemin ürüne katkısı için tahmini bir değer giriniz.)</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getPatentcontribution()+"</td>\n"
          + "</tr>\n";
          contentHtml+= "</table>\n"
          + "</div>\n"
          + "<h3 style=\"font-weight: bold;color: white;background-color: #d32f2f\">SEKTÖRE İLİŞKİN BİLGİLER</h3>\n"
          + "<div>\n"
          + "<table>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Buluşunuzun "
              + "piyasaya sürülmüş olması halinde aktif olarak satışa konu olduğu ana sektör nedir? "
              + "Henüz piyasaya sürülmediyse hangi sektöre hitap etkemtedir?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getPatentsector()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Buluşunuzun aktif olarak satışa konu olduğu diğer sektörler varsa nelerdir?</td>\n";
      if (valuationPatentEntity.getPatentothersector() != null){
        contentHtml += "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getPatentothersector()+"</td></tr>\n";
      }else {
        contentHtml += "<td style=\"width: 70%;border: 1px solid black;\"></td></tr>\n";
      }

          contentHtml+= "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Değerlenmesi istenen buluş konusu "
              + "bir ürün ise pazar payı nedir? Piyasaya sürülmediyse piyasadaki muadilinin pazar payı nedir?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getMarketshare()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Değerlenmesi istenen buluşa konu olan ürünün"
              + " yurtdışında pazar payı bulunmakta mıdır?</td>\n";
      if (valuationPatentEntity.getOverseasmarketshare() != null){
        contentHtml += "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getOverseasmarketshare()+"</td>\n";
      }else {
        contentHtml += "<td style=\"width: 70%;border: 1px solid black;\"></td>\n";
      }
          contentHtml+= "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Yukarıdaki soruya 'Evet' cevabı vermeniz halinde, ihracat yapılan ülkeler hangileridir?</td>\n";
      if (valuationPatentEntity.getExportcountry() != null){
        contentHtml +=  "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getExportcountry()+"</td>\n";
      }else {
        contentHtml += "<td style=\"width: 70%;border: 1px solid black;\"></td>\n";
      }

          contentHtml+= "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">İhracat yapılan ülkelerden sağlanan gelirlerin toplam gelir içerisindeki yüzdeleri nelerdir?</td>\n";
      if (valuationPatentEntity.getExportturnover() != null){
        contentHtml +=  "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getExportturnover()+"</td>\n";
      }else {
        contentHtml += "<td style=\"width: 70%;border: 1px solid black;\"></td>\n";
      }
          contentHtml+= "</tr>\n"
          + "</table>\n"
          + "</div>\n"
          + "<h3 style=\"font-weight: bold;color: white;background-color: #d32f2f\">BÜYÜME TAHMİNLERİ/PROJEKSİYONLARI\n"
          + "</h3>\n"
          + "<div>\n"
          + "<table>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Önümüzdeki 5 yılda gelirlerinizde hedeflediğiniz artış oranı nedir?</td>\n";
      if (valuationPatentEntity.getTurnovertarget() != null){
        contentHtml +=  "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getTurnovertarget()+"</td>\n";
      }else {
        contentHtml += "<td style=\"width: 70%;border: 1px solid black;\"></td>\n";
      }

          contentHtml+= "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Değerlenmesi istenen buluş ya da muadili piyasaya sürüldüyse toplam gelirleriniz içerisindeki yüzdesi nedir?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getTurnoverpercent()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Önümüzdeki 5 yılda değerlenmesi istenen buluşun sağladığı/sağlayacağı gelirlerin tahmini artış yüzdesi nedir?</td>\n";
      if (valuationPatentEntity.getIncomepercent() != null){
        contentHtml +=  "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getIncomepercent()+"</td>\n";
      }else {
        contentHtml += "<td style=\"width: 70%;border: 1px solid black;\"></td>\n";
      }

          contentHtml+= "</tr>\n"
          + "</table>\n"
          + "</div>\n"
          + "<h3 style=\"font-weight: bold;color: white;background-color: #d32f2f\">BULUŞUNUZA İLİŞKİN SÖZLEŞMELER</h3>\n"
          + "<div>\n"
          + "<table>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Buluşunuza ait lisans sözleşmesi yapılmış mıdır? Yapıldıysa kaç adet lisans verilmiştir?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getLicense()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Yukarıdaki soruya cevabınız \"Evet \" ise royalty oranı kaç olarak belirlenmiştir?</td>\n";
      if (valuationPatentEntity.getLicenseroyalt() != null){
        contentHtml +=  "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getLicenseroyalt()+"</td></tr>\n";
      }else {
        contentHtml += "<td style=\"width: 70%;border: 1px solid black;\"></td></tr>\n";
      }

          contentHtml+= "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Buluşunuzun konu olduğu başka bir sözleşme var mıdır?(rehin, know-how vb.) </td>\n";
      if (valuationPatentEntity.getContract() != null){
        contentHtml +=  "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getContract()+"</td>\n";
      }else {
        contentHtml += "<td style=\"width: 70%;border: 1px solid black;\"></td>\n";
      }

          contentHtml+= "</tr>\n"
          + "</table>\n"
          + "</div>\n"
          + "<h3 style=\"font-weight: bold;color: white;background-color: #d32f2f\">MALİYETLERE İLİŞKİN BİLGİLER</h3>\n"
          + "<div>\n"
          + "<table>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Buluşunuza ilişkin reklam, sponsorluk, tanıtım kampanyası vs. yapılmış mıdır?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getAdvertisement()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Yukarıdaki soruya cevabınız \"Evet\" ise bu kapsamda yapılan harcamaların toplamı ne kadardır?(Lütfen yıl bazında gösteriniz.)?</td>\n";
      if (valuationPatentEntity.getTotalexpenditure() != null){
        contentHtml += "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getTotalexpenditure()+"</td>\n";
      }else {
        contentHtml += "<td style=\"width: 70%;border: 1px solid black;\"></td>\n";
      }

          contentHtml+= "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Buluşunuz için yapılan Ar-Ge harcamalarının toplamı ne kadardır?</td>\n";
      if (valuationPatentEntity.getSpending() != null){
        contentHtml += "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getSpending()+"</td>\n";
      }else {
        contentHtml += "<td style=\"width: 70%;border: 1px solid black;\"></td>\n";
      }

          contentHtml+= "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Buluşun tescili için dünya genelinde yapılan başvuru masrafları ve yıllık aidatların toplamı ne kadardır</td>\n";
      if (valuationPatentEntity.getWorldspending() != null){
        contentHtml += "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getWorldspending()+"</td>\n";
      }else {
        contentHtml +="<td style=\"width: 70%;border: 1px solid black;\"></td>\n";
      }

          contentHtml+= "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Buluşunuza ilişkin dava/takip masrafı yapıldıysa dava/takip masraflarının toplamı ne kadardır?</td>\n";
      if (valuationPatentEntity.getCaseexpense() != null){
        contentHtml += "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getCaseexpense()+"</td>\n";
      }else {
        contentHtml +="<td style=\"width: 70%;border: 1px solid black;\"></td>\n";
      }

          contentHtml+= "</tr>\n"
          + "</table>\n"
          + "</div>\n"
          + "<h3 style=\"font-weight: bold;color: white;background-color: #d32f2f\">TESCİLE İLİŞKİN BİLGİLER</h3>\n"
          + "<div>\n"
          + "<table>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Türkiye dışındaki ülkelerde münferiden buluşunuza ait bir başvurunuz/tesciliniz bulunmakta mıdır?</td>\n";
      if (valuationPatentEntity.getCountryoutside() != null){
        contentHtml += "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getCountryoutside()+"</td>\n";
      }else {
        contentHtml +="<td style=\"width: 70%;border: 1px solid black;\"></td>\n";
      }

          contentHtml+= "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Buluşunuza ilişkin Avrupa birliği patent, PCT ya da Benelux ülkelerine ilişkin bölgesel patent başvuru bulunmakta mıdır?</td>\n";
      if (valuationPatentEntity.getEuropeanunio() != null){
        contentHtml += "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getEuropeanunio()+"</td>\n";
      }else {
        contentHtml +="<td style=\"width: 70%;border: 1px solid black;\"></td>\n";
      }


          contentHtml+= "</tr>\n"
          + "</table>\n"
          + "</div>\n";

      helper.setText(contentHtml, true);
      helper.setSubject("Patent Değerleme Talebi"+"("+valuationPatentEntity.getTrackingNumber()+")");

    } else if (servicesType == 4) {
      ValuationTrademarkEntity valuationTrademarkEntity = valuationTrademarkRepository.getById(id);
      trackingNumber = valuationTrademarkEntity.getTrackingNumber();
//      helper.addAttachment("dekont.jpeg", new ByteArrayResource(valuationTrademarkEntity.getDekont()));
      String contentHtml="<h1 style=\"font-weight: bold;color: white;background-color: #d32f2f\">Marka Değerleme Talebi </h1>\n"
          + "<br>\n"
          + "<h3 style=\"font-weight: bold;color: white;background-color: #d32f2f\">BAŞVURU SAHİBİ </h3>\n"
          + "<div style=\"font-weight: bold;color: white;background-color: #6c757d\">Ad Soyad/Ticaret Unvanı</div>\n"
          + "<div>"+valuationTrademarkEntity.getName_surname()+"</div>\n"
          + "<div style=\"font-weight: bold;color: white;background-color: #6c757d\">T.C. Kimlik No/Vergi D./Vergi No</div>\n"
          + "<div>"+valuationTrademarkEntity.getTc()+"</div>\n"
          +"<div style=\"font-weight: bold;color: white;background-color: #6c757d\">İletişim Kurulacak Kişi (Talepte Bulunan Tüzel Kişi ise)</div>\n";
      if (valuationTrademarkEntity.getLegalPerson() != null) {
        contentHtml += "<div>" + valuationTrademarkEntity.getLegalPerson() + "</div>\n";
      }else {
        contentHtml += "<div></div>\n";
      }
      contentHtml += "<div style=\"font-weight: bold;color: white;background-color: #6c757d\"> Adres</div>\n"
          + "<div>"+valuationTrademarkEntity.getAddress()+"</div>\n"
          + "<div style=\"font-weight: bold;color: white;background-color: #6c757d\">Telefon</div>\n"
          + "<div>"+valuationTrademarkEntity.getTel()+"</div>\n"
          + "<div style=\"font-weight: bold;color: white;background-color: #6c757d\">E-posta</div>\n"
          + "<div>"+valuationTrademarkEntity.getEmail()+"</div>\n"
          + "<h3 style=\"font-weight: bold;color: white;background-color: #d32f2f\">MARKAYA İLİŞKİN GENEL BİLGİLER</h3>\n"
          + "<div>\n"
          + "<table>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Marka Başvuru Numarası </td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationTrademarkEntity.getValuationTrademarkAppNo()+"</td>\n"
          + "</tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Marka değerlenmesi talebinizdeki amacınız nedir?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationTrademarkEntity.getTrademarkpurpose()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Değerlenmesi istenen markanın diğer markalarınızla ortak kullanımı/ilişkisi bulunmakta mıdır? Eğer bulunmakta ise değerlenmesi istenen marka hakim marka konumunda mıdır?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationTrademarkEntity.getCommonusage()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Markanızı hangi ülke/ülkelerde kullanmakta/kullanmayı amaçlamaktasınız?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationTrademarkEntity.getTargetcountry()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Markanızı ne kadar süre kullanmayı planlamaktasınız?</td>\n";
          if(valuationTrademarkEntity.getTrademarktime() != null) {
            contentHtml+="<td style=\"width: 70%;border: 1px solid black;\">" + valuationTrademarkEntity.getTrademarktime() + "</td>\n";
          } else{
            contentHtml+="<td style=\"width: 70%;border: 1px solid black;\"></td>\n";
          }
          contentHtml+= "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Değerlenmesi amaçlanan marka ilk defa piyasaya ne zaman sürülmüştür?</td>\n";
      if(valuationTrademarkEntity.getMarkettime() != null) {
        contentHtml+="<td style=\"width: 70%;border: 1px solid black;\">" + valuationTrademarkEntity.getMarkettime() + "</td>\n";
      } else{
        contentHtml+="<td style=\"width: 70%;border: 1px solid black;\"></td>\n";
      }
        contentHtml+= "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Müşterilerin marka adı altında satılan ürünü/hizmeti talep etmesinde markanızın katkısı ne kadardır?(Lütfen tahmini bir yüzde belirtiniz.)</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationTrademarkEntity.getTrademarkcontribution()+"</td>\n"
          + "</tr>\n"
          + "</table>\n"
          + "</div>\n"
          + "<h3 style=\"font-weight: bold;color: white;background-color: #d32f2f\">SEKTÖRE İLİŞKİN BİLGİLER</h3>\n"
          + "<div>\n"
          + "<table>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Markanızın aktif olarak satışa konu olduğu ana sektör nedir?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationTrademarkEntity.getMainsector()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Markanızın aktif olarak satışa konu olduğu diğer sektörler varsa nelerdir?</td>\n";

      if(valuationTrademarkEntity.getOthersector() != null) {
        contentHtml+="<td style=\"width: 70%;border: 1px solid black;\">" + valuationTrademarkEntity.getOthersector() + "</td>\n";
      } else{
        contentHtml+="<td style=\"width: 70%;border: 1px solid black;\"></td>\n";
      }
         contentHtml += "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Değerlenmesi istenen markanızın pazar payı nedir?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationTrademarkEntity.getMarketshare()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Değerlenmesi istenen markanun yurtdışında pazar payı bulunmakta mıdır?</td>\n";
      if(valuationTrademarkEntity.getOverseasmarketshare() != null) {
        contentHtml+="<td style=\"width: 70%;border: 1px solid black;\">" + valuationTrademarkEntity.getOverseasmarketshare() + "</td>\n";
      } else{
        contentHtml+="<td style=\"width: 70%;border: 1px solid black;\"></td>\n";
      }
          contentHtml+= "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Yukarıdaki soruya 'Evet' cevabı vermeniz halinde, ihracat yapılan ülkeler hangileridir?</td>\n";
      if(valuationTrademarkEntity.getExportcountry() != null) {
        contentHtml+="<td style=\"width: 70%;border: 1px solid black;\">" + valuationTrademarkEntity.getExportcountry() + "</td>\n";
      } else{
        contentHtml+="<td style=\"width: 70%;border: 1px solid black;\"></td>\n";
      }
          contentHtml+= "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">İhracat yapılan ülkelerden sağlanan gelirlerin toplam gelir içerisindeki yüzdeleri nelerdir?</td>\n";
      if(valuationTrademarkEntity.getTurnoverpercent() != null) {
        contentHtml+="<td style=\"width: 70%;border: 1px solid black;\">" + valuationTrademarkEntity.getTurnoverpercent() + "</td>\n";
      } else{
        contentHtml+="<td style=\"width: 70%;border: 1px solid black;\"></td>\n";
      }
         contentHtml += "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">•\tSektörde en başarılı rakip marka/markalar kimlerdir? Bu rakip/rakiplere ait pazar payı tahmininiz nedir?</td>\n";
      if(valuationTrademarkEntity.getCompetingmarketshare() != null) {
        contentHtml+="<td style=\"width: 70%;border: 1px solid black;\">" + valuationTrademarkEntity.getCompetingmarketshare() + "</td>\n";
      } else{
        contentHtml+="<td style=\"width: 70%;border: 1px solid black;\"></td>\n";
      }
         contentHtml += "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">•\tSektördeki en başarılı rakip/rakiplerinizin piyasaya giriş tarihi nedir?</td>\n";
      if(valuationTrademarkEntity.getMarkethistory() != null) {
        contentHtml+="<td style=\"width: 70%;border: 1px solid black;\">" + valuationTrademarkEntity.getMarkethistory() + "</td>\n";
      } else{
        contentHtml+="<td style=\"width: 70%;border: 1px solid black;\"></td>\n";
      }
      contentHtml += "</tr>\n"
          + "</table>\n"
          + "</div>\n"
          + "<h3 style=\"font-weight: bold;color: white;background-color: #d32f2f\">BÜYÜME TAHMİNLERİ/PROJEKSİYONLARI</h3>\n"
          + "<div>\n"
          + "<table>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">•\tÖnümüzdeki 5 yılda gelirlerinizde hedeflediğiniz artış oranı nedir?</td>\n";
      if(valuationTrademarkEntity.getTurnovertarget() != null) {
        contentHtml+="<td style=\"width: 70%;border: 1px solid black;\">" + valuationTrademarkEntity.getTurnovertarget() + "</td>\n";
      } else{
        contentHtml+="<td style=\"width: 70%;border: 1px solid black;\"></td>\n";
      }
      contentHtml += "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">•\tDeğerlenmesi istenen marka adı altında "
          + "satılan ürün/sunulan hizmetlerden sağlanan gelirlerin, toplam gelirleriniz içerisindeki yüzdesi nedir?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationTrademarkEntity.getTrademarkturnoverpercent()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">•\tÖnümüzdeki 5 yılda değerlenmesi istenen markanın sağladığı gelirlerin tahmini artış yüzdesi nedir?</td>\n";
      if(valuationTrademarkEntity.getIncomeincreasepercent() != null) {
        contentHtml+="<td style=\"width: 70%;border: 1px solid black;\">" + valuationTrademarkEntity.getIncomeincreasepercent() + "</td>\n";
      } else{
        contentHtml+="<td style=\"width: 70%;border: 1px solid black;\"></td>\n";
      }
      contentHtml += "</tr>\n"
          + "</table>\n"
          + "</div>\n"
          + "<h3 style=\"font-weight: bold;color: white;background-color: #d32f2f\">MARKANIZA İLİŞKİN SÖZLEŞMELER</h3>\n"
          + "<div>\n"
          + "<table>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Markanıza ilişkin lisans sözleşmesi yapılmış mıdır? Yapıldıysa kaç adet lisans verilmiştir?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">";
      if(valuationTrademarkEntity.getLicenseChoose().equals("1")){
          contentHtml+="Evet\n";
      }else {
        contentHtml+="Hayır\n";
      }
          contentHtml+=valuationTrademarkEntity.getLicense()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Yukarıdaki soruya cevabınız \"Evet \" ise royalty oranı kaç olarak belirlenmiştir?</td>\n";
      if(valuationTrademarkEntity.getLicenseroyalt() != null) {
        contentHtml+="<td style=\"width: 70%;border: 1px solid black;\">" + valuationTrademarkEntity.getLicenseroyalt() + "</td>\n";
      } else{
        contentHtml+="<td style=\"width: 70%;border: 1px solid black;\"></td>\n";
      }
      contentHtml += "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Markanızın konu olduğu başka bir sözleşme var mıdır?(rehin, franchising vb.)</td>\n";
      if(valuationTrademarkEntity.getContract() != null) {
        contentHtml+="<td style=\"width: 70%;border: 1px solid black;\">" + valuationTrademarkEntity.getContract() + "</td>\n";
      } else{
        contentHtml+="<td style=\"width: 70%;border: 1px solid black;\"></td>\n";
      }
      contentHtml += "</tr>\n"
          + "</table>\n"
          + "</div>\n"
          + "<h3 style=\"font-weight: bold;color: white;background-color: #d32f2f\">TANITIM GİDERLERİNE İLİŞKİN BİLGİLER</h3>\n"
          + "<div>\n"
          + "<table>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Markanıza ilişkin reklam, sponsorluk, tanıtım kampanyası vs. yapılmış mıdır?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationTrademarkEntity.getAdvertisement()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Yukarıdaki soruya cevabınız \"Evet\" ise bu kapsamda yapılan harcamaların toplamı ne kadardır?(Lütfen yıl bazında gösteriniz.)?</td>\n";
      if(valuationTrademarkEntity.getTotalexpenditure() != null) {
        contentHtml+="<td style=\"width: 70%;border: 1px solid black;\">" + valuationTrademarkEntity.getTotalexpenditure() + "</td>\n";
      } else{
        contentHtml+="<td style=\"width: 70%;border: 1px solid black;\"></td>\n";
      }
      contentHtml += "</tr>\n"
          + "</table>\n"
          + "</div>\n"
          + "<h3 style=\"font-weight: bold;color: white;background-color: #d32f2f\">MARKA TESCİLİNE İLİŞKİN BİLGİLER</h3>\n"
          + "<div>\n"
          + "<table>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Türkiye dışındaki ülkelerde münferiden markanıza ait bir başvurunuz/tesciliniz bulunmakta mıdır?</td>\n";
      if(valuationTrademarkEntity.getCountryoutside() != null) {
        contentHtml+="<td style=\"width: 70%;border: 1px solid black;\">" + valuationTrademarkEntity.getCountryoutside() + "</td>\n";
      } else{
        contentHtml+="<td style=\"width: 70%;border: 1px solid black;\"></td>\n";
      }
      contentHtml += "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Markanıza ilişkin Avrupa birliği markası, Madrid Protokolü ya da Benelux ülkelerine ilişkin bölgesel marka başvurusu bulunmakta mıdır?</td>\n";
      if(valuationTrademarkEntity.getEuropeanunion() != null) {
        contentHtml+="<td style=\"width: 70%;border: 1px solid black;\">" + valuationTrademarkEntity.getEuropeanunion() + "</td>\n";
      } else{
        contentHtml+="<td style=\"width: 70%;border: 1px solid black;\"></td>\n";
      }
      contentHtml += "</tr>\n"
          + "</table>\n"
          + "</div>";

      helper.setText(contentHtml, true);
      helper.setSubject("Marka Değerleme Talebi"+"("+valuationTrademarkEntity.getTrackingNumber()+")");


    } else if (servicesType == 5) {

      ActivityAnalysisEntity activityAnalysisEntity = activityAnalysisRepository.getById(id);
      List<ActivityAnalysisPicturesEntity> activityAnalysisPicturesEntities = activityAnalysisPicturesRepository.getByActivityAnalysisId(id);
      trackingNumber = activityAnalysisEntity.getTrackingNumber();
      //helper.addAttachment("dekont.jpeg", new ByteArrayResource(activityAnalysisEntity.getDekont()));

      String[] relatedPicturesImg = null;
      if (activityAnalysisPicturesEntities.size()>0){
        ByteArrayDataSource[] relatedPictures = new ByteArrayDataSource[activityAnalysisPicturesEntities.size()];
        relatedPicturesImg = new String[activityAnalysisPicturesEntities.size()];

        for (int i=0;i<activityAnalysisPicturesEntities.size();i++){
          relatedPictures[i] = new ByteArrayDataSource(
              activityAnalysisPicturesEntities.get(i).getPicture(), activityAnalysisPicturesEntities.get(i).getFileType());
          String ilgiliResimIsim = attachmentNameControl("ilgiliGorsel"+i,activityAnalysisPicturesEntities.get(i).getFileType());
          helper.addAttachment(ilgiliResimIsim, relatedPictures[i]);
          relatedPicturesImg[i] = "<img src=\"cid:"+ilgiliResimIsim+"\"></img><br/>";

        }
      }

      String contentHtml="<h1 style=\"font-weight: bold;color: white;background-color: #d32f2f\">Faaliyet Serbestliği Analizi </h1>\n"
          +"<br>"
          + "<h3 style=\"font-weight: bold;color: white;background-color: #d32f2f\">1. BAŞVURU SAHİBİ </h3>\n"
          + "<div style=\"font-weight: bold;color: white;background-color: #6c757d\">Ad Soyad/Ticaret Unvanı</div>\n"
          + "<div>"+activityAnalysisEntity.getName_surname()+"</div>\n"
          + "<div style=\"font-weight: bold;color: white;background-color: #6c757d\">T.C. Kimlik No/Vergi D./Vergi No</div>\n"
          + "<div>"+activityAnalysisEntity.getTc()+"</div>\n"
          +"<div style=\"font-weight: bold;color: white;background-color: #6c757d\">letişim Kurulacak Kişi "
          + "(Talepte Bulunan Tüzel Kişi ise)</div>\n";
      if (activityAnalysisEntity.getLegalPerson() != null) {
        contentHtml+="<div>" + activityAnalysisEntity.getLegalPerson() + "</div>\n";
      }else {
        contentHtml+= "<div></div>\n";
      }
          contentHtml+= "<div style=\"font-weight: bold;color: white;background-color: #6c757d\"> Adres</div>\n"
          + "<div>"+activityAnalysisEntity.getAddress()+"</div>\n"
          + "<div style=\"font-weight: bold;color: white;background-color: #6c757d\">Telefon</div>\n"
          + "<div>"+activityAnalysisEntity.getTel()+"</div>\n"
          + "<div style=\"font-weight: bold;color: white;background-color: #6c757d\">E-posta</div>\n"
          + "<div>"+activityAnalysisEntity.getEmail()+"</div>\n"
          + "<h3 style=\"font-weight: bold;color: white;background-color: #d32f2f\">2. ÜRÜNE/YÖNTEME İLİŞKİN BİLGİLER </h3>\n"
              +"<h4 style=\"font-weight: bold;color: white;background-color: #000\">2.1 ANAHTAR KELİME ÖNERİLERİ  </h4><span>(Türkçe/İngilizce)</span>\n";
              if(activityAnalysisEntity.getKeyWord() != null) {
                contentHtml+= "<div>" + activityAnalysisEntity.getKeyWord() + "</div>\n";
              }else {
                contentHtml+= "<div></div>\n";
              }
      contentHtml += "<h4 style=\"font-weight: bold;color: white;background-color: #000\">2.2 TEKNİĞİN BİLİNEN DURUMUNDA YER ALAN UYGULAMALAR  </h4><span>(Mevcutta var olan uygulamalar, patent, makale, internet siteleri, youtube videoları vb. görsel ve yazılı kaynakları ve muhtemel rakipleri belirtiniz.)\n"
          + "</span>\n";
      if(activityAnalysisEntity.getOpponent() != null) {
        contentHtml+= "<div>" + activityAnalysisEntity.getOpponent() + "</div>\n";
      }else {
        contentHtml+= "<div></div>\n";
      }
          contentHtml+= "<h4 style=\"font-weight: bold;color: white;background-color: #000\">2.3. ÜRÜNÜN/YÖNTEMİN AYRINTILI AÇIKLAMASI </h4><span>(Faaliyet serbestliği araştırmasına konu bir ürün ise, bu ürünün içerdiği parçaları, bu parçaların işlevlerinin anlatılması gerekmektedir. Eğer faaliyet serbestliğine konu olan bir yöntem ise, bu yöntemin her bir adımının ve bu adımların gerçekleştirilmesi için kullanılan teknik unsurların açıklanması gerekmektedir.)\n"
          + "</span>\n"
          + "<div>"+activityAnalysisEntity.getTechnicalcomponent()+"</div>\n"
          + "<h3 style=\"font-weight: bold;color: white;background-color: #d32f2f\">3. ÜRÜN/YÖNTEM İLE İLGİLİ GÖRSELLER</h3><span>(Faaliyet serbestliği araştırmasına konu bir sistem/aparat/ürün/mekanizma olması durumunda buluşa ilişkin görsellerin eklenmesi önerilmektedir.)</span>\n"
          +"<div>" + activityAnalysisEntity.getImage() + "</div>\n";;
      if (activityAnalysisPicturesEntities.size() > 0) {
        for (int i = 0; i < relatedPicturesImg.length; i++) {
          contentHtml += "<div>" + relatedPicturesImg[i] + "</div>\n"
              + "<br>\n";
        }
      }
          contentHtml+= "<h3 style=\"font-weight: bold;color: white;background-color: #d32f2f\">4. BELİRTMEK İSTEDİĞİNİZ DİĞER HUSUSLAR</h3><span>(Ürününüze/yönteminize ilişkin araştırmamıza katkı sağlayacağını düşündüğünüz başka hususlar varsa belirtiniz.)</span>\n"
          + "<div>"+activityAnalysisEntity.getOtherpoint()+"</div>";

      helper.setText(contentHtml, true);
      helper.setSubject("Faaliyet Serbestliği Analizi"+"("+activityAnalysisEntity.getTrackingNumber()+")");

    } else if (servicesType == 6) {
      InvalidationAssessmentEntity invalidationAssessmentEntity= invalidationAssessmentRepository.getById(id);
      trackingNumber = invalidationAssessmentEntity.getTrackingNumber();
      try {

        String contentHtml = "<h1 style=\"font-weight: bold;color: white;background-color: #d32f2f\">Sınai Mülkiyet Varlıkları Hükümsüzlük Analizi </h1>\n"
            + "<div style=\"font-weight: bold;color: white;background-color: #6c757d\">Ad Soyad/Ticaret Unvanı</div>\n"
            + "<div>" + invalidationAssessmentEntity.getName_surname() + "</div>\n"
            + "<div style=\"font-weight: bold;color: white;background-color: #6c757d\">T.C. Kimlik No/Vergi D./Vergi No</div>\n"
            + "<div>" + invalidationAssessmentEntity.getTc() + "</div>\n"
            + "<div style=\"font-weight: bold;color: white;background-color: #6c757d\"> Adres</div>\n"
            + "<div>" + invalidationAssessmentEntity.getAddress() + "</div>\n"
            + "<div style=\"font-weight: bold;color: white;background-color: #6c757d\">Telefon</div>\n"
            + "<div>" + invalidationAssessmentEntity.getTel() + "</div>\n"
            + "<div style=\"font-weight: bold;color: white;background-color: #6c757d\">E-posta</div>\n"
            + "<div>" + invalidationAssessmentEntity.getEmail() + "</div>\n"
            + "<div style=\"font-weight: bold;color: white;background-color: #6c757d\">Hükümsüzlük Analizine Konu Patent/Faydalı Modelin Başvuru Numarası</div>\n"
            + "<div>" + invalidationAssessmentEntity.getAppNo() + "</div>\n";

        helper.setText(contentHtml, true);
        helper.setSubject("Sınai Mülkiyet Varlıkları Hükümsüzlük Analizi"+"("+invalidationAssessmentEntity.getTrackingNumber()+")");

      } catch (MessagingException e){
        e.getLocalizedMessage();
      }



    }

    helper.setTo("test@turksmd.com.tr");
    helper.setFrom("test@turksmd.com.tr");
    emailSender.send(message);
    return trackingNumber;
  }

  public String attachmentNameControl(String attachmentName, String attachmentContentType){
    if (attachmentContentType.equals("image/jpeg")){
      return attachmentName+".jpg";
    } else if (attachmentContentType.equals("image/png")){
      return attachmentName+".png";
    } else if (attachmentContentType.equals("application/pdf")){
      return attachmentName+".pdf";
    }
    return "";
  }
}
