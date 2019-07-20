package co.lps.mockora.controller;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.lps.mockora.configuration.ApplicationProperties;
import co.lps.mockora.model.dto.EndpointDto;
import co.lps.mockora.service.IMockEndpointService;
import co.lps.mockora.service.IServeEndpointService;
import co.lps.mockora.service.UrlUtilityService;

/**
 * co.lps.mockora.controller
 *
 * @author : josephg
 * @since : 7/07/2019
 */

@RestController
@RequestMapping("/serve")
public class ServeEndpointController {

  Logger logger = LoggerFactory.getLogger(MockEndpointController.class);

  IMockEndpointService mockEndpointService;
  IServeEndpointService serveEndpointService;
  ApplicationProperties appProperties;
  UrlUtilityService urlUtilityService;

  @Autowired
  public ServeEndpointController(IMockEndpointService mockEndpointService,
      IServeEndpointService serveEndpointService, ApplicationProperties appProperties,
      UrlUtilityService urlUtilityService) {
    this.mockEndpointService = mockEndpointService;
    this.serveEndpointService = serveEndpointService;
    this.appProperties = appProperties;
    this.urlUtilityService = urlUtilityService;

  }

  @PostMapping("/**")
  public ResponseEntity<String> servePostMock(HttpServletRequest request,
      @RequestBody EndpointDto dto) {

    logger.info("/serve post request received");
    logger.info("requestUrl: {}", request.getRequestURL());
    logger.info("requestURI: {}", request.getRequestURI());
    return ResponseEntity.ok().body(urlUtilityService.getOrgUrl(request.getRequestURI()));

  }

  @GetMapping("/{orgUrl}/**")
  public ResponseEntity<EndpointDto> serveGetMock(@RequestBody EndpointDto dto) {

    logger.info("/serve post request received with base url {}", appProperties.getBaseUrl());
    mockEndpointService.save(dto);

    return ResponseEntity.ok().body(dto);

  }


}
