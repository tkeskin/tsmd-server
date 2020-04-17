package tr.com.tsmd.cengiz.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.tsmd.cengiz.entity.AboutEntity;
import tr.com.tsmd.cengiz.entity.TechnologyConsultancyViewEntity;

@Repository
public interface TechnologyConsultancyViewRepository extends JpaRepository<TechnologyConsultancyViewEntity, Long> {
  List<TechnologyConsultancyViewEntity> findAll();

  TechnologyConsultancyViewEntity getBy();

}
