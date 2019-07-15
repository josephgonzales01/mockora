package co.lps.mockora;

import co.lps.mockora.dao.endpoint.Endpoint;
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
        Endpoint endpoint = new Endpoint("","", Arrays.asList("firstName","LastName"));
        String myUrl = endpoint.getUrl();

    }

}
