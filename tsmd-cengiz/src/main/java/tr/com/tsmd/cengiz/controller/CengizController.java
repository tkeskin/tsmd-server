package tr.com.tsmd.cengiz.controller;

import java.util.List;
import java.util.stream.Collectors;
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
import org.springframework.web.bind.annotation.RestController;
import tr.com.tsmd.auth.payload.response.MessageResponse;
import tr.com.tsmd.cengiz.models.About;
import tr.com.tsmd.cengiz.models.ActivityAnalysisView;
import tr.com.tsmd.cengiz.models.CatalogItem;
import tr.com.tsmd.cengiz.models.CompanyProfile;
import tr.com.tsmd.cengiz.models.EvaluationInvalidationView;
import tr.com.tsmd.cengiz.models.News;
import tr.com.tsmd.cengiz.models.Notice;
import tr.com.tsmd.cengiz.models.PatentPreServiceCharges;
import tr.com.tsmd.cengiz.models.PatentPreView;
import tr.com.tsmd.cengiz.models.Slogan;
import tr.com.tsmd.cengiz.models.TechnologyConsultancyView;
import tr.com.tsmd.cengiz.models.TrademarkPreServiceCharges;
import tr.com.tsmd.cengiz.models.TrademarkPreView;
import tr.com.tsmd.cengiz.models.UserRating;
import tr.com.tsmd.cengiz.models.ValuationView;
import tr.com.tsmd.cengiz.service.AboutInfoService;
import tr.com.tsmd.cengiz.service.CompanyProfileInfoService;
import tr.com.tsmd.cengiz.service.HomeService;
import tr.com.tsmd.cengiz.service.MovieInfoService;
import tr.com.tsmd.cengiz.service.NewsInfoService;
import tr.com.tsmd.cengiz.service.NoticeInfoService;
import tr.com.tsmd.cengiz.service.ServicesInfoService;
import tr.com.tsmd.cengiz.service.UserRatingService;

@RestController
@RequestMapping("/")
public class CengizController {

  /**
   * spring boot default sl4j
   */
  Logger logger = LoggerFactory.getLogger(CengizController.class);

  @Autowired
  MovieInfoService movieInfoService;

  @Autowired
  UserRatingService ratingInfoService;

  @Autowired
  NewsInfoService newsInfoService;

  @Autowired
  NoticeInfoService noticeInfoService;

  @Autowired
  AboutInfoService aboutInfoService;

  @Autowired
  CompanyProfileInfoService companyProfileInfoService;

  @Autowired
  ServicesInfoService servicesInfoService;

  @Autowired
  HomeService homeService;


  /**
   * dummy api
   *
   * @param id .
   * @return .
   */
  @RequestMapping("/{id}")
  public List<CatalogItem> getCatalog(@PathVariable("id") String id) {
    logger.info("--> getCatalog");
    //list dönen servis için bir class daha yazıp öyle handle ettik
    UserRating ratings = ratingInfoService.getUserRating(id);

    return ratings.getUserRating().stream()
        .map(rating -> movieInfoService.getCatalogItem(rating))
        .collect(Collectors.toList());
  }

  /**
   * dummy api
   *
   * @return .
   */
  @GetMapping("/customers")
  public List<CatalogItem> getCustomers() {

    //list dönen servis için bir class daha yazıp öyle handle ettik
    UserRating ratings = ratingInfoService.getUserRating("5");

    return ratings.getUserRating().stream().map(rating -> movieInfoService.getCatalogItem(rating))
        .collect(Collectors.toList());

 /*   return Collections.singletonList(
        new CatalogItem("Tpe", "yeni", 2019)
    );*/
  }

  /**
   * news list
   *
   * @return .
   */
  @PostMapping("/newsUpdateContent")
  public ResponseEntity<?> updateNewsContent(@RequestBody News news) {

    try {
      newsInfoService.updateNewsContent(news);
      return ResponseEntity.ok(new MessageResponse("Güncelleme işleminiz başarılı!"));
    } catch (Exception e) {
      logger.error(e.getLocalizedMessage());
      return ResponseEntity.ok(new MessageResponse("Güncelleme işleminiz başarısız!"));
    }
  }

  /**
   * notice updateContent
   *
   * @return .
   */
  @PostMapping("/noticeUpdateContent")
  public ResponseEntity<?> updateNoticeContent(@RequestBody Notice notice) {

    try {
      noticeInfoService.updateNoticeContent(notice);
      return ResponseEntity.ok(new MessageResponse("Güncelleme işleminiz başarılı!"));
    } catch (Exception e) {
      logger.error(e.getLocalizedMessage());
      return ResponseEntity.ok(new MessageResponse("Güncelleme işleminiz başarısız!"));
    }
  }

  /**
   * about updateContent
   *
   * @return .
   */
  @PostMapping("/aboutUpdateContent")
  public ResponseEntity<?> updateAboutContent(@RequestBody About about) {
    try {
      aboutInfoService.updateAboutContent(about);

      return ResponseEntity.ok(new MessageResponse("Güncelleme işleminiz başarılı!"));
    } catch (Exception e) {
      logger.error(e.getLocalizedMessage());
      return ResponseEntity.ok(new MessageResponse("Güncelleme işleminiz başarısız!"));
    }
  }

  /**
   * companyProfile updateContent
   *
   * @return .
   */
  @PostMapping("/companyProfileUpdateContent")
  public ResponseEntity<?> updateCompanyProfileContent(@RequestBody CompanyProfile companyProfile) {
    try {
      companyProfileInfoService.updateCompanyProfileContent(companyProfile);

      return ResponseEntity.ok(new MessageResponse("Güncelleme işleminiz başarılı!"));
    } catch (Exception e) {
      logger.error(e.getLocalizedMessage());
      return ResponseEntity.ok(new MessageResponse("Güncelleme işleminiz başarısız!"));
    }
  }


  /**
   * news delete
   *
   * @return .
   */
  @GetMapping("/newsDelete/{id}")
  public void deleteNewss(@PathVariable("id") Long id) {

    newsInfoService.deleteNews(id);

  }

  /**
   * news delete
   *
   * @return .
   */
  @DeleteMapping("/newsDelete/{id}")
  public void deleteNews(@PathVariable("id") Long id) {

    newsInfoService.deleteNews(id);

  }

  /**
   * notice delete
   *
   * @return .
   */
  @GetMapping("/noticeDelete/{id}")
  public void deleteNotice(@PathVariable("id") Long id) {

    noticeInfoService.deleteNotice(id);

  }

  /**
   * notice delete
   *
   * @return .
   */
  @DeleteMapping("/noticeDelete/{id}")
  public void deleteNoticee(@PathVariable("id") Long id) {

    noticeInfoService.deleteNotice(id);

  }

  /**
   * news list
   *
   * @return .
   */
  @GetMapping("/downloadPicture/{id}")
  public ResponseEntity<Resource> downloadPicture(@PathVariable("id") Long id) {

    News news = newsInfoService.getNewsById(id);
    return ResponseEntity.ok()
        .contentType(MediaType.parseMediaType(news.getFileType()))
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""
            + news.getFileName() + "\"")
        .body(new ByteArrayResource(news.getPicture()));

  }


  /**
   * patentpreView updateContent
   *
   * @return .
   */
  @PostMapping("/patentPreUpdateContent")
  public ResponseEntity<?> updatePatentPreViewContent(@RequestBody PatentPreView patentPreView) {

    try {
      servicesInfoService.updatePatentPreViewContent(patentPreView);
      return ResponseEntity.ok(new MessageResponse("Güncelleme işleminiz başarılı!"));
    } catch (Exception e) {
      logger.error(e.getLocalizedMessage());
      return ResponseEntity.ok(new MessageResponse("Güncelleme işleminiz başarısız!"));
    }
  }

  /**
   * trademarkpreView updateContent
   *
   * @return .
   */
  @PostMapping("/trademarkPreUpdateContent")
  public ResponseEntity<?> updateTrademarkPreViewContent(@RequestBody TrademarkPreView trademarkPreView) {

    try {
      servicesInfoService.updateTrademarkPreViewContent(trademarkPreView);

      return ResponseEntity.ok(new MessageResponse("Güncelleme işleminiz başarılı!"));
    } catch (Exception e) {
      logger.error(e.getLocalizedMessage());
      return ResponseEntity.ok(new MessageResponse("Güncelleme işleminiz başarısız!"));
    }
  }

  /**
   * activityanalysisView updateContent
   *
   * @return .
   */
  @PostMapping("/activityAnalysisUpdateContent")
  public ResponseEntity<?> activityAnalysisViewUpdateContent(@RequestBody ActivityAnalysisView activityAnalysisView) {

    try {
      servicesInfoService.updateActivityAnalysisViewContent(activityAnalysisView);
      return ResponseEntity.ok(new MessageResponse("Güncelleme işleminiz başarılı!"));
    } catch (Exception e) {
      logger.error(e.getLocalizedMessage());
      return ResponseEntity.ok(new MessageResponse("Güncelleme işleminiz başarısız!"));
    }
  }

  /**
   * valuationview updateContent
   *
   * @return .
   */
  @PostMapping("/valuationUpdateContent")
  public ResponseEntity<?> valuationViewUpdateContent(@RequestBody ValuationView valuationView) {

    try {
      servicesInfoService.updateValuationViewContent(valuationView);

      return ResponseEntity.ok(new MessageResponse("Güncelleme işleminiz başarılı!"));
    } catch (Exception e) {
      logger.error(e.getLocalizedMessage());
      return ResponseEntity.ok(new MessageResponse("Güncelleme işleminiz başarısız!"));
    }
  }

  /**
   * EvaluationInvalidationView updateContent
   *
   * @return .
   */
  @PostMapping("/evaluationInvalidationUpdateContent")
  public ResponseEntity<?> evaluationInvalidationViewUpdateContent(@RequestBody EvaluationInvalidationView evaluationInvalidationView) {

    try {
      servicesInfoService.updateEvaluationInvalidationViewContent(evaluationInvalidationView);

      return ResponseEntity.ok(new MessageResponse("Güncelleme işleminiz başarılı!"));
    } catch (Exception e) {
      logger.error(e.getLocalizedMessage());
      return ResponseEntity.ok(new MessageResponse("Güncelleme işleminiz başarısız!"));
    }
  }

  /**
   * TechnologyConsultancyView updateContent
   *
   * @return .
   */
  @PostMapping("/technologyConsultancyUpdateContent")
  public ResponseEntity<?> technologyConsultancyViewUpdateContent(@RequestBody TechnologyConsultancyView technologyConsultancyView) {

    try {
      servicesInfoService.updateTechnologyConsultancyViewContent(technologyConsultancyView);
      return ResponseEntity.ok(new MessageResponse("Güncelleme işleminiz başarılı!"));
    } catch (Exception e) {
      logger.error(e.getLocalizedMessage());
      return ResponseEntity.ok(new MessageResponse("Güncelleme işleminiz başarısız!"));
    }
  }


  /**
   * slogan list
   *
   * @return .
   */
  @PostMapping("/sloganUpdate")
  public ResponseEntity<?> sloganUpdate(@RequestBody Slogan slogan) {

    try {
      homeService.sloganUpdate(slogan);
      return ResponseEntity.ok(new MessageResponse("Güncelleme işleminiz başarılı!"));
    } catch (Exception e) {
      logger.error(e.getLocalizedMessage());
      return ResponseEntity.ok(new MessageResponse("Güncelleme işleminiz başarısız!"));
    }
  }

  /**
   * updateTrademarkPreServiceCharges updateContent
   *
   * @return .
   */
  @PostMapping("/updateTrademarkPreServiceCharges")
  public ResponseEntity<?> updateTrademarkPreServiceCharges(@RequestBody TrademarkPreServiceCharges trademarkPreServiceCharges) {

    try {
      servicesInfoService.updateTrademarkPreServiceCharges(trademarkPreServiceCharges);

      return ResponseEntity.ok(new MessageResponse("Güncelleme işleminiz başarılı!"));
    } catch (Exception e) {
      logger.error(e.getLocalizedMessage());
      return ResponseEntity.ok(new MessageResponse("Güncelleme işleminiz başarısız!"));
    }
  }

  /**
   * updateTrademarkPreServiceCharges updateContent
   *
   * @return .
   */
  @PostMapping("/updatePatentPreServiceCharges")
  public ResponseEntity<?> updatePatentPreServiceCharges(@RequestBody PatentPreServiceCharges patentPreServiceCharges) {

    try {
      servicesInfoService.updatePatentPreServiceCharges(patentPreServiceCharges);

      return ResponseEntity.ok(new MessageResponse("Güncelleme işleminiz başarılı!"));
    } catch (Exception e) {
      logger.error(e.getLocalizedMessage());
      return ResponseEntity.ok(new MessageResponse("Güncelleme işleminiz başarısız!"));
    }
  }
}
