package tr.com.tsmd.cengiz.controller;

import com.sun.istack.ByteArrayDataSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import javax.activation.DataHandler;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tr.com.tsmd.auth.payload.response.MessageResponse;
import tr.com.tsmd.cengiz.entity.ActivityAnalysisEntity;
import tr.com.tsmd.cengiz.entity.PatentPreEntity;
import tr.com.tsmd.cengiz.entity.TrademarkPreEntity;
import tr.com.tsmd.cengiz.entity.ValuationPatentEntity;
import tr.com.tsmd.cengiz.entity.ValuationTrademarkEntity;
import tr.com.tsmd.cengiz.models.AboutList;
import tr.com.tsmd.cengiz.models.ActivityAnalysis;
import tr.com.tsmd.cengiz.models.General;
import tr.com.tsmd.cengiz.models.News;
import tr.com.tsmd.cengiz.models.NewsList;
import tr.com.tsmd.cengiz.models.NoticeList;
import tr.com.tsmd.cengiz.models.PatentPre;
import tr.com.tsmd.cengiz.models.TrademarkPre;
import tr.com.tsmd.cengiz.models.TrademarkPreList;
import tr.com.tsmd.cengiz.models.UserList;
import tr.com.tsmd.cengiz.models.ValuationPatent;
import tr.com.tsmd.cengiz.models.ValuationTrademark;
import tr.com.tsmd.cengiz.payload.request.ServicesRequest;
import tr.com.tsmd.cengiz.payload.request.TrademarkPreRequest;
import tr.com.tsmd.cengiz.repository.ActivityAnalysisRepository;
import tr.com.tsmd.cengiz.repository.PatentPreRepository;
import tr.com.tsmd.cengiz.repository.TrademarkPreRepository;
import tr.com.tsmd.cengiz.repository.ValuationPatentRepository;
import tr.com.tsmd.cengiz.repository.ValuationTrademarkRepository;
import tr.com.tsmd.cengiz.service.AboutInfoService;
import tr.com.tsmd.cengiz.service.EmailService;
import tr.com.tsmd.cengiz.service.NewsInfoService;
import tr.com.tsmd.cengiz.service.NoticeInfoService;
import tr.com.tsmd.cengiz.service.UserInfoService;

import javax.validation.Valid;
import tr.com.tsmd.cengiz.util.Mail;

@RestController
@RequestMapping("/public")
public class CengizPublicController {

  /**
   * spring boot default sl4j
   */
  Logger logger = LoggerFactory.getLogger(CengizPublicController.class);

  @Autowired
  UserInfoService userInfoService;

  @Autowired
  NewsInfoService newsInfoService;

  @Autowired
  NoticeInfoService noticeInfoService;

  @Autowired
  AboutInfoService aboutInfoService;

  @Autowired
  EmailService emailService;


  @Autowired
  TrademarkPreRepository trademarkPreRepository;

  @Autowired
  PatentPreRepository patentPreRepository;

  @Autowired
  ValuationPatentRepository valuationPatentRepository;

  @Autowired
  ValuationTrademarkRepository valuationTrademarkRepository;

  @Autowired
  ActivityAnalysisRepository activityAnalysisRepository;

  /**
   * user list
   *
   * @return .
   */
  @GetMapping("/users")
  public UserList getCustomers() {
    //list dönen servis için bir class daha yazıp öyle handle ettik
    UserList userList = userInfoService.getUserList();
    return userList;
  }

  /**
   * services list
   *
   * @return .
   */
  @PostMapping("/services")
  public UserList getServices(@Valid @RequestBody ServicesRequest servicesRequest) {
    //list dönen servis için bir class daha yazıp öyle handle ettik
    UserList userList = userInfoService.getUserList();
    return userList;
  }

  /**
   * news list
   *
   * @return .
   */
  @GetMapping("/news")
  public NewsList getNews() {
    //list dönen servis için bir class daha yazıp öyle handle ettik
    NewsList newsList = newsInfoService.getNewsList();
    return newsList;
  }

  /**
   * notice list
   *
   * @return .
   */
  @GetMapping("/notice")
  public NoticeList getNotice() {
    //list dönen servis için bir class daha yazıp öyle handle ettik
    NoticeList noticeList = noticeInfoService.getNoticeList();
    return noticeList;
  }

  /**
   * about list
   *
   * @return .
   */
  @GetMapping("/about")
  public AboutList getAbout() {
    //list dönen servis için bir class daha yazıp öyle handle ettik
    AboutList aboutList = aboutInfoService.getAboutList();
    return aboutList;
  }

  @PostMapping(value = "/trademarkPreSave")
  public ResponseEntity<General> postTrademarkPre(@RequestBody TrademarkPre trademarkPre) {

    TrademarkPreEntity entity = trademarkPreRepository.save(new TrademarkPreEntity(
        trademarkPre.getTrademarktype(),
        trademarkPre.getTrademarkimage(),
        trademarkPre.getTrademarktext(),
        trademarkPre.getTrademarkclass(),
        trademarkPre.getName_surname(),
        trademarkPre.getTc(),
        trademarkPre.getAddress(),
        trademarkPre.getTel(),
        trademarkPre.getEmail()));


    TrademarkPre trademarkPre1 = new TrademarkPre(entity.getId(), entity.getTrademarktype(), entity.getTrademarkimage(),
        entity.getTrademarktext(), entity.getTrademarkclass(), entity.getName_surname(), entity.getTc(),
        entity.getAddress(), entity.getTel(), entity.getEmail());

    General general = new General("Kayıt işleminiz başarılı...", entity.getId());

    return ResponseEntity.ok(general);
  }

  @PostMapping(value = "/patentPreSave")
  public ResponseEntity<?> postPatentPre(@RequestBody PatentPre patentPre) {

    patentPreRepository.save(new PatentPreEntity(
        patentPre.getName_surname(),
        patentPre.getTc(),
        patentPre.getAddress(),
        patentPre.getTel(),
        patentPre.getEmail(),
        patentPre.getProtectiontype(),
        patentPre.getReporttype(),
        patentPre.getComputerarea(),
        patentPre.getElectricityarea(),
        patentPre.getElectronicarea(),
        patentPre.getMachinearea(),
        patentPre.getMedicinearea(),
        patentPre.getAutomotivearea(),
        patentPre.getMetallurgyarea(),
        patentPre.getBiomedicalarea(),
        patentPre.getChemistryarea(),
        patentPre.getFoodarea(),
        patentPre.getBuildarea(),
        patentPre.getOtherarea(),
        patentPre.getTitle(),
        patentPre.getPatentkeyword(),
        patentPre.getPatentapplication(),
        patentPre.getAdvantage(),
        patentPre.getPublications(),
        patentPre.getDeferencechoose(),
        patentPre.getDeferenceno(),
        patentPre.getDeferencepriority(),
        patentPre.getDetailexplain(),
        patentPre.getPicture(),
        patentPre.getOtherpoint()
    ));
    return ResponseEntity.ok(new MessageResponse("Kayıt işleminiz başarılı!"));
  }

  @PostMapping(value = "/valuationPatentSave")
  public ResponseEntity<?> valuationPatentSave(@RequestBody ValuationPatent valuationPatent) {

    valuationPatentRepository.save(new ValuationPatentEntity(
        valuationPatent.getAddress(),
        valuationPatent.getPatentpurpose(),
        valuationPatent.getPatentappno(),
        valuationPatent.getPatentcountry(),
        valuationPatent.getPatentmarket(),
        valuationPatent.getPatentcontribution(),
        valuationPatent.getPatentsector(),
        valuationPatent.getPatentothersector(),
        valuationPatent.getMarketshare(),
        valuationPatent.getPercentageturnover(),
        valuationPatent.getOverseasmarketshare(),
        valuationPatent.getExportcountry(),
        valuationPatent.getExportturnover(),
        valuationPatent.getRoyaltyrate(),
        valuationPatent.getCompetingmarketshare(),
        valuationPatent.getCompetitordate(),
        valuationPatent.getCompetinggrowthrate(),
        valuationPatent.getTurnovertarget(),
        valuationPatent.getTurnoverpercent(),
        valuationPatent.getIncomepercent(),
        valuationPatent.getLicense(),
        valuationPatent.getLicenseroyalt(),
        valuationPatent.getContract(),
        valuationPatent.getAdvertisement(),
        valuationPatent.getTotalexpenditure(),
        valuationPatent.getSpending(),
        valuationPatent.getDevelopmentspending(),
        valuationPatent.getWorldspending(),
        valuationPatent.getCaseexpense(),
        valuationPatent.getCountryoutside(),
        valuationPatent.getEuropeanunio()
    ));
    return ResponseEntity.ok(new MessageResponse("Kayıt işleminiz başarılı!"));
  }

  @PostMapping(value = "/valuationTrademarkSave")
  public ResponseEntity<?> valuationTrademarkSave(@RequestBody ValuationTrademark valuationTrademark) {

    valuationTrademarkRepository.save(new ValuationTrademarkEntity(
        valuationTrademark.getAddress(),
        valuationTrademark.getTrademarkclass(),
        valuationTrademark.getTrademarkpurpose(),
        valuationTrademark.getRegistrationdate(),
        valuationTrademark.getCommonusage(),
        valuationTrademark.getDominanttrademark(),
        valuationTrademark.getTargetcountry(),
        valuationTrademark.getTrademarktime(),
        valuationTrademark.getMarkettime(),
        valuationTrademark.getTrademarkcontribution(),
        valuationTrademark.getIncomepercent(),
        valuationTrademark.getMainsector(),
        valuationTrademark.getOthersector(),
        valuationTrademark.getMarketshare(),
        valuationTrademark.getTotalturnover(),
        valuationTrademark.getOverseasmarketshare(),
        valuationTrademark.getExportcountry(),
        valuationTrademark.getTurnoverpercent(),
        valuationTrademark.getPercentroyalt(),
        valuationTrademark.getCompetingmarketshare(),
        valuationTrademark.getMarkethistory(),
        valuationTrademark.getGrowthrate(),
        valuationTrademark.getTurnovertarget(),
        valuationTrademark.getTrademarkturnoverpercent(),
        valuationTrademark.getIncomeincreasepercent(),
        valuationTrademark.getLicense(),
        valuationTrademark.getLicenseroyalt(),
        valuationTrademark.getContract(),
        valuationTrademark.getAdvertisement(),
        valuationTrademark.getTotalexpenditure(),
        valuationTrademark.getCountryoutside(),
        valuationTrademark.getEuropeanunion()
    ));
    return ResponseEntity.ok(new MessageResponse("Kayıt işleminiz başarılı!"));
  }

  @PostMapping(value = "/activityAnalysisSave")
  public ResponseEntity<?> activityAnalysisSave(@RequestBody ActivityAnalysis activityAnalysis) {

    activityAnalysisRepository.save(new ActivityAnalysisEntity(
        activityAnalysis.getName_surname(),
        activityAnalysis.getTc(),
        activityAnalysis.getAddress(),
        activityAnalysis.getTel(),
        activityAnalysis.getEmail(),
        activityAnalysis.getKeyWord(),
        activityAnalysis.getOpponent(),
        activityAnalysis.getTechnicalcomponent(),
        activityAnalysis.getImage(),
        activityAnalysis.getOtherpoint()
    ));

    String[] to = {"damlaberber@turkpatent.gov.tr"};
    sendMail("deneme", to, "", 1, "deneme");


    return ResponseEntity.ok(new MessageResponse("Kayıt işleminiz başarılı!"));
  }

  private void sendMail(String replyText, String[] to, String subject, int id, String appNo) {
    Mail mail = new Mail();
    mail.setFrom("damlaberber@turkpatent.gov.tr");
    mail.setTo(to);
    mail.setSubject(subject);
    mail.setContent(replyText);
    try {
      emailService.sendSimpleMessage(mail);
      logger.info("Mail Gonderildi:" + id + " Basvuru no: " + appNo);
    } catch (Exception e) {
      logger.error(e.getLocalizedMessage());
    }
  }

  @PostMapping(value = "/upload", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> fileUpload(@RequestParam("type") Integer type, @RequestParam("id") Long id, @RequestParam("file") MultipartFile uploadFile) throws Exception {
    if (uploadFile.isEmpty()) {
      return ResponseEntity.badRequest().build();
    }

    if (id == null) {
      return ResponseEntity.ok(new MessageResponse("Lütfen önce başvuru sahibi bilgilerini ve markaya ilişkin bilgileri giriniz!"));
    }

    logger.info("id: {}", id);
    logger.info("uploadFile name: {}", uploadFile.getOriginalFilename());
    logger.info("uploadFile size: {}", uploadFile.getSize());
    byte[] image = uploadFile.getBytes();
    //String base64EncodedImage = "data: image/jpeg;base64," + new String (Base64.encodeBase64 (image), StandardCharsets.US_ASCII);
    TrademarkPreEntity entity = trademarkPreRepository.getById(id);
    if (type == 1) {
      entity.setTrademarkimagebyte(image);
      entity.setTrademarkimagename(uploadFile.getOriginalFilename());
    } else if (type == 2) {
      entity.setDekont(image);
      entity.setDekontName(uploadFile.getOriginalFilename());
    }

    trademarkPreRepository.save(entity);

    return ResponseEntity.ok(new MessageResponse("Kayıt işleminiz başarılı!"));
  }


  @PostMapping(value = "/sendEmailTrademarkPre")
  public ResponseEntity<?> sendEmailTrademarkPre(@Valid @RequestBody TrademarkPreRequest trademarkPreRequest) {
    TrademarkPreEntity trademarkPreEntity = trademarkPreRepository.getById(trademarkPreRequest.getId());


    String[] to = {"damlaberber@turkpatent.gov.tr"};
    //sendMail(trademarkPreEntity.getId()+"", to, "", 1, trademarkPreEntity.getAddress());
    Mail mail = new Mail();
    mail.setFrom("damlaberber@turkpatent.gov.tr");
    mail.setTo(to);
    mail.setSubject("deneme");
    mail.setContent(trademarkPreEntity.getAddress());
    try {
      emailService.sendMimeMessage(mail, trademarkPreEntity);

    } catch (Exception e) {
      logger.error(e.getLocalizedMessage());
    }


    return ResponseEntity.ok(new MessageResponse("Mail Gönderilmiştir!"));
  }


  @PostMapping(value = "/addNews")
  public ResponseEntity<?> addNews(@RequestBody News news) {

    newsInfoService.addNews(news);

    return ResponseEntity.ok(new MessageResponse("Kayıt işleminiz başarılı!"));
  }


  @PostMapping(value = "/addNewsAll", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> addNewsAll(@RequestParam("newsTitle") String newsTitle, @RequestParam("newsExplain") String newsExplain,
                                      @RequestParam("mainPicture") MultipartFile mainPicture) throws Exception {

    News news = new News(mainPicture.getBytes(), newsTitle, newsExplain);

    newsInfoService.addNews(news);


    return ResponseEntity.ok(new MessageResponse("Kayıt işleminiz başarılı!"));
  }

  @PostMapping(value = "/addNewsAll2", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> addNewsAll2(@RequestParam("newsTitle") String newsTitle, @RequestParam("newsExplain") String newsExplain,
                                       @RequestParam("mainPicture") MultipartFile mainPicture, @RequestParam("picture") MultipartFile[] picture) throws Exception {


    byte[] image = mainPicture.getBytes();
    String title = newsTitle;
    String explain = newsExplain;


    return ResponseEntity.ok(new MessageResponse("Kayıt işleminiz başarılı!"));
  }

  @PostMapping(value = "/addNewsFiles", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> addNewsFiles(@RequestParam("picture") MultipartFile[] picture) throws Exception {

    for (int i = 0; i < picture.length; i++) {
      byte[] image = picture[i].getBytes();
    }

    return ResponseEntity.ok(new MessageResponse("Kayıt işleminiz başarılı!"));
  }
}
