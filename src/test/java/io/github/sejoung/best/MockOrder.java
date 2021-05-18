package io.github.sejoung.best;

import io.github.sejoung.best.Order;

public class MockOrder implements Order {
  @Override
  public boolean isValidated() {
    return true;
  }
}
