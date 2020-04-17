package tr.com.tsmd.cengiz.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tr.com.tsmd.cengiz.entity.ActivityAnalysisViewEntity;
import tr.com.tsmd.cengiz.entity.EvaluationInvalidationViewEntity;
import tr.com.tsmd.cengiz.entity.PatentPreViewEntity;
import tr.com.tsmd.cengiz.entity.TechnologyConsultancyViewEntity;
import tr.com.tsmd.cengiz.entity.TrademarkPreViewEntity;
import tr.com.tsmd.cengiz.entity.ValuationViewEntity;
import tr.com.tsmd.cengiz.models.ActivityAnalysisView;
import tr.com.tsmd.cengiz.models.EvaluationInvalidationView;
import tr.com.tsmd.cengiz.models.PatentPreView;
import tr.com.tsmd.cengiz.models.TechnologyConsultancyView;
import tr.com.tsmd.cengiz.models.TrademarkPreView;
import tr.com.tsmd.cengiz.models.ValuationView;
import tr.com.tsmd.cengiz.repository.ActivityAnalysisViewRepository;
import tr.com.tsmd.cengiz.repository.EvaluationInvalidationViewRepository;
import tr.com.tsmd.cengiz.repository.PatentPreViewRepository;
import tr.com.tsmd.cengiz.repository.TechnologyConsultancyViewRepository;
import tr.com.tsmd.cengiz.repository.TrademarkPreViewRepository;
import tr.com.tsmd.cengiz.repository.ValuationViewRepository;

@Service
public class ServicesInfoServiceImpl implements ServicesInfoService {
  @Autowired
  PatentPreViewRepository patentPreViewRepository;

  @Autowired
  TrademarkPreViewRepository trademarkPreViewRepository;


  @Autowired
  ActivityAnalysisViewRepository activityAnalysisViewRepository;
  
  @Autowired
  ValuationViewRepository valuationViewRepository;

  @Autowired
  EvaluationInvalidationViewRepository evaluationInvalidationViewRepository;

  @Autowired
  TechnologyConsultancyViewRepository technologyConsultancyViewRepository;


  @Override
  public PatentPreView getPatentPreViewBy() {
    PatentPreViewEntity entity = patentPreViewRepository.getBy();
    PatentPreView patentPreView = new PatentPreView(entity.getId(), entity.getPicture(), entity.getPatentPreExplain(), "data: image/jpeg;base64," +
        new String(Base64.encodeBase64(entity.getPicture()), StandardCharsets.US_ASCII), entity.getFileName(), entity.getFileType());
    return patentPreView;
  }

  @Override
  public void updatePatentPreViewContent(PatentPreView patentPreView) {

    PatentPreViewEntity entity = patentPreViewRepository.getBy();
    entity.setPatentPreExplain(patentPreView.getPatentPreExplain());

    patentPreViewRepository.save(entity);

  }

  @Override
  public void updatePatentPreViewPicture(Long id, MultipartFile picture) {
    PatentPreViewEntity entity = patentPreViewRepository.getBy();

    try {
      entity.setFileName(picture.getOriginalFilename());
      entity.setFileType(picture.getContentType());
      entity.setPicture(picture.getBytes());

      patentPreViewRepository.save(entity);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  @Override
  public TrademarkPreView getTrademarkPreViewBy() {
    TrademarkPreViewEntity entity = trademarkPreViewRepository.getBy();
    TrademarkPreView trademarkPreView = new TrademarkPreView(entity.getId(), entity.getPicture(), entity.getTrademarkPreExplain(), "data: image/jpeg;base64," +
        new String(Base64.encodeBase64(entity.getPicture()), StandardCharsets.US_ASCII), entity.getFileName(), entity.getFileType());
    return trademarkPreView;
  }

  @Override
  public void updateTrademarkPreViewContent(TrademarkPreView trademarkPreView) {

    TrademarkPreViewEntity entity = trademarkPreViewRepository.getBy();
    entity.setTrademarkPreExplain(trademarkPreView.getTrademarkPreExplain());

    trademarkPreViewRepository.save(entity);

  }

  @Override
  public void updateTrademarkPreViewPicture(Long id, MultipartFile picture) {
    TrademarkPreViewEntity entity = trademarkPreViewRepository.getBy();

    try {
      entity.setFileName(picture.getOriginalFilename());
      entity.setFileType(picture.getContentType());
      entity.setPicture(picture.getBytes());

      trademarkPreViewRepository.save(entity);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  @Override
  public ActivityAnalysisView getActivityAnalysisViewBy() {
    ActivityAnalysisViewEntity entity = activityAnalysisViewRepository.getBy();
    ActivityAnalysisView activityAnalysisView = new ActivityAnalysisView(entity.getId(), entity.getPicture(), entity.getActivityAnalysisExplain(), "data: image/jpeg;base64," +
        new String(Base64.encodeBase64(entity.getPicture()), StandardCharsets.US_ASCII), entity.getFileName(), entity.getFileType());
    return activityAnalysisView;
  }

  @Override
  public void updateActivityAnalysisViewContent(ActivityAnalysisView activityAnalysisView) {

    ActivityAnalysisViewEntity entity = activityAnalysisViewRepository.getBy();
    entity.setActivityAnalysisExplain(activityAnalysisView.getActivityAnalysisExplain());

    activityAnalysisViewRepository.save(entity);

  }

  @Override
  public void updateActivityAnalysisViewPicture(Long id, MultipartFile picture) {
    ActivityAnalysisViewEntity entity = activityAnalysisViewRepository.getBy();

    try {
      entity.setFileName(picture.getOriginalFilename());
      entity.setFileType(picture.getContentType());
      entity.setPicture(picture.getBytes());

      activityAnalysisViewRepository.save(entity);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }



  @Override
  public ValuationView getValuationViewBy() {
    ValuationViewEntity entity = valuationViewRepository.getBy();
    ValuationView valuationView = new ValuationView(entity.getId(), entity.getPicture(), entity.getValuationExplain(), "data: image/jpeg;base64," +
        new String(Base64.encodeBase64(entity.getPicture()), StandardCharsets.US_ASCII), entity.getFileName(), entity.getFileType());
    return valuationView;
  }

  @Override
  public void updateValuationViewContent(ValuationView valuationView) {

    ValuationViewEntity entity = valuationViewRepository.getBy();
    entity.setValuationExplain(valuationView.getValuationExplain());

    valuationViewRepository.save(entity);

  }

  @Override
  public void updateValuationViewPicture(Long id, MultipartFile picture) {
    ValuationViewEntity entity = valuationViewRepository.getBy();

    try {
      entity.setFileName(picture.getOriginalFilename());
      entity.setFileType(picture.getContentType());
      entity.setPicture(picture.getBytes());

      valuationViewRepository.save(entity);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  @Override
  public EvaluationInvalidationView getEvaluationInvalidationViewBy() {
    EvaluationInvalidationViewEntity entity = evaluationInvalidationViewRepository.getBy();
    EvaluationInvalidationView evaluationInvalidationView = new EvaluationInvalidationView(entity.getId(), entity.getPicture(), entity.getEvaluationInvalidationExplain(), "data: image/jpeg;base64," +
        new String(Base64.encodeBase64(entity.getPicture()), StandardCharsets.US_ASCII), entity.getFileName(), entity.getFileType());
    return evaluationInvalidationView;
  }

  @Override
  public void updateEvaluationInvalidationViewContent(EvaluationInvalidationView evaluationInvalidationView) {

    EvaluationInvalidationViewEntity entity = evaluationInvalidationViewRepository.getBy();
    entity.setEvaluationInvalidationExplain(entity.getEvaluationInvalidationExplain());

    evaluationInvalidationViewRepository.save(entity);

  }

  @Override
  public void updateEvaluationInvalidationViewPicture(Long id, MultipartFile picture) {
    EvaluationInvalidationViewEntity entity = evaluationInvalidationViewRepository.getBy();

    try {
      entity.setFileName(picture.getOriginalFilename());
      entity.setFileType(picture.getContentType());
      entity.setPicture(picture.getBytes());

      evaluationInvalidationViewRepository.save(entity);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  @Override
  public TechnologyConsultancyView getTechnologyConsultancyViewBy() {
    TechnologyConsultancyViewEntity entity = technologyConsultancyViewRepository.getBy();
    TechnologyConsultancyView technologyConsultancyView = new TechnologyConsultancyView(entity.getId(), entity.getPicture(), entity.getTechnologyConsultancyExplain(), "data: image/jpeg;base64," +
        new String(Base64.encodeBase64(entity.getPicture()), StandardCharsets.US_ASCII), entity.getFileName(), entity.getFileType());
    return technologyConsultancyView;
  }

  @Override
  public void updateTechnologyConsultancyViewContent(TechnologyConsultancyView technologyConsultancyView) {

    TechnologyConsultancyViewEntity entity = technologyConsultancyViewRepository.getBy();
    entity.setTechnologyConsultancyExplain(technologyConsultancyView.getTechnologyConsultancyExplain());

    technologyConsultancyViewRepository.save(entity);

  }

  @Override
  public void updateTechnologyConsultancyViewPicture(Long id, MultipartFile picture) {
    TechnologyConsultancyViewEntity entity = technologyConsultancyViewRepository.getBy();

    try {
      entity.setFileName(picture.getOriginalFilename());
      entity.setFileType(picture.getContentType());
      entity.setPicture(picture.getBytes());

      technologyConsultancyViewRepository.save(entity);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
