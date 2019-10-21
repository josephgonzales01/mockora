package co.lps.mockora.model.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MockDto {
  private String orgId;
  private String resourceId;
  private List<MethodDto> methods;
  private String id;

  public MockDto(String orgId, String resourceId, List<MethodDto> methods) {
    this(orgId.toLowerCase(), resourceId.toLowerCase(), methods, null);
  }


}
