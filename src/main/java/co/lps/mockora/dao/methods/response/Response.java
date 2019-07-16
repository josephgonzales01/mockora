package co.lps.mockora.dao.methods.response;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * co.lps.mockora.dao.methods.response
 *
 * @author : josephg
 * @since : 16/07/2019
 */
@Data
@AllArgsConstructor
public class Response {

    private String body;
    private int status;
    private String headers;
}
