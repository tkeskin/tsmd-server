package tr.com.tsmd.cengiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.tsmd.cengiz.entity.KvvkEntity;

@Repository
public interface KvvkRepository extends JpaRepository<KvvkEntity, Long> {

}
