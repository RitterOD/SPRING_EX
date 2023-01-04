package org.maslov.template.diagramapp.controller;

import org.maslov.template.auth.configuration.RestURL;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RestURL.API_V1_DIAG)
public class DiagramController {

  @GetMapping
  public ResponseEntity<String> getAllDiagrams() {
    return ResponseEntity.ok().body("ALL DIAGRAMS STUB IMPLEMENTATION");
  }
}
