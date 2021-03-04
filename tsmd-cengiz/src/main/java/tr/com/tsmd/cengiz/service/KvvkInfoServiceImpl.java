package tr.com.tsmd.cengiz.service;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.tsmd.cengiz.entity.KvvkEntity;
import tr.com.tsmd.cengiz.repository.KvvkRepository;

@Service
public class KvvkInfoServiceImpl implements KvvkInfoService {
  @Autowired
  KvvkRepository kvvkRepository;


  @Override
  public Long saveKvvk(KvvkEntity kvvk) {
//    kvvkRepository.deleteAll();
    Optional<KvvkEntity> entity = kvvkRepository.findAllByLanguage(kvvk.getLanguage());
    KvvkEntity kvvkEntity;
    if (entity.isPresent()) {
      entity.get().setFileName(kvvk.getFileName());
      entity.get().setFileType(kvvk.getFileType());
      entity.get().setKvvk(kvvk.getKvvk());
      entity.get().setLanguage(kvvk.getLanguage());
      kvvkEntity=kvvkRepository.save(entity.get());
    } else {
      kvvkEntity=kvvkRepository.save(kvvk);
    }

    return kvvkEntity.getId();
  }

  @Override
  public KvvkEntity getKvvkFile(String language) {
    return kvvkRepository.findAllByLanguage(language).get();
  }
}
