package tr.com.tsmd.cengiz.service;

import com.sun.istack.ByteArrayDataSource;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.List;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import tr.com.tsmd.cengiz.entity.ActivityAnalysisEntity;
import tr.com.tsmd.cengiz.entity.ActivityAnalysisPicturesEntity;
import tr.com.tsmd.cengiz.entity.PatentPreEntity;
import tr.com.tsmd.cengiz.entity.PatentPreRelatedPicturesEntity;
import tr.com.tsmd.cengiz.entity.PatentPreTableEntity;
import tr.com.tsmd.cengiz.entity.TrademarkPreEntity;
import tr.com.tsmd.cengiz.entity.ValuationPatentEntity;
import tr.com.tsmd.cengiz.entity.ValuationTrademarkEntity;
import tr.com.tsmd.cengiz.repository.ActivityAnalysisPicturesRepository;
import tr.com.tsmd.cengiz.repository.ActivityAnalysisRepository;
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
  public void sendMimeMessage(Long id, Integer servicesType) throws MessagingException {
    MimeMessage message = emailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message,
        MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
        StandardCharsets.UTF_8.name());
    if (servicesType == 1) {
      TrademarkPreEntity trademarkPreEntity= trademarkPreRepository.getById(id);
      try {
        ByteArrayDataSource bds = new ByteArrayDataSource(trademarkPreEntity.getTrademarkimagebyte(), "image/jpeg");

        helper.addAttachment("marka_ornegi.jpeg", bds);
        String inlineImage = "<img src=\"cid:marka_ornegi.jpeg\"></img><br/>";
        helper.addAttachment("dekont.jpeg", new ByteArrayResource(trademarkPreEntity.getDekont()));
        String contentHtml="<h1 style=\"font-weight: bold;color: white;background-color: #d32f2f\">Marka Ön Araştırma Raporu </h1>\n"
            + "<div style=\"font-weight: bold;color: white;background-color: #6c757d\">Ad Soyad/Ticaret Unvanı</div>\n"
            + "<div>"+trademarkPreEntity.getName_surname()+"</div>\n"
            + "<div style=\"font-weight: bold;color: white;background-color: #6c757d\">T.C. Kimlik No/Verdi D./Vergi No</div>\n"
            + "<div>"+trademarkPreEntity.getTc()+"</div>\n"
            + "<div style=\"font-weight: bold;color: white;background-color: #6c757d\"> Adres</div>\n"
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

        contentHtml+= "<div style=\"font-weight: bold;color: white;background-color: #6c757d\">Marka Örneği</div>\n"
            + "<div>"+inlineImage+"</div>\n"
            + "<div style=\"font-weight: bold;color: white;background-color: #6c757d\">Marka Yazılı İfade Edilişi</div>\n"
            + "<div>"+trademarkPreEntity.getTrademarktext()+"</div>\n"
            + "<div style=\"font-weight: bold;color: white;background-color: #6c757d\">Mal/Hizmet Sınıfları</div>\n"
            + "<div>"+trademarkPreEntity.getTrademarkclass()+"</div>";
        helper.setText(contentHtml, true);
        helper.setSubject("Marka Ön Araştırma Raporu Talebi");

      } catch (MessagingException e){
        e.getLocalizedMessage();
      }



    } else if (servicesType == 2) {
      PatentPreEntity patentPreEntity = patentPreRepository.getById(id);
      List<PatentPreTableEntity> patentPreTableEntity = patentPreTableRepository.getByPatentPreId(id);
      List<PatentPreRelatedPicturesEntity> patentPreRelatedPicturesEntities = patentPreRelatedPicturesRepository.getByPatentPreId(id);

      String[] relatedPicturesImg = null;
      if (patentPreRelatedPicturesEntities.size()>0){
        ByteArrayDataSource[] relatedPictures = new ByteArrayDataSource[patentPreRelatedPicturesEntities.size()];
         relatedPicturesImg = new String[patentPreRelatedPicturesEntities.size()];

         for (int i=0;i<patentPreRelatedPicturesEntities.size();i++){
           relatedPictures[i] = new ByteArrayDataSource(patentPreRelatedPicturesEntities.get(i).getPicture(), "image/jpeg");
           helper.addAttachment(i+".jpeg", relatedPictures[i]);
           relatedPicturesImg[i] = "<img src=\"cid:"+i+".jpeg\"></img><br/>";

         }
      }

      helper.addAttachment("dekont.jpeg", new ByteArrayResource(patentPreEntity.getDekont()));

      String contentHtml="<h1 style=\"font-weight: bold;color: white;background-color: #d32f2f\">Patent Ön Araştırma Raporu </h1>\n"
          +"<br>"
          + "<h3 style=\"font-weight: bold;color: white;background-color: #d32f2f\">1. BAŞVURU SAHİBİ </h3>\n"
          + "<div style=\"font-weight: bold;color: white;background-color: #6c757d\">Ad Soyad/Ticaret Unvanı</div>\n"
          + "<div>"+patentPreEntity.getName_surname()+"</div>\n"
          + "<div style=\"font-weight: bold;color: white;background-color: #6c757d\">T.C. Kimlik No/Verdi D./Vergi No</div>\n"
          + "<div>"+patentPreEntity.getTc()+"</div>\n"
          + "<div style=\"font-weight: bold;color: white;background-color: #6c757d\"> Adres</div>\n"
          + "<div>"+patentPreEntity.getAddress()+"</div>\n"
          + "<div style=\"font-weight: bold;color: white;background-color: #6c757d\">Telefon</div>\n"
          + "<div>"+patentPreEntity.getTel()+"</div>\n"
          + "<div style=\"font-weight: bold;color: white;background-color: #6c757d\">E-posta</div>\n"
          + "<div>"+patentPreEntity.getEmail()+"</div>\n"
          + "<div style=\"font-weight: bold;color: white;background-color: #6c757d\">İstenen Koruma Türü</div>\n";
      if (patentPreEntity.getProtectiontype() != null && patentPreEntity.getProtectiontype().equals("5")){
        contentHtml+= "<div>Standart</div>\n";
      }else if (patentPreEntity.getProtectiontype() != null && patentPreEntity.getProtectiontype().equals("6")){
        contentHtml+= "<div>Faydalı Model</div>\n";
      }else if (patentPreEntity.getProtectiontype() != null && patentPreEntity.getProtectiontype().equals("7")){
        contentHtml+= "<div>Rapor Sonrasında Belirleyeceğim</div>\n";
      }

          contentHtml+= "<div style=\"font-weight: bold;color: white;background-color: #6c757d\">Tercih Edilen Rapor Türü</div>\n";
      if (patentPreEntity.getReporttype() != null && patentPreEntity.getReporttype().equals("8")){
        contentHtml+= "<div>Standart</div>\n";
      }else if (patentPreEntity.getReporttype() != null && patentPreEntity.getReporttype().equals("9")){
        contentHtml+= "<div>Detaylı</div>\n";
      }

          contentHtml+= "<div style=\"font-weight: bold;color: white;background-color: #6c757d\">Buluşun İlgili Olduğu Teknik Alan/Alanlar</div>\n";
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

       contentHtml+= "<h3 style=\"font-weight: bold;color: white;background-color: #d32f2f\">2. BULUŞA İLİŞKİN BİLGİLER </h3>\n"
           +"<br>"
          + "<h4 style=\"font-weight: bold;color: white;background-color: #000\">2.1 BULUŞ BAŞLIĞI </h4><span>(Birkaç kelime ile buluşu kısaca tanımlayan bir başlık yazınız.)</span>\n"
          + "<div>"+patentPreEntity.getTitle()+"</div>\n"
          + "<h4 style=\"font-weight: bold;color: white;background-color: #000\">2.2 ANAHTAR KELİME ÖNERİLERİ </h4><span>(Türkçe/İngilizce)</span>\n"
          + "<div>"+patentPreEntity.getPatentkeyword()+"</div>\n"
          + "<h4 style=\"font-weight: bold;color: white;background-color: #000\">2.3. TEKNİĞİN BİLİNEN DURUMUNDA YER ALAN UYGULAMALAR</h4><span>(Mevcutta var olan uygulamalar, patent, makale, internet siteleri, youtube videoları vb. görsel ve yazılı kaynakları belirtiniz.)</span>\n"
          + "<div>"+patentPreEntity.getPatentapplication()+"</div>\n"
          + "<h4 style=\"font-weight: bold;color: white;background-color: #000\">2.4. BULUŞUN SAĞLADIĞI AVANTAJLAR</h4><span>(Buluşun sağladığı kolaylıkları, iyileştirmeleri, teknik soruna çözümleri belirtiniz.)</span>\n"
          + "<div>"+patentPreEntity.getAdvantage()+"</div>\n"
          + "<h4 style=\"font-weight: bold;color: white;background-color: #000\">2.5. TARAFINIZCA YAPILMIŞ / YAPILMASI PLANLANAN YAYINLAR*</h4><span>(Buluşun sözlü ya da yazılı açıklaması daha önce bir yerde yapıldı ise lütfen belirtiniz. Örneğin; makale, haber, sergi, youtube vb. Bu kısımla ilgili kılavuzu incelemeniz önem arz etmektedir.)</span>\n"
          + "<div>"+patentPreEntity.getPublications()+"</div>\n"
          + "<h3 style=\"font-weight: bold;color: white;background-color: #d32f2f\">3. BULUŞUN AYRINTILI AÇIKLAMASI</h3>\n"
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
          contentHtml+= "<h4 style=\"font-weight: bold;color: white;background-color: #000\">3.2. BULUŞUN AYRINTILI AÇIKLAMASI*</h4>\n"
          + "<div>"+patentPreEntity.getDetailexplain()+"</div>\n"
          + "<h3 style=\"font-weight: bold;color: white;background-color: #d32f2f\">4. BULUŞLA İLGİLİ GÖRSELLER</h3>\n"
          + "<div>(Buluşunuzun özellikle bir sistem/aparat/ürün/mekanizma olması durumunda buluşa ilişkin görsellerin eklenmesi önerilmektedir.)</div>\n"
          +"<div>" + patentPreEntity.getPicture() + "</div>\n";

           if (patentPreRelatedPicturesEntities.size()>0) {
             for (int i=0;i<relatedPicturesImg.length;i++) {
               contentHtml += "<div>" + relatedPicturesImg[i] + "</div>\n"
                   +"<br>\n";
             }
           }
          contentHtml+= "<h3 style=\"font-weight: bold;color: white;background-color: #d32f2f\">5. BELİRTMEK İSTEDİĞİNİZ DİĞER HUSUSLAR</h3>\n"
          + "<div>(Buluşunuza ilişkin araştırmamıza katkı sağlayacağını düşündüğünüz başka hususlar varsa belirtiniz.)</div>\n"
          + "<div>"+patentPreEntity.getOtherpoint()+"</div>\n";

      helper.setText(contentHtml, true);
      helper.setSubject("Patent Ön Araştırma Raporu Talebi");


    } else if (servicesType == 3) {
      ValuationPatentEntity valuationPatentEntity = valuationPatentRepository.getById(id);
//      helper.addAttachment("dekont.jpeg", new ByteArrayResource(valuationPatentEntity.getDekont()));
      String contentHtml="<h1 style=\"font-weight: bold;color: white;background-color: #d32f2f\">Patent Değerleme Talep Formu </h1>\n"
          + "<br>\n"
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
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Değerlenmesi istenen patentin dosya numarası nedir?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getPatentappno()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Buluşunuzu hangi ülkede ve ne amaçla kullanıyorsunuz/kullanmayı amaçlamaktasınız?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getPatentcountry()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Değerlemesi amaçlanan buluş ilk defa piyasaya ne zaman sürülmüştür?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getPatentmarket()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Uzun vadede buluşunuzun gelirlerinizdeki katkısı ne kadar olacaktır?(Tahmini bir yüzde belirtiniz.)</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getPatentcontribution()+"</td>\n"
          + "</tr>\n"
          + "</table>\n"
          + "</div>\n"
          + "<h3 style=\"font-weight: bold;color: white;background-color: #d32f2f\">BULUŞA İLİŞKİN SEKTÖR BİLGİLERİ</h3>\n"
          + "<div>\n"
          + "<table>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Buluşunuzun aktif olarak satışa konu olduğu ana sektör nedir?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getPatentsector()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Buluşunuzun aktif olarak satışa konu olduğu diğer sektörler varsa nelerdir?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getPatentothersector()+"</td></tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Değerlenmesi istenen buluşun pazar payı nedir?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getMarketshare()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Değerlenmesi istenen buluşun sağladığı ciro, toplam gelirinizde diğer buluşların sağladığı cirodan ayırt edilemiyorsa, değerlenmesi istenen buluşun toplam ciro içerisinde yüzdesi nedir?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getPercentageturnover()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Değerlenmesi istenen buluşun yurtdışında pazar payı bulunmakta mıdır?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getOverseasmarketshare()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Yukarıdaki soruya 'Evet' cevabı vermeniz halinde, ihracaat yapılan ülkeler hangileridir?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getExportcountry()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">İhracaat yapılan ülkelerden sağlanan gelirlerin toplam ciro içerisindeki yüzdeleri nelerdir?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getExportturnover()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Buluşunuzun ait olduğu sektörde royalty oranları yüzde kaç olmaktadır?(Bilginiz olması halinde lütfen belirtiniz.)</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getRoyaltyrate()+"</td>\n"
          + "</tr>\n"
          + "</table>\n"
          + "</div>\n"
          + "<h3 style=\"font-weight: bold;color: white;background-color: #d32f2f\">PAZARA İLİŞKİN BİLGİLER</h3>\n"
          + "<div>\n"
          + "<table>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Sektördeki en \"eski\" başarılı rakibinizin pazar payı tahmini nedir?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getCompetingmarketshare()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Sektördeki en \"eski\" başarılı rakibinizin ilk piyasaya çıkış tarihi nedir?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getCompetitordate()+"</td></tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">\"En başarılı rakibnizin\" son 4 yıl gelirindeki ortalama yıllık büyüme oranı tahmininiz nedir?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getCompetinggrowthrate()+"</td>\n"
          + "</tr>\n"
          + "</table>\n"
          + "</div>\n"
          + "<h3 style=\"font-weight: bold;color: white;background-color: #d32f2f\">BÜYÜME TAHMİNLERİ/PROJEKSİYONLARI\n"
          + "</h3>\n"
          + "<div>\n"
          + "<table>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Önümüzdeki beş yılda ciro artışı hedefiniz nedir?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getTurnovertarget()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Değerlenmesi istenen buluşun ciro içerisindeki yüzdesi nedir?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getTurnoverpercent()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Değerlenmesi istenen buluşun gelir artışı yüzdesi nedir?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getIncomepercent()+"</td>\n"
          + "</tr>\n"
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
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Yukarıdaki soruya cevabınız \"Evet \" ise royalty oranı kaç olarak belirlenmiştir?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getLicenseroyalt()+"</td></tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Buluşunuzun konu olduğu başka bir sözleşme var mıdır?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getContract()+"</td>\n"
          + "</tr>\n"
          + "</table>\n"
          + "</div>\n"
          + "<h3 style=\"font-weight: bold;color: white;background-color: #d32f2f\">TANITIM GİDERLERİNE İLİŞKİN BİLGİLER</h3>\n"
          + "<div>\n"
          + "<table>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Buluşunuza ilişkin reklam, sponsorluk, tanıtım kampanyası vs. yapılmış mıdır?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getAdvertisement()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Yukarıdaki soruya cevabınız \"Evet\" ise bu kapsamda ypaılan harcamaların toplamı ne kadardır?(Lütfen yıl bazında gösteriniz.)?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getTotalexpenditure()+"</td>\n"
          + "</tr>\n"
          + "</table>\n"
          + "</div>\n"
          + "<h3 style=\"font-weight: bold;color: white;background-color: #d32f2f\">MALİYETLERE İLİŞKİN BİLGİLER</h3>\n"
          + "<div>\n"
          + "<table>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Buluşunuzun ortaya çıkması için yapılan harcamaların toplamı ne kadardır?(Fiziksel sermaye ve beşeri sermaye ayrımı kapsamında karşılaştırarak belirtiniz.)</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getSpending()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Buluşu geliştrimek için yapılan harcamaların toplamı ne kadardır?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getDevelopmentspending()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Buluşun tescili için tüm dünya genelinde yapılan başvurularınız kapsamında yaptığınız toplam harcama ne kadarıdır?(Başvuru ve yıllık aidatları ayrı ayrı belirtiniz.)</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getWorldspending()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Buluşunuza ilişkin yspmış olduğunuz dava ya da takip masrafı (varsa) ne kadardır?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getCaseexpense()+"</td>\n"
          + "</tr>\n"
          + "</table>\n"
          + "</div>\n"
          + "<h3 style=\"font-weight: bold;color: white;background-color: #d32f2f\">TESCİLE İLİŞKİN BİLGİLER</h3>\n"
          + "<div>\n"
          + "<table>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Türkiye dışındaki ülkelerde münferiden buluşunuza ait bir başvurunuz/tesciliniz bulunmakta mıdır?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getCountryoutside()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Buluşunuza ilişkin Avrupa birliği patent, PCT ya da Benelux ülkelerine ilişkin bölgesel patent başvuru bulunmakta mıdır?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationPatentEntity.getEuropeanunio()+"</td>\n"
          + "</tr>\n"
          + "</table>\n"
          + "</div>\n";

      helper.setText(contentHtml, true);
      helper.setSubject("Patent Değerleme Talebi");

    } else if (servicesType == 4) {
      ValuationTrademarkEntity valuationTrademarkEntity = valuationTrademarkRepository.getById(id);
//      helper.addAttachment("dekont.jpeg", new ByteArrayResource(valuationTrademarkEntity.getDekont()));
      String contentHtml="<h1 style=\"font-weight: bold;color: white;background-color: #d32f2f\">Marka Değerleme Talep Formu </h1>\n"
          + "<br>\n"
          + "<h3 style=\"font-weight: bold;color: white;background-color: #d32f2f\">MARKAYA İLİŞKİN GENEL BİLGİLER</h3>\n"
          + "<div>\n"
          + "<table>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">MARKA HAKKI SAHİBİ/ADRESİ</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationTrademarkEntity.getAddress()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Markanızın tescilli olduğu ürün/hizmet sınıfları hangileridir?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationTrademarkEntity.getTrademarkclass()+"</td></tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Marka değerlenmesi talebinizdeki amacınız nedir?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationTrademarkEntity.getTrademarkpurpose()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Değerlenmesi istenen markanın tescil tarihi nedir?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationTrademarkEntity.getRegistrationdate()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Değerlemesi istenen markanın diğer markalarınızla ortak kullanımı/ilişkisi bulunmakta mıdır?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationTrademarkEntity.getCommonusage()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Yukarıdaki soruya \"Evet\" cebanı vermeniz halinde, değerlenmesi istenen marka hakim marka mıdır?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationTrademarkEntity.getDominanttrademark()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Markanızı hangi ülkede ve ne amaçla kullanuyorsunuz/kullanmayı amaçlamktasınız?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationTrademarkEntity.getTargetcountry()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Markanızı ne kadar süre kullanmayı planlamaktasınız?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationTrademarkEntity.getTrademarktime()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Değerlenmesi amaçlanan marka ilk defa piyasaya ne zaman sürülmüştür?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationTrademarkEntity.getMarkettime()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Müşterilerin marka adı altında satılan ürünü/hizmeti talep etmesinde markanızın katkısı ne kadardır?(Lütfen tahmini bir yüzde belirtiniz.)</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationTrademarkEntity.getTrademarkcontribution()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Uzun vadede markanızın gelirlerinizdeki katkısı (ürün/hizmete gelen talep haricinde) ne kadar olacaktır?(Tahmini bir yüzde belirtiniz.)</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationTrademarkEntity.getIncomepercent()+"</td>\n"
          + "</tr>\n"
          + "</table>\n"
          + "</div>\n"
          + "<h3 style=\"font-weight: bold;color: white;background-color: #d32f2f\">MARKAYA İLİŞKİN SEKTÖR BİLGİLERİ</h3>\n"
          + "<div>\n"
          + "<table>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Markanızın aktif olarak satışa konu olduğu ana sektör nedir?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationTrademarkEntity.getMainsector()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Markanızın aktif olarak satışa konu olduğu diğer sektörler varsa nelerdir?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationTrademarkEntity.getOthersector()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Değerlenmesi istenen markanızın pazar payı nedir?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationTrademarkEntity.getMarketshare()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Değerlenmesi istenen markanın sağladığı ciro, toplam gelirinizde diğer markaların sağladığı cirodan ayırt edilemiyorsa, değerlenmesi istenen markanın toplam ciro içerisinde yüzdesi nedir?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationTrademarkEntity.getTotalturnover()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Değerlenmesi istenen markanun yurtdışında pazar payı bulunmakta mıdır?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationTrademarkEntity.getOverseasmarketshare()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Yukarıdaki soruya 'Evet' cevabı vermeniz halinde, ihracaat yapılan ülkeler hangileridir?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationTrademarkEntity.getExportcountry()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">İhracaat yapılan ülkelerden sağlanan gelirlerin toplam ciro içerisindeki yüzdeleri nelerdir?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationTrademarkEntity.getTurnoverpercent()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Markanızın ait olduğu sektörde royalty oranları yüzde kaç olmaktadır?(Bilginiz olması halinde lütfen belirtiniz.)</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationTrademarkEntity.getPercentroyalt()+"</td>\n"
          + "</tr>\n"
          + "</table>\n"
          + "</div>\n"
          + "<h3 style=\"font-weight: bold;color: white;background-color: #d32f2f\">PAZARA İLİŞKİN BİLGİLER</h3>\n"
          + "<div>\n"
          + "<table>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Sektördeki en \"eski\" başarılı rakip markanızın pazar payı tahmini nedir?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationTrademarkEntity.getCompetingmarketshare()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Sektördeki en \"eski\" başarılı rakip markanın ilk piyasaya çıkış tarihi nedir?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationTrademarkEntity.getMarkethistory()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">\"En başarılı rakip markanın\" son 4 yıl gelirlerindeki ortalama yıllık büyüme oranı tahmininiz nedir?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationTrademarkEntity.getGrowthrate()+"</td>\n"
          + "</tr>\n"
          + "</table>\n"
          + "</div>\n"
          + "<h3 style=\"font-weight: bold;color: white;background-color: #d32f2f\">BÜYÜME TAHMİNLERİ/PROJEKSİYONLARI</h3>\n"
          + "<div>\n"
          + "<table>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Önümüzdeki beş yılda ciro artışı hedefiniz nedir?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationTrademarkEntity.getTurnovertarget()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Değerlenmesi istenen markanın ciro içerisindeki yüzdesi nedir?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationTrademarkEntity.getTrademarkturnoverpercent()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Değerlenmesi istenen markanın gelir artışı yüzdesi nedir?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationTrademarkEntity.getIncomeincreasepercent()+"</td>\n"
          + "</tr>\n"
          + "</table>\n"
          + "</div>\n"
          + "<h3 style=\"font-weight: bold;color: white;background-color: #d32f2f\">MARKANIZA İLİŞKİN SÖZLEŞMELER</h3>\n"
          + "<div>\n"
          + "<table>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Markanıza ilişkin lisans sözleşmesi yapılmış mıdır? Yapıldıysa kaç adet lisans verilmiştir?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationTrademarkEntity.getLicense()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Yukarıdaki soruya cevabınız \"Evet \" ise royalty oranı kaç olarak belirlenmiştir?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationTrademarkEntity.getLicenseroyalt()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Markanızın konu olduğu başka bir sözleşme var mıdır?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationTrademarkEntity.getContract()+"</td>\n"
          + "</tr>\n"
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
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Yukarıdaki soruya cevabınız \"Evet\" ise bu kapsamda ypaılan harcamaların toplamı ne kadardır?(Lütfen yıl bazında gösteriniz.)?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationTrademarkEntity.getTotalexpenditure()+"</td>\n"
          + "</tr>\n"
          + "</table>\n"
          + "</div>\n"
          + "<h3 style=\"font-weight: bold;color: white;background-color: #d32f2f\">MARKA TESCİLİNE İLİŞKİN BİLGİLER</h3>\n"
          + "<div>\n"
          + "<table>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Türkiye dışındaki ülkelerde münferiden markanıza ait bir başvurunuz/tesciliniz bulunmakta mıdır?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationTrademarkEntity.getCountryoutside()+"</td>\n"
          + "</tr>\n"
          + "<tr>\n"
          + "<td style=\"font-weight: bold;color: white;background-color: #6c757d;width: 30%;\">Markanıza ilişkin Avrupa birliği markası, Madrid Protokolü ya da Benelux ülkelerine ilişkin bölgesel marka başvurusu bulunmakta mıdır?</td>\n"
          + "<td style=\"width: 70%;border: 1px solid black;\">"+valuationTrademarkEntity.getEuropeanunion()+"</td>\n"
          + "</tr>\n"
          + "</table>\n"
          + "</div>";

      helper.setText(contentHtml, true);
      helper.setSubject("Marka Değerleme Talebi");


    } else if (servicesType == 5) {

      ActivityAnalysisEntity activityAnalysisEntity = activityAnalysisRepository.getById(id);
      List<ActivityAnalysisPicturesEntity> activityAnalysisPicturesEntities = activityAnalysisPicturesRepository.getByActivityAnalysisId(id);
      helper.addAttachment("dekont.jpeg", new ByteArrayResource(activityAnalysisEntity.getDekont()));

      String[] relatedPicturesImg = null;
      if (activityAnalysisPicturesEntities.size()>0){
        ByteArrayDataSource[] relatedPictures = new ByteArrayDataSource[activityAnalysisPicturesEntities.size()];
        relatedPicturesImg = new String[activityAnalysisPicturesEntities.size()];

        for (int i=0;i<activityAnalysisPicturesEntities.size();i++){
          relatedPictures[i] = new ByteArrayDataSource(activityAnalysisPicturesEntities.get(i).getPicture(), "image/jpeg");
          helper.addAttachment(i+".jpeg", relatedPictures[i]);
          relatedPicturesImg[i] = "<img src=\"cid:"+i+".jpeg\"></img><br/>";

        }
      }

      String contentHtml="<h1 style=\"font-weight: bold;color: white;background-color: #d32f2f\">Faaliyet Serbestliği Analizi </h1>\n"
          +"<br>"
          + "<h3 style=\"font-weight: bold;color: white;background-color: #d32f2f\">1. BAŞVURU SAHİBİ </h3>\n"
          + "<div style=\"font-weight: bold;color: white;background-color: #6c757d\">Ad Soyad/Ticaret Unvanı</div>\n"
          + "<div>"+activityAnalysisEntity.getName_surname()+"</div>\n"
          + "<div style=\"font-weight: bold;color: white;background-color: #6c757d\">T.C. Kimlik No/Verdi D./Vergi No</div>\n"
          + "<div>"+activityAnalysisEntity.getTc()+"</div>\n"
          + "<div style=\"font-weight: bold;color: white;background-color: #6c757d\"> Adres</div>\n"
          + "<div>"+activityAnalysisEntity.getAddress()+"</div>\n"
          + "<div style=\"font-weight: bold;color: white;background-color: #6c757d\">Telefon</div>\n"
          + "<div>"+activityAnalysisEntity.getTel()+"</div>\n"
          + "<div style=\"font-weight: bold;color: white;background-color: #6c757d\">E-posta</div>\n"
          + "<div>"+activityAnalysisEntity.getEmail()+"</div>\n"
          + "<h3 style=\"font-weight: bold;color: white;background-color: #d32f2f\">2. ÜRÜNE/YÖNTEME İLİŞKİN BİLGİLER </h3>\n"
          + "<h4 style=\"font-weight: bold;color: white;background-color: #000\">2.1 ANAHTAR KELİME ÖNERİLERİ  </h4><span>(Türkçe/İngilizce)</span>\n"
          + "<div>"+activityAnalysisEntity.getKeyWord()+"</div>\n"
          + "<h4 style=\"font-weight: bold;color: white;background-color: #000\">2.2 TEKNİĞİN BİLİNEN DURUMUNDA YER ALAN UYGULAMALAR  </h4><span>(Mevcutta var olan uygulamalar, patent, makale, internet siteleri, youtube videoları vb. görsel ve yazılı kaynakları ve muhtemel rakipleri belirtiniz.)\n"
          + "</span>\n"
          + "<div>"+activityAnalysisEntity.getOpponent()+"</div>\n"
          + "<h4 style=\"font-weight: bold;color: white;background-color: #000\">2.3. ÜRÜNÜN/YÖNTEMİN AYRINTILI AÇIKLAMASI </h4><span>(Faaliyet serbestliği araştırmasına konu bir ürün ise, bu ürünün içerdiği parçaları, bu parçaların işlevlerinin anlatılması gerekmektedir. Eğer faaliyet serbestliğine konu olan bir yöntem ise, bu yöntemin her bir adımının ve bu adımların gerçekleştirilmesi için kullanılan teknik unsurların açıklanması gerekmektedir.)\n"
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
      helper.setSubject("Faaliyet Serbestliği Analizi");

    } else if (servicesType == 6) {


    }

    helper.setTo("test@turksmd.com.tr");
    helper.setFrom("test@turksmd.com.tr");
    emailSender.send(message);
  }
}
