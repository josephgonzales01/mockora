package co.lps.mockora.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.lps.mockora.model.dao.Endpoint;
import co.lps.mockora.model.dto.EndpointDto;
import co.lps.mockora.model.dto.ResponseDto;
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
    List<Endpoint> endpointList = endpointRepository.findByOrgIdAndUrl(orgId, url);
    Optional<EndpointDto> endpoint = endpointList.stream().findFirst().map(endpointModelMapper::mapToDto);
    endpoint.ifPresent(e->e.getMethods());

    return null;
  }
}


