package tr.com.tsmd.cengiz.service;

import org.springframework.web.multipart.MultipartFile;
import tr.com.tsmd.cengiz.models.ActivityAnalysisView;
import tr.com.tsmd.cengiz.models.EvaluationInvalidationView;
import tr.com.tsmd.cengiz.models.PatentPreView;
import tr.com.tsmd.cengiz.models.TechnologyConsultancyView;
import tr.com.tsmd.cengiz.models.TrademarkPreView;
import tr.com.tsmd.cengiz.models.ValuationView;

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
}
