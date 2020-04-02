package tr.com.tsmd.cengiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.tsmd.cengiz.entity.ValuationPatentEntity;

@Repository
public interface ValuationPatentRepository extends JpaRepository<ValuationPatentEntity, Long> {

  ValuationPatentEntity getById(Long id);
}
