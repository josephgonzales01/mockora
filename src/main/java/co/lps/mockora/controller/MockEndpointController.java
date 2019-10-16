package co.lps.mockora.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.lps.mockora.constants.ApplicationURL;
import co.lps.mockora.model.dto.CommonResponseDto;
import co.lps.mockora.model.dto.EndpointDto;
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
@RequestMapping(ApplicationURL.MOCK_URL)
@Slf4j
public class MockEndpointController {

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
  public ResponseEntity<CommonResponseDto> addMock(HttpServletRequest request,
      @RequestBody EndpointDto dto) {
    String url = urlUtilityService.getServeUrlWithoutOrg(request.getRequestURI(), dto.getOrgId());
    String orgId = dto.getOrgId().toLowerCase();

    log.debug("[MOCK:POST] for url {}{}", orgId, url);
    mockEndpointService.save(dto);

    return ResponseEntity.ok()
        .body(new CommonResponseDto(
            201, "Successfully Created endpoint", String.format("%s%s/%s%s",
                urlUtilityService.getHostAndPort(), ApplicationURL.SERVE_URL, orgId, dto.getUrl()),
            null));
  }

  @GetMapping("/**")
  public ResponseEntity<String> getMock() {

    return ResponseEntity.ok().body("Hello world 2");

  }

}
