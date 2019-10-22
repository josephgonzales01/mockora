package co.lps.mockora.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import co.lps.mockora.constants.HttpMethod;
import co.lps.mockora.error.ErrorMsg;
import co.lps.mockora.error.MockoraException;
import co.lps.mockora.model.dao.Mock;
import co.lps.mockora.model.dto.MethodDto;
import co.lps.mockora.model.dto.MockDto;
import co.lps.mockora.model.dto.ResponseDto;
import co.lps.mockora.respository.MockRepository;
import co.lps.mockora.service.mapper.MockModelMapper;
import lombok.extern.slf4j.Slf4j;

/**
 * co.lps.mockora.service
 *
 * @author : josephg
 * @since : 7/07/2019
 */

@Service
@Slf4j
public class ServeEndpointServiceImpl implements ServeEndpointService {

  private MockRepository mockRepository;
  private MockModelMapper mockModelMapper;

  @Autowired
  public ServeEndpointServiceImpl(MockRepository mockRepository, MockModelMapper mockModelMapper) {
    this.mockRepository = mockRepository;
    this.mockModelMapper = mockModelMapper;

  }

  @Override
  public ResponseDto extractGetResponse(String orgId, String resourceId) {
    return extractMethodResponse(orgId, resourceId, HttpMethod.GET);
  }

  @Override
  public ResponseDto extractPostResponse(String orgId, String resourceId) {
    return extractMethodResponse(orgId, resourceId, HttpMethod.POST);
  }

  @Override
  public ResponseDto extractPutResponse(String orgId, String resourceId) {
    return extractMethodResponse(orgId, resourceId, HttpMethod.PUT);
  }

  @Override
  public ResponseDto extractPatchResponse(String orgId, String resourceId) {
    return extractMethodResponse(orgId, resourceId, HttpMethod.PATCH);
  }

  @Override
  public ResponseDto extractDeleteResponse(String orgId, String resourceId) {
    return extractMethodResponse(orgId, resourceId, HttpMethod.DELETE);
  }


  private ResponseDto extractMethodResponse(final String orgId, final String resourceId,
      final HttpMethod methodType) {
    Mock mocks = mockRepository.findByOrgIdAndResourceId(orgId, resourceId);

    if (mocks != null) {
      String errMsg = String.format(ErrorMsg.LOG_MOCK_NOT_FOUND, orgId, resourceId);
      log.error(errMsg);
      throw new MockoraException(errMsg, HttpStatus.NOT_FOUND);
    }
    // extract mock
    MockDto mockDto = mockModelMapper.mapToDto(mocks);

    // extract mock method
    Optional<MethodDto> method = mockDto.getMethods().stream()
        .filter(m -> m.getMethodType().equals(methodType.name())).findFirst();
    if (!method.isPresent()) {
      String errMsg = String.format(ErrorMsg.LOG_REQUEST_METHOD_NOT_FOUND, methodType.name());
      log.error(errMsg);
      throw new MockoraException(errMsg, HttpStatus.METHOD_NOT_ALLOWED);
    }

    // extract method response
    return method.get().getResponse();
  }
}


