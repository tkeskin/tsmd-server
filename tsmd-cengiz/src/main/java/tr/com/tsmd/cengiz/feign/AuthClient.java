package tr.com.tsmd.cengiz.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tr.com.tsmd.cengiz.models.UserList;
import tr.com.tsmd.cengiz.models.UserRating;

@FeignClient("tsmd-auth")
public interface AuthClient {
  @RequestMapping(method = RequestMethod.GET, value = "/api/public/users")
  UserList getUserList();
}
