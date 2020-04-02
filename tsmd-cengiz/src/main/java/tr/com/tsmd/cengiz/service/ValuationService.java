package tr.com.tsmd.cengiz.service;


import org.springframework.web.multipart.MultipartFile;
import tr.com.tsmd.cengiz.models.FullDataList;

public interface ValuationService {


  void addValuationPatentDekont(Long id, MultipartFile dekont) throws Exception ;

  void addValuationTrademarkDekont(Long id, MultipartFile dekont) throws Exception ;
}
