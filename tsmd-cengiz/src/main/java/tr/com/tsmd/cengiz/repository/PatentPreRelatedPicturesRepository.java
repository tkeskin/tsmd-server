package tr.com.tsmd.cengiz.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.tsmd.cengiz.entity.NewsRelatedPicturesEntity;
import tr.com.tsmd.cengiz.entity.PatentPreRelatedPicturesEntity;

@Repository
public interface PatentPreRelatedPicturesRepository extends JpaRepository<PatentPreRelatedPicturesEntity, Long> {
  List<PatentPreRelatedPicturesEntity> findAll();

  List<PatentPreRelatedPicturesEntity> getByPatentPreId(Long id);

  PatentPreRelatedPicturesEntity getById(Long id);
}
