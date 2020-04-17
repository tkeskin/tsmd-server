package tr.com.tsmd.cengiz.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.tsmd.cengiz.entity.AboutEntity;
import tr.com.tsmd.cengiz.entity.PatentPreViewEntity;

@Repository
public interface PatentPreViewRepository extends JpaRepository<PatentPreViewEntity, Long> {
  List<PatentPreViewEntity> findAll();

  PatentPreViewEntity getBy();

}
