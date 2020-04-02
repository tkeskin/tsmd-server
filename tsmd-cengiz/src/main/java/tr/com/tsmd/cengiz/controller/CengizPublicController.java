package tr.com.tsmd.cengiz.controller;


import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tr.com.tsmd.auth.payload.response.MessageResponse;
import tr.com.tsmd.cengiz.entity.ActivityAnalysisEntity;
import tr.com.tsmd.cengiz.entity.ContactMailEntity;
import tr.com.tsmd.cengiz.entity.PatentPreEntity;
import tr.com.tsmd.cengiz.entity.TrademarkPreEntity;
import tr.com.tsmd.cengiz.entity.ValuationPatentEntity;
import tr.com.tsmd.cengiz.entity.ValuationTrademarkEntity;
import tr.com.tsmd.cengiz.models.AboutList;
import tr.com.tsmd.cengiz.models.ActivityAnalysis;
import tr.com.tsmd.cengiz.models.ContactMail;
import tr.com.tsmd.cengiz.models.FullDataList;
import tr.com.tsmd.cengiz.models.General;
import tr.com.tsmd.cengiz.models.News;
import tr.com.tsmd.cengiz.models.NewsList;
import tr.com.tsmd.cengiz.models.NewsRelatedPicturesList;
import tr.com.tsmd.cengiz.models.Notice;
import tr.com.tsmd.cengiz.models.NoticeList;
import tr.com.tsmd.cengiz.models.PatentPre;
import tr.com.tsmd.cengiz.models.TrademarkPre;
import tr.com.tsmd.cengiz.models.UserList;
import tr.com.tsmd.cengiz.models.ValuationPatent;
import tr.com.tsmd.cengiz.models.ValuationTrademark;
import tr.com.tsmd.cengiz.payload.request.ServicesRequest;
import tr.com.tsmd.cengiz.payload.request.TrademarkPreRequest;
import tr.com.tsmd.cengiz.repository.ActivityAnalysisRepository;
import tr.com.tsmd.cengiz.repository.ContactMailRepository;
import tr.com.tsmd.cengiz.repository.PatentPreRepository;
import tr.com.tsmd.cengiz.repository.TrademarkPreRepository;
import tr.com.tsmd.cengiz.repository.ValuationPatentRepository;
import tr.com.tsmd.cengiz.repository.ValuationTrademarkRepository;
import tr.com.tsmd.cengiz.service.AboutInfoService;
import tr.com.tsmd.cengiz.service.ActivityAnalysisService;
import tr.com.tsmd.cengiz.service.EmailService;
import tr.com.tsmd.cengiz.service.NewsInfoService;
import tr.com.tsmd.cengiz.service.NoticeInfoService;
import tr.com.tsmd.cengiz.service.PatentPreService;
import tr.com.tsmd.cengiz.service.UserInfoService;

import javax.validation.Valid;
import tr.com.tsmd.cengiz.service.ValuationService;
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
  PatentPreService patentPreService;

  @Autowired
  ValuationService valuationService;

  @Autowired
  ActivityAnalysisService activityAnalysisService;

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

  @Autowired
  ContactMailRepository contactMailRepository;

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
   * news list
   *
   * @return .
   */
  @GetMapping("/news/{id}")
  public News getNewsById(@PathVariable("id") Long id) {

    News news = newsInfoService.getNewsById(id);
    return news;
  }

  /**
   * news list
   *
   * @return .
   */
  @GetMapping("/notice/{id}")
  public Notice getNoticeById(@PathVariable("id") Long id) {

    Notice notice = noticeInfoService.getNoticeById(id);
    return notice;
  }

  /**
   * news list
   *
   * @return .
   */
  @DeleteMapping("/newsDelete/{id}")
  public void deleteNews(@PathVariable("id") Long id) {

    newsInfoService.deleteNews(id);

  }

  /**
   * news list
   *
   * @return .
   */
  @PostMapping(value = "/newsUpdatePicture", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> updateNewsPicture(@RequestParam("id") Long id, @RequestParam("mainPicture") MultipartFile mainPicture) throws Exception {


    newsInfoService.updateNewsPicture(id,mainPicture);

    return ResponseEntity.ok(new MessageResponse("Ana resmi Güncelleme işleminiz başarılı!"));
  }

  /**
   * notice list
   *
   * @return .
   */
  @PostMapping(value = "/noticeUpdatePicture", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> updateNoticePicture(@RequestParam("id") Long id, @RequestParam("picture") MultipartFile picture) throws Exception {


    noticeInfoService.updateNoticePicture(id,picture);

    return ResponseEntity.ok(new MessageResponse("Ana resmi Güncelleme işleminiz başarılı!"));
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

  /**
   * about list
   *
   * @return .
   */
  @GetMapping("/newsRelatedPictures/{newsId}")
  public NewsRelatedPicturesList getNewsRelatedPictures(@PathVariable("newsId") Long newsId) {
    //list dönen servis için bir class daha yazıp öyle handle ettik
    NewsRelatedPicturesList newsRelatedPicturesList = newsInfoService.getNewsRelatedPicturesList(newsId);
    return newsRelatedPicturesList;
  }

  /**
   * about list
   *
   * @return .
   */
  @GetMapping("/deleteNewsRelatedPictures/{id}")
  public ResponseEntity<?> deleteNewsRelatedPictures(@PathVariable("id") Long id) {
    //list dönen servis için bir class daha yazıp öyle handle ettik
    newsInfoService.deleteNewsRelatedPicturesById(id);
    return ResponseEntity.ok(new MessageResponse("Silindi!"));
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
  public ResponseEntity<General> postPatentPre(@RequestBody PatentPre patentPre) {

    PatentPreEntity patentPreEntity = patentPreRepository.save(new PatentPreEntity(
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
        patentPre.getDetailexplain(),
        patentPre.getPicture(),
        patentPre.getOtherpoint()
    ));
    General general=new General();
    general.setMessage("Kayıt işleminiz başarılı!");
    general.setId(patentPreEntity.getId());


    return ResponseEntity.ok(general);
  }

  @PostMapping(value = "/valuationPatentSave")
  public ResponseEntity<General> valuationPatentSave(@RequestBody ValuationPatent valuationPatent) {

    ValuationPatentEntity valuationPatentEntity=valuationPatentRepository.save(new ValuationPatentEntity(
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
    General general=new General();
    general.setMessage("Kayıt işleminiz başarılı!");
    general.setId(valuationPatentEntity.getId());


    return ResponseEntity.ok(general);
  }

  @PostMapping(value = "/valuationTrademarkSave")
  public ResponseEntity<General> valuationTrademarkSave(@RequestBody ValuationTrademark valuationTrademark) {

    ValuationTrademarkEntity valuationTrademarkEntity=valuationTrademarkRepository.save(new ValuationTrademarkEntity(
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
    General general=new General();
    general.setMessage("Kayıt işleminiz başarılı!");
    general.setId(valuationTrademarkEntity.getId());


    return ResponseEntity.ok(general);
  }

  @PostMapping(value = "/activityAnalysisSave")
  public ResponseEntity<General> activityAnalysisSave(@RequestBody ActivityAnalysis activityAnalysis) {

    ActivityAnalysisEntity activityAnalysisEntity=activityAnalysisRepository.save(new ActivityAnalysisEntity(
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




    General general=new General();
    general.setMessage("Kayıt işleminiz başarılı!");
    general.setId(activityAnalysisEntity.getId());


    return ResponseEntity.ok(general);
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


  @PostMapping(value = "/sendEmailTrademarkPre/{id}")
  public ResponseEntity<?> sendEmailTrademarkPre(@PathVariable("id") Long id) {

    try {
      emailService.sendMimeMessage(id, 1);

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
  public ResponseEntity<General> addNewsAll(@RequestParam("newsTitle") String newsTitle, @RequestParam("newsExplain") String newsExplain,
                                      @RequestParam("mainPicture") MultipartFile mainPicture) throws Exception {

    News news = new News(mainPicture.getBytes(), newsTitle, newsExplain,mainPicture.getOriginalFilename(),mainPicture.getContentType());

    Long id=newsInfoService.addNews(news);

    General general=new General();
    general.setMessage("Kayıt işleminiz başarılı!");
    general.setId(id);


    return ResponseEntity.ok(general);
  }

  @PostMapping(value = "/addNotice", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<General> addNotice(@RequestParam("noticeTitle") String noticeTitle, @RequestParam("noticeExplain") String noticeExplain,
                                            @RequestParam("picture") MultipartFile picture) throws Exception {

    Notice notice = new Notice(picture.getBytes(), noticeTitle, noticeExplain,picture.getOriginalFilename(),picture.getContentType());

    Long id=noticeInfoService.addNotice(notice);

    General general=new General();
    general.setMessage("Kayıt işleminiz başarılı!");
    general.setId(id);


    return ResponseEntity.ok(general);
  }

  @PostMapping(value = "/addNewsFiles", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> addNewsFiles(@RequestParam("id") Long id,@RequestParam("relatedPictures") MultipartFile relatedPictures) throws Exception {

      newsInfoService.addNewsRelatedPictures(id,relatedPictures);


    return ResponseEntity.ok(new MessageResponse("Kayıt işleminiz başarılı!"));
  }

  @PostMapping(value = "/addMultipartFiles", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> addMultipartFiles(@RequestParam("pictures") MultipartFile[] pictures,@RequestParam("dekont") MultipartFile dekont) throws Exception {

  System.out.println(pictures.length);
  for (int i=0;i<pictures.length;i++){
    String fileName=pictures[i].getOriginalFilename();
  }

    return ResponseEntity.ok(new MessageResponse("Kayıt işleminiz başarılı!"));
  }

  /**
   * news list
   *
   * @return .
   */
  @PostMapping(value = "/newsUpdateRelatedPicture", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> updateNewsRelatedPicture(@RequestParam("id") Long id, @RequestParam("relatedPicture") MultipartFile relatedPicture) throws Exception {


    newsInfoService.updateNewsRelatedPicture(id,relatedPicture);

    return ResponseEntity.ok(new MessageResponse("Resim güncelleme başarılı!"));
  }

  @PostMapping(value = "/sendContactMail")
  public ResponseEntity<?> sendContactMail(@RequestBody ContactMail contactMail) {

    contactMailRepository.save(new ContactMailEntity(contactMail.getEmail(),contactMail.getNameSurname(),contactMail.getMessage()));

    String[] to = {"damlaberber@turkpatent.gov.tr"};
    String content= "Ad Soyad:"+contactMail.getNameSurname()+"Email:"+contactMail.getEmail()+"Message:"+contactMail.getMessage();
    sendMail(content, to, contactMail.getEmail(), 1, "");

    return ResponseEntity.ok(new MessageResponse("Mailiniz gönderilmiştir!"));
  }


  @PostMapping(value = "/fullData/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> sendDataTable(@PathVariable("id") Long id,@RequestBody FullDataList fullDataList) {

    patentPreService.savePatentPreTable(id,fullDataList);

    return ResponseEntity.ok(new MessageResponse("Başarılı"));
  }


  @PostMapping(value = "/sendEmailPatentPre/{id}")
  public ResponseEntity<?> sendEmailPatentPre(@PathVariable("id") Long id) {

    try {
      emailService.sendMimeMessage(id, 2);

    } catch (Exception e) {
      logger.error(e.getLocalizedMessage());
    }

    return ResponseEntity.ok(new MessageResponse("Mail Gönderilmiştir!"));
  }

  @PostMapping(value = "/sendEmailValuationPatent/{id}")
  public ResponseEntity<?> sendEmailValuationPatent(@PathVariable("id") Long id) {

    try {
      emailService.sendMimeMessage(id, 3);

    } catch (Exception e) {
      logger.error(e.getLocalizedMessage());
    }

    return ResponseEntity.ok(new MessageResponse("Mail Gönderilmiştir!"));
  }
  @PostMapping(value = "/sendEmailValuationTrademark/{id}")
  public ResponseEntity<?> sendEmailValuationTrademark(@PathVariable("id") Long id) {

    try {
      emailService.sendMimeMessage(id, 4);

    } catch (Exception e) {
      logger.error(e.getLocalizedMessage());
    }

    return ResponseEntity.ok(new MessageResponse("Mail Gönderilmiştir!"));
  }

  @PostMapping(value = "/sendEmailActivityAnalysis/{id}")
  public ResponseEntity<?> sendEmailActivityAnalysis(@PathVariable("id") Long id) {

    try {
      emailService.sendMimeMessage(id, 5);

    } catch (Exception e) {
      logger.error(e.getLocalizedMessage());
    }

    return ResponseEntity.ok(new MessageResponse("Mail Gönderilmiştir!"));
  }

  @PostMapping(value = "/addPatentPreRelatedPictures/{patentPreId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> addPatentPreRelatedPictures(@PathVariable("patentPreId")Long patentPreId,
                                                       @RequestParam("pictures") MultipartFile[] pictures)
      throws Exception {

    patentPreService.addPatentPreRelatedPictures(patentPreId,pictures);

    return ResponseEntity.ok(new MessageResponse("Kayıt işleminiz başarılı!"));
  }

  @PostMapping(value = "/addPatentPreDekont/{patentPreId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> addPatentPreDekont(@PathVariable("patentPreId")Long patentPreId,
                                                       @RequestParam("dekont") MultipartFile dekont) throws Exception {

    patentPreService.addDekont(patentPreId,dekont);

    return ResponseEntity.ok(new MessageResponse("Kayıt işleminiz başarılı!"));
  }

  @PostMapping(value = "/addValuationPatentDekont/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> addValuationPatentDekont(@PathVariable("id")Long id,
                                              @RequestParam("dekont") MultipartFile dekont) throws Exception {

    valuationService.addValuationPatentDekont(id,dekont);

    return ResponseEntity.ok(new MessageResponse("Kayıt işleminiz başarılı!"));
  }

  @PostMapping(value = "/addValuationTrademarkDekont/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> addValuationTrademarkDekont(@PathVariable("id")Long id,
                                                     @RequestParam("dekont") MultipartFile dekont) throws Exception {

    valuationService.addValuationTrademarkDekont(id,dekont);

    return ResponseEntity.ok(new MessageResponse("Kayıt işleminiz başarılı!"));
  }

  @PostMapping(value = "/addActivityAnalysisDekont/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> addActivityAnalysisDekont(@PathVariable("id")Long id,
                                                        @RequestParam("dekont") MultipartFile dekont) throws Exception {

    activityAnalysisService.addActivityAnalysisDekont(id,dekont);

    return ResponseEntity.ok(new MessageResponse("Kayıt işleminiz başarılı!"));
  }

  @PostMapping(value = "/addActivityAnalysisPictures/{activityId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> addActivityAnalysisPictures(@PathVariable("activityId")Long activityId,
                                                       @RequestParam("pictures") MultipartFile[] pictures)
      throws Exception {

    activityAnalysisService.addActivityAnalysisPictures(activityId,pictures);

    return ResponseEntity.ok(new MessageResponse("Kayıt işleminiz başarılı!"));
  }

}
