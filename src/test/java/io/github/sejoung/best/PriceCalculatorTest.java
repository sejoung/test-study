package io.github.sejoung.best;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PriceCalculatorTest {

  @DisplayName("Seam 도입 전")
  @Nested
  class NotSeam {
    @DisplayName("화요일이 아닌 날은 정상가격이다.")
    @Test
    void getDiscountedPriceNotTuesdayReturnsFullPrice() {
      var priceCalculator = new PriceCalculator();
      var actual = priceCalculator.getDiscountedPrice(2);
      assertThat(actual).isEqualTo(2);
    }

    @DisplayName("화요일은 반값이다.")
    @Test
    void getDiscountedPriceOnTuesdayReturnsHalfPrice() {
      var priceCalculator = new PriceCalculator();
      var actual = priceCalculator.getDiscountedPrice(2);
      assertThat(actual).isEqualTo(1);
    }
  }

  @DisplayName("Seam 도입")
  @Nested
  class Seam {
    @DisplayName("화요일이 아닌 날은 정상가격이다.")
    @Test
    void getDiscountedPriceNotTuesdayReturnsFullPrice() {
      var priceCalculator = new PriceCalculator();
      var dateTime = LocalDateTime.of(2021, 5, 19, 11, 10);
      var dateTimeProviderStub = new DateTimeProviderStub(dateTime);
      var actual = priceCalculator.getDiscountedPrice(2, dateTimeProviderStub);
      assertThat(actual).isEqualTo(2);
    }

    @DisplayName("화요일은 반값이다.")
    @Test
    void getDiscountedPriceOnTuesdayReturnsHalfPrice() {
      var priceCalculator = new PriceCalculator();
      var dateTime = LocalDateTime.of(2021, 5, 18, 11, 10);
      var dateTimeProviderStub = new DateTimeProviderStub(dateTime);
      var actual = priceCalculator.getDiscountedPrice(2, dateTimeProviderStub);
      assertThat(actual).isEqualTo(1);
    }
  }
}
