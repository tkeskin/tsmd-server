package tr.com.tsmd.cengiz.service;

import org.springframework.web.multipart.MultipartFile;
import tr.com.tsmd.cengiz.entity.ActivityAnalysisViewPdfEntity;
import tr.com.tsmd.cengiz.entity.EvaluationInvalidationViewPdfEntity;
import tr.com.tsmd.cengiz.entity.PatentPreViewPdfEntity;
import tr.com.tsmd.cengiz.entity.TechnologyConsultancyViewPdfEntity;
import tr.com.tsmd.cengiz.entity.TrademarkPreViewEntity;
import tr.com.tsmd.cengiz.entity.TrademarkPreViewPdfEntity;
import tr.com.tsmd.cengiz.entity.ValuationViewPdfEntity;
import tr.com.tsmd.cengiz.models.ActivityAnalysisView;
import tr.com.tsmd.cengiz.models.ActivityAnalysisViewPdfList;
import tr.com.tsmd.cengiz.models.EvaluationInvalidationView;
import tr.com.tsmd.cengiz.models.EvaluationInvalidationViewPdfList;
import tr.com.tsmd.cengiz.models.NewsRelatedPicturesList;
import tr.com.tsmd.cengiz.models.PatentPreServiceCharges;
import tr.com.tsmd.cengiz.models.PatentPreView;
import tr.com.tsmd.cengiz.models.PatentPreViewPdfList;
import tr.com.tsmd.cengiz.models.TechnologyConsultancyView;
import tr.com.tsmd.cengiz.models.TechnologyConsultancyViewPdfList;
import tr.com.tsmd.cengiz.models.TrademarkPreServiceCharges;
import tr.com.tsmd.cengiz.models.TrademarkPreView;
import tr.com.tsmd.cengiz.models.TrademarkPreViewPdfList;
import tr.com.tsmd.cengiz.models.ValuationView;
import tr.com.tsmd.cengiz.models.ValuationViewPdfList;

public interface ServicesInfoService {

  TrademarkPreView getTrademarkPreViewBy();

  void updateTrademarkPreViewContent(TrademarkPreView trademarkPreView);

  void updateTrademarkPreViewPicture(Long id, MultipartFile picture);

  PatentPreView getPatentPreViewBy();

  void updatePatentPreViewContent(PatentPreView patentPreView);

  void updatePatentPreViewPicture(Long id, MultipartFile picture);

  ActivityAnalysisView getActivityAnalysisViewBy();

  void updateActivityAnalysisViewContent(ActivityAnalysisView about);

  void updateActivityAnalysisViewPicture(Long id, MultipartFile picture);

  ValuationView getValuationViewBy();

  void updateValuationViewContent(ValuationView valuationView);

  void updateValuationViewPicture(Long id, MultipartFile picture);

  EvaluationInvalidationView getEvaluationInvalidationViewBy();

  void updateEvaluationInvalidationViewContent(EvaluationInvalidationView evaluationInvalidationView);

  void updateEvaluationInvalidationViewPicture(Long id, MultipartFile picture);

  TechnologyConsultancyView getTechnologyConsultancyViewBy();

  void updateTechnologyConsultancyViewContent(TechnologyConsultancyView technologyConsultancyView);

  void updateTechnologyConsultancyViewPicture(Long id, MultipartFile picture);

  void uploadTrademarkPreViewPdfFiles(Long id, MultipartFile[] pdfFiles) throws Exception ;

  TrademarkPreViewPdfList getTrademarkPreViewPdfFiles(Long trademarkPreViewId);

  void deleteTrademarkPreViewPdfById(Long id);

  TrademarkPreViewPdfEntity getTrademarkPreViewPdfById(Long id);

  void uploadPatentPreViewPdfFiles(Long patentPreViewId, MultipartFile[] pdfFiles) throws Exception ;

  PatentPreViewPdfList getPatentPreViewPdfFiles(Long patentPreViewId);

  void deletePatentPreViewPdfById(Long id);

  PatentPreViewPdfEntity getPatentPreViewPdfById(Long id);


  void uploadActivityAnalysisViewPdfFiles(Long patentPreViewId, MultipartFile[] pdfFiles) throws Exception ;

  ActivityAnalysisViewPdfList getActivityAnalysisViewPdfFiles(Long activityAnalysisViewId);

  void deleteActivityAnalysisViewPdfById(Long id);

  ActivityAnalysisViewPdfEntity getActivityAnalysisViewPdfById(Long id);



  void uploadValuationViewPdfFiles(Long patentPreViewId, MultipartFile[] pdfFiles) throws Exception ;

  ValuationViewPdfList getValuationViewPdfFiles(Long valuationViewId);

  void deleteValuationViewPdfById(Long id);

  ValuationViewPdfEntity getValuationViewPdfById(Long id);


  void uploadEvaluationInvalidationViewPdfFiles(Long patentPreViewId, MultipartFile[] pdfFiles) throws Exception ;

  EvaluationInvalidationViewPdfList getEvaluationInvalidationViewPdfFiles(Long evaluationInvalidationViewId);

  void deleteEvaluationInvalidationViewPdfById(Long id);

  EvaluationInvalidationViewPdfEntity getEvaluationInvalidationViewPdfById(Long id);



  void uploadTechnologyConsultancyViewPdfFiles(Long patentPreViewId, MultipartFile[] pdfFiles) throws Exception ;

  TechnologyConsultancyViewPdfList getTechnologyConsultancyViewPdfFiles(Long technologyConsultancyViewId);

  void deleteTechnologyConsultancyViewPdfById(Long id);

  TechnologyConsultancyViewPdfEntity getTechnologyConsultancyViewPdfById(Long id);


  void saveTrademarkPreViewNice(MultipartFile nice);

  TrademarkPreServiceCharges getTrademarkPreServiceCharges();

  void updateTrademarkPreServiceCharges(TrademarkPreServiceCharges trademarkPreServiceCharges);

  PatentPreServiceCharges getPatentPreServiceCharges();

  void updatePatentPreServiceCharges(PatentPreServiceCharges patentPreServiceCharges);
}
