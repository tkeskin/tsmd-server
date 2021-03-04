package tr.com.tsmd.cengiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.tsmd.cengiz.entity.GeneratorInvalidationAssessmentEntity;

@Repository
public interface GeneratorInvalidationAssessmentRepository extends JpaRepository<GeneratorInvalidationAssessmentEntity, Long> {


}
