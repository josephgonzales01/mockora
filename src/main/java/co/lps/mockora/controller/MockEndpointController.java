package co.lps.mockora.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.lps.mockora.constants.ApplicationURL;
import co.lps.mockora.model.dto.CommonMessageDto;
import co.lps.mockora.model.dto.EndpointDto;
import co.lps.mockora.service.MockEndpointService;
import co.lps.mockora.service.ServeEndpointService;
import co.lps.mockora.service.UrlUtilityService;

/**
 * co.lps.mockora.controller
 *
 * @author : josephg
 * @since : 7/07/2019
 */

@RestController
@RequestMapping(ApplicationURL.MOCK_URL)
public class MockEndpointController {

  Logger logger = LoggerFactory.getLogger(MockEndpointController.class);

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

  @PostMapping("/**")
  public ResponseEntity<CommonMessageDto> addMock(@RequestBody EndpointDto dto) {

    logger.info("/mock post request received");
    mockEndpointService.save(dto);

    return ResponseEntity.ok()
        .body(new CommonMessageDto(
            "Successfully Created endpoint", String.format("%s%s%s",
                urlUtilityService.getHostAndPort(), ApplicationURL.SERVE_URL, dto.getUrl()),
            HttpStatus.CREATED.value()));
  }

  @GetMapping("/**")
  public ResponseEntity<String> getMock() {

    return ResponseEntity.ok().body("Hello world 2");

  }

}
