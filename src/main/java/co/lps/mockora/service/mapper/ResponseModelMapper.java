package co.lps.mockora.service.mapper;

import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.lps.mockora.model.dao.Response;
import co.lps.mockora.model.dto.HeaderDto;
import co.lps.mockora.model.dto.ResponseDto;

@Service
public class ResponseModelMapper {

  private HeaderModelMapper headerModelMapper;

  @Autowired
  public ResponseModelMapper(HeaderModelMapper headerModelMapper) {
    this.headerModelMapper = headerModelMapper;
  }

  public Response mapToDao(ResponseDto dto) {
    return new Response(dto.getBody(), dto.getStatus() <= 0 ? 200 : dto.getStatus(),
        headerModelMapper.mapToDao(dto.getHeaders() == null
            ? Arrays.asList(new HeaderDto("Content-Type", "application/json"))
            : dto.getHeaders()));
  }

  public ResponseDto mapToDto(Response dao) {

    return new ResponseDto(dao.getBody(), dao.getStatus(),
        headerModelMapper.mapToDto(dao.getHeaders()));
  }

}
