package co.lps.mockora.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * co.lps.mockora.model.dto
 *
 * @author : josephg
 * @since : 16/07/2019
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SettingsDto {
  
  private boolean showNull;
  private int delay;
  
}
