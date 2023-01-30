package org.maslov.monitor.controller;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppRestController {

  private AtomicInteger visitCounter;

  public Supplier<Number> getVisitCounter() {
    return ()-> visitCounter.get();
  }

  public AppRestController(MeterRegistry registry) {
    this.visitCounter = new AtomicInteger(0);
    Gauge.builder("user.visits", getVisitCounter())
      .tag("version", "v1")
      .description("user visits on main page")
      .register(registry);
  }

  @GetMapping("/")
  public ResponseEntity<String> index() {
    visitCounter.incrementAndGet();

    return ResponseEntity.ok().body("Monitor Application");
  }
}
