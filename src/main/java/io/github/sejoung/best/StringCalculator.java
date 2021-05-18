package io.github.sejoung.best;

import java.util.Objects;

public class StringCalculator {

  public int add(String i) {

    if (Objects.isNull(i)) {
      throw new NumberFormatException("i is null");
    }

    if ("".equals(i)) {
      return 0;
    }

    var strings = i.split(",");
    var result = 0;

    if (strings.length == 0) {
      result = Integer.parseInt(i);
    } else {
      for (String value : strings) {
        result += Integer.parseInt(value);
      }
    }
    if (result > 1000) {
      throw new OverflowException();
    }
    return result;
  }
}
