package jpabook.jpashop.service.query;

import jpabook.jpashop.domain.OrderItem;
import lombok.Data;

@Data
public class OrderItemDto {

  private String itemName; // 상품명
  private int orderPrice; // 주문가격
  private int count; // 수량

  public OrderItemDto(OrderItem orderItem) {
    this.itemName = orderItem.getItem().getName();
    this.orderPrice = orderItem.getOrderPrice();
    this.count = orderItem.getCount();
  }
}
