package co.lps.mockora.controller;

import co.lps.mockora.service.IServeEndpointService;
import co.lps.mockora.dao.Endpoint;
import co.lps.mockora.service.IEndpointService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * co.lps.mockora.controller
 *
 * @author : josephg
 * @since : 7/07/2019
 */

@RestController
@RequestMapping("/v1")
public class MapEndpointController {

  Logger logger = LoggerFactory.getLogger(MapEndpointController.class);

  IEndpointService setEndpointService;
  IServeEndpointService serveEndpointService;

  @Autowired
  public MapEndpointController(IEndpointService setEndpointService,
      IServeEndpointService serveEndpointService) {
    this.setEndpointService = setEndpointService;
    this.serveEndpointService = serveEndpointService;
  }

  @PostMapping("/map")
  public ResponseEntity<Endpoint> addMock(@RequestBody Endpoint endpointRequest) {
    
    logger.info("/map post request received");

    return ResponseEntity.ok().body(endpointRequest);

  }

  @GetMapping("/map")
  public ResponseEntity<String> getMock() {

    return ResponseEntity.ok().body("Hello world 2");

  }


}
