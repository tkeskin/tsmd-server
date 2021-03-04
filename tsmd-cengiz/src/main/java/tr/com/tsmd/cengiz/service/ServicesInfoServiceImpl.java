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
import tr.com.tsmd.cengiz.entity.ActivityAnalysisViewEntity;
import tr.com.tsmd.cengiz.entity.ActivityAnalysisViewPdfEntity;
import tr.com.tsmd.cengiz.entity.EvaluationInvalidationViewEntity;
import tr.com.tsmd.cengiz.entity.EvaluationInvalidationViewPdfEntity;
import tr.com.tsmd.cengiz.entity.PatentPreServiceChargesEntity;
import tr.com.tsmd.cengiz.entity.PatentPreViewEntity;
import tr.com.tsmd.cengiz.entity.PatentPreViewPdfEntity;
import tr.com.tsmd.cengiz.entity.TechnologyConsultancyViewEntity;
import tr.com.tsmd.cengiz.entity.TechnologyConsultancyViewPdfEntity;
import tr.com.tsmd.cengiz.entity.TrademarkPreServiceChargesEntity;
import tr.com.tsmd.cengiz.entity.TrademarkPreViewEntity;
import tr.com.tsmd.cengiz.entity.TrademarkPreViewPdfEntity;
import tr.com.tsmd.cengiz.entity.ValuationViewEntity;
import tr.com.tsmd.cengiz.entity.ValuationViewPdfEntity;
import tr.com.tsmd.cengiz.models.ActivityAnalysisView;
import tr.com.tsmd.cengiz.models.ActivityAnalysisViewPdf;
import tr.com.tsmd.cengiz.models.ActivityAnalysisViewPdfList;
import tr.com.tsmd.cengiz.models.EvaluationInvalidationView;
import tr.com.tsmd.cengiz.models.EvaluationInvalidationViewPdf;
import tr.com.tsmd.cengiz.models.EvaluationInvalidationViewPdfList;
import tr.com.tsmd.cengiz.models.PatentPreServiceCharges;
import tr.com.tsmd.cengiz.models.PatentPreView;
import tr.com.tsmd.cengiz.models.PatentPreViewPdf;
import tr.com.tsmd.cengiz.models.PatentPreViewPdfList;
import tr.com.tsmd.cengiz.models.TechnologyConsultancyView;
import tr.com.tsmd.cengiz.models.TechnologyConsultancyViewPdf;
import tr.com.tsmd.cengiz.models.TechnologyConsultancyViewPdfList;
import tr.com.tsmd.cengiz.models.TrademarkPreServiceCharges;
import tr.com.tsmd.cengiz.models.TrademarkPreView;
import tr.com.tsmd.cengiz.models.TrademarkPreViewPdf;
import tr.com.tsmd.cengiz.models.TrademarkPreViewPdfList;
import tr.com.tsmd.cengiz.models.ValuationView;
import tr.com.tsmd.cengiz.models.ValuationViewPdf;
import tr.com.tsmd.cengiz.models.ValuationViewPdfList;
import tr.com.tsmd.cengiz.repository.ActivityAnalysisViewPdfRepository;
import tr.com.tsmd.cengiz.repository.ActivityAnalysisViewRepository;
import tr.com.tsmd.cengiz.repository.EvaluationInvalidationViewPdfRepository;
import tr.com.tsmd.cengiz.repository.EvaluationInvalidationViewRepository;
import tr.com.tsmd.cengiz.repository.PatentPreServiceChargesRepository;
import tr.com.tsmd.cengiz.repository.PatentPreViewPdfRepository;
import tr.com.tsmd.cengiz.repository.PatentPreViewRepository;
import tr.com.tsmd.cengiz.repository.TechnologyConsultancyViewPdfRepository;
import tr.com.tsmd.cengiz.repository.TechnologyConsultancyViewRepository;
import tr.com.tsmd.cengiz.repository.TrademarkPreServiceChargesRepository;
import tr.com.tsmd.cengiz.repository.TrademarkPreViewPdfRepository;
import tr.com.tsmd.cengiz.repository.TrademarkPreViewRepository;
import tr.com.tsmd.cengiz.repository.ValuationViewPdfRepository;
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

  @Autowired
  TrademarkPreViewPdfRepository trademarkPreViewPdfRepository;

  @Autowired
  PatentPreViewPdfRepository patentPreViewPdfRepository;

  @Autowired
  ActivityAnalysisViewPdfRepository activityAnalysisViewPdfRepository;

  @Autowired
  ValuationViewPdfRepository valuationViewPdfRepository;

  @Autowired
  EvaluationInvalidationViewPdfRepository evaluationInvalidationViewPdfRepository;

  @Autowired
  TechnologyConsultancyViewPdfRepository technologyConsultancyViewPdfRepository;

  @Autowired
  TrademarkPreServiceChargesRepository trademarkPreServiceChargesRepository;

  @Autowired
  PatentPreServiceChargesRepository patentPreServiceChargesRepository;


  @Override
  public PatentPreView getPatentPreViewBy() {
    PatentPreViewEntity entity = patentPreViewRepository.getBy();
    PatentPreView patentPreView = new PatentPreView(entity.getId(), entity.getPicture(), entity.getPatentPreExplain(),entity.getPatentPreExplainEn(), "data: image/jpeg;base64," +
        new String(Base64.encodeBase64(entity.getPicture()), StandardCharsets.US_ASCII), entity.getFileName(), entity.getFileType());
    return patentPreView;
  }

  @Override
  public void updatePatentPreViewContent(PatentPreView patentPreView) {

    PatentPreViewEntity entity = patentPreViewRepository.getBy();
    entity.setPatentPreExplain(patentPreView.getPatentPreExplain());
    entity.setPatentPreExplainEn(patentPreView.getPatentPreExplainEn());

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
    TrademarkPreView trademarkPreView = null;
    if (entity.getNice() != null) {
      trademarkPreView = new TrademarkPreView(entity.getId(), entity.getTrademarkPreExplain(),entity.getTrademarkPreExplainEn(), entity.getPicture(), "data: image/jpeg;base64," +
          new String(Base64.encodeBase64(entity.getPicture()), StandardCharsets.US_ASCII), entity.getFileName(), entity.getFileType(),
          entity.getNice(), "data: image/jpeg;base64," +
          new String(Base64.encodeBase64(entity.getNice()), StandardCharsets.US_ASCII), entity.getNiceFileName(), entity.getNiceFileType());
    } else {
      trademarkPreView = new TrademarkPreView(entity.getId(), entity.getPicture(), entity.getTrademarkPreExplain(), "data: image/jpeg;base64," +
          new String(Base64.encodeBase64(entity.getPicture()), StandardCharsets.US_ASCII), entity.getFileName(), entity.getFileType());
    }
    return trademarkPreView;
  }

  @Override
  public void updateTrademarkPreViewContent(TrademarkPreView trademarkPreView) {

    TrademarkPreViewEntity entity = trademarkPreViewRepository.getBy();
    entity.setTrademarkPreExplain(trademarkPreView.getTrademarkPreExplain());
    entity.setTrademarkPreExplainEn(trademarkPreView.getTrademarkPreExplainEn());

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
    ActivityAnalysisView activityAnalysisView = new ActivityAnalysisView(entity.getId(), entity.getPicture(), entity.getActivityAnalysisExplain(), entity.getActivityAnalysisExplainEn(),"data: image/jpeg;base64," +
        new String(Base64.encodeBase64(entity.getPicture()), StandardCharsets.US_ASCII), entity.getFileName(), entity.getFileType());
    return activityAnalysisView;
  }

  @Override
  public void updateActivityAnalysisViewContent(ActivityAnalysisView activityAnalysisView) {

    ActivityAnalysisViewEntity entity = activityAnalysisViewRepository.getBy();
    entity.setActivityAnalysisExplain(activityAnalysisView.getActivityAnalysisExplain());
    entity.setActivityAnalysisExplainEn(activityAnalysisView.getActivityAnalysisExplainEn());

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
    ValuationView valuationView = new ValuationView(entity.getId(), entity.getPicture(), entity.getValuationExplain(),entity.getValuationExplainEn(), "data: image/jpeg;base64," +
        new String(Base64.encodeBase64(entity.getPicture()), StandardCharsets.US_ASCII), entity.getFileName(), entity.getFileType());
    return valuationView;
  }

  @Override
  public void updateValuationViewContent(ValuationView valuationView) {

    ValuationViewEntity entity = valuationViewRepository.getBy();
    entity.setValuationExplain(valuationView.getValuationExplain());
    entity.setValuationExplainEn(valuationView.getValuationExplainEn());

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
    EvaluationInvalidationView evaluationInvalidationView = new EvaluationInvalidationView(entity.getId(), entity.getPicture(), entity.getEvaluationInvalidationExplain(), entity.getEvaluationInvalidationExplainEn(),"data: image/jpeg;base64," +
        new String(Base64.encodeBase64(entity.getPicture()), StandardCharsets.US_ASCII), entity.getFileName(), entity.getFileType());
    return evaluationInvalidationView;
  }

  @Override
  public void updateEvaluationInvalidationViewContent(EvaluationInvalidationView evaluationInvalidationView) {

    EvaluationInvalidationViewEntity entity = evaluationInvalidationViewRepository.getBy();
    entity.setEvaluationInvalidationExplain(evaluationInvalidationView.getEvaluationInvalidationExplain());
    entity.setEvaluationInvalidationExplainEn(evaluationInvalidationView.getEvaluationInvalidationExplainEn());

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
    TechnologyConsultancyView technologyConsultancyView = new TechnologyConsultancyView(entity.getId(), entity.getPicture(), entity.getTechnologyConsultancyExplain(),entity.getTechnologyConsultancyExplainEn(), "data: image/jpeg;base64," +
        new String(Base64.encodeBase64(entity.getPicture()), StandardCharsets.US_ASCII), entity.getFileName(), entity.getFileType());
    return technologyConsultancyView;
  }

  @Override
  public void updateTechnologyConsultancyViewContent(TechnologyConsultancyView technologyConsultancyView) {

    TechnologyConsultancyViewEntity entity = technologyConsultancyViewRepository.getBy();
    entity.setTechnologyConsultancyExplain(technologyConsultancyView.getTechnologyConsultancyExplain());
    entity.setTechnologyConsultancyExplainEn(technologyConsultancyView.getTechnologyConsultancyExplainEn());

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


  @Override
  public void uploadPatentPreViewPdfFiles(Long id, MultipartFile[] pdfFiles) throws Exception {
    for (MultipartFile multipartFile : pdfFiles) {
      PatentPreViewPdfEntity patentPreViewPdfEntity = new PatentPreViewPdfEntity();
      patentPreViewPdfEntity.setFileName(multipartFile.getOriginalFilename());
      patentPreViewPdfEntity.setFileType(multipartFile.getContentType());
      patentPreViewPdfEntity.setPdfFile(multipartFile.getBytes());
      patentPreViewPdfEntity.setPatentPreViewId(id);
      patentPreViewPdfRepository.save(patentPreViewPdfEntity);
    }
  }

  @Override
  public PatentPreViewPdfList getPatentPreViewPdfFiles(Long patentPreViewId) {
    List<PatentPreViewPdfEntity> entities = new ArrayList<>();
    List<PatentPreViewPdf> dtos = new ArrayList<>();
    PatentPreViewPdfList patentPreViewPdfList = new PatentPreViewPdfList();
    entities = patentPreViewPdfRepository.getByPatentPreViewId(patentPreViewId);

    for (PatentPreViewPdfEntity entity : entities) {
      PatentPreViewPdf patentPreViewPdf = new PatentPreViewPdf();
      patentPreViewPdf.setFileName(entity.getFileName());
      patentPreViewPdf.setFileType(entity.getFileType());
      patentPreViewPdf.setId(entity.getId());
      patentPreViewPdf.setPdf(entity.getPdfFile());
      patentPreViewPdf.setBase64Pdf("data: image/jpeg;base64," +
          new String(Base64.encodeBase64(entity.getPdfFile()), StandardCharsets.US_ASCII));
      patentPreViewPdf.setPatentPreViewId(patentPreViewId);
      dtos.add(patentPreViewPdf);
    }
    patentPreViewPdfList.setPatentPreViewPdfs(dtos);
    return patentPreViewPdfList;
  }

  @Override
  public void deletePatentPreViewPdfById(Long id) {
    patentPreViewPdfRepository.deleteById(id);
  }

  @Override
  public PatentPreViewPdfEntity getPatentPreViewPdfById(Long id) {
    return patentPreViewPdfRepository.getById(id);
  }


  @Override
  public void uploadTrademarkPreViewPdfFiles(Long id, MultipartFile[] pdfFiles) throws Exception {
    for (MultipartFile multipartFile : pdfFiles) {
      TrademarkPreViewPdfEntity trademarkPreViewPdfEntity = new TrademarkPreViewPdfEntity();
      trademarkPreViewPdfEntity.setFileName(multipartFile.getOriginalFilename());
      trademarkPreViewPdfEntity.setFileType(multipartFile.getContentType());
      trademarkPreViewPdfEntity.setPdfFile(multipartFile.getBytes());
      trademarkPreViewPdfEntity.setTrademarkPreViewId(id);
      trademarkPreViewPdfRepository.save(trademarkPreViewPdfEntity);
    }
  }

  @Override
  public TrademarkPreViewPdfList getTrademarkPreViewPdfFiles(Long trademarkPreViewId) {
    List<TrademarkPreViewPdfEntity> entities = new ArrayList<>();
    List<TrademarkPreViewPdf> dtos = new ArrayList<>();
    TrademarkPreViewPdfList trademarkPreViewPdfList = new TrademarkPreViewPdfList();
    entities = trademarkPreViewPdfRepository.getByTrademarkPreViewId(trademarkPreViewId);

    for (TrademarkPreViewPdfEntity entity : entities) {
      TrademarkPreViewPdf trademarkPreViewPdf = new TrademarkPreViewPdf();
      trademarkPreViewPdf.setFileName(entity.getFileName());
      trademarkPreViewPdf.setFileType(entity.getFileType());
      trademarkPreViewPdf.setId(entity.getId());
      trademarkPreViewPdf.setPdf(entity.getPdfFile());
      trademarkPreViewPdf.setBase64Pdf("data: image/jpeg;base64," +
          new String(Base64.encodeBase64(entity.getPdfFile()), StandardCharsets.US_ASCII));
      trademarkPreViewPdf.setTrademarkPreViewId(trademarkPreViewId);
      dtos.add(trademarkPreViewPdf);
    }
    trademarkPreViewPdfList.setTrademarkPreViewPdfs(dtos);
    return trademarkPreViewPdfList;
  }

  @Override
  public void deleteTrademarkPreViewPdfById(Long id) {
    trademarkPreViewPdfRepository.deleteById(id);
  }

  @Override
  public TrademarkPreViewPdfEntity getTrademarkPreViewPdfById(Long id) {
    return trademarkPreViewPdfRepository.getById(id);
  }

  @Override
  public void uploadActivityAnalysisViewPdfFiles(Long id, MultipartFile[] pdfFiles) throws Exception {
    for (MultipartFile multipartFile : pdfFiles) {
      ActivityAnalysisViewPdfEntity activityAnalysisViewPdfEntity = new ActivityAnalysisViewPdfEntity();
      activityAnalysisViewPdfEntity.setFileName(multipartFile.getOriginalFilename());
      activityAnalysisViewPdfEntity.setFileType(multipartFile.getContentType());
      activityAnalysisViewPdfEntity.setPdfFile(multipartFile.getBytes());
      activityAnalysisViewPdfEntity.setActivityAnalysisViewId(id);
      activityAnalysisViewPdfRepository.save(activityAnalysisViewPdfEntity);
    }
  }

  @Override
  public ActivityAnalysisViewPdfList getActivityAnalysisViewPdfFiles(Long activityAnalysisViewId) {
    List<ActivityAnalysisViewPdfEntity> entities = new ArrayList<>();
    List<ActivityAnalysisViewPdf> dtos = new ArrayList<>();
    ActivityAnalysisViewPdfList activityAnalysisViewPdfList = new ActivityAnalysisViewPdfList();
    entities = activityAnalysisViewPdfRepository.getByActivityAnalysisViewId(activityAnalysisViewId);

    for (ActivityAnalysisViewPdfEntity entity : entities) {
      ActivityAnalysisViewPdf activityAnalysisViewPdf = new ActivityAnalysisViewPdf();
      activityAnalysisViewPdf.setFileName(entity.getFileName());
      activityAnalysisViewPdf.setFileType(entity.getFileType());
      activityAnalysisViewPdf.setId(entity.getId());
      activityAnalysisViewPdf.setPdf(entity.getPdfFile());
      activityAnalysisViewPdf.setBase64Pdf("data: image/jpeg;base64," +
          new String(Base64.encodeBase64(entity.getPdfFile()), StandardCharsets.US_ASCII));
      activityAnalysisViewPdf.setActivityAnalysisViewId(activityAnalysisViewId);
      dtos.add(activityAnalysisViewPdf);
    }
    activityAnalysisViewPdfList.setActivityAnalysisViewPdfs(dtos);
    return activityAnalysisViewPdfList;
  }

  @Override
  public void deleteActivityAnalysisViewPdfById(Long id) {
    activityAnalysisViewPdfRepository.deleteById(id);
  }

  @Override
  public ActivityAnalysisViewPdfEntity getActivityAnalysisViewPdfById(Long id) {
    return activityAnalysisViewPdfRepository.getById(id);
  }


  @Override
  public void uploadValuationViewPdfFiles(Long id, MultipartFile[] pdfFiles) throws Exception {
    for (MultipartFile multipartFile : pdfFiles) {
      ValuationViewPdfEntity valuationViewPdfEntity = new ValuationViewPdfEntity();
      valuationViewPdfEntity.setFileName(multipartFile.getOriginalFilename());
      valuationViewPdfEntity.setFileType(multipartFile.getContentType());
      valuationViewPdfEntity.setPdfFile(multipartFile.getBytes());
      valuationViewPdfEntity.setValuationViewId(id);
      valuationViewPdfRepository.save(valuationViewPdfEntity);
    }
  }

  @Override
  public ValuationViewPdfList getValuationViewPdfFiles(Long valuationViewId) {
    List<ValuationViewPdfEntity> entities = new ArrayList<>();
    List<ValuationViewPdf> dtos = new ArrayList<>();
    ValuationViewPdfList valuationViewPdfList = new ValuationViewPdfList();
    entities = valuationViewPdfRepository.getByValuationViewId(valuationViewId);

    for (ValuationViewPdfEntity entity : entities) {
      ValuationViewPdf valuationViewPdf = new ValuationViewPdf();
      valuationViewPdf.setFileName(entity.getFileName());
      valuationViewPdf.setFileType(entity.getFileType());
      valuationViewPdf.setId(entity.getId());
      valuationViewPdf.setPdf(entity.getPdfFile());
      valuationViewPdf.setBase64Pdf("data: image/jpeg;base64," +
          new String(Base64.encodeBase64(entity.getPdfFile()), StandardCharsets.US_ASCII));
      valuationViewPdf.setValuationViewId(valuationViewId);
      dtos.add(valuationViewPdf);
    }
    valuationViewPdfList.setValuationViewPdfs(dtos);
    return valuationViewPdfList;
  }

  @Override
  public void deleteValuationViewPdfById(Long id) {
    valuationViewPdfRepository.deleteById(id);
  }

  @Override
  public ValuationViewPdfEntity getValuationViewPdfById(Long id) {
    return valuationViewPdfRepository.getById(id);
  }


  @Override
  public void uploadEvaluationInvalidationViewPdfFiles(Long id, MultipartFile[] pdfFiles) throws Exception {
    for (MultipartFile multipartFile : pdfFiles) {
      EvaluationInvalidationViewPdfEntity evaluationInvalidationViewPdfEntity = new EvaluationInvalidationViewPdfEntity();
      evaluationInvalidationViewPdfEntity.setFileName(multipartFile.getOriginalFilename());
      evaluationInvalidationViewPdfEntity.setFileType(multipartFile.getContentType());
      evaluationInvalidationViewPdfEntity.setPdfFile(multipartFile.getBytes());
      evaluationInvalidationViewPdfEntity.setEvaluationInvalidationViewId(id);
      evaluationInvalidationViewPdfRepository.save(evaluationInvalidationViewPdfEntity);
    }
  }

  @Override
  public EvaluationInvalidationViewPdfList getEvaluationInvalidationViewPdfFiles(Long evaluationInvalidationViewId) {
    List<EvaluationInvalidationViewPdfEntity> entities = new ArrayList<>();
    List<EvaluationInvalidationViewPdf> dtos = new ArrayList<>();
    EvaluationInvalidationViewPdfList evaluationInvalidationViewPdfList = new EvaluationInvalidationViewPdfList();
    entities = evaluationInvalidationViewPdfRepository.getByEvaluationInvalidationViewId(evaluationInvalidationViewId);

    for (EvaluationInvalidationViewPdfEntity entity : entities) {
      EvaluationInvalidationViewPdf evaluationInvalidationViewPdf = new EvaluationInvalidationViewPdf();
      evaluationInvalidationViewPdf.setFileName(entity.getFileName());
      evaluationInvalidationViewPdf.setFileType(entity.getFileType());
      evaluationInvalidationViewPdf.setId(entity.getId());
      evaluationInvalidationViewPdf.setPdf(entity.getPdfFile());
      evaluationInvalidationViewPdf.setBase64Pdf("data: image/jpeg;base64," +
          new String(Base64.encodeBase64(entity.getPdfFile()), StandardCharsets.US_ASCII));
      evaluationInvalidationViewPdf.setEvaluationInvalidationViewId(evaluationInvalidationViewId);
      dtos.add(evaluationInvalidationViewPdf);
    }
    evaluationInvalidationViewPdfList.setEvaluationInvalidationViewPdfs(dtos);
    return evaluationInvalidationViewPdfList;
  }

  @Override
  public void deleteEvaluationInvalidationViewPdfById(Long id) {
    evaluationInvalidationViewPdfRepository.deleteById(id);
  }

  @Override
  public EvaluationInvalidationViewPdfEntity getEvaluationInvalidationViewPdfById(Long id) {
    return evaluationInvalidationViewPdfRepository.getById(id);
  }


  @Override
  public void uploadTechnologyConsultancyViewPdfFiles(Long id, MultipartFile[] pdfFiles) throws Exception {
    for (MultipartFile multipartFile : pdfFiles) {
      TechnologyConsultancyViewPdfEntity technologyConsultancyViewPdfEntity = new TechnologyConsultancyViewPdfEntity();
      technologyConsultancyViewPdfEntity.setFileName(multipartFile.getOriginalFilename());
      technologyConsultancyViewPdfEntity.setFileType(multipartFile.getContentType());
      technologyConsultancyViewPdfEntity.setPdfFile(multipartFile.getBytes());
      technologyConsultancyViewPdfEntity.setTechnologyConsultancyViewId(id);
      technologyConsultancyViewPdfRepository.save(technologyConsultancyViewPdfEntity);
    }
  }

  @Override
  public TechnologyConsultancyViewPdfList getTechnologyConsultancyViewPdfFiles(Long technologyConsultancyViewId) {
    List<TechnologyConsultancyViewPdfEntity> entities = new ArrayList<>();
    List<TechnologyConsultancyViewPdf> dtos = new ArrayList<>();
    TechnologyConsultancyViewPdfList technologyConsultancyViewPdfList = new TechnologyConsultancyViewPdfList();
    entities = technologyConsultancyViewPdfRepository.getByTechnologyConsultancyViewId(technologyConsultancyViewId);

    for (TechnologyConsultancyViewPdfEntity entity : entities) {
      TechnologyConsultancyViewPdf technologyConsultancyViewPdf = new TechnologyConsultancyViewPdf();
      technologyConsultancyViewPdf.setFileName(entity.getFileName());
      technologyConsultancyViewPdf.setFileType(entity.getFileType());
      technologyConsultancyViewPdf.setId(entity.getId());
      technologyConsultancyViewPdf.setPdf(entity.getPdfFile());
      technologyConsultancyViewPdf.setBase64Pdf("data: image/jpeg;base64," +
          new String(Base64.encodeBase64(entity.getPdfFile()), StandardCharsets.US_ASCII));
      technologyConsultancyViewPdf.setTechnologyConsultancyViewId(technologyConsultancyViewId);
      dtos.add(technologyConsultancyViewPdf);
    }
    technologyConsultancyViewPdfList.setTechnologyConsultancyViewPdfs(dtos);
    return technologyConsultancyViewPdfList;
  }

  @Override
  public void deleteTechnologyConsultancyViewPdfById(Long id) {
    technologyConsultancyViewPdfRepository.deleteById(id);
  }

  @Override
  public TechnologyConsultancyViewPdfEntity getTechnologyConsultancyViewPdfById(Long id) {
    return technologyConsultancyViewPdfRepository.getById(id);
  }



  @Override
  public void saveTrademarkPreViewNice(MultipartFile nice) {
    TrademarkPreViewEntity entity = trademarkPreViewRepository.getBy();

    try {
      entity.setNiceFileName(nice.getOriginalFilename());
      entity.setNiceFileType(nice.getContentType());
      entity.setNice(nice.getBytes());

      trademarkPreViewRepository.save(entity);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public TrademarkPreServiceCharges getTrademarkPreServiceCharges() {
    Optional<TrademarkPreServiceChargesEntity> optional = trademarkPreServiceChargesRepository.getBy();
    if (optional.isPresent()) {
     return new TrademarkPreServiceCharges(optional.get().getId(),optional.get().getExplain(),optional.get().getExplainEn());
    } else {
      return new TrademarkPreServiceCharges();
    }
  }

  @Override
  public void updateTrademarkPreServiceCharges(TrademarkPreServiceCharges trademarkPreServiceCharges) {
    Optional<TrademarkPreServiceChargesEntity> optional = trademarkPreServiceChargesRepository.getBy();
    if (optional.isPresent()) {
      optional.get().setExplain(trademarkPreServiceCharges.getExplain());
      optional.get().setExplainEn(trademarkPreServiceCharges.getExplainEn());
      trademarkPreServiceChargesRepository.save(optional.get());
    } else {
      TrademarkPreServiceChargesEntity trademarkPreServiceChargesEntity = new TrademarkPreServiceChargesEntity();
      trademarkPreServiceCharges.setExplain(trademarkPreServiceCharges.getExplain());
      trademarkPreServiceCharges.setExplainEn(trademarkPreServiceCharges.getExplainEn());
      trademarkPreServiceChargesRepository.save(trademarkPreServiceChargesEntity);
    }

  }

  @Override
  public PatentPreServiceCharges getPatentPreServiceCharges() {
    Optional<PatentPreServiceChargesEntity> optional = patentPreServiceChargesRepository.getBy();
    if (optional.isPresent()) {
      return new PatentPreServiceCharges(optional.get().getId(),optional.get().getExplain(),optional.get().getExplainEn());
    } else {
      return new PatentPreServiceCharges();
    }
  }

  @Override
  public void updatePatentPreServiceCharges(PatentPreServiceCharges patentPreServiceCharges) {
    Optional<PatentPreServiceChargesEntity> optional = patentPreServiceChargesRepository.getBy();
    if (optional.isPresent()) {
      optional.get().setExplain(patentPreServiceCharges.getExplain());
      optional.get().setExplainEn(patentPreServiceCharges.getExplainEn());
      patentPreServiceChargesRepository.save(optional.get());
    } else {
      PatentPreServiceChargesEntity patentPreServiceChargesEntity = new PatentPreServiceChargesEntity();
      patentPreServiceChargesEntity.setExplain(patentPreServiceCharges.getExplain());
      patentPreServiceChargesEntity.setExplainEn(patentPreServiceCharges.getExplainEn());
      patentPreServiceChargesRepository.save(patentPreServiceChargesEntity);
    }
  }
}
