package co.lps.mockora.model.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonInclude(Include.NON_EMPTY)
public class CommonResponseDto {

  private int code;
  private String message;
  private String details;
  private List<ErrorDto> errors;


}
