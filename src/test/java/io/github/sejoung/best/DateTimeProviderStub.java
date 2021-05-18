package io.github.sejoung.best;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class DateTimeProviderStub implements IDateTimeProvider {

  private final LocalDateTime dateTime;

  public DateTimeProviderStub(LocalDateTime dateTime) {
    this.dateTime = dateTime;
  }

  @Override
  public DayOfWeek DayOfWeek() {
    return dateTime.getDayOfWeek();
  }
}
