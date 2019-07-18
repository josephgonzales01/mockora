package co.lps.mockora.service.mapper;

import org.springframework.stereotype.Service;
import co.lps.mockora.model.dao.Settings;
import co.lps.mockora.model.dto.SettingsDto;

@Service
public class SettingsModelMapper {

  public Settings maptoDao(SettingsDto dto) {
    return new Settings(dto.isShowNull(), dto.getDelay());
  }

}
