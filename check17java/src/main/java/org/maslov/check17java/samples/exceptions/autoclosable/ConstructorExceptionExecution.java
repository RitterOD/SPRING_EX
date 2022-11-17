package org.maslov.check17java.samples.exceptions.autoclosable;

public class ConstructorExceptionExecution extends AutoClosableStub{

  public ConstructorExceptionExecution(String name) {
    super(name);
    throw new RuntimeException("exception from constructor of object: " + this.getObjectName());
  }
}
