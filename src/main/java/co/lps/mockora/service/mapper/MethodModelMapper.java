package co.lps.mockora.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.lps.mockora.model.dao.Method;
import co.lps.mockora.model.dto.MethodDto;

@Service
public class MethodModelMapper {

    @Autowired
    private ResponseModelMapper responseModelMapper;
    @Autowired
    private SettingsModelMapper settingsModelMapper;

    public Method mapToDao(MethodDto dto) {

        return new Method(dto.getMethodType(), settingsModelMapper.maptoDao(dto.getSettings()), responseModelMapper.mapToDao(dto.getResponse()));
    }

    public MethodDto mapToDto(Method dao) {

        return new MethodDto(dao.getMethodType(), settingsModelMapper.mapToDto(dao.getSettings()), responseModelMapper.mapToDto(dao.getResponse()));
    }

}
