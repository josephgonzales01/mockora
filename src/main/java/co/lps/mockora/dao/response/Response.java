package co.lps.mockora.dao.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * co.lps.mockora.dao.response
 *
 * @author : josephg
 * @since : 6/07/2019
 */
@Data
@AllArgsConstructor
public class Response {
    @Id
    private String id;
    private String body;
}
