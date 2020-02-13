package tr.com.tsmd.cengiz.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import tr.com.tsmd.cengiz.feign.KeskinClient;
import tr.com.tsmd.cengiz.models.Rating;
import tr.com.tsmd.cengiz.models.UserRating;

@Service
public class UserRatingServiceImpl implements UserRatingService {

  @Autowired
  KeskinClient keskinClient;

/*  @Autowired
  private RestTemplate restTemplate;

  */

  /**
   * getCatalog metodunun birden fazla apiye ba??ml?l??? oldu?u i�in
   * api call i?ini par�al?d?k ve hystrix ile handle ettik
   * rating apide bir sorun varsa hystrix devreye girecek
   *
   * @param
   * @return
   *//*
  @HystrixCommand(fallbackMethod = "getFallbackUserRating")
  public UserRating getUserRating(@PathVariable("id") String id) {
    return restTemplate.getForObject("http://tpe-keskin/users/" + id, UserRating.class);
  }

  public UserRating getFallbackUserRating(@PathVariable("id") String id) {
    UserRating userRating = new UserRating();
    userRating.setUserRating(Arrays.asList(
        new Rating("10000", "tpe-keskin-error")
    ));
    System.out.println("tpe-keskin-error");
    return userRating;
  }*/
  @HystrixCommand(fallbackMethod = "getFallbackUserRating")
  public UserRating getUserRating(String userId) {
    return keskinClient.getRating(userId);
  }

  public UserRating getFallbackUserRating(@PathVariable("id") String id) {
    UserRating userRating = new UserRating();
    userRating.setUserRating(Arrays.asList(
        new Rating("10000", "tpe-keskin-error")
    ));
    System.out.println("tpe-keskin-error");
    return userRating;
  }

}
