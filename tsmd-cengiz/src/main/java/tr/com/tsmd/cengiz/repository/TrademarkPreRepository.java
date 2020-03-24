package tr.com.tsmd.cengiz.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.tsmd.cengiz.entity.AboutEntity;
import tr.com.tsmd.cengiz.entity.TrademarkPreEntity;

@Repository
public interface TrademarkPreRepository extends JpaRepository<TrademarkPreEntity, Long> {

  TrademarkPreEntity getById(Long id);

}
