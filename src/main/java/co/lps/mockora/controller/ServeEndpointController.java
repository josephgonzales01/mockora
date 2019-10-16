package co.lps.mockora.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.lps.mockora.constants.ApplicationURL;
import co.lps.mockora.model.dto.ResponseDto;
import co.lps.mockora.service.MockEndpointService;
import co.lps.mockora.service.ServeEndpointService;
import co.lps.mockora.service.UrlUtilityService;
import lombok.extern.slf4j.Slf4j;

/**
 * co.lps.mockora.controller
 *
 * @author : josephg
 * @since : 7/07/2019
 */

@RestController
@RequestMapping(ApplicationURL.SERVE_URL)
@Slf4j
public class ServeEndpointController {

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

    log.debug("[SERVE:POST] for url {}{}", orgId, url);
    return buildResponse(serveEndpointService.extractPostResponse(orgId, url));

  }

  @GetMapping("/{orgId}/**")
  public ResponseEntity<HashMap<String, Object>> serveGetEndpoint(HttpServletRequest request,
      @PathVariable String orgId) {

    String url = urlUtilityService.getServeUrlWithoutOrg(request.getRequestURI(), orgId);
    orgId = orgId.toLowerCase();

    log.debug("[SERVE:GET] for url {}{}", orgId, url);

    return buildResponse(serveEndpointService.extractGetResponse(orgId, url));

  }

  @PutMapping("/{orgId}/**")
  public ResponseEntity<HashMap<String, Object>> servePutEndpoint(HttpServletRequest request,
      @PathVariable String orgId, @RequestBody Map<Object, Object> body) {

    String url = urlUtilityService.getServeUrlWithoutOrg(request.getRequestURI(), orgId);
    orgId = orgId.toLowerCase();

    log.debug("[SERVE:PUT] for url {}{}", orgId, url);

    return buildResponse(serveEndpointService.extractPutResponse(orgId, url));

  }

  @PatchMapping("/{orgId}/**")
  public ResponseEntity<HashMap<String, Object>> servePatchEndpoint(HttpServletRequest request,
      @PathVariable String orgId, @RequestBody Map<Object, Object> body) {

    String url = urlUtilityService.getServeUrlWithoutOrg(request.getRequestURI(), orgId);
    orgId = orgId.toLowerCase();

    log.debug("[SERVE:PATCH] for url {}{}", orgId, url);

    return buildResponse(serveEndpointService.extractPatchResponse(orgId, url));

  }

  @DeleteMapping("/{orgId}/**")
  public ResponseEntity<HashMap<String, Object>> serveDeleteEndpoint(HttpServletRequest request,
      @PathVariable String orgId) {

    String url = urlUtilityService.getServeUrlWithoutOrg(request.getRequestURI(), orgId);
    orgId = orgId.toLowerCase();

    log.debug("[SERVE:DELETE] for url {}{}", orgId, url);

    return buildResponse(serveEndpointService.extractDeleteResponse(orgId, url));

  }


  private ResponseEntity<HashMap<String, Object>> buildResponse(final ResponseDto response) {

    HttpHeaders headers = new HttpHeaders();
    response.getHeaders().forEach(h -> headers.add(h.getKey(), h.getValue()));
    return ResponseEntity.status(response.getStatus()).headers(headers).body(response.getBody());
  }

}
