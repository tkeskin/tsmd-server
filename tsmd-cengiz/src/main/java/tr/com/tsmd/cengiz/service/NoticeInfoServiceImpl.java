package tr.com.tsmd.cengiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.tsmd.cengiz.entity.NewsEntity;
import tr.com.tsmd.cengiz.entity.NoticeEntity;
import tr.com.tsmd.cengiz.models.News;
import tr.com.tsmd.cengiz.models.NewsList;
import tr.com.tsmd.cengiz.models.Notice;
import tr.com.tsmd.cengiz.models.NoticeList;
import tr.com.tsmd.cengiz.repository.NewsRepository;
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

    for (int i=0; i<noticeEntities.size();i++) {
      Notice notice = new Notice();
      notice.setId(noticeEntities.get(i).getId());
      notice.setPicture(noticeEntities.get(i).getPicture());
      notice.setNoticeTitle(noticeEntities.get(i).getNoticeTitle());
      notice.setNoticeExplain(noticeEntities.get(i).getNoticeExplain());
      noticeList1.add(notice);

    }

    NoticeList noticeList = new NoticeList();
    noticeList.setNoticeList(noticeList1);

    return noticeList;
  }

}
