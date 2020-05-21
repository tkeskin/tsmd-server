package tr.com.tsmd.cengiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.tsmd.cengiz.entity.InvalidationAssessmentEntity;

@Repository
public interface InvalidationAssessmentRepository extends JpaRepository<InvalidationAssessmentEntity, Long> {

  InvalidationAssessmentEntity getById(Long id);

}
