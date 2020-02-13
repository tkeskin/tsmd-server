package tr.com.tsmd.cengiz.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.tsmd.cengiz.feign.AuthClient;
import tr.com.tsmd.cengiz.models.UserList;

@Service
public class UserInfoServiceImpl implements UserInfoService {

  @Autowired
  AuthClient authClient;

  @HystrixCommand(fallbackMethod = "getFallbackUserList")
  @Override
  public UserList getUserList() {
    return authClient.getUserList();
  }

  public UserList getFallbackUserList() {
    UserList userRating = new UserList();
    System.out.println("tpe-auth-error");
    return userRating;
  }

}
