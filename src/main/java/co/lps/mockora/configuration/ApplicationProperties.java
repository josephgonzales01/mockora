package co.lps.mockora.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import lombok.Getter;

/**
 * co.lps.mockora.configuration
 *
 * @author : josephg
 * @since : 20/07/2019
 */

@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationProperties {

  @Getter
  @Value("${server.servlet.context-path}")
  private String baseUrl;
  
  public static final String SERVE_URL = "/serve";
  public static final String MOCK_URL = "/mock";
  

}
