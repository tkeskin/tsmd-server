package tr.com.tsmd.cengiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.tsmd.cengiz.entity.NewsEntity;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<NewsEntity, Long> {
  List<NewsEntity> findAll();

  List<NewsEntity> getByPublished(Boolean published);

  NewsEntity getById(Long id);

}
