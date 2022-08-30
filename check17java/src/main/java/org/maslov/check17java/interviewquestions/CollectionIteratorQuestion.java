package org.maslov.check17java.interviewquestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class CollectionIteratorQuestion {

  public List<Long> getLst() {
    return lst;
  }

  private final List<Long> lst;

  public List<Long> getEmptyLst() {
    return emptylst;
  }


  private final List<Long> emptylst;

  public CollectionIteratorQuestion() {
    Random ran = new Random();
    int sz = ran.nextInt(10);
    lst = new ArrayList<>();
    for (int i =0; i < sz; ++i){
      lst.add(ran.nextLong());
    }
    emptylst = new LinkedList<>();
  }
}
