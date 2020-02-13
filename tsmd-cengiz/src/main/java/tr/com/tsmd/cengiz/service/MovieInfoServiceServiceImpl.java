package tr.com.tsmd.cengiz.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.tsmd.cengiz.feign.ArasClient;
import tr.com.tsmd.cengiz.models.CatalogItem;
import tr.com.tsmd.cengiz.models.Movie;
import tr.com.tsmd.cengiz.models.Rating;

@Service
public class MovieInfoServiceServiceImpl implements MovieInfoService {

  @Autowired
  ArasClient arasClient;

/*  @Autowired
  private RestTemplate restTemplate;

  */

  /**
   * getCatalog metodunun birden fazla apiye ba??ml?l??? oldu?u i�in
   * api call i?ini par�al?d?k ve hystrix ile handle ettik
   * info apide bir sorun varsa hystrix devreye girecek
   * bulkhead pattern
   *
   * @param rating
   * @return
   *//*
  @HystrixCommand(fallbackMethod = "getFallbackCatalogItem",
      threadPoolKey = "infoPool",
      threadPoolProperties = {
          @HystrixProperty(name = "coreSize", value = "20"),
          @HystrixProperty(name = "maxQueueSize", value = "10")
      })
  public CatalogItem getCatalogItem(Rating rating) {
    Movie movie = restTemplate.getForObject("http://tpe-aras/" + rating.getName(), Movie.class);
    return new CatalogItem(movie.getName(), movie.getDescription(), 4);
  }

  public CatalogItem getFallbackCatalogItem(Rating rating) {
    System.out.println("tpe-aras-error");
    return new CatalogItem("tpe-aras-error", "tpe-aras-error", 1);
  }*/
  @HystrixCommand(fallbackMethod = "getFallbackCatalogItem",
      threadPoolKey = "infoPool",
      threadPoolProperties = {
          @HystrixProperty(name = "coreSize", value = "20"),
          @HystrixProperty(name = "maxQueueSize", value = "10")
      })
  public CatalogItem getCatalogItem(Rating rating) {
    Movie movie = arasClient.getMovie(rating.getName());
    return new CatalogItem(movie.getName(), movie.getDescription(), 4);
  }

  public CatalogItem getFallbackCatalogItem(Rating rating) {
    System.out.println("tpe-aras-error");
    return new CatalogItem("tpe-aras-error", "tpe-aras-error", 1);
  }
}
