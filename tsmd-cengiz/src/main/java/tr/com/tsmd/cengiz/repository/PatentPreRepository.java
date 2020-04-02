package tr.com.tsmd.cengiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.tsmd.cengiz.entity.PatentPreEntity;

@Repository
public interface PatentPreRepository extends JpaRepository<PatentPreEntity, Long> {

  PatentPreEntity getById(Long id);
}
