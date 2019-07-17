package co.lps.mockora;

import co.lps.mockora.dao.Endpoint;
import co.lps.mockora.dao.Settings;
import co.lps.mockora.dao.methods.Method;
import co.lps.mockora.dao.methods.response.Response;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import java.util.Arrays;

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
    Endpoint endpoint = new Endpoint("", "", "",
        Arrays.asList(new Method("", new Settings(), new Response("", 200, ""))));
    String myUrl = endpoint.getUrl();

  }

}
