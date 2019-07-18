package co.lps.mockora.service;

import co.lps.mockora.model.dto.EndpointDto;

/**
 * co.lps.mockora.service
 *
 * @author : josephg
 * @since : 7/07/2019
 */
public interface IMockEndpointService {

  void save(EndpointDto endpointRequest);
  
}
