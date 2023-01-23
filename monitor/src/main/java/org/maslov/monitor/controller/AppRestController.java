package org.maslov.monitor.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppRestController {

  @GetMapping("/")
  public ResponseEntity<String> index() {
    return ResponseEntity.ok().body("Monitor Application");
  }
}
