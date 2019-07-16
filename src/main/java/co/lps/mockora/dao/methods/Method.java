package co.lps.mockora.dao.methods;

import co.lps.mockora.dao.Settings;
import co.lps.mockora.dao.methods.response.Response;
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
public class Method {

    private String method;
    private Settings settings;
    private Response response;

}
