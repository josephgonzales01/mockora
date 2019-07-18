package co.lps.mockora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * co.lps.mockora
 *
 * @author : josephg
 * @since : 15/07/2019
 */

@SpringBootApplication
@EnableConfigurationProperties
public class MockoraApplication {

  public static void main(String[] args) {
    SpringApplication.run(MockoraApplication.class, args);


  }

}
