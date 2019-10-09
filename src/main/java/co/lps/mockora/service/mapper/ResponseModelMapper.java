package co.lps.mockora.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.lps.mockora.model.dao.Response;
import co.lps.mockora.model.dto.ResponseDto;

@Service
public class ResponseModelMapper {
  @Autowired
  private HeaderModelMapper headerModelMapper;

  public Response mapToDao(ResponseDto dto) {
    return new Response(dto.getBody(), dto.getStatus(),
        headerModelMapper.mapToDao(dto.getHeaders()));
  }

  public ResponseDto mapToDto(Response dao) {

    return new ResponseDto(dao.getBody(), dao.getStatus(),
        headerModelMapper.mapToDto(dao.getHeaders()));
  }

}
