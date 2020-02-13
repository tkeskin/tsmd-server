package tr.com.tsmd.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.tsmd.auth.models.UserList;
import tr.com.tsmd.auth.service.UserInfoService;

@RestController
@RequestMapping("/yy")
public class AuthPublicController {

/*  @Autowired
  UserInfoService userInfoService;

  @GetMapping("/users")
  public ResponseEntity<?> getUserInfo() {
    UserList userInfo = userInfoService.getUserInfo();
    return ResponseEntity.ok(userInfo);
  }*/

}
