package org.maslov.check17java.controllers;

import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.maslov.check17java.model.Point;
import org.maslov.check17java.service.PointService;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class AppController {

  private final PointService pointService;

  private final Environment environment;

  public AppController(PointService pointService, Environment environment) {
    this.pointService = pointService;
    this.environment = environment;
  }

  @GetMapping("/")
  public ModelAndView getIndex() {
    List<Point> randomPoints = pointService.getRandomPoints();
    log.info("list.size()=" + randomPoints.size());
    return new ModelAndView("index", Map.of("randomPoints", randomPoints));
  }

}
