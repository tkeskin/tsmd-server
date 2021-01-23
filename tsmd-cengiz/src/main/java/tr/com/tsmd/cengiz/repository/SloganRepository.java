package tr.com.tsmd.cengiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.tsmd.cengiz.entity.SloganEntity;

@Repository
public interface SloganRepository extends JpaRepository<SloganEntity, Long> {

  SloganEntity getById(Long id);

}
