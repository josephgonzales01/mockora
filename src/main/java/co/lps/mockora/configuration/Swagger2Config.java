package co.lps.mockora.configuration;

import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import co.lps.mockora.constants.ApplicationURL;
import co.lps.mockora.constants.SwagMe;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
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
public class Swagger2Config implements WebMvcConfigurer{

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .select().apis(RequestHandlerSelectors.basePackage("co.lps.mockora.controller"))
        .paths(paths()).build()
        .tags(new Tag(SwagMe.TAG_MOCK_APIS, "Mock APIs operations"), 
              new Tag(SwagMe.TAG_SERVE_APIS, "Serve Mock APIs operations"));
  }


  public Predicate<String> paths() {
    return Predicates.or(PathSelectors.regex(ApplicationURL.SERVE_URL + "/.*"),
        PathSelectors.regex(ApplicationURL.MOCK_URL + "/.*"));
  }

  public ApiInfo apiInfo() {
    return new ApiInfo("Mockora Rest stubbing APIs",
        "This page lists all the operations for adding and configuring Mock APIs", "0.9",
        "Terms of service", new Contact("", "http://lps.co.nz/", "josephgonzales01@gmail.com"),
        "License of API", "API license URL", Collections.emptyList());
  }
  
  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addRedirectViewController( ApplicationURL.HELP_URL, "swagger-ui.html");
  }



}
