package io.github.sejoung.best;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class PriceCalculator {

  public int getDiscountedPrice(int price) {
    if (LocalDateTime.now().getDayOfWeek() == DayOfWeek.TUESDAY) {
      return price / 2;
    } else {
      return price;
    }
  }

  public int getDiscountedPrice(int price, IDateTimeProvider dateTimeProvider) {
    if (dateTimeProvider.DayOfWeek() == DayOfWeek.TUESDAY) {
      return price / 2;
    } else {
      return price;
    }
  }

}
