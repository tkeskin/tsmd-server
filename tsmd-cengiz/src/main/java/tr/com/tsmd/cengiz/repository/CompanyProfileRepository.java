package tr.com.tsmd.cengiz.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.tsmd.cengiz.entity.AboutEntity;
import tr.com.tsmd.cengiz.entity.CompanyProfileEntity;

@Repository
public interface CompanyProfileRepository extends JpaRepository<CompanyProfileEntity, Long> {
  List<CompanyProfileEntity> findAll();

  CompanyProfileEntity getBy();

}
