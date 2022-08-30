package org.maslov.check17java.interviewquestions;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.NoSuchElementException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class CollectionIteratorQuestionTest {

  CollectionIteratorQuestion collections = new CollectionIteratorQuestion();

  @Test
  void testEmpty() {
    // 127 question
    var emptyLst= collections.getEmptyLst();
    var iterator = emptyLst.iterator();
    var exception =assertThrows(NoSuchElementException.class, () -> {iterator.next();});
    log.info(exception.getMessage());
  }

  @Test
  void testCopyToArray() {
    // 121 question
    var longLst = collections.getLst();
    assertDoesNotThrow(() -> {var arr = longLst.toArray(new Long[0]); log.info(Arrays.toString(arr));});
    var exception = assertThrows(ArrayStoreException.class,() -> {var arr = longLst.toArray(new StringBuilder[0]); log.info(Arrays.toString(arr));});
    log.info(exception.getMessage());
    Long[] type = null;
    var exc = assertThrows(NullPointerException.class,() -> {var arr = longLst.toArray(type); log.info(Arrays.toString(arr));});
    log.info(exc.getMessage());
  }

}