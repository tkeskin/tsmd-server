package tr.com.tsmd.cengiz.service;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    kvvkRepository.deleteAll();
    KvvkEntity entity = kvvkRepository.save(kvvk);

    return entity.getId();
  }

  @Override
  public KvvkEntity getKvvkFile() {
    return kvvkRepository.findAll().get(0);
  }
}
