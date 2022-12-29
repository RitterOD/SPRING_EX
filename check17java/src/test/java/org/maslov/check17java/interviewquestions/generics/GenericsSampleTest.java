package org.maslov.check17java.interviewquestions.generics;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.maslov.check17java.interviewquestions.generics.GenericsSample.Event;

class GenericsSampleTest {

  private final static int EVENT_DATA_LENGTH = 25;

  @Test
  void notThrow() {
    final int eventAmount = 10;

    var gs = new GenericsSample();
    List<Event> events= new ArrayList<>();
    for(int i = 0; i < eventAmount; ++i) {
      events.add(new Event(RandomStringUtils.random(EVENT_DATA_LENGTH)));
    }
    assertDoesNotThrow(() -> gs.producerExtends(events));
  }

  @Test
  void notThrowConsumerSuper() {
    final int eventAmount = 10;

    var gs = new GenericsSample();
    List<Event> events= new ArrayList<>();
    for(int i = 0; i < eventAmount; ++i) {
      events.add(new Event(RandomStringUtils.random(EVENT_DATA_LENGTH)));
    }
    assertDoesNotThrow(() -> gs.consumerSuper(events));
  }


  @Test
  void reverse() {

    List<String> src = Arrays.asList("A", "B", "C", "D", "E");
    List<String> expected = Arrays.asList("E", "D", "C", "B", "A");
    var gc = new GenericsSample();
    gc.reverseWildCardCapture(src);
//    assertThat(actual, is(expected));
    assertIterableEquals(expected, src);


  }
}