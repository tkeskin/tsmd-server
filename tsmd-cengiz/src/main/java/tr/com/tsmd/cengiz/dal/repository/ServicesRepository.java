package tr.com.tsmd.cengiz.dal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.tsmd.cengiz.dal.entity.ServicesEntity;

import java.util.List;

@Repository
public interface ServicesRepository extends JpaRepository<ServicesEntity, String> {
  List<ServicesEntity> getById(String id);
}
