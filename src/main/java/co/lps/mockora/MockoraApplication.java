package co.lps.mockora;

import co.lps.mockora.dao.request.Request;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MockoraApplication {

    public static void main(String[] args) {
        SpringApplication.run(MockoraApplication.class, args);
        Request request = new Request("","","");
        String myUrl = request.getUrl();
    }

}
