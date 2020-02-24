package tr.com.tsmd.cengiz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tr.com.tsmd.cengiz.models.AboutList;
import tr.com.tsmd.cengiz.models.NewsList;
import tr.com.tsmd.cengiz.models.NoticeList;
import tr.com.tsmd.cengiz.models.UserList;
import tr.com.tsmd.cengiz.payload.request.ServicesRequest;
import tr.com.tsmd.cengiz.service.AboutInfoService;
import tr.com.tsmd.cengiz.service.NewsInfoService;
import tr.com.tsmd.cengiz.service.NoticeInfoService;
import tr.com.tsmd.cengiz.service.UserInfoService;

import javax.validation.Valid;

@RestController
@RequestMapping("/public")
public class CengizPublicController {

  /**
   * spring boot default sl4j
   */
  Logger logger = LoggerFactory.getLogger(CengizPublicController.class);

  @Autowired
  UserInfoService userInfoService;

  @Autowired
  NewsInfoService newsInfoService;

  @Autowired
  NoticeInfoService noticeInfoService;

  @Autowired
  AboutInfoService aboutInfoService;


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

  /**
   * services list
   *
   * @return .
   */
  @PostMapping("/services")
  public UserList getServices(@Valid @RequestBody ServicesRequest servicesRequest) {
    //list dönen servis için bir class daha yazıp öyle handle ettik
    UserList userList = userInfoService.getUserList();
    return userList;
  }

  /**
   * news list
   *
   * @return .
   */
  @GetMapping("/news")
  public NewsList getNews() {
    //list dönen servis için bir class daha yazıp öyle handle ettik
    NewsList newsList = newsInfoService.getNewsList();
    return newsList;
  }

  /**
   * notice list
   *
   * @return .
   */
  @GetMapping("/notice")
  public NoticeList getNotice() {
    //list dönen servis için bir class daha yazıp öyle handle ettik
    NoticeList noticeList = noticeInfoService.getNoticeList();
    return noticeList;
  }

  /**
   * about list
   *
   * @return .
   */
  @GetMapping("/about")
  public AboutList getAbout() {
    //list dönen servis için bir class daha yazıp öyle handle ettik
    AboutList aboutList = aboutInfoService.getAboutList();
    return aboutList;
  }

}
