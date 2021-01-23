package tr.com.tsmd.cengiz;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableJpaAuditing
@EnableFeignClients
public class CengizApplication implements CommandLineRunner {

  private static final Logger LOGGER = LoggerFactory.getLogger(CengizApplication.class);


  @Autowired
  private Environment environment;

  public static void main(String[] args) {
    SpringApplication.run(CengizApplication.class, args);
  }

  /**
   * hey spring bana bir resttemplate instance ver,bu instance bir kere oluşsun
   * singleton olsun ve birden fazla instance var ise loadbalanced yaptır
   *
   * @return
   */
  @Bean
  @LoadBalanced
  public RestTemplate getRestTemplate() {
    return new RestTemplate();
  }

  @Override
  public void run(String... args) throws Exception {
    String[] activeProfiles = environment.getActiveProfiles();

    LOGGER.info("*** Active profiles: " + Arrays.stream(activeProfiles)
        .map(s -> "(" + s + ")")
        .reduce("", String::concat));

    final String prodProfile = "prod";
    if (Arrays.stream(activeProfiles).anyMatch(
        env -> env.equalsIgnoreCase(prodProfile))) {

      System.setProperty("spring.profiles.active", prodProfile);
      if (System.getProperty("spring.profiles.active") == null
          || !System.getProperty("spring.profiles.active").equals(prodProfile)) {
        String exMessage = "*** UYGULAMA PROFİLİ 'prod' OLARAK SET EDİLEMEDİ!!!";
        LOGGER.error(exMessage);
        throw new RuntimeException(exMessage);
      }
      LOGGER.info("*** System property of spring.profiles.active is set to prod");

    }

  }
}
