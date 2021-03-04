package tr.com.tsmd.cengiz.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tr.com.tsmd.cengiz.entity.AboutEntity;
import tr.com.tsmd.cengiz.entity.NewsEntity;
import tr.com.tsmd.cengiz.entity.NoticeEntity;
import tr.com.tsmd.cengiz.models.About;
import tr.com.tsmd.cengiz.models.AboutList;
import tr.com.tsmd.cengiz.models.News;
import tr.com.tsmd.cengiz.models.NewsList;
import tr.com.tsmd.cengiz.models.Notice;
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

  @Override
  public About getAboutBy() {
    AboutEntity entity = aboutRepository.getBy();
    About about = new About(entity.getId(), entity.getAboutExplain(), entity.getAboutExplainEn(), entity.getPicture(),"data: image/jpeg;base64," +
        new String(Base64.encodeBase64(entity.getPicture()), StandardCharsets.US_ASCII), entity.getFileName(), entity.getFileType());
    return about;
  }

  @Override
  public void updateAboutContent(About about) {

    AboutEntity entity = aboutRepository.getBy();
    entity.setAboutExplain(about.getAboutExplain());
    entity.setAboutExplainEn(about.getAboutExplainEn());

    aboutRepository.save(entity);

  }

  @Override
  public void updateAboutPicture(Long id, MultipartFile picture) {
    AboutEntity entity = aboutRepository.getBy();

    try {
      entity.setFileName(picture.getOriginalFilename());
      entity.setFileType(picture.getContentType());
      entity.setPicture(picture.getBytes());

      aboutRepository.save(entity);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
