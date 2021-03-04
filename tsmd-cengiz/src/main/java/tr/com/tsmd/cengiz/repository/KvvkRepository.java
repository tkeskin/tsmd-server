package tr.com.tsmd.cengiz.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.tsmd.cengiz.entity.KvvkEntity;

@Repository
public interface KvvkRepository extends JpaRepository<KvvkEntity, Long> {

  Optional<KvvkEntity> findAllByLanguage(String language);
}
