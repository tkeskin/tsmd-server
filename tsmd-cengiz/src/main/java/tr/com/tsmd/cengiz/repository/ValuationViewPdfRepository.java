package tr.com.tsmd.cengiz.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.tsmd.cengiz.entity.ActivityAnalysisViewPdfEntity;
import tr.com.tsmd.cengiz.entity.ValuationViewPdfEntity;

@Repository
public interface ValuationViewPdfRepository extends JpaRepository<ValuationViewPdfEntity, Long> {
  List<ValuationViewPdfEntity> findAll();

  List<ValuationViewPdfEntity> getByValuationViewId(Long id);

  ValuationViewPdfEntity getById(Long id);
}
