package tr.com.tsmd.keskin.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import tr.com.tsmd.keskin.models.Rating;
import tr.com.tsmd.keskin.models.UserRating;

@RestController
@RequestMapping("/")
public class KeskinController {

  @Autowired
  private RestTemplate restTemplate;

  @RequestMapping("/{id}")
  public List<Rating> getMrating(@PathVariable("id") String id) {
    return Collections.singletonList(
        new Rating("def", "fff")
    );
  }

  @RequestMapping("/users/{userId}")
  public UserRating getUserRating(@PathVariable("userId") String userId) {
    List<Rating> ratings = Arrays.asList(
        new Rating("900", "abc"),
        new Rating("901", "def")
    );
    UserRating userRating = new UserRating();
    userRating.setUserRating(ratings);
    return userRating;
  }
}
