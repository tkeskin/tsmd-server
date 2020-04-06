package tr.com.tsmd.cengiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.tsmd.cengiz.entity.NewsEntity;
import tr.com.tsmd.cengiz.entity.NoticeEntity;

import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<NoticeEntity, Long> {
  List<NoticeEntity> findAll();

  List<NoticeEntity> getByPublished(Boolean published);

  NoticeEntity getById(Long id);


}
