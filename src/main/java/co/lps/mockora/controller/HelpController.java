package co.lps.mockora.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")

public class HelpController {

  @GetMapping
  public String helpDoc() {

    return "redirect:swagger-ui.html";
  }


}
