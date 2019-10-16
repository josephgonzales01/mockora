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
@AllArgsConstructor
public class SettingsDto {

  private boolean showNull;
  private int delay;

  public SettingsDto() {
    this(false, 1000);
  }

}
