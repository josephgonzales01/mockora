package co.lps.mockora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.lps.mockora.model.dao.Endpoint;
import co.lps.mockora.model.dto.EndpointDto;
import co.lps.mockora.respository.EndpointRepository;
import co.lps.mockora.service.mapper.EndpointModelMapper;

/**
 * co.lps.mockora.service
 *
 * @author : josephg
 * @since : 7/07/2019
 */

@Service
public class MockEndpointServiceImpl implements MockEndpointService {


  private EndpointModelMapper endpointModelMapper;
  private EndpointRepository endpointRepository;

  @Autowired
  public MockEndpointServiceImpl(EndpointModelMapper endpointModelMapper,
      EndpointRepository endpointRepository) {
    this.endpointModelMapper = endpointModelMapper;
    this.endpointRepository = endpointRepository;
  }

  @Override
  public void save(EndpointDto dto) {

    Endpoint endpoint = endpointModelMapper.mapToDao(dto);
    endpointRepository.save(endpoint);

  }

  @Override
  public List<Endpoint> findByOrgIdAndUrl(String orgId, String url) {
    return endpointRepository.findByOrgIdAndUrl(orgId, url);
  }

  @Override
  public List<Endpoint> findByOrgId(String orgId) {
    return endpointRepository.findByOrgId(orgId);
  }
}
