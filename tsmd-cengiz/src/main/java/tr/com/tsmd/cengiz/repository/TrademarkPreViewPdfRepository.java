package tr.com.tsmd.cengiz.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.tsmd.cengiz.entity.TrademarkPreViewPdfEntity;

@Repository
public interface TrademarkPreViewPdfRepository extends JpaRepository<TrademarkPreViewPdfEntity, Long> {
  List<TrademarkPreViewPdfEntity> findAll();

  List<TrademarkPreViewPdfEntity> getByTrademarkPreViewId(Long id);

  TrademarkPreViewPdfEntity getById(Long id);
}
