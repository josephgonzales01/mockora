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

/**
 * co.lps.mockora.service
 *
 * @author : josephg
 * @since : 7/07/2019
 */

@Service
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
  public ResponseDto endpointGetResponse(String orgId, String url) {
    return extractMethodResponse(orgId, url, HttpMethod.GET.name());
  }

  @Override
  public ResponseDto endpointPostResponse(String orgId, String url) {
    return extractMethodResponse(orgId, url, HttpMethod.POST.name());
  }

  @Override
  public ResponseDto endpointPutResponse(String orgId, String url) {
    return extractMethodResponse(orgId, url, HttpMethod.PUT.name());
  }

  @Override
  public ResponseDto endpointPatchResponse(String orgId, String url) {
    return extractMethodResponse(orgId, url, HttpMethod.PATCH.name());
  }

  @Override
  public ResponseDto endpointDeleteResponse(String orgId, String url) {
    return extractMethodResponse(orgId, url, HttpMethod.DELETE.name());
  }


  private ResponseDto extractMethodResponse(final String orgId, final String url,
      final String methodType) {
    List<Endpoint> endpointList = endpointRepository.findByOrgIdAndUrl(orgId, url);

    // extract endpoint
    Optional<EndpointDto> endpoint =
        endpointList.stream().findFirst().map(endpointModelMapper::mapToDto);
    if (!endpoint.isPresent()) {
      throw new MockoraException(HttpStatus.NOT_FOUND);
    }

    // extract endpoint method
    Optional<MethodDto> method = endpoint.get().getMethods().stream()
        .filter(m -> m.getMethodType().equals(methodType)).findFirst();
    if (!method.isPresent()) {
      throw new MockoraException(HttpStatus.METHOD_NOT_ALLOWED);
    }

    // extract method response
    return method.get().getResponse();
  }
}


