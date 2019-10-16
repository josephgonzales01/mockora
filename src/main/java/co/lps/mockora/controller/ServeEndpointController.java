package co.lps.mockora.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.lps.mockora.constants.ApplicationURL;
import co.lps.mockora.model.dto.ResponseDto;
import co.lps.mockora.service.MockEndpointService;
import co.lps.mockora.service.ServeEndpointService;
import co.lps.mockora.service.UrlUtilityService;
import java.util.HashMap;
import java.util.Map;

/**
 * co.lps.mockora.controller
 *
 * @author : josephg
 * @since : 7/07/2019
 */

@RestController
@RequestMapping(ApplicationURL.SERVE_URL)
public class ServeEndpointController {

  Logger logger = LoggerFactory.getLogger(ServeEndpointController.class);

  ServeEndpointService serveEndpointService;
  MockEndpointService mockEndpointService;
  UrlUtilityService urlUtilityService;


  @Autowired
  public ServeEndpointController(ServeEndpointService serveEndpointService,
      MockEndpointService mockEndpointService, UrlUtilityService urlUtilityService) {
    this.serveEndpointService = serveEndpointService;
    this.mockEndpointService = mockEndpointService;
    this.urlUtilityService = urlUtilityService;

  }

  @PostMapping("/{orgId}/**")
  public ResponseEntity<HashMap<String, Object>> servePostEndpoint(HttpServletRequest request,
      @PathVariable String orgId, @RequestBody Map<Object, Object> body) {

    String url = urlUtilityService.getServeUrlWithoutOrg(request.getRequestURI(), orgId);

    logger.info("/serve POST request received with base url {}", url);
    ResponseDto response = serveEndpointService.endpointPostResponse(orgId, url);
    return ResponseEntity.status(response.getStatus()).body(response.getBody());
  }

  @GetMapping("/{orgId}/**")
  public ResponseEntity<HashMap<String, Object>> serveGetEndpoint(HttpServletRequest request,
      @PathVariable String orgId) {

    String url = urlUtilityService.getServeUrlWithoutOrg(request.getRequestURI(), orgId);

    logger.info("/serve GET request received with base url {}", url);
    ResponseDto response = serveEndpointService.endpointGetResponse(orgId, url);
    return ResponseEntity.status(response.getStatus()).body(response.getBody());

  }

}
