package tr.com.tsmd.cengiz.service;

import org.springframework.web.multipart.MultipartFile;
import tr.com.tsmd.cengiz.models.HomePage;
import tr.com.tsmd.cengiz.models.Slogan;

public interface HomeService {

  HomePage getSliderList();

  void deletePictureById(Long id);

  void sloganUpdate(Slogan slogan);

  void uploadSliderPictures(String sliderExplain, MultipartFile picture);

  void updateSliderRelatedPicture(Long id, MultipartFile relatedPicture);

  String deleteSliderRelatedPictures(Long id);

  void updateSliderPictureExplain(Long id, String sliderExplain);
}
