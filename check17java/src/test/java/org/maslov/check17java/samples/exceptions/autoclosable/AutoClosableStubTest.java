package org.maslov.check17java.samples.exceptions.autoclosable;

import static org.junit.jupiter.api.Assertions.*;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
class AutoClosableStubTest {

  @Test
  public void testExceptionInConstructor() {
    Assertions.assertDoesNotThrow(() -> {
      try (AutoClosableStub stub = new ConstructorExceptionExecution("constructorExceptionExecutionAutoClosable")) {
        stub.doWork();
      } catch (Exception e) {
        log.info("Execute catch:" + e.getMessage());
      } finally {
        log.info("execute finally");
      }

    });
  }


    @Test
    public void testNormalExecutionConstructor() {
      Assertions.assertDoesNotThrow(() -> {
        try(AutoClosableStub stub = new NormalExecution("normalExecutionAutoClosable")) {
          stub.doWork();
        } catch (Exception e) {
          log.info("Execute catch:" + e.getMessage());
        } finally {
          log.info("execute finally");
        }

      });
  }

  @Test
  public void testExceptionInTry() {
    Assertions.assertDoesNotThrow(() -> {
      try(AutoClosableStub stub = new NormalExecution("normalExecutionAutoClosable")) {
        stub.doWorkCheckedException();
      } catch (Exception e) {
        log.info("Execute catch:" + e.getMessage());
      } finally {
        log.info("execute finally");
      }

    });
  }


  @Test
  public void testNullInResourceInit() {
    Assertions.assertDoesNotThrow(() -> {
      try(AutoClosableStub stub = null) {
        log.info("IN TRY");
        //stub.doWorkCheckedException();
      } catch (Exception e) {
        log.info("Execute catch:" + e.getMessage());
      } finally {
        log.info("execute finally");
      }

    });
  }


}