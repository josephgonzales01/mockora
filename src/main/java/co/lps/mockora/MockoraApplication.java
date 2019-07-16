package co.lps.mockora;

import co.lps.mockora.dao.Endpoint;
import co.lps.mockora.dao.Settings;
import co.lps.mockora.dao.methods.Method;
import co.lps.mockora.dao.methods.response.Response;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

/**
 * co.lps.mockora
 *
 * @author : josephg
 * @since : 15/07/2019
 */

@SpringBootApplication
public class MockoraApplication {

    public static void main(String[] args) {
        SpringApplication.run(MockoraApplication.class, args);
        Endpoint endpoint = new Endpoint("", "", "", Arrays.asList(new Method("", new Settings(), new Response("", 200, ""))));
        String myUrl = endpoint.getUrl();

    }

}
