package co.lps.mockora.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import co.lps.mockora.constants.HttpMethod;
import co.lps.mockora.error.MockoraException;
import co.lps.mockora.model.dao.Endpoint;
import co.lps.mockora.model.dto.EndpointDto;
import co.lps.mockora.model.dto.MethodDto;
import co.lps.mockora.model.dto.ResponseDto;
import co.lps.mockora.respository.EndpointRepository;
import co.lps.mockora.service.mapper.EndpointModelMapper;
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

  private EndpointRepository endpointRepository;
  private EndpointModelMapper endpointModelMapper;

  @Autowired
  public ServeEndpointServiceImpl(EndpointRepository endpointRepository,
      EndpointModelMapper endpointModelMapper) {
    this.endpointRepository = endpointRepository;
    this.endpointModelMapper = endpointModelMapper;

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
    List<Endpoint> endpointList = endpointRepository.findByOrgIdAndResourceId(orgId, resourceId);

    // extract endpoint
    Optional<EndpointDto> endpoint =
        endpointList.stream().findFirst().map(endpointModelMapper::mapToDto);
    if (!endpoint.isPresent()) {
      String errMsg = String.format("No mock endpoint for %s%s found", orgId, resourceId);
      log.error(errMsg);
      throw new MockoraException(errMsg, HttpStatus.NOT_FOUND);
    }

    // extract endpoint method
    Optional<MethodDto> method = endpoint.get().getMethods().stream()
        .filter(m -> m.getMethodType().equals(methodType.name())).findFirst();
    if (!method.isPresent()) {
      String errMsg = "Request Method not supported";
      log.error(errMsg);
      throw new MockoraException(errMsg, HttpStatus.METHOD_NOT_ALLOWED);
    }

    // extract method response
    return method.get().getResponse();
  }
}


