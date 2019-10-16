package co.lps.mockora.service;

import co.lps.mockora.model.dto.ResponseDto;

/**
 * co.lps.mockora.service
 *
 * @author : josephg
 * @since : 7/07/2019
 */
public interface ServeEndpointService {

  ResponseDto extractGetResponse(String orgId, String url);

  ResponseDto extractPostResponse(String orgId, String url);

  ResponseDto extractPutResponse(String orgId, String url);

  ResponseDto extractPatchResponse(String orgId, String url);

  ResponseDto extractDeleteResponse(String orgId, String url);


}
