package newint.northwind.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_details", schema = "public")
public class OrderDetail {
  @EmbeddedId
  private OrderDetailId id;

  @ManyToOne()
  @MapsId("order_id")
  @JoinColumn(name = "order_id", referencedColumnName = "order_id")
  private Order order;

  @ManyToOne
  @MapsId("product_id")
  @JoinColumn(name = "product_id", referencedColumnName = "product_id")
  private Product product;

  private Float unit_price;
  private Short quantity;
  private Float discount;

  public OrderDetail() {}

  public OrderDetailId getId() { return id; }
  public Float getUnitPrice() { return unit_price; }
  public Short getQuantity() { return quantity; }
  public Float getDiscount() { return discount; }

  public void setUnitPrice(Float price) { unit_price = price; }
  public void setQuantity(Short amount) { quantity = amount; }
  public void setDiscount(Float dis) { discount = dis; }
}
