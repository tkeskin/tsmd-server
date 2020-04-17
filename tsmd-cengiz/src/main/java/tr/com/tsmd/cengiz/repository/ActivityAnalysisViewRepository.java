package tr.com.tsmd.cengiz.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.tsmd.cengiz.entity.AboutEntity;
import tr.com.tsmd.cengiz.entity.ActivityAnalysisViewEntity;

@Repository
public interface ActivityAnalysisViewRepository extends JpaRepository<ActivityAnalysisViewEntity, Long> {
  List<ActivityAnalysisViewEntity> findAll();

  ActivityAnalysisViewEntity getBy();

}
