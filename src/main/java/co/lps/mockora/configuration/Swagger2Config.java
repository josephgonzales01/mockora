package co.lps.mockora.configuration;

import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import co.lps.mockora.constants.ApplicationURL;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.RelativePathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * co.lps.mockora.configuration
 *
 * @author : josephg
 * @since : 6/07/2019
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
        .apis(RequestHandlerSelectors.basePackage("co.lps.mockora.controller")).paths(paths())
        .build().pathProvider(new RelativePathProvider(null) {
          @Override
          public String getApplicationBasePath() {
            return "/help";
          }
        });
  }


  public Predicate<String> paths() {
    return Predicates.or(PathSelectors.regex(ApplicationURL.SERVE_URL + "/.*"),
        PathSelectors.regex(ApplicationURL.MOCK_URL + "/.*"));
  }

  public ApiInfo apiInfo() {
    return new ApiInfo("Mockora Rest stubbing APIs",
        "This page lists all the APIs for adding and configuring API Stubs", "0.9",
        "Terms of service", new Contact("", "http://lps.co.nz/", "joseph.gonzales@lps.co.nz"),
        "License of API", "API license URL", Collections.emptyList());
  }


}
