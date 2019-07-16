package co.lps.mockora.controller;

import co.lps.mockora.service.IServeEndpointService;
import co.lps.mockora.service.IEndpointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
public class SetEndpointController {

    IEndpointService setEndpointService;
    IServeEndpointService serveEndpointService;

    @Autowired
    public SetEndpointController(IEndpointService setEndpointService, IServeEndpointService serveEndpointService) {
        this.setEndpointService = setEndpointService;
        this.serveEndpointService = serveEndpointService;
    }

    @PostMapping("/set")
    public ResponseEntity<String> addMock() {

        return ResponseEntity.ok().body("Hello world 2");

    }

    @GetMapping("/set")
    public ResponseEntity<String> getMock() {

        return ResponseEntity.ok().body("Hello world 2");

    }


}
