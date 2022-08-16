package org.maslov.check17java.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;
import org.maslov.check17java.model.Point;
import org.springframework.stereotype.Service;

@Service
public class PointService {

  private final RandomGenerator generator;

  public PointService() {
    generator = RandomGeneratorFactory.getDefault().create();
  }

  public List<Point> getRandomPoints() {
      var xCoordinate = generator.ints().limit(10).toArray();
      var yCoordinate = generator.ints().limit(10).toArray();
      List<Point> rv = new ArrayList<>();
      for(int i = 0; i < xCoordinate.length; ++i) {
        rv.add(new Point(xCoordinate[i], yCoordinate[i]));
      }
      return rv;
  }

}
