package tr.com.tsmd.cengiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.tsmd.cengiz.entity.ActivityAnalysisEntity;

@Repository
public interface ActivityAnalysisRepository extends JpaRepository<ActivityAnalysisEntity, Long> {

}
