package tr.com.tsmd.cengiz.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.tsmd.cengiz.entity.ActivityAnalysisViewPdfEntity;
import tr.com.tsmd.cengiz.entity.PatentPreViewPdfEntity;

@Repository
public interface ActivityAnalysisViewPdfRepository extends JpaRepository<ActivityAnalysisViewPdfEntity, Long> {
  List<ActivityAnalysisViewPdfEntity> findAll();

  List<ActivityAnalysisViewPdfEntity> getByActivityAnalysisViewId(Long id);

  ActivityAnalysisViewPdfEntity getById(Long id);
}
