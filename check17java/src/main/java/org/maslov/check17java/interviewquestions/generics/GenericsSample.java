package org.maslov.check17java.interviewquestions.generics;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GenericsSample {

  @Getter
  @Setter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Event {
    private String message;
  }

  public void producerExtends(List<? extends Event> eventSource) {
    for(Event e : eventSource) {
      log.info(e.getMessage());
    }
  }

  public void consumerSuper(List<? super Event> eventSource) {
    for(Object e : eventSource) {
      log.info(((Event)e).getMessage());
    }
  }

//  void reverse(List<?> lst) {
//    List<?> tmp = lst;
//    for(int i = 0; i < lst.size(); ++i) {
//      lst.set(i, tmp.get(lst.size() - i - 1));
//    }
//  }

  void reverseWildCardCapture(List<?> lst) {
      reverseImpl(lst);
  }

  private <T> void  reverseImpl(List<T> lst) {
    List<T> tmp = new ArrayList<>(lst);
    for(int i = 0; i < lst.size(); ++i) {
      lst.set(i, tmp.get(lst.size() - i - 1));
    }
  }


}
