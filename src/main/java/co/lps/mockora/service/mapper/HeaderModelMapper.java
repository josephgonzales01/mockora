package co.lps.mockora.service.mapper;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import co.lps.mockora.model.dao.Header;
import co.lps.mockora.model.dto.HeaderDto;

@Service
public class HeaderModelMapper {

  public Header mapToDao(HeaderDto dto) {
    return new Header(dto.getKey(), dto.getValue());
  }

  public HeaderDto mapToDto(Header dao) {
    return new HeaderDto(dao.getKey(), dao.getValue());
  }

  public List<Header> mapToDao(List<HeaderDto> dto) {
    return dto.stream().map(this::mapToDao).collect(Collectors.toList());
  }

  public List<HeaderDto> mapToDto(List<Header> dao) {
    return dao.stream().map(this::mapToDto).collect(Collectors.toList());
  }
}
