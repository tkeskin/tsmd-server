package tr.com.tsmd.cengiz.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.tsmd.cengiz.entity.PatentPreTableEntity;

@Repository
public interface PatentPreTableRepository extends JpaRepository<PatentPreTableEntity, Long> {

  List<PatentPreTableEntity> getByPatentPreId(Long patentPreId);

}
