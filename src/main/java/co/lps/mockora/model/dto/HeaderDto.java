package co.lps.mockora.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HeaderDto {

  private String key;
  private String value;
}
