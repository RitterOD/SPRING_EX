package org.maslov.check17java.samples.exceptions.autoclosable;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AutoClosableStub implements AutoCloseable{

  public AutoClosableStub(String objectName) {
    this.objectName = objectName;
  }

  public String getObjectName() {
    return objectName;
  }

  private final String objectName;

  public void doWork() {
    log.info("Execute doWork. Object: " + this.objectName);
  }

  public void doWorkCheckedException() throws Exception {
    log.info("Execute doWorkCheckedException. Object: " + this.objectName);
    throw new Exception("Exception from object: " + getObjectName() + " in method doWorkCheckedException");
  }

  @Override public void close() throws Exception {
      log.info("Execute close. Object: " + this.objectName);
  }
}
