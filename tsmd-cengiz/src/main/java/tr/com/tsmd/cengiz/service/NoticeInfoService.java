package tr.com.tsmd.cengiz.service;

import org.springframework.web.multipart.MultipartFile;
import tr.com.tsmd.cengiz.models.Notice;
import tr.com.tsmd.cengiz.models.NoticeList;

public interface NoticeInfoService {
  NoticeList getNoticeList();

  Long addNotice(Notice notice);

  Notice getNoticeById(Long id);

  void deleteNotice(Long id);

  void updateNoticeContent(Notice notice);

  void updateNoticePicture(Long id, MultipartFile picture);

}
