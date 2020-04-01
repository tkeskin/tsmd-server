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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import tr.com.tsmd.auth.payload.response.MessageResponse;
import tr.com.tsmd.cengiz.entity.TrademarkPreEntity;
import tr.com.tsmd.cengiz.models.CatalogItem;
import tr.com.tsmd.cengiz.models.News;
import tr.com.tsmd.cengiz.models.Notice;
import tr.com.tsmd.cengiz.models.TrademarkPre;
import tr.com.tsmd.cengiz.models.TrademarkPreList;
import tr.com.tsmd.cengiz.models.UserRating;
import tr.com.tsmd.cengiz.repository.TrademarkPreRepository;
import tr.com.tsmd.cengiz.service.MovieInfoService;
import tr.com.tsmd.cengiz.service.NewsInfoService;
import tr.com.tsmd.cengiz.service.NoticeInfoService;
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

    newsInfoService.updateNewsContent(news);

    return ResponseEntity.ok(new MessageResponse("Güncelleme işleminiz başarılı!"));
  }

  /**
   * notice updateContent
   *
   * @return .
   */
  @PostMapping("/noticeUpdateContent")
  public ResponseEntity<?> updateNoticeContent(@RequestBody Notice notice) {

    noticeInfoService.updateNoticeContent(notice);

    return ResponseEntity.ok(new MessageResponse("Güncelleme işleminiz başarılı!"));
  }


  /**
   * news delete
   *
   * @return .
   */
  @GetMapping("/newsDelete/{id}")
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

}
