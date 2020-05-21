package tr.com.tsmd.cengiz.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.tsmd.cengiz.entity.ActivityAnalysisViewPdfEntity;
import tr.com.tsmd.cengiz.entity.TechnologyConsultancyViewPdfEntity;

@Repository
public interface TechnologyConsultancyViewPdfRepository extends JpaRepository<TechnologyConsultancyViewPdfEntity, Long> {
  List<TechnologyConsultancyViewPdfEntity> findAll();

  List<TechnologyConsultancyViewPdfEntity> getByTechnologyConsultancyViewId(Long id);

  TechnologyConsultancyViewPdfEntity getById(Long id);
}
