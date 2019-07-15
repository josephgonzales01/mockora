package co.lps.mockora.dao.endpoint;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * co.lps.mockora.dao.endpoint
 *
 * @author : josephg
 * @since : 6/07/2019
 */
@Data
@AllArgsConstructor
@Document
public class Endpoint {

    @Id
    private String id;
    private String url;
    //TODO requestProperties type set to RequestProperty
    private List<String> requestProperties;

}
