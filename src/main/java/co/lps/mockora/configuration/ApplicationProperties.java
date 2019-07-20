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
@Getter
public class ApplicationProperties {

  @Value("${server.servlet.context-path}")
  private String baseUrl;

}
