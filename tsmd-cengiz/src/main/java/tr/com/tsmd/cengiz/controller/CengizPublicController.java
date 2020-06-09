package tr.com.tsmd.cengiz.controller;


import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import tr.com.tsmd.auth.payload.response.MessageResponse;
import tr.com.tsmd.cengiz.entity.ActivityAnalysisEntity;
import tr.com.tsmd.cengiz.entity.ActivityAnalysisPicturesEntity;
import tr.com.tsmd.cengiz.entity.ActivityAnalysisViewPdfEntity;
import tr.com.tsmd.cengiz.entity.ContactMailEntity;
import tr.com.tsmd.cengiz.entity.EvaluationInvalidationViewPdfEntity;
import tr.com.tsmd.cengiz.entity.InvalidationAssessmentEntity;
import tr.com.tsmd.cengiz.entity.PatentPreEntity;
import tr.com.tsmd.cengiz.entity.PatentPreRelatedPicturesEntity;
import tr.com.tsmd.cengiz.entity.PatentPreTableEntity;
import tr.com.tsmd.cengiz.entity.PatentPreViewPdfEntity;
import tr.com.tsmd.cengiz.entity.TechnologyConsultancyViewPdfEntity;
import tr.com.tsmd.cengiz.entity.TrademarkPreEntity;
import tr.com.tsmd.cengiz.entity.TrademarkPreViewPdfEntity;
import tr.com.tsmd.cengiz.entity.ValuationPatentEntity;
import tr.com.tsmd.cengiz.entity.ValuationTrademarkEntity;
import tr.com.tsmd.cengiz.entity.ValuationViewPdfEntity;
import tr.com.tsmd.cengiz.models.About;
import tr.com.tsmd.cengiz.models.AboutList;
import tr.com.tsmd.cengiz.models.ActivityAnalysis;
import tr.com.tsmd.cengiz.models.ActivityAnalysisList;
import tr.com.tsmd.cengiz.models.ActivityAnalysisPictures;
import tr.com.tsmd.cengiz.models.ActivityAnalysisPicturesList;
import tr.com.tsmd.cengiz.models.ActivityAnalysisView;
import tr.com.tsmd.cengiz.models.ActivityAnalysisViewPdfList;
import tr.com.tsmd.cengiz.models.CompanyProfile;
import tr.com.tsmd.cengiz.models.ContactMail;
import tr.com.tsmd.cengiz.models.EvaluationInvalidationView;
import tr.com.tsmd.cengiz.models.EvaluationInvalidationViewPdfList;
import tr.com.tsmd.cengiz.models.FullData;
import tr.com.tsmd.cengiz.models.FullDataList;
import tr.com.tsmd.cengiz.models.General;
import tr.com.tsmd.cengiz.models.InvalidationAssessment;
import tr.com.tsmd.cengiz.models.InvalidationAssessmentList;
import tr.com.tsmd.cengiz.models.News;
import tr.com.tsmd.cengiz.models.NewsList;
import tr.com.tsmd.cengiz.models.NewsRelatedPicturesList;
import tr.com.tsmd.cengiz.models.Notice;
import tr.com.tsmd.cengiz.models.NoticeList;
import tr.com.tsmd.cengiz.models.PatentPre;
import tr.com.tsmd.cengiz.models.PatentPreList;
import tr.com.tsmd.cengiz.models.PatentPreRelatedPictures;
import tr.com.tsmd.cengiz.models.PatentPreRelatedPicturesList;
import tr.com.tsmd.cengiz.models.PatentPreView;
import tr.com.tsmd.cengiz.models.PatentPreViewPdfList;
import tr.com.tsmd.cengiz.models.TechnologyConsultancyView;
import tr.com.tsmd.cengiz.models.TechnologyConsultancyViewPdfList;
import tr.com.tsmd.cengiz.models.TrademarkPre;
import tr.com.tsmd.cengiz.models.TrademarkPreList;
import tr.com.tsmd.cengiz.models.TrademarkPreView;
import tr.com.tsmd.cengiz.models.TrademarkPreViewPdfList;
import tr.com.tsmd.cengiz.models.UserList;
import tr.com.tsmd.cengiz.models.ValuationPatent;
import tr.com.tsmd.cengiz.models.ValuationPatentList;
import tr.com.tsmd.cengiz.models.ValuationTrademark;
import tr.com.tsmd.cengiz.models.ValuationTrademarkList;
import tr.com.tsmd.cengiz.models.ValuationView;
import tr.com.tsmd.cengiz.models.ValuationViewPdfList;
import tr.com.tsmd.cengiz.payload.request.ServicesRequest;
import tr.com.tsmd.cengiz.repository.ActivityAnalysisPicturesRepository;
import tr.com.tsmd.cengiz.repository.ActivityAnalysisRepository;
import tr.com.tsmd.cengiz.repository.ContactMailRepository;
import tr.com.tsmd.cengiz.repository.InvalidationAssessmentRepository;
import tr.com.tsmd.cengiz.repository.PatentPreRelatedPicturesRepository;
import tr.com.tsmd.cengiz.repository.PatentPreRepository;
import tr.com.tsmd.cengiz.repository.PatentPreTableRepository;
import tr.com.tsmd.cengiz.repository.TrademarkPreRepository;
import tr.com.tsmd.cengiz.repository.ValuationPatentRepository;
import tr.com.tsmd.cengiz.repository.ValuationTrademarkRepository;
import tr.com.tsmd.cengiz.service.AboutInfoService;
import tr.com.tsmd.cengiz.service.ActivityAnalysisService;
import tr.com.tsmd.cengiz.service.CompanyProfileInfoService;
import tr.com.tsmd.cengiz.service.EmailService;
import tr.com.tsmd.cengiz.service.NewsInfoService;
import tr.com.tsmd.cengiz.service.NoticeInfoService;
import tr.com.tsmd.cengiz.service.PatentPreService;
import tr.com.tsmd.cengiz.service.ServicesInfoService;
import tr.com.tsmd.cengiz.service.UserInfoService;
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
  CompanyProfileInfoService companyProfileInfoService;

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

  @Autowired
  ServicesInfoService servicesInfoService;

  @Autowired
  PatentPreRelatedPicturesRepository patentPreRelatedPicturesRepository;

  @Autowired
  PatentPreTableRepository patentPreTableRepository;

  @Autowired
  ActivityAnalysisPicturesRepository activityAnalysisPicturesRepository;

  @Autowired
  InvalidationAssessmentRepository invalidationAssessmentRepository;


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
  @GetMapping("/newsPublished")
  public NewsList getNewsPublished() {
    //list dönen servis için bir class daha yazıp öyle handle ettik
    NewsList newsList = newsInfoService.getNewsPublishedList();
    return newsList;
  }

  /**
   * trademarkpreapplications list
   *
   * @return .
   */
  @GetMapping("/trademarkPreApplications")
  public TrademarkPreList getTrademarkPreApplications() {
    //list dönen servis için bir class daha yazıp öyle handle ettik
    List<TrademarkPreEntity> trademarkPreEntities = trademarkPreRepository.findAll();
    List<TrademarkPre> trademarkPres = new ArrayList<>();
    for (TrademarkPreEntity entity: trademarkPreEntities) {
      TrademarkPre trademarkPre = new TrademarkPre();
          trademarkPre.setId(entity.getId());
          trademarkPre.setTrademarktype(entity.getTrademarktype());
          if (entity.getTrademarkimagebyte() != null) {
            trademarkPre.setTrademarkimage( "data: image/jpeg;base64," +
                new String(Base64.encodeBase64(entity.getTrademarkimagebyte()), StandardCharsets.US_ASCII));
          } else {
            trademarkPre.setTrademarkimage("");
      }

      trademarkPre.setTrademarktext(entity.getTrademarktext());
      trademarkPre.setTrademarkclass(entity.getTrademarkclass());
      trademarkPre.setName_surname(entity.getName_surname());
      trademarkPre.setTc(entity.getTc());
      trademarkPre.setAddress(entity.getAddress());
      trademarkPre.setTel(entity.getTel());
      trademarkPre.setEmail(entity.getEmail());
      trademarkPre.setCreatedAt(entity.getCreatedAt());
      trademarkPre.setLegalPerson(entity.getLegalPerson());
      trademarkPres.add(trademarkPre);
    }

    TrademarkPreList trademarkPreList = new TrademarkPreList();
    trademarkPreList.setTrademarkPres(trademarkPres);
    return trademarkPreList;
  }


  /**
   * trademarkpreapplications list
   *
   * @return .
   */
  @GetMapping("/invalidationAssessmentApplications")
  public InvalidationAssessmentList getInvalidationAssessmentApplications() {
    //list dönen servis için bir class daha yazıp öyle handle ettik
    List<InvalidationAssessmentEntity> invalidationAssessmentEntities = invalidationAssessmentRepository.findAll();
    List<InvalidationAssessment> invalidationAssessments = new ArrayList<>();
    for (InvalidationAssessmentEntity entity: invalidationAssessmentEntities) {
      InvalidationAssessment invalidationAssessment = new InvalidationAssessment();
      invalidationAssessment.setId(entity.getId());
      invalidationAssessment.setAppNo(entity.getAppNo());
      invalidationAssessment.setTc(entity.getTc());
      invalidationAssessment.setAddress(entity.getAddress());
      invalidationAssessment.setTel(entity.getTel());
      invalidationAssessment.setEmail(entity.getEmail());
      invalidationAssessment.setCreatedAt(entity.getCreatedAt());
      invalidationAssessments.add(invalidationAssessment);
    }

    InvalidationAssessmentList invalidationAssessmentList = new InvalidationAssessmentList();
    invalidationAssessmentList.setInvalidationAssessments(invalidationAssessments);
    return invalidationAssessmentList;
  }


  /**
   * trademarkpreapplications list
   *
   * @return .
   */
  @GetMapping("/patentPreApplications")
  public PatentPreList getPatentPreApplications() {
    List<PatentPreEntity> patentPreEntities = patentPreRepository.findAll();
    List<PatentPre> patentPres = new ArrayList<>();
    for (PatentPreEntity entity: patentPreEntities) {
      PatentPre patentPre = new PatentPre();
      patentPre.setId(entity.getId());
      if (entity.getProtectiontype().equals("5")){
        patentPre.setProtectiontype("Patent");
      }else if (entity.getProtectiontype().equals("6")){
        patentPre.setProtectiontype("Faydalı Model");
      }else if (entity.getProtectiontype().equals("7")){
        patentPre.setProtectiontype("Rapor Sonrasında Belirleyeceğim");
      }else {
        patentPre.setProtectiontype(entity.getProtectiontype());
      }

      if (entity.getReporttype().equals("8")){
        patentPre.setReporttype("Standart");
      }else if (entity.getReporttype().equals("9")){
        patentPre.setReporttype("Detaylı");
      }else {
        patentPre.setReporttype(entity.getReporttype());
      }
      patentPre.setName_surname(entity.getName_surname());
      patentPre.setTc(entity.getTc());
      patentPre.setAddress(entity.getAddress());
      patentPre.setTel(entity.getTel());
      patentPre.setEmail(entity.getEmail());
      patentPre.setCreatedAt(entity.getCreatedAt());
      patentPre.setLegalPerson(entity.getLegalPerson());
      patentPres.add(patentPre);
    }

    PatentPreList patentPreList = new PatentPreList();
    patentPreList.setPatentPres(patentPres);
    return patentPreList;
  }


  /**
   * news list
   *
   * @return .
   */
  @GetMapping("/trademarkPreApplications/{id}")
  public TrademarkPre getTrademarkPreApplicationsById(@PathVariable("id") Long id) {

    TrademarkPreEntity entity = trademarkPreRepository.getById(id);
    TrademarkPre trademarkPre = new TrademarkPre();
    trademarkPre.setId(entity.getId());
    trademarkPre.setTrademarktype(entity.getTrademarktype());
    if (entity.getTrademarkimagebyte() != null) {
      trademarkPre.setTrademarkimage( "data: image/jpeg;base64," +
          new String(Base64.encodeBase64(entity.getTrademarkimagebyte()), StandardCharsets.US_ASCII));
    } else {
      trademarkPre.setTrademarkimage("");
    }

    trademarkPre.setTrademarktext(entity.getTrademarktext());
    trademarkPre.setTrademarkclass(entity.getTrademarkclass());
    trademarkPre.setName_surname(entity.getName_surname());
    trademarkPre.setTc(entity.getTc());
    trademarkPre.setAddress(entity.getAddress());
    trademarkPre.setTel(entity.getTel());
    trademarkPre.setEmail(entity.getEmail());
    trademarkPre.setCreatedAt(entity.getCreatedAt());
    trademarkPre.setDekontBase64("data: image/jpeg;base64," +
        new String(Base64.encodeBase64(entity.getDekont()), StandardCharsets.US_ASCII));
    trademarkPre.setLegalPerson(entity.getLegalPerson());
    trademarkPre.setTrademarkItemList(entity.getTrademarkItemList());
    return trademarkPre;
  }

  /**
   * valuationTrademarkApplication list
   *
   * @return .
   */
  @GetMapping("/valuationTrademarkApplications/{id}")
  public ValuationTrademark getValuationTrademarkApplicationsById(@PathVariable("id") Long id) {

    ValuationTrademarkEntity entity = valuationTrademarkRepository.getById(id);
    ValuationTrademark valuationTrademark = new ValuationTrademark();
    valuationTrademark.setId(entity.getId());
    valuationTrademark.setName_surname(entity.getName_surname());
    valuationTrademark.setValuationTrademarkAppNo(entity.getValuationTrademarkAppNo());
    valuationTrademark.setLegalPerson(entity.getLegalPerson());
    valuationTrademark.setEmail(entity.getEmail());
    valuationTrademark.setTc(entity.getTc());
    valuationTrademark.setTel(entity.getTel());
    valuationTrademark.setAddress(entity.getAddress());
    valuationTrademark.setLicenseChoose(entity.getLicenseChoose());
//    valuationTrademark.setTrademarkclass(entity.getTrademarkclass());
    valuationTrademark.setTrademarkpurpose(entity.getTrademarkpurpose());
//    valuationTrademark.setRegistrationdate(entity.getRegistrationdate());
    valuationTrademark.setCommonusage(entity.getCommonusage());
//    valuationTrademark.setDominanttrademark(entity.getDominanttrademark());
    valuationTrademark.setTargetcountry(entity.getTargetcountry());
    valuationTrademark.setTrademarktime(entity.getTrademarktime());
    valuationTrademark.setMarkettime(entity.getMarkettime());
    valuationTrademark.setTrademarkcontribution(entity.getTrademarkcontribution());
//    valuationTrademark.setIncomepercent(entity.getIncomepercent());
    valuationTrademark.setMainsector(entity.getMainsector());
    valuationTrademark.setOthersector(entity.getOthersector());
    valuationTrademark.setMarketshare(entity.getMarketshare());
//    valuationTrademark.setTotalturnover(entity.getTotalturnover());
    valuationTrademark.setOverseasmarketshare(entity.getOverseasmarketshare());
    valuationTrademark.setExportcountry(entity.getExportcountry());
    valuationTrademark.setTurnoverpercent(entity.getTurnoverpercent());
//    valuationTrademark.setPercentroyalt(entity.getPercentroyalt());
    valuationTrademark.setCompetingmarketshare(entity.getCompetingmarketshare());
    valuationTrademark.setMarkethistory(entity.getMarkethistory());
//    valuationTrademark.setGrowthrate(entity.getGrowthrate());
    valuationTrademark.setTurnovertarget(entity.getTurnovertarget());
    valuationTrademark.setTrademarkturnoverpercent(entity.getTrademarkturnoverpercent());
    valuationTrademark.setIncomeincreasepercent(entity.getIncomeincreasepercent());
    valuationTrademark.setLicense(entity.getLicense());
    valuationTrademark.setLicenseroyalt(entity.getLicenseroyalt());
    valuationTrademark.setContract(entity.getContract());
    valuationTrademark.setAdvertisement(entity.getAdvertisement());
    valuationTrademark.setTotalexpenditure(entity.getTotalexpenditure());
    valuationTrademark.setCountryoutside(entity.getCountryoutside());
    valuationTrademark.setEuropeanunion(entity.getEuropeanunion());
    return valuationTrademark;
  }

  /**
   * valuationTrademarkApplication list
   *
   * @return .
   */
  @GetMapping("/valuationTrademarkApplications")
  public ValuationTrademarkList getValuationTrademarkApplications() {

    List<ValuationTrademarkEntity> entities = valuationTrademarkRepository.findAll();
    List<ValuationTrademark> valuationTrademarkList = new ArrayList<>();
    for (ValuationTrademarkEntity entity : entities) {
      ValuationTrademark valuationTrademark = new ValuationTrademark();
      valuationTrademark.setId(entity.getId());
      valuationTrademark.setAddress(entity.getAddress());
      valuationTrademark.setCreatedAt(entity.getCreatedAt());
      valuationTrademark.setName_surname(entity.getName_surname());
      valuationTrademark.setValuationTrademarkAppNo(entity.getValuationTrademarkAppNo());
      valuationTrademark.setLegalPerson(entity.getLegalPerson());
      valuationTrademark.setEmail(entity.getEmail());
      valuationTrademark.setTc(entity.getTc());
      valuationTrademark.setTel(entity.getTel());
      valuationTrademarkList.add(valuationTrademark);
    }
    ValuationTrademarkList valuationTrademarkList1 = new ValuationTrademarkList();
    valuationTrademarkList1.setValuationTrademarks(valuationTrademarkList);
    return valuationTrademarkList1;
  }

  /**
   * valuationTrademarkApplication list
   *
   * @return .
   */
  @GetMapping("/valuationPatentApplications")
  public ValuationPatentList getValuationPatentkApplications() {

    List<ValuationPatentEntity> entities = valuationPatentRepository.findAll();
    List<ValuationPatent> valuationPatentList = new ArrayList<>();
    for (ValuationPatentEntity entity : entities) {
      ValuationPatent valuationPatent = new ValuationPatent();
      valuationPatent.setId(entity.getId());
      valuationPatent.setAddress(entity.getAddress());
      valuationPatent.setCreatedAt(entity.getCreatedAt());
      valuationPatent.setName_surname(entity.getName_surname());
      valuationPatent.setLegalPerson(entity.getLegalPerson());
      valuationPatent.setEmail(entity.getEmail());
      valuationPatent.setTc(entity.getTc());
      valuationPatent.setTel(entity.getTel());
      valuationPatentList.add(valuationPatent);
    }
    ValuationPatentList valuationPatentList1 = new ValuationPatentList();
    valuationPatentList1.setValuationPatents(valuationPatentList);
    return valuationPatentList1;
  }

  /**
   * valuationTrademarkApplication list
   *
   * @return .
   */
  @GetMapping("/valuationPatentApplications/{id}")
  public ValuationPatent getValuationPatentApplicationsById(@PathVariable("id") Long id) {

    ValuationPatentEntity entity = valuationPatentRepository.getById(id);
    ValuationPatent valuationPatent = new ValuationPatent();
    valuationPatent.setId(entity.getId());
    valuationPatent.setName_surname(entity.getName_surname());
    valuationPatent.setLegalPerson(entity.getLegalPerson());
    valuationPatent.setEmail(entity.getEmail());
    valuationPatent.setTc(entity.getTc());
    valuationPatent.setTel(entity.getTel());
    valuationPatent.setAddress(entity.getAddress());
    valuationPatent.setPatentpurpose(entity.getPatentpurpose());
    valuationPatent.setPatentappno(entity.getPatentappno());
    valuationPatent.setPatentcountry(entity.getPatentcountry());
    valuationPatent.setPatentmarket(entity.getPatentmarket());
    valuationPatent.setLicenseChoose(entity.getLicenseChoose());
//    valuationPatent.setPatentcontribution(entity.getPatentcontribution());
    valuationPatent.setPatentsector(entity.getPatentsector());
    valuationPatent.setPatentothersector(entity.getPatentothersector());
    valuationPatent.setMarketshare(entity.getMarketshare());
//    valuationPatent.setPercentageturnover(entity.getPercentageturnover());
    valuationPatent.setOverseasmarketshare(entity.getOverseasmarketshare());
    valuationPatent.setExportcountry(entity.getExportcountry());
    valuationPatent.setExportturnover(entity.getExportturnover());
//    valuationPatent.setRoyaltyrate(entity.getRoyaltyrate());
    valuationPatent.setCompetingmarketshare(entity.getCompetingmarketshare());
    valuationPatent.setCompetitordate(entity.getCompetitordate());
//    valuationPatent.setCompetinggrowthrate(entity.getCompetinggrowthrate());
    valuationPatent.setTurnovertarget(entity.getTurnovertarget());
    valuationPatent.setTurnoverpercent(entity.getTurnoverpercent());
    valuationPatent.setIncomepercent(entity.getIncomepercent());
    valuationPatent.setLicense(entity.getLicense());
    valuationPatent.setLicenseroyalt(entity.getLicenseroyalt());
    valuationPatent.setContract(entity.getContract());
    valuationPatent.setAdvertisement(entity.getAdvertisement());
    valuationPatent.setTotalexpenditure(entity.getTotalexpenditure());
    valuationPatent.setSpending(entity.getSpending());
//    valuationPatent.setDevelopmentspending(entity.getDevelopmentspending());
    valuationPatent.setWorldspending(entity.getWorldspending());
    valuationPatent.setCaseexpense(entity.getCaseexpense());
    valuationPatent.setCountryoutside(entity.getCountryoutside());
    valuationPatent.setEuropeanunio(entity.getEuropeanunio());


    return valuationPatent;
  }


  /**
   * valuationTrademarkApplication list
   *
   * @return .
   */
  @GetMapping("/activityAnalysisApplications/{id}")
  public ActivityAnalysis getActivityAnalysisApplicationsById(@PathVariable("id") Long id) {

    ActivityAnalysisEntity entity = activityAnalysisRepository.getById(id);
    ActivityAnalysis activityAnalysis = new ActivityAnalysis();
    activityAnalysis.setId(entity.getId());
    activityAnalysis.setAddress(entity.getAddress());
    activityAnalysis.setName_surname(entity.getName_surname());
    activityAnalysis.setTc(entity.getTc());
    activityAnalysis.setTel(entity.getTel());
    activityAnalysis.setEmail(entity.getEmail());
    activityAnalysis.setKeyWord(entity.getKeyWord());
    activityAnalysis.setOpponent(entity.getOpponent());
    activityAnalysis.setTechnicalcomponent(entity.getTechnicalcomponent());
    activityAnalysis.setImage(entity.getImage());
    activityAnalysis.setOtherpoint(entity.getOtherpoint());
    activityAnalysis.setDekontBase64("data: image/jpeg;base64," +
        new String(Base64.encodeBase64(entity.getDekont()), StandardCharsets.US_ASCII));
    activityAnalysis.setLegalPerson(entity.getLegalPerson());


    return activityAnalysis;
  }

  /**
   * valuationTrademarkApplication list
   *
   * @return .
   */
  @GetMapping("/activityAnalysisApplicationPicturesByActivityAnalysisId/{id}")
  public ActivityAnalysisPicturesList getActivityAnalysisApplicationPicturesByActivityAnalysisId(@PathVariable("id") Long id) {

    List<ActivityAnalysisPicturesEntity> entities = activityAnalysisPicturesRepository.getByActivityAnalysisId(id);
    List<ActivityAnalysisPictures> activityAnalysisPictures = new ArrayList<>();
    for (ActivityAnalysisPicturesEntity entity:entities) {
      ActivityAnalysisPictures model = new ActivityAnalysisPictures();
      model.setId(entity.getId());
      model.setPictureBase64("data: image/jpeg;base64," +
          new String(Base64.encodeBase64(entity.getPicture()), StandardCharsets.US_ASCII));
      activityAnalysisPictures.add(model);
    }

    ActivityAnalysisPicturesList activityAnalysisPicturesList = new ActivityAnalysisPicturesList();
    activityAnalysisPicturesList.setActivityAnalysesPicturesList(activityAnalysisPictures);

    return activityAnalysisPicturesList;
  }


  /**
   * trademarkpreapplications list
   *
   * @return .
   */
  @GetMapping("/activityAnalysisApplications")
  public ActivityAnalysisList getActivityAnalysisApplications() {
    List<ActivityAnalysisEntity> activityAnalysisEntities = activityAnalysisRepository.findAll();
    List<ActivityAnalysis> activityAnalyses = new ArrayList<>();
    for (ActivityAnalysisEntity entity: activityAnalysisEntities) {
      ActivityAnalysis activityAnalysis = new ActivityAnalysis();
      activityAnalysis.setId(entity.getId());
      activityAnalysis.setName_surname(entity.getName_surname());
      activityAnalysis.setTc(entity.getTc());
      activityAnalysis.setAddress(entity.getAddress());
      activityAnalysis.setTel(entity.getTel());
      activityAnalysis.setEmail(entity.getEmail());
      activityAnalysis.setCreatedAt(entity.getCreatedAt());
      activityAnalysis.setLegalPerson(entity.getLegalPerson());
      activityAnalyses.add(activityAnalysis);
    }

    ActivityAnalysisList activityAnalysisList = new ActivityAnalysisList();
    activityAnalysisList.setActivityAnalyses(activityAnalyses);
    return activityAnalysisList;
  }



  /**
   * news list
   *
   * @return .
   */
  @GetMapping("/patentPreApplications/{id}")
  public PatentPre getPatentPreApplicationsById(@PathVariable("id") Long id) {

    PatentPreEntity entity = patentPreRepository.getById(id);
    PatentPre patentPre = new PatentPre();
    patentPre.setId(entity.getId());
    patentPre.setName_surname(entity.getName_surname());
    patentPre.setTc(entity.getTc());
    patentPre.setAddress(entity.getAddress());
    patentPre.setTel(entity.getTel());
    patentPre.setEmail(entity.getEmail());
    patentPre.setCreatedAt(entity.getCreatedAt());
    patentPre.setDekontBase64("data: image/jpeg;base64," +
        new String(Base64.encodeBase64(entity.getDekont()), StandardCharsets.US_ASCII));

    patentPre.setProtectiontype(entity.getProtectiontype());
    patentPre.setReporttype(entity.getReporttype());
    patentPre.setComputerarea(entity.getComputerarea());
    patentPre.setElectricityarea(entity.getElectricityarea());
    patentPre.setElectronicarea(entity.getElectronicarea());
    patentPre.setMachinearea(entity.getMachinearea());
    patentPre.setMedicinearea(entity.getMedicinearea());
    patentPre.setAutomotivearea(entity.getAutomotivearea());
    patentPre.setMetallurgyarea(entity.getMetallurgyarea());
    patentPre.setBiomedicalarea(entity.getBiomedicalarea());
    patentPre.setChemistryarea(entity.getChemistryarea());
    patentPre.setFoodarea(entity.getFoodarea());
    patentPre.setBuildarea(entity.getBuildarea());
    patentPre.setOtherarea(entity.getOtherarea());
    patentPre.setTitle(entity.getTitle());
    patentPre.setPatentkeyword(entity.getPatentkeyword());
    patentPre.setPatentapplication(entity.getPatentapplication());
    patentPre.setAdvantage(entity.getAdvantage());
    patentPre.setPublications(entity.getPublications());
    patentPre.setDetailexplain(entity.getDetailexplain());
    patentPre.setPicture(entity.getPicture());
    patentPre.setOtherpoint(entity.getOtherpoint());
    patentPre.setLegalPerson(entity.getLegalPerson());


    return patentPre;
  }

  /**
   * news list
   *
   * @return .
   */
  @GetMapping("/patentPreApplicationRelatedPicturesByPatentPreId/{id}")
  public PatentPreRelatedPicturesList getPatentPreApplicationRelatedPicturesByPatentPreId(@PathVariable("id") Long id) {

    List<PatentPreRelatedPicturesEntity> entities = patentPreRelatedPicturesRepository.getByPatentPreId(id);
    List<PatentPreRelatedPictures> patentPreRelatedPictures = new ArrayList<>();
    for (PatentPreRelatedPicturesEntity entity:entities) {
      PatentPreRelatedPictures model = new PatentPreRelatedPictures();
      model.setId(entity.getId());
      model.setPictureBase64("data: image/jpeg;base64," +
          new String(Base64.encodeBase64(entity.getPicture()), StandardCharsets.US_ASCII));
      patentPreRelatedPictures.add(model);
    }

    PatentPreRelatedPicturesList patentPreRelatedPicturesList = new PatentPreRelatedPicturesList();
    patentPreRelatedPicturesList.setPatentPreRelatedPictures(patentPreRelatedPictures);

    return patentPreRelatedPicturesList;
  }

  /**
   * news list
   *
   * @return .
   */
  @GetMapping("/patentPreApplicationFullDateTableByPatentPreId/{id}")
  public FullDataList getPatentPreApplicationFullDateTableByPatentPreId(@PathVariable("id") Long id) {

    List<PatentPreTableEntity> entities = patentPreTableRepository.getByPatentPreId(id);
    List<FullData> fullDataList = new ArrayList<>();
    for (PatentPreTableEntity entity:entities) {
      FullData model = new FullData();
      model.setId(entity.getId().toString());
      model.setDeferencechoose(entity.getDeferencechoose());
      model.setDeferenceno(entity.getDeferenceno());
      model.setDeferencepriority(entity.getDeferencepriority());
      fullDataList.add(model);
    }

    FullDataList fullDataList1 = new FullDataList();
    fullDataList1.setFullData(fullDataList);

    return fullDataList1;
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
   * notice
   *
   * @return .
   */
  @GetMapping("/notice/{id}")
  public Notice getNoticeById(@PathVariable("id") Long id) {

    Notice notice = noticeInfoService.getNoticeById(id);
    return notice;
  }

  /**
   * about
   *
   * @return .
   */
  @GetMapping("/aboutBy")
  public About getAboutBy() {

    About about = aboutInfoService.getAboutBy();
    return about;
  }

  /**
   * companyprofile
   *
   * @return .
   */
  @GetMapping("/companyProfileBy")
  public CompanyProfile getCompanyProfileBy() {

    CompanyProfile companyProfile = companyProfileInfoService.getCompanyProfileBy();
    return companyProfile;
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


    newsInfoService.updateNewsPicture(id, mainPicture);

    return ResponseEntity.ok(new MessageResponse("Ana resmi Güncelleme işleminiz başarılı!"));
  }

  /**
   * notice list
   *
   * @return .
   */
  @PostMapping(value = "/noticeUpdatePicture", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> updateNoticePicture(@RequestParam("id") Long id, @RequestParam("picture") MultipartFile picture) throws Exception {


    noticeInfoService.updateNoticePicture(id, picture);

    return ResponseEntity.ok(new MessageResponse("Ana resmi Güncelleme işleminiz başarılı!"));
  }

  /**
   * about list
   *
   * @return .
   */
  @PostMapping(value = "/aboutUpdatePicture", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> updateAboutPicture(@RequestParam("id") Long id, @RequestParam("picture") MultipartFile picture) throws Exception {


    aboutInfoService.updateAboutPicture(id, picture);

    return ResponseEntity.ok(new MessageResponse("Ana resmi Güncelleme işleminiz başarılı!"));
  }

  /**
   * companyProfile list
   *
   * @return .
   */
  @PostMapping(value = "/companyProfileUpdatePicture", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> updateCompanyProfilePicture(@RequestParam("id") Long id, @RequestParam("picture") MultipartFile picture) throws Exception {

    companyProfileInfoService.updateCompanyProfilePicture(id, picture);

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
   * notice list
   *
   * @return .
   */
  @GetMapping("/noticePublished")
  public NoticeList getNoticePublished() {
    //list dönen servis için bir class daha yazıp öyle handle ettik
    NoticeList noticeList = noticeInfoService.getNoticePublishedList();
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
        trademarkPre.getEmail(),
        trademarkPre.getLegalPerson(),
        trademarkPre.getTrademarkItemList()
    ));


    TrademarkPre trademarkPre1 = new TrademarkPre(entity.getId(), entity.getTrademarktype(), entity.getTrademarkimage(),
        entity.getTrademarktext(), entity.getTrademarkclass(), entity.getName_surname(), entity.getTc(),
        entity.getAddress(), entity.getTel(), entity.getEmail(), entity.getLegalPerson(), entity.getTrademarkItemList());

    General general = new General("Kayıt işleminiz başarılı...", entity.getId());

    return ResponseEntity.ok(general);
  }

  @PostMapping(value = "/invalidationAssessmentSave")
  public ResponseEntity<General> postInvalidationAssessment(@RequestBody InvalidationAssessment invalidationAssessment) {

    InvalidationAssessmentEntity entity = invalidationAssessmentRepository.save(new InvalidationAssessmentEntity(
        invalidationAssessment.getAppNo(),
        invalidationAssessment.getTc(),
        invalidationAssessment.getAddress(),
        invalidationAssessment.getTel(),
        invalidationAssessment.getEmail()));


    InvalidationAssessment invalidationAssessment1 = new InvalidationAssessment(entity.getId(), entity.getAppNo(), entity.getTc(),
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
        patentPre.getOtherpoint(),
        patentPre.getLegalPerson()
    ));
    General general = new General();
    general.setMessage("Kayıt işleminiz başarılı!");
    general.setId(patentPreEntity.getId());


    return ResponseEntity.ok(general);
  }

  @PostMapping(value = "/valuationPatentSave")
  public ResponseEntity<General> valuationPatentSave(@RequestBody ValuationPatent valuationPatent) {

    ValuationPatentEntity valuationPatentEntity = valuationPatentRepository.save(new ValuationPatentEntity(
        valuationPatent.getAddress(),
        valuationPatent.getPatentpurpose(),
        valuationPatent.getPatentappno(),
        valuationPatent.getPatentcountry(),
        valuationPatent.getPatentmarket(),
        valuationPatent.getPatentsector(),
        valuationPatent.getPatentothersector(),
        valuationPatent.getMarketshare(),
        valuationPatent.getOverseasmarketshare(),
        valuationPatent.getExportcountry(),
        valuationPatent.getExportturnover(),
        valuationPatent.getCompetingmarketshare(),
        valuationPatent.getCompetitordate(),
        valuationPatent.getTurnovertarget(),
        valuationPatent.getTurnoverpercent(),
        valuationPatent.getIncomepercent(),
        valuationPatent.getLicense(),
        valuationPatent.getLicenseroyalt(),
        valuationPatent.getContract(),
        valuationPatent.getAdvertisement(),
        valuationPatent.getTotalexpenditure(),
        valuationPatent.getSpending(),
        valuationPatent.getWorldspending(),
        valuationPatent.getCaseexpense(),
        valuationPatent.getCountryoutside(),
        valuationPatent.getEuropeanunio(),
        valuationPatent.getName_surname(),
        valuationPatent.getTc(),
        valuationPatent.getTel(),
        valuationPatent.getEmail(),
        valuationPatent.getLegalPerson(),
        valuationPatent.getLicenseChoose()
    ));
    General general = new General();
    general.setMessage("Kayıt işleminiz başarılı!");
    general.setId(valuationPatentEntity.getId());


    return ResponseEntity.ok(general);
  }

  @PostMapping(value = "/valuationTrademarkSave")
  public ResponseEntity<General> valuationTrademarkSave(@RequestBody ValuationTrademark valuationTrademark) {

    ValuationTrademarkEntity valuationTrademarkEntity = valuationTrademarkRepository.save(new ValuationTrademarkEntity(
        valuationTrademark.getAddress(),
        valuationTrademark.getTrademarkpurpose(),
        valuationTrademark.getCommonusage(),
        valuationTrademark.getTargetcountry(),
        valuationTrademark.getTrademarktime(),
        valuationTrademark.getMarkettime(),
        valuationTrademark.getTrademarkcontribution(),
        valuationTrademark.getMainsector(),
        valuationTrademark.getOthersector(),
        valuationTrademark.getMarketshare(),
        valuationTrademark.getOverseasmarketshare(),
        valuationTrademark.getExportcountry(),
        valuationTrademark.getTurnoverpercent(),
        valuationTrademark.getCompetingmarketshare(),
        valuationTrademark.getMarkethistory(),
        valuationTrademark.getTurnovertarget(),
        valuationTrademark.getTrademarkturnoverpercent(),
        valuationTrademark.getIncomeincreasepercent(),
        valuationTrademark.getLicense(),
        valuationTrademark.getLicenseroyalt(),
        valuationTrademark.getContract(),
        valuationTrademark.getAdvertisement(),
        valuationTrademark.getTotalexpenditure(),
        valuationTrademark.getCountryoutside(),
        valuationTrademark.getEuropeanunion(),
        valuationTrademark.getName_surname(),
        valuationTrademark.getTc(),
        valuationTrademark.getTel(),
        valuationTrademark.getEmail(),
        valuationTrademark.getLegalPerson(),
        valuationTrademark.getValuationTrademarkAppNo(),
        valuationTrademark.getLicenseChoose()
    ));
    General general = new General();
    general.setMessage("Kayıt işleminiz başarılı!");
    general.setId(valuationTrademarkEntity.getId());


    return ResponseEntity.ok(general);
  }

  @PostMapping(value = "/activityAnalysisSave")
  public ResponseEntity<General> activityAnalysisSave(@RequestBody ActivityAnalysis activityAnalysis) {

    ActivityAnalysisEntity activityAnalysisEntity = activityAnalysisRepository.save(new ActivityAnalysisEntity(
        activityAnalysis.getName_surname(),
        activityAnalysis.getTc(),
        activityAnalysis.getAddress(),
        activityAnalysis.getTel(),
        activityAnalysis.getEmail(),
        activityAnalysis.getKeyWord(),
        activityAnalysis.getOpponent(),
        activityAnalysis.getTechnicalcomponent(),
        activityAnalysis.getImage(),
        activityAnalysis.getOtherpoint(),
        activityAnalysis.getLegalPerson()
    ));


    General general = new General();
    general.setMessage("Kayıt işleminiz başarılı!");
    general.setId(activityAnalysisEntity.getId());


    return ResponseEntity.ok(general);
  }

  private void sendMail(String replyText, String[] to, String subject, int id, String appNo) {
    Mail mail = new Mail();
    mail.setFrom("test@turksmd.com.tr");
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
      return ResponseEntity.ok(new MessageResponse("Mail Gönderilmiştir!"));
    } catch (Exception e) {
      logger.error(e.getLocalizedMessage());
      return ResponseEntity.ok(new MessageResponse("Mail Gönderilememiştir! Lütfen sorumlu ile görüşürünüz."));
    }

  }

  @PostMapping(value = "/sendEmailInvalidationAssessment/{id}")
  public ResponseEntity<?> sendEmailInvalidationAssessment(@PathVariable("id") Long id) {

    try {
      emailService.sendMimeMessage(id, 6);
      return ResponseEntity.ok(new MessageResponse("Mail Gönderilmiştir!"));
    } catch (Exception e) {
      logger.error(e.getLocalizedMessage());
      return ResponseEntity.ok(new MessageResponse("Mail Gönderilememiştir! Lütfen sorumlu ile görüşürünüz."));
    }

  }


  @PostMapping(value = "/addNews")
  public ResponseEntity<?> addNews(@RequestBody News news) {

    newsInfoService.addNews(news);

    return ResponseEntity.ok(new MessageResponse("Kayıt işleminiz başarılı!"));
  }


  @PostMapping(value = "/addNewsAll", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<General> addNewsAll(@RequestParam("newsTitle") String newsTitle, @RequestParam("newsExplain") String newsExplain,
                                            @RequestParam("published") Boolean published,
                                            @RequestParam("mainPicture") MultipartFile mainPicture) throws Exception {

    News news = new News(mainPicture.getBytes(), newsTitle, newsExplain, mainPicture.getOriginalFilename(), mainPicture.getContentType(), published);

    Long id = newsInfoService.addNews(news);

    General general = new General();
    general.setMessage("Kayıt işleminiz başarılı!");
    general.setId(id);


    return ResponseEntity.ok(general);
  }

  @PostMapping(value = "/addNotice", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<General> addNotice(@RequestParam("noticeTitle") String noticeTitle, @RequestParam("noticeExplain") String noticeExplain,
                                           @RequestParam("published") Boolean published,
                                           @RequestParam("picture") MultipartFile picture) throws Exception {


    Notice notice = new Notice(picture.getBytes(), noticeTitle, noticeExplain, picture.getOriginalFilename(), picture.getContentType(), published);

    Long id = noticeInfoService.addNotice(notice);

    General general = new General();
    general.setMessage("Kayıt işleminiz başarılı!");
    general.setId(id);


    return ResponseEntity.ok(general);
  }

  @PostMapping(value = "/addNewsFiles", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> addNewsFiles(@RequestParam("id") Long id, @RequestParam("relatedPictures") MultipartFile relatedPictures) throws Exception {

    newsInfoService.addNewsRelatedPictures(id, relatedPictures);


    return ResponseEntity.ok(new MessageResponse("Kayıt işleminiz başarılı!"));
  }

  @PostMapping(value = "/addMultipartFiles", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> addMultipartFiles(@RequestParam("pictures") MultipartFile[] pictures, @RequestParam("dekont") MultipartFile dekont) throws Exception {

    System.out.println(pictures.length);
    for (int i = 0; i < pictures.length; i++) {
      String fileName = pictures[i].getOriginalFilename();
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


    newsInfoService.updateNewsRelatedPicture(id, relatedPicture);

    return ResponseEntity.ok(new MessageResponse("Resim güncelleme başarılı!"));
  }

  @PostMapping(value = "/sendContactMail")
  public ResponseEntity<?> sendContactMail(@RequestBody ContactMail contactMail) {
    try {
      contactMailRepository.save(new ContactMailEntity(contactMail.getEmail(), contactMail.getNameSurname(), contactMail.getMessage()));

      String[] to = {"test@turksmd.com.tr"};
      String content = "Ad Soyad:" + contactMail.getNameSurname() + "Email:" + contactMail.getEmail() + "Message:" + contactMail.getMessage();
      sendMail(content, to, contactMail.getEmail(), 1, "");
      return ResponseEntity.ok(new MessageResponse("Mailiniz gönderilmiştir!"));
    } catch (Exception e) {
      logger.error(e.getLocalizedMessage());
      return ResponseEntity.ok(new MessageResponse("Mailiniz gönderilememiştir. Lütfen email bilginizi kontrol ediniz!"));
    }

  }


  @PostMapping(value = "/fullData/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> sendDataTable(@PathVariable("id") Long id, @RequestBody FullDataList fullDataList) {

    patentPreService.savePatentPreTable(id, fullDataList);

    return ResponseEntity.ok(new MessageResponse("Başarılı"));
  }


  @PostMapping(value = "/sendEmailPatentPre/{id}")
  public ResponseEntity<?> sendEmailPatentPre(@PathVariable("id") Long id) {

    try {
      emailService.sendMimeMessage(id, 2);
      return ResponseEntity.ok(new MessageResponse("Mail Gönderilmiştir!"));

    } catch (Exception e) {
      logger.error(e.getLocalizedMessage());
      return ResponseEntity.ok(new MessageResponse("Mail Gönderilememiştir! Lütfen sorumlu ile görüşürünüz."));
    }


  }

  @PostMapping(value = "/sendEmailValuationPatent/{id}")
  public ResponseEntity<?> sendEmailValuationPatent(@PathVariable("id") Long id) {

    try {
      emailService.sendMimeMessage(id, 3);
      return ResponseEntity.ok(new MessageResponse("Mail Gönderilmiştir!"));

    } catch (Exception e) {
      logger.error(e.getLocalizedMessage());
      return ResponseEntity.ok(new MessageResponse("Mail Gönderilememiştir! Lütfen sorumlu ile görüşürünüz."));
    }

  }

  @PostMapping(value = "/sendEmailValuationTrademark/{id}")
  public ResponseEntity<?> sendEmailValuationTrademark(@PathVariable("id") Long id) {

    try {
      emailService.sendMimeMessage(id, 4);
      return ResponseEntity.ok(new MessageResponse("Mail Gönderilmiştir!"));
    } catch (Exception e) {
      logger.error(e.getLocalizedMessage());
      return ResponseEntity.ok(new MessageResponse("Mail Gönderilememiştir! Lütfen sorumlu ile görüşürünüz."));
    }

  }

  @PostMapping(value = "/sendEmailActivityAnalysis/{id}")
  public ResponseEntity<?> sendEmailActivityAnalysis(@PathVariable("id") Long id) {

    try {
      emailService.sendMimeMessage(id, 5);
      return ResponseEntity.ok(new MessageResponse("Mail Gönderilmiştir!"));
    } catch (Exception e) {
      logger.error(e.getLocalizedMessage());
      return ResponseEntity.ok(new MessageResponse("Mail Gönderilememiştir! Lütfen sorumlu ile görüşürünüz."));
    }

  }

  @PostMapping(value = "/addPatentPreRelatedPictures/{patentPreId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> addPatentPreRelatedPictures(@PathVariable("patentPreId") Long patentPreId,
                                                       @RequestParam("pictures") MultipartFile[] pictures)
      throws Exception {

    patentPreService.addPatentPreRelatedPictures(patentPreId, pictures);

    return ResponseEntity.ok(new MessageResponse("Kayıt işleminiz başarılı!"));
  }

  @PostMapping(value = "/addPatentPreDekont/{patentPreId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> addPatentPreDekont(@PathVariable("patentPreId") Long patentPreId,
                                              @RequestParam("dekont") MultipartFile dekont) throws Exception {

    patentPreService.addDekont(patentPreId, dekont);

    return ResponseEntity.ok(new MessageResponse("Kayıt işleminiz başarılı!"));
  }

  @PostMapping(value = "/addValuationPatentDekont/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> addValuationPatentDekont(@PathVariable("id") Long id,
                                                    @RequestParam("dekont") MultipartFile dekont) throws Exception {

    valuationService.addValuationPatentDekont(id, dekont);

    return ResponseEntity.ok(new MessageResponse("Kayıt işleminiz başarılı!"));
  }

  @PostMapping(value = "/addValuationTrademarkDekont/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> addValuationTrademarkDekont(@PathVariable("id") Long id,
                                                       @RequestParam("dekont") MultipartFile dekont) throws Exception {

    valuationService.addValuationTrademarkDekont(id, dekont);

    return ResponseEntity.ok(new MessageResponse("Kayıt işleminiz başarılı!"));
  }

  @PostMapping(value = "/addActivityAnalysisDekont/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> addActivityAnalysisDekont(@PathVariable("id") Long id,
                                                     @RequestParam("dekont") MultipartFile dekont) throws Exception {

    activityAnalysisService.addActivityAnalysisDekont(id, dekont);

    return ResponseEntity.ok(new MessageResponse("Kayıt işleminiz başarılı!"));
  }

  @PostMapping(value = "/addActivityAnalysisPictures/{activityId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> addActivityAnalysisPictures(@PathVariable("activityId") Long activityId,
                                                       @RequestParam("pictures") MultipartFile[] pictures)
      throws Exception {

    activityAnalysisService.addActivityAnalysisPictures(activityId, pictures);

    return ResponseEntity.ok(new MessageResponse("Kayıt işleminiz başarılı!"));
  }


  @PostMapping(value = "/deneme")
  public ResponseEntity<General> postTrademarkPre(@RequestBody String editor) {


    General general = new General("Kayıt işleminiz başarılı...", 1L);

    return ResponseEntity.ok(general);
  }


  /**
   * trademarkpreview
   *
   * @return .
   */
  @GetMapping("/trademarkPreBy")
  public TrademarkPreView getTrademarkPreViewBy() {

    TrademarkPreView trademarkPreView = servicesInfoService.getTrademarkPreViewBy();
    return trademarkPreView;
  }


  /**
   * trademarkpreview picture
   *
   * @return .
   */
  @PostMapping(value = "/trademarkPreUpdatePicture", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> updateTrademarkPreViewPicture(@RequestParam("id") Long id, @RequestParam("picture") MultipartFile picture) throws Exception {


    servicesInfoService.updateTrademarkPreViewPicture(id, picture);

    return ResponseEntity.ok(new MessageResponse("Ana resmi Güncelleme işleminiz başarılı!"));
  }

  /**
   * PatentPreView
   *
   * @return .
   */
  @GetMapping("patentPreBy")
  public PatentPreView getPatentPreViewBy() {

    PatentPreView patentPreView = servicesInfoService.getPatentPreViewBy();
    return patentPreView;
  }


  /**
   * PatentPreView picture
   *
   * @return .
   */
  @PostMapping(value = "/patentPreUpdatePicture", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> updatePatentPreViewPicture(@RequestParam("id") Long id, @RequestParam("picture") MultipartFile picture) throws Exception {


    servicesInfoService.updatePatentPreViewPicture(id, picture);

    return ResponseEntity.ok(new MessageResponse("Ana resmi Güncelleme işleminiz başarılı!"));
  }


  /**
   * ActivityAnalysisView
   *
   * @return .
   */
  @GetMapping("activityAnalysisBy")
  public ActivityAnalysisView getActivityAnalysisViewBy() {

    ActivityAnalysisView activityAnalysisView = servicesInfoService.getActivityAnalysisViewBy();
    return activityAnalysisView;
  }


  /**
   * ActivityAnalysisView picture
   *
   * @return .
   */
  @PostMapping(value = "/activityAnalysisUpdatePicture", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> updateActivityAnalysisViewPicture(@RequestParam("id") Long id, @RequestParam("picture") MultipartFile picture) throws Exception {


    servicesInfoService.updateActivityAnalysisViewPicture(id, picture);

    return ResponseEntity.ok(new MessageResponse("Ana resmi Güncelleme işleminiz başarılı!"));
  }


  /**
   * ValuationView
   *
   * @return .
   */
  @GetMapping("valuationBy")
  public ValuationView getValuationViewBy() {

    ValuationView valuationView = servicesInfoService.getValuationViewBy();
    return valuationView;
  }


  /**
   * ValuationView picture
   *
   * @return .
   */
  @PostMapping(value = "/valuationUpdatePicture", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> updateValuationViewPicture(@RequestParam("id") Long id, @RequestParam("picture") MultipartFile picture) throws Exception {


    servicesInfoService.updateTrademarkPreViewPicture(id, picture);

    return ResponseEntity.ok(new MessageResponse("Ana resmi Güncelleme işleminiz başarılı!"));
  }


  /**
   * EvaluationInvalidationView
   *
   * @return .
   */
  @GetMapping("evaluationInvalidationBy")
  public EvaluationInvalidationView getEvaluationInvalidationViewBy() {

    EvaluationInvalidationView evaluationInvalidationView = servicesInfoService.getEvaluationInvalidationViewBy();
    return evaluationInvalidationView;
  }


  /**
   * EvaluationInvalidationView picture
   *
   * @return .
   */
  @PostMapping(value = "/evaluationInvalidationUpdatePicture", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> updateEvaluationInvalidationViewPicture(@RequestParam("id") Long id, @RequestParam("picture") MultipartFile picture) throws Exception {


    servicesInfoService.updateEvaluationInvalidationViewPicture(id, picture);

    return ResponseEntity.ok(new MessageResponse("Ana resmi Güncelleme işleminiz başarılı!"));
  }


  /**
   * TechnologyConsultancyView
   *
   * @return .
   */
  @GetMapping("technologyConsultancyBy")
  public TechnologyConsultancyView getTechnologyConsultancyViewBy() {

    TechnologyConsultancyView technologyConsultancyView = servicesInfoService.getTechnologyConsultancyViewBy();
    return technologyConsultancyView;
  }


  /**
   * TechnologyConsultancyView picture
   *
   * @return .
   */
  @PostMapping(value = "/technologyConsultancyUpdatePicture", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> updateTechnologyConsultancyViewPicture(@RequestParam("id") Long id, @RequestParam("picture") MultipartFile picture) throws Exception {


    servicesInfoService.updateTechnologyConsultancyViewPicture(id, picture);

    return ResponseEntity.ok(new MessageResponse("Ana resmi Güncelleme işleminiz başarılı!"));
  }


  @PostMapping(value = "/uploadTrademarkPreViewPdfFiles/{trademarkPreViewId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> uploadTrademarkPreViewPdfFiles(@PathVariable("trademarkPreViewId") Long trademarkPreViewId,
                                                       @RequestParam("pdfFiles") MultipartFile[] pdfFiles)
      throws Exception {

    servicesInfoService.uploadTrademarkPreViewPdfFiles(trademarkPreViewId, pdfFiles);

    return ResponseEntity.ok(new MessageResponse("Kayıt işleminiz başarılı!"));
  }

  /**
   * about list
   *
   * @return .
   */
  @GetMapping("/getTrademarkPreViewPdfFiles/{trademarkPreViewId}")
  public TrademarkPreViewPdfList getTrademarkPreViewPdfFiles(@PathVariable("trademarkPreViewId") Long trademarkPreViewId) {
    //list dönen servis için bir class daha yazıp öyle handle ettik
    TrademarkPreViewPdfList trademarkPreViewPdfList = servicesInfoService.getTrademarkPreViewPdfFiles(trademarkPreViewId);
    return trademarkPreViewPdfList;
  }

  /**
   * about list
   *
   * @return .
   */
  @GetMapping("/deleteTrademarkPreViewPdf/{id}")
  public ResponseEntity<?> deleteTrademarkPreViewPdf(@PathVariable("id") Long id) {
    //list dönen servis için bir class daha yazıp öyle handle ettik
    servicesInfoService.deleteTrademarkPreViewPdfById(id);
    return ResponseEntity.ok(new MessageResponse("Silindi!"));
  }

  /**
   * about list
   *
   * @return .
   */
  @GetMapping("/downloadTrademarkPreViewPdf/{id}")
  public ResponseEntity<Resource> downloadTrademarkPreViewPdf(@PathVariable("id") Long id) {
    //list dönen servis için bir class daha yazıp öyle handle ettik
    TrademarkPreViewPdfEntity trademarkPreViewPdfEntity = servicesInfoService.getTrademarkPreViewPdfById(id);
    return ResponseEntity.ok()
        .contentType(MediaType.parseMediaType(trademarkPreViewPdfEntity.getFileType()))
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""
            + trademarkPreViewPdfEntity.getFileName() + "\"")
        .body(new ByteArrayResource(trademarkPreViewPdfEntity.getPdfFile()));
  }

  @PostMapping(value = "/uploadPatentPreViewPdfFiles/{patentPreViewId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> uploadPatentPreViewPdfFiles(@PathVariable("patentPreViewId") Long patentPreViewId,
                                                          @RequestParam("pdfFiles") MultipartFile[] pdfFiles)
      throws Exception {

    servicesInfoService.uploadPatentPreViewPdfFiles(patentPreViewId, pdfFiles);

    return ResponseEntity.ok(new MessageResponse("Kayıt işleminiz başarılı!"));
  }

  /**
   * about list
   *
   * @return .
   */
  @GetMapping("/getPatentPreViewPdfFiles/{patentPreViewId}")
  public PatentPreViewPdfList getPatentPreViewPdfFiles(@PathVariable("patentPreViewId") Long patentPreViewId) {
    //list dönen servis için bir class daha yazıp öyle handle ettik
    PatentPreViewPdfList patentPreViewPdfList = servicesInfoService.getPatentPreViewPdfFiles(patentPreViewId);
    return patentPreViewPdfList;
  }

  /**
   * about list
   *
   * @return .
   */
  @GetMapping("/deletePatentPreViewPdf/{id}")
  public ResponseEntity<?> deletePatentPreViewPdf(@PathVariable("id") Long id) {
    //list dönen servis için bir class daha yazıp öyle handle ettik
    servicesInfoService.deletePatentPreViewPdfById(id);
    return ResponseEntity.ok(new MessageResponse("Silindi!"));
  }

  /**
   * about list
   *
   * @return .
   */
  @GetMapping("/downloadPatentPreViewPdf/{id}")
  public ResponseEntity<Resource> downloadPatentPreViewPdf(@PathVariable("id") Long id) {
    //list dönen servis için bir class daha yazıp öyle handle ettik
    PatentPreViewPdfEntity patentPreViewPdfEntity = servicesInfoService.getPatentPreViewPdfById(id);
    return ResponseEntity.ok()
        .contentType(MediaType.parseMediaType(patentPreViewPdfEntity.getFileType()))
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""
            + patentPreViewPdfEntity.getFileName() + "\"")
        .body(new ByteArrayResource(patentPreViewPdfEntity.getPdfFile()));
  }

  @PostMapping(value = "/uploadActivityAnalysisViewPdfFiles/{activityAnalysisViewId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> uploadActivityAnalysisViewPdfFiles(@PathVariable("activityAnalysisViewId") Long activityAnalysisViewId,
                                                       @RequestParam("pdfFiles") MultipartFile[] pdfFiles)
      throws Exception {

    servicesInfoService.uploadActivityAnalysisViewPdfFiles(activityAnalysisViewId, pdfFiles);

    return ResponseEntity.ok(new MessageResponse("Kayıt işleminiz başarılı!"));
  }

  /**
   * about list
   *
   * @return .
   */
  @GetMapping("/getActivityAnalysisViewPdfFiles/{activityAnalysisViewId}")
  public ActivityAnalysisViewPdfList getActivityAnalysisViewPdfFiles(@PathVariable("activityAnalysisViewId") Long activityAnalysisViewId) {
    //list dönen servis için bir class daha yazıp öyle handle ettik
    ActivityAnalysisViewPdfList activityAnalysisViewPdfList = servicesInfoService.getActivityAnalysisViewPdfFiles(activityAnalysisViewId);
    return activityAnalysisViewPdfList;
  }

  /**
   * about list
   *
   * @return .
   */
  @GetMapping("/deleteActivityAnalysisViewPdf/{id}")
  public ResponseEntity<?> deleteActivityAnalysisViewPdf(@PathVariable("id") Long id) {
    //list dönen servis için bir class daha yazıp öyle handle ettik
    servicesInfoService.deleteActivityAnalysisViewPdfById(id);
    return ResponseEntity.ok(new MessageResponse("Silindi!"));
  }

  /**
   * about list
   *
   * @return .
   */
  @GetMapping("/downloadActivityAnalysisViewPdf/{id}")
  public ResponseEntity<Resource> downloadActivityAnalysisViewPdf(@PathVariable("id") Long id) {
    //list dönen servis için bir class daha yazıp öyle handle ettik
    ActivityAnalysisViewPdfEntity activityAnalysisViewPdfEntity = servicesInfoService.getActivityAnalysisViewPdfById(id);
    return ResponseEntity.ok()
        .contentType(MediaType.parseMediaType(activityAnalysisViewPdfEntity.getFileType()))
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""
            + activityAnalysisViewPdfEntity.getFileName() + "\"")
        .body(new ByteArrayResource(activityAnalysisViewPdfEntity.getPdfFile()));
  }

  @PostMapping(value = "/uploadValuationViewPdfFiles/{valuationViewId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> uploadValuationViewPdfFiles(@PathVariable("valuationViewId") Long valuationViewId,
                                                              @RequestParam("pdfFiles") MultipartFile[] pdfFiles)
      throws Exception {

    servicesInfoService.uploadValuationViewPdfFiles(valuationViewId, pdfFiles);

    return ResponseEntity.ok(new MessageResponse("Kayıt işleminiz başarılı!"));
  }

  /**
   * about list
   *
   * @return .
   */
  @GetMapping("/getValuationViewPdfFiles/{valuationViewId}")
  public ValuationViewPdfList getValuationViewPdfFiles(@PathVariable("valuationViewId") Long valuationViewId) {
    //list dönen servis için bir class daha yazıp öyle handle ettik
    ValuationViewPdfList valuationViewPdfList = servicesInfoService.getValuationViewPdfFiles(valuationViewId);
    return valuationViewPdfList;
  }

  /**
   * about list
   *
   * @return .
   */
  @GetMapping("/deleteValuationViewPdf/{id}")
  public ResponseEntity<?> deleteValuationViewPdf(@PathVariable("id") Long id) {
    //list dönen servis için bir class daha yazıp öyle handle ettik
    servicesInfoService.deleteValuationViewPdfById(id);
    return ResponseEntity.ok(new MessageResponse("Silindi!"));
  }

  /**
   * about list
   *
   * @return .
   */
  @GetMapping("/downloadValuationViewPdf/{id}")
  public ResponseEntity<Resource> downloadValuationViewPdf(@PathVariable("id") Long id) {
    //list dönen servis için bir class daha yazıp öyle handle ettik
    ValuationViewPdfEntity valuationViewPdfEntity = servicesInfoService.getValuationViewPdfById(id);
    return ResponseEntity.ok()
        .contentType(MediaType.parseMediaType(valuationViewPdfEntity.getFileType()))
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""
            + valuationViewPdfEntity.getFileName() + "\"")
        .body(new ByteArrayResource(valuationViewPdfEntity.getPdfFile()));
  }

  @PostMapping(value = "/uploadEvaluationInvalidationViewPdfFiles/{evaluationInvalidationViewId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> uploadEvaluationInvalidationViewPdfFiles(@PathVariable("evaluationInvalidationViewId") Long evaluationInvalidationViewId,
                                                       @RequestParam("pdfFiles") MultipartFile[] pdfFiles)
      throws Exception {

    servicesInfoService.uploadEvaluationInvalidationViewPdfFiles(evaluationInvalidationViewId, pdfFiles);

    return ResponseEntity.ok(new MessageResponse("Kayıt işleminiz başarılı!"));
  }

  /**
   * about list
   *
   * @return .
   */
  @GetMapping("/getEvaluationInvalidationViewPdfFiles/{evaluationInvalidationViewId}")
  public EvaluationInvalidationViewPdfList getEvaluationInvalidationViewPdfFiles(
      @PathVariable("evaluationInvalidationViewId") Long evaluationInvalidationViewId) {
    //list dönen servis için bir class daha yazıp öyle handle ettik
    EvaluationInvalidationViewPdfList evaluationInvalidationViewPdfList =
        servicesInfoService.getEvaluationInvalidationViewPdfFiles(evaluationInvalidationViewId);
    return evaluationInvalidationViewPdfList;
  }

  /**
   * about list
   *
   * @return .
   */
  @GetMapping("/deleteEvaluationInvalidationViewPdf/{id}")
  public ResponseEntity<?> deleteEvaluationInvalidationViewPdf(@PathVariable("id") Long id) {
    //list dönen servis için bir class daha yazıp öyle handle ettik
    servicesInfoService.deleteEvaluationInvalidationViewPdfById(id);
    return ResponseEntity.ok(new MessageResponse("Silindi!"));
  }

  /**
   * about list
   *
   * @return .
   */
  @GetMapping("/downloadEvaluationInvalidationViewPdf/{id}")
  public ResponseEntity<Resource> downloadEvaluationInvalidationViewPdf(@PathVariable("id") Long id) {
    //list dönen servis için bir class daha yazıp öyle handle ettik
    EvaluationInvalidationViewPdfEntity evaluationInvalidationViewPdfEntity =
        servicesInfoService.getEvaluationInvalidationViewPdfById(id);
    return ResponseEntity.ok()
        .contentType(MediaType.parseMediaType(evaluationInvalidationViewPdfEntity.getFileType()))
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""
            + evaluationInvalidationViewPdfEntity.getFileName() + "\"")
        .body(new ByteArrayResource(evaluationInvalidationViewPdfEntity.getPdfFile()));
  }

  @PostMapping(value = "/uploadTechnologyConsultancyViewPdfFiles/{technologyConsultancyViewId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> uploadTechnologyConsultancyViewPdfFiles(
      @PathVariable("technologyConsultancyViewId") Long technologyConsultancyViewId,
      @RequestParam("pdfFiles") MultipartFile[] pdfFiles)
      throws Exception {

    servicesInfoService.uploadTechnologyConsultancyViewPdfFiles(technologyConsultancyViewId, pdfFiles);

    return ResponseEntity.ok(new MessageResponse("Kayıt işleminiz başarılı!"));
  }

  /**
   * about list
   *
   * @return .
   */
  @GetMapping("/getTechnologyConsultancyViewPdfFiles/{technologyConsultancyViewId}")
  public TechnologyConsultancyViewPdfList getTechnologyConsultancyViewPdfFiles(
      @PathVariable("technologyConsultancyViewId") Long technologyConsultancyViewId) {
    //list dönen servis için bir class daha yazıp öyle handle ettik
    TechnologyConsultancyViewPdfList technologyConsultancyViewPdfList =
        servicesInfoService.getTechnologyConsultancyViewPdfFiles(technologyConsultancyViewId);
    return technologyConsultancyViewPdfList;
  }

  /**
   * about list
   *
   * @return .
   */
  @GetMapping("/deleteTechnologyConsultancyViewPdf/{id}")
  public ResponseEntity<?> deleteTechnologyConsultancyViewPdf(@PathVariable("id") Long id) {
    //list dönen servis için bir class daha yazıp öyle handle ettik
    servicesInfoService.deleteTechnologyConsultancyViewPdfById(id);
    return ResponseEntity.ok(new MessageResponse("Silindi!"));
  }

  /**
   * about list
   *
   * @return .
   */
  @GetMapping("/downloadTechnologyConsultancyViewPdf/{id}")
  public ResponseEntity<Resource> downloadTechnologyConsultancyViewPdf(@PathVariable("id") Long id) {
    //list dönen servis için bir class daha yazıp öyle handle ettik
    TechnologyConsultancyViewPdfEntity technologyConsultancyViewPdfEntity =
        servicesInfoService.getTechnologyConsultancyViewPdfById(id);
    return ResponseEntity.ok()
        .contentType(MediaType.parseMediaType(technologyConsultancyViewPdfEntity.getFileType()))
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""
            + technologyConsultancyViewPdfEntity.getFileName() + "\"")
        .body(new ByteArrayResource(technologyConsultancyViewPdfEntity.getPdfFile()));
  }
}
