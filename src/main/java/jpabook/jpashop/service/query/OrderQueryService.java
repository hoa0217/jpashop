package jpabook.jpashop.service.query;

import static java.util.stream.Collectors.toList;

import java.util.List;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.repository.OrderRepository;
import jpabook.jpashop.repository.OrderSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderQueryService {

  private final OrderRepository orderRepository;

  public List<Order> ordersV1() {
    List<Order> all = orderRepository.findAllByString(new OrderSearch());
    for (Order order : all) {
      order.getMember().getName();
      order.getDelivery().getAddress();
      order.getOrderItems().stream()
          .forEach(o -> o.getItem().getName());
    }
    return all;
  }

  public List<OrderDto> ordersV2() {
    List<Order> orders = orderRepository.findAllByString(new OrderSearch());
    List<OrderDto> collect = orders.stream()
        .map(order -> new OrderDto(order))
        .collect(toList());

    return collect;
  }

  public List<OrderDto> ordersV3() {
    List<Order> orders = orderRepository.findAllWithItem();

    List<OrderDto> collect = orders.stream()
        .map(order -> new OrderDto(order))
        .collect(toList());

    return collect;
  }

  public List<OrderDto> ordersV3_page(int offset, int limit) {
    List<Order> orders = orderRepository.findAllWithMemberDelivery(offset, limit);

    List<OrderDto> collect = orders.stream()
        .map(order -> new OrderDto(order))
        .collect(toList());

    return collect;
  }
}
