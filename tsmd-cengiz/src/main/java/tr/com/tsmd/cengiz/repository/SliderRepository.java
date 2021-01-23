package tr.com.tsmd.cengiz.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.tsmd.cengiz.entity.SliderEntity;

@Repository
public interface SliderRepository extends JpaRepository<SliderEntity, Long> {
  List<SliderEntity> findAllByOrderByIdAsc();

  SliderEntity getById(Long id);

  void deleteById(Long id);
}
