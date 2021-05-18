package io.github.sejoung.fake;

public class MockOrder implements Order {
  @Override
  public boolean isValidated() {
    return true;
  }
}
