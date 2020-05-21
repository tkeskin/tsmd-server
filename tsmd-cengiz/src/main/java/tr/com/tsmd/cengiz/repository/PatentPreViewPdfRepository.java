package tr.com.tsmd.cengiz.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.tsmd.cengiz.entity.PatentPreViewPdfEntity;
import tr.com.tsmd.cengiz.entity.TrademarkPreViewPdfEntity;

@Repository
public interface PatentPreViewPdfRepository extends JpaRepository<PatentPreViewPdfEntity, Long> {
  List<PatentPreViewPdfEntity> findAll();

  List<PatentPreViewPdfEntity> getByPatentPreViewId(Long id);

  PatentPreViewPdfEntity getById(Long id);
}
