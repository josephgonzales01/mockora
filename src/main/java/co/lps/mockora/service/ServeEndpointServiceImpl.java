package co.lps.mockora.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import co.lps.mockora.constants.HttpMethod;
import co.lps.mockora.model.dao.Endpoint;
import co.lps.mockora.model.dto.EndpointDto;
import co.lps.mockora.model.dto.MethodDto;
import co.lps.mockora.model.dto.ResponseDto;
import co.lps.mockora.model.exception.MockoraException;
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
  public ResponseDto extractGetResponse(String orgId, String url) {
    return extractMethodResponse(orgId, url, HttpMethod.GET);
  }

  @Override
  public ResponseDto extractPostResponse(String orgId, String url) {
    return extractMethodResponse(orgId, url, HttpMethod.POST);
  }

  @Override
  public ResponseDto extractPutResponse(String orgId, String url) {
    return extractMethodResponse(orgId, url, HttpMethod.PUT);
  }

  @Override
  public ResponseDto extractPatchResponse(String orgId, String url) {
    return extractMethodResponse(orgId, url, HttpMethod.PATCH);
  }

  @Override
  public ResponseDto extractDeleteResponse(String orgId, String url) {
    return extractMethodResponse(orgId, url, HttpMethod.DELETE);
  }


  private ResponseDto extractMethodResponse(final String orgId, final String url,
      final HttpMethod methodType) {
    List<Endpoint> endpointList = endpointRepository.findByOrgIdAndUrl(orgId, url);

    // extract endpoint
    Optional<EndpointDto> endpoint =
        endpointList.stream().findFirst().map(endpointModelMapper::mapToDto);
    if (!endpoint.isPresent()) {
      String errMsg = String.format("No mock endpoint for %s%s found", orgId, url);
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


