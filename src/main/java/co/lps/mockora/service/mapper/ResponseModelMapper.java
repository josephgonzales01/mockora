package co.lps.mockora.service.mapper;

import org.springframework.stereotype.Service;
import co.lps.mockora.model.dao.Response;
import co.lps.mockora.model.dto.ResponseDto;

@Service
public class ResponseModelMapper {

  public Response mapToDao(ResponseDto dto) {
    return new Response(dto.getBody(), dto.getStatus(), dto.getHeaders());
  }

}
