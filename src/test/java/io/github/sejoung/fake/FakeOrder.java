package io.github.sejoung.fake;

public class FakeOrder implements Order {
  @Override
  public boolean isValidated() {
    return true;
  }
}
