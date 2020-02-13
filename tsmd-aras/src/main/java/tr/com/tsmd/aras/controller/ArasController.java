package tr.com.tsmd.aras.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import tr.com.tsmd.aras.models.Movie;
import tr.com.tsmd.aras.models.MovieSummary;

@RestController
@RequestMapping("/")
public class ArasController {

  @Value("${api.key}")
  private String apiKey;

  @Autowired
  private RestTemplate restTemplate;

  /**
   * dummy response
   *
   * @param id .
   * @return .
   */
  @RequestMapping("/{id}")
  public Movie getMinfo(@PathVariable("id") String id) {
    MovieSummary movieSummary = restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + id + "?api_key=" + apiKey, MovieSummary.class);
    return new Movie(id, movieSummary.getTitle(), movieSummary.getOverview());
  }
}
