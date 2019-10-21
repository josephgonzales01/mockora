package co.lps.mockora.model.dto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.springframework.util.ObjectUtils;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * co.lps.mockora.model.dto.methods.response
 *
 * @author : josephg
 * @since : 16/07/2019
 */
@Data
@AllArgsConstructor
public class ResponseDto {
  private HashMap<String, Object> body;
  private int status;
  private List<HeaderDto> headers;

  public List<HeaderDto> getHeaders() {
    if (ObjectUtils.isEmpty(headers))
      return Arrays.asList(new HeaderDto("Content-Type", "application/json"));
    return headers;
  }

  public int getStatus() {
    if (status <= 0)
      return 200;
    return status;
  }

}
