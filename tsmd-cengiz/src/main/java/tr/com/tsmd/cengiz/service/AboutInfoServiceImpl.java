package tr.com.tsmd.cengiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.tsmd.cengiz.entity.AboutEntity;
import tr.com.tsmd.cengiz.entity.NewsEntity;
import tr.com.tsmd.cengiz.models.About;
import tr.com.tsmd.cengiz.models.AboutList;
import tr.com.tsmd.cengiz.models.News;
import tr.com.tsmd.cengiz.models.NewsList;
import tr.com.tsmd.cengiz.repository.AboutRepository;
import tr.com.tsmd.cengiz.repository.NewsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AboutInfoServiceImpl implements AboutInfoService {
  @Autowired
  AboutRepository aboutRepository;


  @Override
  public AboutList getAboutList() {

    List<AboutEntity> aboutEntities = aboutRepository.findAll();
    List<About> aboutList1 = new ArrayList<>();

    for (int i=0; i<aboutEntities.size();i++) {
      About about = new About();
      about.setId(aboutEntities.get(i).getId());
      about.setAboutExplain(aboutEntities.get(i).getAboutExplain());
      aboutList1.add(about);

    }

    AboutList aboutList = new AboutList();
    aboutList.setAboutList(aboutList1);

    return aboutList;
  }

}
