package io.github.sejoung.fake;

public class Purchase {

  private final Order order;

  private boolean canBeShipped;

  public Purchase(Order order) {
    this.order = order;
    this.canBeShipped = false;
  }

  public void validateOrders() {
    if (!order.isValidated()) {
      throw new IllegalArgumentException("order is not valid");
    }
    this.canBeShipped = true;
  }

  public boolean isCanBeShipped() {
    return canBeShipped;
  }
}
