package org.maslov.check17java.benchmarks.simple;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

public class OutputAverageTimeTest {

  static int i = 0;

  @Benchmark
  @Fork(value = 2)
  @Measurement(iterations = 10, time = 1)
  @Warmup(iterations = 5, time = 1)
  public void init(Blackhole blackhole) {
    blackhole.consume(new Object());
    //System.out.println("BENCHMARK STANDARD OUTPUT: " + ++i);
  }

  public static void main(String[] args) throws IOException {
    org.openjdk.jmh.Main.main(args);
  }

}
