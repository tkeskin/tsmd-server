package tr.com.tsmd.cengiz.service;

import org.springframework.web.multipart.MultipartFile;
import tr.com.tsmd.cengiz.models.News;
import tr.com.tsmd.cengiz.models.NewsList;
import tr.com.tsmd.cengiz.models.NewsRelatedPicturesList;
import tr.com.tsmd.cengiz.models.UserList;

public interface NewsInfoService {
  NewsList getNewsList();

  NewsList getNewsPublishedList();

  Long addNews(News news);

  News getNewsById(Long id);

  void deleteNews(Long id);

  void updateNewsContent(News news);

  void updateNewsPicture(Long id, MultipartFile mainPicture);

  void addNewsRelatedPictures(Long id, MultipartFile relatedPictures);

  NewsRelatedPicturesList getNewsRelatedPicturesList(Long newsId);

  void deleteNewsRelatedPicturesById(Long id);

  void updateNewsRelatedPicture(Long id, MultipartFile relatedPicture);
}
