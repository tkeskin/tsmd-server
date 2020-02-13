package tr.com.tsmd.keskin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableHystrixDashboard
public class KeskinApplication {

  public static void main(String[] args) {
    SpringApplication.run(KeskinApplication.class, args);
  }

  /**
   * hey spring bana bir resttemplate instance ver,bu instance bir kere olu?sun
   * singleton olsun ve birden fazla instance var ise loadbalanced yapt?r
   *
   * @return
   */
  @Bean
  @LoadBalanced
  public RestTemplate getRestTemplate() {
    return new RestTemplate();
  }

}
