package co.lps.mockora.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import co.lps.mockora.model.dto.MethodDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.lps.mockora.model.dao.Endpoint;
import co.lps.mockora.model.dao.Method;
import co.lps.mockora.model.dto.EndpointDto;

@Service
public class EndpointModelMapper {


  private MethodModelMapper methodModelMapper;

  @Autowired
  public EndpointModelMapper(MethodModelMapper methodModelMapper) {
    this.methodModelMapper = methodModelMapper;
  }

  public Endpoint mapToDao(EndpointDto dto) {

    List<Method> methods =
        dto.getMethods().stream().map(methodModelMapper::mapToDao).collect(Collectors.toList());

    return new Endpoint(dto.getId(), dto.getUrl(), dto.getOrgId(), methods);
  }

  public EndpointDto mapToDto(Endpoint dao) {

    List<MethodDto> methods =
        dao.getMethods().stream().map(methodModelMapper::mapToDto).collect(Collectors.toList());
    return new EndpointDto(dao.getId(), dao.getUrl(), dao.getOrgId(), methods);
  }

}
