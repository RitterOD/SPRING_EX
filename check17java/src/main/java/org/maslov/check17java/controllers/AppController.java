package org.maslov.check17java.controllers;

import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.maslov.check17java.model.Point;
import org.maslov.check17java.service.PointService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class AppController {

  private final PointService pointService;

  public AppController(PointService pointService) {
    this.pointService = pointService;
  }

  @GetMapping("/")
  public ModelAndView getIndex() {
    List<Point> randomPoints = pointService.getRandomPoints();
    log.info("list.size()=" + randomPoints.size());
    return new ModelAndView("index", Map.of("randomPoints", randomPoints));
  }

}
