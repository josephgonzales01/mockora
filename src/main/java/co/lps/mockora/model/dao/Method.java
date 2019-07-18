package co.lps.mockora.model.dao;

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
