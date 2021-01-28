package tr.com.tsmd.cengiz.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.tsmd.cengiz.entity.PatentPreServiceChargesEntity;

@Repository
public interface PatentPreServiceChargesRepository extends JpaRepository<PatentPreServiceChargesEntity, Long> {

  Optional<PatentPreServiceChargesEntity> getBy();
}
