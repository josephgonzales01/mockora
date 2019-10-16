package co.lps.mockora.model.dto;

import java.util.HashMap;
import java.util.List;
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

}
