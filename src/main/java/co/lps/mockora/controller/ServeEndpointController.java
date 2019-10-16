package co.lps.mockora.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
    orgId = orgId.toLowerCase();

    logger.info("[SERVE:POST] for url {}{}", orgId, url);
    return buildResponse(serveEndpointService.endpointPostResponse(orgId, url));

  }

  @GetMapping("/{orgId}/**")
  public ResponseEntity<HashMap<String, Object>> serveGetEndpoint(HttpServletRequest request,
      @PathVariable String orgId) {

    String url = urlUtilityService.getServeUrlWithoutOrg(request.getRequestURI(), orgId);
    orgId = orgId.toLowerCase();

    logger.info("[SERVE:GET] for url {}{}", orgId, url);
 
    return buildResponse(serveEndpointService.endpointGetResponse(orgId, url));

  }

  @PutMapping("/{orgId}/**")
  public ResponseEntity<HashMap<String, Object>> servePutEndpoint(HttpServletRequest request,
      @PathVariable String orgId, @RequestBody Map<Object, Object> body) {

    String url = urlUtilityService.getServeUrlWithoutOrg(request.getRequestURI(), orgId);
    orgId = orgId.toLowerCase();

    logger.info("[SERVE:PUT] for url {}{}", orgId, url);

    return buildResponse(serveEndpointService.endpointPutResponse(orgId, url));

  }

  @PatchMapping("/{orgId}/**")
  public ResponseEntity<HashMap<String, Object>> servePatchEndpoint(HttpServletRequest request,
      @PathVariable String orgId, @RequestBody Map<Object, Object> body) {

    String url = urlUtilityService.getServeUrlWithoutOrg(request.getRequestURI(), orgId);
    orgId = orgId.toLowerCase();

    logger.info("[SERVE:PATCH] for url {}{}", orgId, url);

    return buildResponse(serveEndpointService.endpointPatchResponse(orgId, url));

  }

  @DeleteMapping("/{orgId}/**")
  public ResponseEntity<HashMap<String, Object>> serveDeleteEndpoint(HttpServletRequest request,
      @PathVariable String orgId, @RequestBody Map<Object, Object> body) {

    String url = urlUtilityService.getServeUrlWithoutOrg(request.getRequestURI(), orgId);
    orgId = orgId.toLowerCase();

    logger.info("[SERVE:DELETE] for url {}{}", orgId, url);

    return buildResponse(serveEndpointService.endpointDeleteResponse(orgId, url));

  }


  private ResponseEntity<HashMap<String, Object>> buildResponse(final ResponseDto response) {

    HttpHeaders headers = new HttpHeaders();
    response.getHeaders().forEach(h -> headers.add(h.getKey(), h.getValue()));

    return ResponseEntity.status(response.getStatus()).headers(headers).body(response.getBody());
  }

}
