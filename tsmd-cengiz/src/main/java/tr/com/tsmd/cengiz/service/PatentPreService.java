package tr.com.tsmd.cengiz.service;


import org.springframework.web.multipart.MultipartFile;
import tr.com.tsmd.cengiz.models.FullDataList;

public interface PatentPreService {

  void savePatentPreTable(Long id, FullDataList fullDataList);

  void addPatentPreRelatedPictures(Long patentPreId, MultipartFile[] pictures) throws Exception;

  void addDekont(Long patentPreId, MultipartFile dekont) throws Exception;
}
