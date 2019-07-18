package co.lps.mockora.model.dao.methods;

import co.lps.mockora.model.dao.Settings;
import co.lps.mockora.model.dao.methods.response.Response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * co.lps.mockora.model.dao.methods.response
 *
 * @author : josephg
 * @since : 16/07/2019
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Method {

  private String methodType;
  private Settings settings;
  private Response response;

}
