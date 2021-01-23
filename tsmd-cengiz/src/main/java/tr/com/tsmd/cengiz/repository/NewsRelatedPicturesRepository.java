package tr.com.tsmd.cengiz.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.tsmd.cengiz.entity.AboutEntity;
import tr.com.tsmd.cengiz.entity.NewsRelatedPicturesEntity;

@Repository
public interface NewsRelatedPicturesRepository extends JpaRepository<NewsRelatedPicturesEntity, Long> {
  List<NewsRelatedPicturesEntity> findAll();

  List<NewsRelatedPicturesEntity> getByNewsId(Long id);

  NewsRelatedPicturesEntity getById(Long id);

  void deleteAllByNewsId(Long newsId);
}
