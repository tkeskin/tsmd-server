package tr.com.tsmd.cengiz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.tsmd.cengiz.models.UserList;
import tr.com.tsmd.cengiz.service.UserInfoService;

@RestController
@RequestMapping("/public")
public class CengizPublicController {

  /**
   * spring boot default sl4j
   */
  Logger logger = LoggerFactory.getLogger(CengizPublicController.class);

  @Autowired
  UserInfoService userInfoService;

  /**
   * user list
   *
   * @return .
   */
  @GetMapping("/users")
  public UserList getCustomers() {
    //list dönen servis için bir class daha yazıp öyle handle ettik
    UserList userList = userInfoService.getUserList();
    return userList;
  }
}
