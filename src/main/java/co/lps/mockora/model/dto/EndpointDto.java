package co.lps.mockora.model.dto;

import java.util.List;
import org.springframework.data.annotation.Id;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import co.lps.mockora.constants.ApplicationURL;
import co.lps.mockora.service.UrlUtilityService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * co.lps.mockora.model.dao.endpoint
 *
 * @author : josephg
 * @since : 6/07/2019
 */
@Data
@AllArgsConstructor
public class EndpointDto {

  @Id
  private String id;
  @JsonIgnore
  private String resourceId;
  @JsonIgnore
  private String orgId;

  private List<MethodDto> methods;


  public String getOrgId() {
    return orgId.toLowerCase();
  }

  public String getResourceId() {
    return resourceId.toLowerCase();
  }

  public void setUrl(String orgId, String resourceId) {
    this.orgId = orgId;
    this.resourceId = resourceId;
  }



}
