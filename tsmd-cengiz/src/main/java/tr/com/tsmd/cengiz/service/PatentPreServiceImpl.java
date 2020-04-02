package tr.com.tsmd.cengiz.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tr.com.tsmd.cengiz.entity.AboutEntity;
import tr.com.tsmd.cengiz.entity.PatentPreEntity;
import tr.com.tsmd.cengiz.entity.PatentPreRelatedPicturesEntity;
import tr.com.tsmd.cengiz.entity.PatentPreTableEntity;
import tr.com.tsmd.cengiz.models.About;
import tr.com.tsmd.cengiz.models.AboutList;
import tr.com.tsmd.cengiz.models.FullData;
import tr.com.tsmd.cengiz.models.FullDataList;
import tr.com.tsmd.cengiz.repository.AboutRepository;
import tr.com.tsmd.cengiz.repository.PatentPreRelatedPicturesRepository;
import tr.com.tsmd.cengiz.repository.PatentPreRepository;
import tr.com.tsmd.cengiz.repository.PatentPreTableRepository;

@Service
public class PatentPreServiceImpl implements PatentPreService {
  @Autowired
  PatentPreTableRepository patentPreTableRepository;

  @Autowired
  PatentPreRelatedPicturesRepository patentPreRelatedPicturesRepository;

  @Autowired
  PatentPreRepository patentPreRepository;


  @Override
  public void savePatentPreTable(Long id, FullDataList fullDataList) {

    for (FullData fullData : fullDataList.getFullData()) {
      PatentPreTableEntity patentPreTableEntity = new PatentPreTableEntity();
      patentPreTableEntity.setDeferenceno(fullData.getDeferenceno());
      patentPreTableEntity.setDeferencepriority(fullData.getDeferencepriority());
      patentPreTableEntity.setDeferencechoose(fullData.getDeferencechoose());
      patentPreTableEntity.setPatentPreId(id);
      patentPreTableRepository.save(patentPreTableEntity);
    }

  }

  @Override
  public void addPatentPreRelatedPictures(Long patentPreId, MultipartFile[] pictures) throws Exception{

    for (MultipartFile multipartFile : pictures) {
      PatentPreRelatedPicturesEntity patentPreRelatedPicturesEntity = new PatentPreRelatedPicturesEntity();
      patentPreRelatedPicturesEntity.setFileName(multipartFile.getOriginalFilename());
      patentPreRelatedPicturesEntity.setFileType(multipartFile.getContentType());
      patentPreRelatedPicturesEntity.setPicture(multipartFile.getBytes());
      patentPreRelatedPicturesEntity.setPatentPreId(patentPreId);
      patentPreRelatedPicturesRepository.save(patentPreRelatedPicturesEntity);
    }

  }

  @Override
  public void addDekont(Long patentPreId, MultipartFile dekont)  throws Exception {
    PatentPreEntity patentPreEntity = patentPreRepository.getById(patentPreId);

    patentPreEntity.setDekont(dekont.getBytes());
    patentPreEntity.setDekontFileName(dekont.getOriginalFilename());
    patentPreEntity.setDekontFileType(dekont.getContentType());
    patentPreRepository.save(patentPreEntity);

  }
}
