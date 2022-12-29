package org.maslov.template.controller;

import org.maslov.template.user.configuration.RestURL;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RestURL.API_V1_HOME)
public class AppController {

  @GetMapping
  public ResponseEntity<String> getHome() {
    return ResponseEntity.ok().body("Spring Security Template Application");
  }
}
