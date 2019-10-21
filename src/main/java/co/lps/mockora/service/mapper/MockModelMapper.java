package co.lps.mockora.service.mapper;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.lps.mockora.model.dao.Method;
import co.lps.mockora.model.dao.Mock;
import co.lps.mockora.model.dto.MethodDto;
import co.lps.mockora.model.dto.MockDto;

@Service
public class MockModelMapper {


  private MethodModelMapper methodModelMapper;

  @Autowired
  public MockModelMapper(MethodModelMapper methodModelMapper) {
    this.methodModelMapper = methodModelMapper;
  }

  public Mock mapToDao(MockDto dto) {

    List<Method> methods =
        dto.getMethods().stream().map(methodModelMapper::mapToDao).collect(Collectors.toList());
    return new Mock(dto.getOrgId(), dto.getResourceId(), methods, dto.getId());
  }

  public MockDto mapToDto(Mock dao) {

    List<MethodDto> methods =
        dao.getMethods().stream().map(methodModelMapper::mapToDto).collect(Collectors.toList());
    return new MockDto(dao.getOrgId(), dao.getResourceId(), methods, dao.getId());
  }

}
