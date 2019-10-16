package co.lps.mockora.model.dto;

import org.springframework.data.mongodb.core.aggregation.StringOperators.ToUpper;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MethodDto {

  @JsonProperty("method")
  private String methodType;
  private SettingsDto settings;
  private ResponseDto response;

  private void setMethodType(String method) {
    methodType = method.toUpperCase();
  }

}
