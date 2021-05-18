package io.github.sejoung.best;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseTest {

  @DisplayName("stub이 mock이라고 잘못 불리는 예")
  @Test
  void orderStubTest() {
    var mockOrder = new MockOrder();
    var purchase = new Purchase(mockOrder);
    purchase.validateOrders();
    Assertions.assertThat(purchase.isCanBeShipped()).isTrue();
  }

  @DisplayName("stub이 mock이라고 잘못 불리는 예(용어를 fake로 수정)")
  @Test
  void orderFakeTest() {
    var fakeOrder = new FakeOrder();
    var purchase = new Purchase(fakeOrder);
    purchase.validateOrders();
    Assertions.assertThat(purchase.isCanBeShipped()).isTrue();
  }

  @DisplayName("mock 테스트")
  @Test
  void orderMockTest() {
    var mockOrder = new MockOrder();
    var purchase = new Purchase(mockOrder);
    purchase.validateOrders();
    Assertions.assertThat(mockOrder.isValidated()).isTrue();
  }
}