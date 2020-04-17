package tr.com.tsmd.cengiz.service;

import org.springframework.web.multipart.MultipartFile;
import tr.com.tsmd.cengiz.models.About;
import tr.com.tsmd.cengiz.models.AboutList;
import tr.com.tsmd.cengiz.models.NewsList;
import tr.com.tsmd.cengiz.models.Notice;
import tr.com.tsmd.cengiz.models.NoticeList;

public interface AboutInfoService {
  public AboutList getAboutList();

  About getAboutBy();

  void updateAboutContent(About about);

  void updateAboutPicture(Long id, MultipartFile picture);
}
