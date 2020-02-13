package tr.com.tsmd.cengiz.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.tsmd.cengiz.models.CatalogItem;
import tr.com.tsmd.cengiz.models.UserRating;
import tr.com.tsmd.cengiz.service.MovieInfoService;
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
}
