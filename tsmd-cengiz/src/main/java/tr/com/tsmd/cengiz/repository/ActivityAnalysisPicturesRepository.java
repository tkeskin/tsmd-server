package tr.com.tsmd.cengiz.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.tsmd.cengiz.entity.ActivityAnalysisPicturesEntity;
import tr.com.tsmd.cengiz.entity.PatentPreRelatedPicturesEntity;

@Repository
public interface ActivityAnalysisPicturesRepository extends JpaRepository<ActivityAnalysisPicturesEntity, Long> {
  List<ActivityAnalysisPicturesEntity> findAll();

  List<ActivityAnalysisPicturesEntity> getByActivityAnalysisId(Long id);

  ActivityAnalysisPicturesEntity getById(Long id);
}
