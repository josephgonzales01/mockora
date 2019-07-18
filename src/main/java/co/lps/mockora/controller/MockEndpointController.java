package co.lps.mockora.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.lps.mockora.model.dto.EndpointDto;
import co.lps.mockora.service.IMockEndpointService;
import co.lps.mockora.service.IServeEndpointService;

/**
 * co.lps.mockora.controller
 *
 * @author : josephg
 * @since : 7/07/2019
 */

@RestController
@RequestMapping("/v1")
public class MockEndpointController {

  Logger logger = LoggerFactory.getLogger(MockEndpointController.class);

  IMockEndpointService mockEndpointService;
  IServeEndpointService serveEndpointService;

  @Autowired
  public MockEndpointController(IMockEndpointService mockEndpointService,
      IServeEndpointService serveEndpointService) {
    this.mockEndpointService = mockEndpointService;
    this.serveEndpointService = serveEndpointService;
  }

  @PostMapping("/mock")
  public ResponseEntity<EndpointDto> addMock(@RequestBody EndpointDto dto) {
    
    logger.info("/map post request received");
    mockEndpointService.save(dto);

    return ResponseEntity.ok().body(dto);

  }

  @GetMapping("/mock")
  public ResponseEntity<String> getMock() {

    return ResponseEntity.ok().body("Hello world 2");

  }


}
