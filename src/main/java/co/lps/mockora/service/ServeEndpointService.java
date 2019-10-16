package co.lps.mockora.service;

import co.lps.mockora.model.dto.ResponseDto;

/**
 * co.lps.mockora.service
 *
 * @author : josephg
 * @since : 7/07/2019
 */
public interface ServeEndpointService {

  ResponseDto endpointGetResponse(String orgId, String url);

  ResponseDto endpointPostResponse(String orgId, String url);

  ResponseDto endpointPutResponse(String orgId, String url);

  ResponseDto endpointPatchResponse(String orgId, String url);

  ResponseDto endpointDeleteResponse(String orgId, String url);


}
