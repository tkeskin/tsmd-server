package tr.com.tsmd.cengiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.tsmd.cengiz.entity.GeneratorValuationPatentEntity;
import tr.com.tsmd.cengiz.entity.GeneratorValuationTrademarkEntity;

@Repository
public interface GeneratorValuationPatentRepository extends JpaRepository<GeneratorValuationPatentEntity, Long> {


}
