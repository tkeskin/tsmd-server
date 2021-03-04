package tr.com.tsmd.cengiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.tsmd.cengiz.entity.GeneratorActivityAnalysisEntity;
import tr.com.tsmd.cengiz.entity.GeneratorPatentPreEntity;

@Repository
public interface GeneratorActivityAnalysisRepository extends JpaRepository<GeneratorActivityAnalysisEntity, Long> {


}
