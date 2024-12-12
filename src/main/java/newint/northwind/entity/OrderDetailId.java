package newint.northwind.entity;

import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class OrderDetailId {
  private Short order_id;

  private Short product_id;

  public OrderDetailId() {}

  public OrderDetailId(Short id1, Short id2) {
    order_id = id1;
    product_id = id2;
  }

  public Short getOrderId() { return order_id; }
  public Short getProductId() { return product_id; }

  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(o == null || getClass() != o.getClass()) return false;

    OrderDetailId that = (OrderDetailId) o;
    return Objects.equals(order_id, that.order_id) && Objects.equals(product_id, that.product_id);
  }

  @Override
  public int hashCode() { return Objects.hash(order_id, product_id); }
}
