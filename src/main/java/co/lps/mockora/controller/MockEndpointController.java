package co.lps.mockora.controller;

import java.net.URI;
import java.net.URISyntaxException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.lps.mockora.constants.ApplicationURL;
import co.lps.mockora.constants.SwagMe;
import co.lps.mockora.model.dto.CommonResponseDto;
import co.lps.mockora.model.dto.EndpointDto;
import co.lps.mockora.service.MockEndpointService;
import co.lps.mockora.service.ServeEndpointService;
import co.lps.mockora.service.UrlUtilityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * co.lps.mockora.controller
 *
 * @author : josephg
 * @since : 7/07/2019
 */

@RestController
@RequestMapping(ApplicationURL.MOCK_URL)
@Slf4j
@Api(tags = SwagMe.TAG_MOCK_APIS)
public class MockEndpointController {

  MockEndpointService mockEndpointService;
  ServeEndpointService serveEndpointService;
  UrlUtilityService urlUtilityService;

  @Autowired
  public MockEndpointController(MockEndpointService mockEndpointService,
      ServeEndpointService serveEndpointService, UrlUtilityService urlUtilityService) {
    this.mockEndpointService = mockEndpointService;
    this.serveEndpointService = serveEndpointService;
    this.urlUtilityService = urlUtilityService;
  }

  @PostMapping(value = "/{orgId}/{resourceId}/**", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Create a Mock API operation")
  public ResponseEntity<CommonResponseDto> addMock(HttpServletRequest request,
      @PathVariable String orgId, @PathVariable String resourceId, @RequestBody EndpointDto dto)
      throws URISyntaxException {
    dto.setUrl(orgId, resourceId);
    log.debug("[MOCK:POST] for url {}{}", dto.getOrgId(), dto.getResourceId());
    mockEndpointService.save(dto);
    String createdUri = String.format("%s%s/%s%s", urlUtilityService.getHostAndPort(),
        ApplicationURL.SERVE_URL, dto.getOrgId(), dto.getResourceId());

    return ResponseEntity.created(new URI(createdUri))
        .body(new CommonResponseDto(201, "Successfully Created endpoint", createdUri, null));
  }

  

}
