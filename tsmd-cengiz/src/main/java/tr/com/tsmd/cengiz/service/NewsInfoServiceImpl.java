package tr.com.tsmd.cengiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.tsmd.cengiz.entity.NewsEntity;
import tr.com.tsmd.cengiz.models.News;
import tr.com.tsmd.cengiz.models.NewsList;
import tr.com.tsmd.cengiz.repository.NewsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsInfoServiceImpl implements NewsInfoService {
  @Autowired
  NewsRepository newsRepository;


  @Override
  public NewsList getNewsList() {

    List<NewsEntity> newsEntities = newsRepository.findAll();
    List<News> newsList1 = new ArrayList<>();

    for (int i=0; i<newsEntities.size();i++) {
      News news = new News();
      news.setId(newsEntities.get(i).getId());
      news.setPicture(newsEntities.get(i).getPicture());
      news.setNewsTitle(newsEntities.get(i).getNewsTitle());
      news.setNewsExplain(newsEntities.get(i).getNewsExplain());
      newsList1.add(news);

    }

    NewsList newsList = new NewsList();
    newsList.setNewsList(newsList1);

    return newsList;
  }

}
