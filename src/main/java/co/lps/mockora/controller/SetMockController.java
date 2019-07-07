package co.lps.mockora.controller;

import co.lps.mockora.service.IServeMockService;
import co.lps.mockora.service.ISetMockService;
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
public class SetMockController {

    ISetMockService setMockService;
    IServeMockService serveMockService;

    @Autowired
    public SetMockController(ISetMockService setMockService, IServeMockService serveMockerService) {
        this.setMockService = setMockService;
        this.serveMockService = serveMockerService;
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
