package tr.com.tsmd.cengiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tr.com.tsmd.cengiz.entity.PatentPreEntity;
import tr.com.tsmd.cengiz.entity.PatentPreRelatedPicturesEntity;
import tr.com.tsmd.cengiz.entity.PatentPreTableEntity;
import tr.com.tsmd.cengiz.entity.ValuationPatentEntity;
import tr.com.tsmd.cengiz.entity.ValuationTrademarkEntity;
import tr.com.tsmd.cengiz.models.FullData;
import tr.com.tsmd.cengiz.models.FullDataList;
import tr.com.tsmd.cengiz.models.ValuationTrademark;
import tr.com.tsmd.cengiz.repository.PatentPreRelatedPicturesRepository;
import tr.com.tsmd.cengiz.repository.PatentPreRepository;
import tr.com.tsmd.cengiz.repository.PatentPreTableRepository;
import tr.com.tsmd.cengiz.repository.ValuationPatentRepository;
import tr.com.tsmd.cengiz.repository.ValuationTrademarkRepository;

@Service
public class ValuationServiceImpl implements ValuationService {
  @Autowired
  ValuationPatentRepository valuationPatentRepository;

  @Autowired
  ValuationTrademarkRepository valuationTrademarkRepository;


  @Override
  public void addValuationPatentDekont(Long id, MultipartFile dekont)  throws Exception {
    ValuationPatentEntity valuationPatentEntity = valuationPatentRepository.getById(id);

    valuationPatentEntity.setDekont(dekont.getBytes());
    valuationPatentEntity.setDekontFileName(dekont.getOriginalFilename());
    valuationPatentEntity.setDekontFileType(dekont.getContentType());
    valuationPatentRepository.save(valuationPatentEntity);

  }

  @Override
  public void addValuationTrademarkDekont(Long id, MultipartFile dekont)  throws Exception {
    ValuationTrademarkEntity valuationTrademarkEntity = valuationTrademarkRepository.getById(id);

    valuationTrademarkEntity.setDekont(dekont.getBytes());
    valuationTrademarkEntity.setDekontFileName(dekont.getOriginalFilename());
    valuationTrademarkEntity.setDekontFileType(dekont.getContentType());
    valuationTrademarkRepository.save(valuationTrademarkEntity);

  }
}
