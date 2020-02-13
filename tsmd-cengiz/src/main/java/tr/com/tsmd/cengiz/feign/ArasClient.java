package tr.com.tsmd.cengiz.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tr.com.tsmd.cengiz.models.Movie;

@FeignClient("tsmd-aras")
public interface ArasClient {

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  Movie getMovie(@PathVariable("id") String id);
}
