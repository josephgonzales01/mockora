package co.lps.mockora.service;

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
public class MockEndpointService implements IMockEndpointService {

  @Autowired
  private EndpointModelMapper endpointModelMapper;

  @Autowired
  private EndpointRepository endpointRepository;

  @Override
  public void save(EndpointDto dto) {

    Endpoint endpoint = endpointModelMapper.mapToDao(dto);
    endpointRepository.save(endpoint);

  }

}
