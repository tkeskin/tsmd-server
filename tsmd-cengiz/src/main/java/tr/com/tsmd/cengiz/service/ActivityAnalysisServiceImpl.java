package tr.com.tsmd.cengiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tr.com.tsmd.cengiz.entity.ActivityAnalysisEntity;
import tr.com.tsmd.cengiz.entity.ActivityAnalysisPicturesEntity;
import tr.com.tsmd.cengiz.entity.PatentPreRelatedPicturesEntity;
import tr.com.tsmd.cengiz.entity.ValuationPatentEntity;
import tr.com.tsmd.cengiz.entity.ValuationTrademarkEntity;
import tr.com.tsmd.cengiz.repository.ActivityAnalysisPicturesRepository;
import tr.com.tsmd.cengiz.repository.ActivityAnalysisRepository;
import tr.com.tsmd.cengiz.repository.ValuationPatentRepository;
import tr.com.tsmd.cengiz.repository.ValuationTrademarkRepository;

@Service
public class ActivityAnalysisServiceImpl implements ActivityAnalysisService {
  @Autowired
  ActivityAnalysisRepository activityAnalysisRepository;

  @Autowired
  ActivityAnalysisPicturesRepository activityAnalysisPicturesRepository;



  @Override
  public void addActivityAnalysisDekont(Long id, MultipartFile dekont)  throws Exception {
    ActivityAnalysisEntity activityAnalysisEntity = activityAnalysisRepository.getById(id);

    activityAnalysisEntity.setDekont(dekont.getBytes());
    activityAnalysisEntity.setDekontFileName(dekont.getOriginalFilename());
    activityAnalysisEntity.setDekontFileType(dekont.getContentType());
    activityAnalysisRepository.save(activityAnalysisEntity);

  }

  @Override
  public void addActivityAnalysisPictures(Long id, MultipartFile[] pictures) throws Exception {

    for (MultipartFile multipartFile : pictures) {
      ActivityAnalysisPicturesEntity activityAnalysisPicturesEntity = new ActivityAnalysisPicturesEntity();
      activityAnalysisPicturesEntity.setFileName(multipartFile.getOriginalFilename());
      activityAnalysisPicturesEntity.setFileType(multipartFile.getContentType());
      activityAnalysisPicturesEntity.setPicture(multipartFile.getBytes());
      activityAnalysisPicturesEntity.setActivityAnalysisId(id);
      activityAnalysisPicturesRepository.save(activityAnalysisPicturesEntity);
    }
  }
}
