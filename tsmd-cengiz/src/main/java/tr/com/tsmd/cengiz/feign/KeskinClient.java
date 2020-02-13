package tr.com.tsmd.cengiz.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tr.com.tsmd.cengiz.models.UserRating;

@FeignClient("tsmd-keskin")
public interface KeskinClient {

  @RequestMapping(method = RequestMethod.GET, value = "/users/{userId}")
  UserRating getRating(@PathVariable("userId") String userId);
}
