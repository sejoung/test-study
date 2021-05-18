package io.github.sejoung.best;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParserTest {

  @DisplayName("private 메소드 테스트는 public 메소드 테스트로 충분하다.")
  @Test
  void parseLogLineStartsAndEndsWithSpaceReturnsTrimmedResult() {
    var parser = new Parser();
    var actual = parser.parseLogLine(" a ");
    assertThat(actual).isEqualTo("a");
  }
}
