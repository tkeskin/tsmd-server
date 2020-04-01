package tr.com.tsmd.cengiz.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tr.com.tsmd.cengiz.entity.NoticeEntity;
import tr.com.tsmd.cengiz.models.Notice;
import tr.com.tsmd.cengiz.models.NoticeList;
import tr.com.tsmd.cengiz.repository.NoticeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoticeInfoServiceImpl implements NoticeInfoService {
  @Autowired
  NoticeRepository noticeRepository;


  @Override
  public NoticeList getNoticeList() {

    List<NoticeEntity> noticeEntities = noticeRepository.findAll();
    List<Notice> noticeList1 = new ArrayList<>();

    for (int i = 0; i < noticeEntities.size(); i++) {
      Notice notice = new Notice();
      notice.setId(noticeEntities.get(i).getId());
      String base64EncodedImage = "data: image/jpeg;base64," +
          new String(Base64.encodeBase64(noticeEntities.get(i).getPicture()), StandardCharsets.US_ASCII);
      //notice.setPicture(noticeEntities.get(i).getPicture());
      notice.setPictureBase64(base64EncodedImage);
      notice.setNoticeTitle(noticeEntities.get(i).getNoticeTitle());
      notice.setNoticeExplain(noticeEntities.get(i).getNoticeExplain());
      noticeList1.add(notice);

    }

    NoticeList noticeList = new NoticeList();
    noticeList.setNoticeList(noticeList1);

    return noticeList;
  }

  @Override
  public Long addNotice(Notice notice) {
    NoticeEntity entity = noticeRepository.save(new NoticeEntity(notice.getPicture(), notice.getNoticeTitle(), notice.getNoticeExplain(), notice.getFileName(), notice.getFileType()));

    return entity.getId();
  }

  @Override
  public Notice getNoticeById(Long id) {
    NoticeEntity entity = noticeRepository.getById(id);
    Notice notice = new Notice(entity.getId(), entity.getPicture(), entity.getNoticeTitle(), entity.getNoticeExplain(), "data: image/jpeg;base64," +
        new String(Base64.encodeBase64(entity.getPicture()), StandardCharsets.US_ASCII), entity.getFileName(), entity.getFileType());
    return notice;
  }

  @Override
  public void deleteNotice(Long id) {
    noticeRepository.deleteById(id);
  }

  @Override
  public void updateNoticeContent(Notice notice) {
    NoticeEntity entity = noticeRepository.getById(notice.getId());
    entity.setNoticeTitle(notice.getNoticeTitle());
    entity.setNoticeExplain(notice.getNoticeExplain());
    noticeRepository.save(entity);
  }

  @Override
  public void updateNoticePicture(Long id, MultipartFile picture) {
    NoticeEntity entity = noticeRepository.getById(id);

    try {
      entity.setFileName(picture.getOriginalFilename());
      entity.setFileType(picture.getContentType());
      entity.setPicture(picture.getBytes());
      noticeRepository.save(entity);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
