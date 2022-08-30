package org.maslov.check17java.interviewquestions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.maslov.check17java.interviewquestions.InitializationOrder.Base;
import org.maslov.check17java.interviewquestions.InitializationOrder.Subclass;

class InitializationOrderTest {

  @Test
  void example() {
    System.out.println("First Subclass instance:");
    Base base = new Subclass();

    System.out.println("Another Subclass instance:");
    base = new Subclass();

    System.out.println("Instance of Base:");
    base = new Base();
  }

}