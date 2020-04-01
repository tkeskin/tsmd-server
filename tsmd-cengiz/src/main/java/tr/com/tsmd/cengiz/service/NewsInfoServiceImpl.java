package tr.com.tsmd.cengiz.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tr.com.tsmd.cengiz.entity.NewsEntity;
import tr.com.tsmd.cengiz.entity.NewsRelatedPicturesEntity;
import tr.com.tsmd.cengiz.models.News;
import tr.com.tsmd.cengiz.models.NewsList;
import tr.com.tsmd.cengiz.models.NewsRelatedPictures;
import tr.com.tsmd.cengiz.models.NewsRelatedPicturesList;
import tr.com.tsmd.cengiz.repository.NewsRelatedPicturesRepository;
import tr.com.tsmd.cengiz.repository.NewsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsInfoServiceImpl implements NewsInfoService {
  @Autowired
  NewsRepository newsRepository;

  @Autowired
  NewsRelatedPicturesRepository newsRelatedPicturesRepository;


  @Override
  public NewsList getNewsList() {

    List<NewsEntity> newsEntities = newsRepository.findAll();
    List<News> newsList1 = new ArrayList<>();

    for (int i=0; i<newsEntities.size();i++) {
      News news = new News();
      news.setId(newsEntities.get(i).getId());
      String base64EncodedImage = "data: image/jpeg;base64," +
          new String (Base64.encodeBase64 (newsEntities.get(i).getPicture()), StandardCharsets.US_ASCII);
      //news.setPicture(newsEntities.get(i).getPicture());
      news.setPictureBase64(base64EncodedImage);
      news.setNewsTitle(newsEntities.get(i).getNewsTitle());
      news.setNewsExplain(newsEntities.get(i).getNewsExplain());
      newsList1.add(news);

    }

    NewsList newsList = new NewsList();
    newsList.setNewsList(newsList1);

    return newsList;
  }

  @Override
  public Long addNews(News news) {
    NewsEntity entity=newsRepository.save(new NewsEntity(news.getPicture(),news.getNewsTitle(),news.getNewsExplain(),news.getFileName(),news.getFileType()));

    return entity.getId();
  }

  @Override
  public News getNewsById(Long id) {

    NewsEntity entity=newsRepository.getById(id);
    News news = new News(entity.getId(),entity.getPicture(),entity.getNewsTitle(),entity.getNewsExplain(),"data: image/jpeg;base64," +
        new String (Base64.encodeBase64 (entity.getPicture()), StandardCharsets.US_ASCII),entity.getFileName(),entity.getFileType());
    return news;
  }

  @Override
  public void deleteNews(Long id) {
    newsRepository.deleteById(id);
  }

  @Override
  public void updateNewsContent(News news) {
    NewsEntity entity=newsRepository.getById(news.getId());
    entity.setNewsTitle(news.getNewsTitle());
    entity.setNewsExplain(news.getNewsExplain());
    newsRepository.save(entity);
  }

  @Override
  public void updateNewsPicture(Long id, MultipartFile mainPicture) {
    NewsEntity entity=newsRepository.getById(id);

    try {
      entity.setFileName(mainPicture.getOriginalFilename());
      entity.setFileType(mainPicture.getContentType());
      entity.setPicture(mainPicture.getBytes());
      newsRepository.save(entity);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void addNewsRelatedPictures(Long id, MultipartFile relatedPictures) {
    NewsRelatedPicturesEntity entity=new NewsRelatedPicturesEntity();
    entity.setFileName(relatedPictures.getOriginalFilename());
    entity.setFileType(relatedPictures.getContentType());
    try {
      entity.setPicture(relatedPictures.getBytes());
    } catch (IOException e) {
      e.printStackTrace();
    }
    entity.setNewsId(id);
    newsRelatedPicturesRepository.save(entity);
  }

  @Override
  public NewsRelatedPicturesList getNewsRelatedPicturesList(Long newsId) {
    List<NewsRelatedPicturesEntity> entities=new ArrayList<>();
    List<NewsRelatedPictures> dtos=new ArrayList<>();
    NewsRelatedPicturesList newsRelatedPicturesList=new NewsRelatedPicturesList();
    entities=newsRelatedPicturesRepository.getByNewsId(newsId);

    for (NewsRelatedPicturesEntity entity : entities){
      NewsRelatedPictures newsRelatedPictures = new NewsRelatedPictures();
      newsRelatedPictures.setFileName(entity.getFileName());
      newsRelatedPictures.setFileType(entity.getFileType());
      newsRelatedPictures.setId(entity.getId());
      newsRelatedPictures.setPicture(entity.getPicture());
      newsRelatedPictures.setBase64Picture("data: image/jpeg;base64," +
          new String (Base64.encodeBase64 (entity.getPicture()), StandardCharsets.US_ASCII));
      newsRelatedPictures.setNewsId(entity.getNewsId());
      dtos.add(newsRelatedPictures);
    }
    newsRelatedPicturesList.setNewsRelatedPictures(dtos);
    return newsRelatedPicturesList;
  }

  @Override
  public void deleteNewsRelatedPicturesById(Long id) {
     newsRelatedPicturesRepository.deleteById(id);
  }

  @Override
  public void updateNewsRelatedPicture(Long id, MultipartFile relatedPicture) {
    NewsRelatedPicturesEntity entity=newsRelatedPicturesRepository.getById(id);

    try {
      entity.setFileName(relatedPicture.getOriginalFilename());
      entity.setFileType(relatedPicture.getContentType());
      entity.setPicture(relatedPicture.getBytes());
      newsRelatedPicturesRepository.save(entity);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
