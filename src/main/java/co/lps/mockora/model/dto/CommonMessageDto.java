package co.lps.mockora.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonMessageDto {
  
  private String message;
  private String description;
  private int code;
  

}
