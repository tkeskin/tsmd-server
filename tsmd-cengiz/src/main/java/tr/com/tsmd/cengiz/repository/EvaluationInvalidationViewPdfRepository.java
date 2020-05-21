package tr.com.tsmd.cengiz.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.tsmd.cengiz.entity.ActivityAnalysisViewPdfEntity;
import tr.com.tsmd.cengiz.entity.EvaluationInvalidationViewPdfEntity;

@Repository
public interface EvaluationInvalidationViewPdfRepository extends JpaRepository<EvaluationInvalidationViewPdfEntity, Long> {
  List<EvaluationInvalidationViewPdfEntity> findAll();

  List<EvaluationInvalidationViewPdfEntity> getByEvaluationInvalidationViewId(Long id);

  EvaluationInvalidationViewPdfEntity getById(Long id);
}
