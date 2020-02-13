package tr.com.tsmd.cengiz.service;

import org.springframework.web.bind.annotation.PathVariable;
import tr.com.tsmd.cengiz.models.UserRating;

public interface UserRatingService {
  public UserRating getUserRating(@PathVariable("id") String id);

}
