package co.lps.mockora.model.dto.methods.response;

import java.util.HashMap;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * co.lps.mockora.model.dto.methods.response
 *
 * @author : josephg
 * @since : 16/07/2019
 */
@Data
@NoArgsConstructor
public class ResponseDto {

  private HashMap<String, Object> body;
  private int status;
  private String headers;

}
