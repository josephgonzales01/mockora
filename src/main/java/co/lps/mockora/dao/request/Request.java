package co.lps.mockora.dao.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * co.lps.mockora.dao.request
 *
 * @author : josephg
 * @since : 6/07/2019
 */
@Getter
@Setter
@AllArgsConstructor
public class Request {

    private String url;
    private String method;
    private String body;

}
