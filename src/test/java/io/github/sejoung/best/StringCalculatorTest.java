package io.github.sejoung.best;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringCalculatorTest {

  @DisplayName("네이밍")
  @Nested
  class Naming {
    @DisplayName("Bad")
    @Test
    void testSingle() {
      var stringCalculator = new StringCalculator();
      var actual = stringCalculator.add("0");
      assertThat(actual).isZero();
    }

    @DisplayName("Better")
    @Test
    void addSingleNumberReturnsSameNumber() {
      var stringCalculator = new StringCalculator();
      var actual = stringCalculator.add("0");
      assertThat(actual).isZero();
    }
  }

  @DisplayName("정렬")
  @Nested
  class Arranging {

    @DisplayName("Bad")
    @Nested
    class Bad {
      @Test
      void addEmptyStringReturnsZero() {
        // Arrange
        var stringCalculator = new StringCalculator();
        // Assert
        assertThat(stringCalculator.add("")).isZero();
      }
    }

    @DisplayName("Better")
    @Nested
    class Better {
      @Test
      void addEmptyStringReturnsZero() {
        // Arrange
        var stringCalculator = new StringCalculator();
        // Act
        var actual = stringCalculator.add("");
        // Assert
        assertThat(actual).isZero();
      }
    }
  }

  @DisplayName("최소한의 테스트 통과 작성")
  @Nested
  class MinimallyPassing {

    @DisplayName("Bad")
    @Nested
    class Bad {
      @Test
      void addSingleNumberReturnsSameNumber() {
        var stringCalculator = new StringCalculator();
        var actual = stringCalculator.add("42");
        assertThat(actual).isEqualTo(42);
      }
    }

    @DisplayName("Better")
    @Nested
    class Better {
      @Test
      void addSingleNumberReturnsSameNumber() {
        var stringCalculator = new StringCalculator();
        var actual = stringCalculator.add("0");
        assertThat(actual).isZero();
      }
    }
  }

  @DisplayName("매직 문자열 방지")
  @Nested
  class MagicStrings {

    @DisplayName("Bad")
    @Test
    void addBigNumberThrowsException() {
      var stringCalculator = new StringCalculator();
      var actual = catchThrowable(() -> stringCalculator.add("1001"));
      assertThat(actual).isInstanceOf(OverflowException.class);
    }

    @DisplayName("Better")
    @Test
    void addMaximumSumResultThrowsOverflowException() {
      var stringCalculator = new StringCalculator();
      String MAXIMUM_RESULT = "1001";
      var actual = catchThrowable(() -> stringCalculator.add(MAXIMUM_RESULT));
      assertThat(actual).isInstanceOf(OverflowException.class);
    }
  }

  @DisplayName("테스트에서 논리 방지")
  @Nested
  class LogicInTests {

    @DisplayName("Bad")
    @Test
    void addMultipleNumbersReturnsCorrectResults() {
      var stringCalculator = new StringCalculator();
      var expected = 0;
      var testCases = new String[] {"0,0,0", "0,1,2", "1,2,3"};

      for (String test : testCases) {
        var actual = stringCalculator.add(test);
        assertThat(actual).isEqualTo(expected);
        expected += 3;
      }
    }

    @DisplayName("Better")
    @ParameterizedTest(name = "{displayName} {arguments} [{index}]")
    @CsvSource(
        value = {"0,0,0:0", "0,1,2:3", "1,2,3:6"},
        delimiterString = ":")
    void addMultipleNumbersReturnsSumOfNumbers(String input, int expected) {
      var stringCalculator = new StringCalculator();
      var actual = stringCalculator.add(input);
      assertThat(actual).isEqualTo(expected);
    }
  }

  @DisplayName("설정 및 해제할 도우미 방법 선호")
  @Nested
  class SetupTeardown {

    @DisplayName("Bad")
    @Nested
    class Bad {
      private final StringCalculator stringCalculator;

      public Bad() {
        this.stringCalculator = new StringCalculator();
      }

      @Test
      void addTwoNumbersReturnsSumOfNumbers() {
        var actual = stringCalculator.add("0,1");
        assertThat(actual).isOne();
      }
    }

    @DisplayName("Better")
    @Nested
    class Better {
      @Test
      void addTwoNumbersReturnsSumOfNumbers() {
        var stringCalculator = createDefaultStringCalculator();
        var actual = stringCalculator.add("0,1");
        assertThat(actual).isOne();
      }

      private StringCalculator createDefaultStringCalculator() {
        return new StringCalculator();
      }
    }
  }

  @DisplayName("다중 어설션 방지")
  @Nested
  class MultipleAsserts {

    @DisplayName("Bad")
    @Test
    void addEdgeCasesThrowsNumberFormatExceptions() {
      var stringCalculator = new StringCalculator();
      assertThatThrownBy(() -> stringCalculator.add(null))
          .isInstanceOf(NumberFormatException.class);
      assertThatThrownBy(() -> stringCalculator.add("a")).isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("Better")
    @ParameterizedTest(name = "{displayName} {arguments} [{index}]")
    @NullSource
    @ValueSource(strings = "a")
    void addInputNullOrAlphabeticThrowsNumberFormatException(String input) {
      var stringCalculator = new StringCalculator();
      assertThatThrownBy(() -> stringCalculator.add(input))
          .isInstanceOf(NumberFormatException.class);
    }
  }
}
