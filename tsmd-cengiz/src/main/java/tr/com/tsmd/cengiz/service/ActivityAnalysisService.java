package tr.com.tsmd.cengiz.service;


import org.springframework.web.multipart.MultipartFile;

public interface ActivityAnalysisService {


  void addActivityAnalysisDekont(Long id, MultipartFile dekont) throws Exception ;

  void addActivityAnalysisPictures(Long id, MultipartFile[] pictures) throws Exception ;
}
