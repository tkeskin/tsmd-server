package tr.com.tsmd.cengiz.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tr.com.tsmd.cengiz.entity.NewsEntity;
import tr.com.tsmd.cengiz.entity.NewsRelatedPicturesEntity;
import tr.com.tsmd.cengiz.entity.PatentPreRelatedPicturesEntity;
import tr.com.tsmd.cengiz.entity.SliderEntity;
import tr.com.tsmd.cengiz.entity.SloganEntity;
import tr.com.tsmd.cengiz.models.Slider;
import tr.com.tsmd.cengiz.models.HomePage;
import tr.com.tsmd.cengiz.models.Slogan;
import tr.com.tsmd.cengiz.repository.SliderRepository;
import tr.com.tsmd.cengiz.repository.SloganRepository;

@Service
public class HomeServiceImpl implements HomeService {
  @Autowired
  SliderRepository sliderRepository;

  @Autowired
  SloganRepository sloganRepository;

  @Override
  public HomePage getSliderList() {

    List<SliderEntity> entities=new ArrayList<>();
    List<Slider> dtos=new ArrayList<>();
    HomePage homePage=new HomePage();
    entities=sliderRepository.findAllByOrderByIdAsc();

    List<SloganEntity> sloganEntities = sloganRepository.findAll();

    for (SliderEntity entity : entities){
      Slider slider = new Slider();
      slider.setId(entity.getId());
      slider.setPicture(entity.getPicture());
      slider.setPictureExplain(entity.getPictureExplain());
      slider.setPictureType(entity.getPictureType());
      slider.setBase64Picture("data: image/jpeg;base64," +
          new String (Base64.encodeBase64 (entity.getPicture()), StandardCharsets.US_ASCII));
      slider.setPictureName(entity.getPictureName());
      dtos.add(slider);
    }
    homePage.setSliders(dtos);
    Slogan slogan = new Slogan(sloganEntities.get(0).getId(),sloganEntities.get(0).getSlogan());
    homePage.setSlogan(slogan);

    return homePage;
  }

  @Override
  public void deletePictureById(Long id) {

  }

  @Override
  public void sloganUpdate(Slogan slogan) {
    SloganEntity sloganEntity = sloganRepository.getById(slogan.getId());
    sloganEntity.setSlogan(slogan.getSlogan());
    sloganRepository.save(sloganEntity);
  }

  @Override
  public void uploadSliderPictures(String sliderExplain, MultipartFile picture) {
    SliderEntity entity=new SliderEntity();
    entity.setPictureName(picture.getOriginalFilename());
    entity.setPictureType(picture.getContentType());
    try {
      entity.setPicture(picture.getBytes());
    } catch (IOException e) {
      e.printStackTrace();
    }
    entity.setPictureExplain(sliderExplain);
    sliderRepository.save(entity);
  }

  @Override
  public void updateSliderRelatedPicture(Long id, MultipartFile relatedPicture) {
    SliderEntity entity=sliderRepository.getById(id);

    try {
      entity.setPictureName(relatedPicture.getOriginalFilename());
      entity.setPictureType(relatedPicture.getContentType());
      entity.setPicture(relatedPicture.getBytes());
      sliderRepository.save(entity);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public String deleteSliderRelatedPictures(Long id) {
    List<SliderEntity> entities = sliderRepository.findAll();
    if (entities.size() == 1){
      return "Slider en az 1 resim olmalıdır. Silemezsiniz";
    } else {
      sliderRepository.deleteById(id);
      return "Silindi";
    }
  }

  @Override
  public void updateSliderPictureExplain(Long id, String sliderExplain) {
    SliderEntity entity=sliderRepository.getById(id);

    entity.setPictureExplain(sliderExplain);
    sliderRepository.save(entity);
  }
}
