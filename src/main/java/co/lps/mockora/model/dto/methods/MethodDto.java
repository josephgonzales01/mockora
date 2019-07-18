package co.lps.mockora.model.dto.methods;

import com.fasterxml.jackson.annotation.JsonProperty;
import co.lps.mockora.model.dao.Settings;
import co.lps.mockora.model.dao.methods.response.Response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MethodDto {

  @JsonProperty("method")
  private String methodType;
  private Settings settings;
  private Response response;

}
