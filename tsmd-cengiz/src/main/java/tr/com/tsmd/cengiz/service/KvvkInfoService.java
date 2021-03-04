package tr.com.tsmd.cengiz.service;

import tr.com.tsmd.cengiz.entity.KvvkEntity;
import tr.com.tsmd.cengiz.models.Notice;

public interface KvvkInfoService {

  Long saveKvvk(KvvkEntity kvvkEntity);

  KvvkEntity getKvvkFile(String language);
}
