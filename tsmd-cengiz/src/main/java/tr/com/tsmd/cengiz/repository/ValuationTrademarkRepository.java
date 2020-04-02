package tr.com.tsmd.cengiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.tsmd.cengiz.entity.ValuationTrademarkEntity;

@Repository
public interface ValuationTrademarkRepository extends JpaRepository<ValuationTrademarkEntity, Long> {

  ValuationTrademarkEntity getById(Long id);
}
