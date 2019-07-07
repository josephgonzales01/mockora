package co.lps.mockora.dao.request;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * co.lps.mockora.dao.request
 *
 * @author : josephg
 * @since : 6/07/2019
 */
@Data
@AllArgsConstructor
public class Request {

    private String url;
    private String method;
    private String body;

}
