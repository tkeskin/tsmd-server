package tr.com.tsmd.cengiz.service;

import tr.com.tsmd.cengiz.models.News;
import tr.com.tsmd.cengiz.models.NewsList;
import tr.com.tsmd.cengiz.models.UserList;

public interface NewsInfoService {
  public NewsList getNewsList();

  public void addNews(News news);

  News getNewsById(Long id);

  void deleteNews(Long id);
}
