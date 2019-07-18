package co.lps.mockora.model.dto;

import java.util.List;
import org.springframework.data.annotation.Id;
import co.lps.mockora.model.dto.methods.MethodDto;
import lombok.AllArgsConstructor;
import lombok.Data;

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
  private String url;
  private String organizationId;
  private List<MethodDto> methods;

}
