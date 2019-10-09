package co.lps.mockora.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.lps.mockora.constants.ApplicationURL;
import co.lps.mockora.service.MockEndpointService;
import co.lps.mockora.service.UrlUtilityService;

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

    Logger logger = LoggerFactory.getLogger(MockEndpointController.class);

    MockEndpointService mockEndpointService;


    UrlUtilityService urlUtilityService;

    @Autowired
    public ServeEndpointController(MockEndpointService mockEndpointService,
                                   UrlUtilityService urlUtilityService) {
        this.mockEndpointService = mockEndpointService;
        this.urlUtilityService = urlUtilityService;

    }

    @PostMapping("/{orgId}/**")
    public ResponseEntity<String> servePostMock(HttpServletRequest request, @PathVariable String orgId, @RequestBody Map<Object, Object> body) {

        logger.info("{} post request received", request.getRequestURI());
        logger.info("from {} organization", request.getRequestURI());

        return ResponseEntity.ok().body(urlUtilityService.getServeUrlWithoutOrg(request.getRequestURI(), orgId));
    }

    @GetMapping("/{orgId}/**")
    public ResponseEntity<String> serveGetMock(HttpServletRequest request, @PathVariable String orgId) {
        logger.info("from {}",request.getRequestURI());
      
        logger.info("/serve post request received with base url {}", urlUtilityService.getServeUrlWithoutOrg(request.getRequestURI(), orgId));
        return ResponseEntity.ok().body("helloworld");

    }


}
