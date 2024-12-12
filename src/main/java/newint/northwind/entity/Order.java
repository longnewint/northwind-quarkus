package newint.northwind.entity;

import java.sql.Date;
import java.util.List;

import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders", schema = "public")
public class Order {
  @Id @NotNull
  @Column(name = "order_id")
  private Short id;

  @OneToMany(mappedBy = "order",
    cascade = CascadeType.ALL,
    orphanRemoval = true)
  private List<OrderDetail> details;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
    name = "customer_id", referencedColumnName = "customer_id",
    insertable=false, updatable=false)
  private Customer customer;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
    name = "employee_id", referencedColumnName = "employee_id",
    insertable=false, updatable=false)
  private Employee employee;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
    name = "ship_via", referencedColumnName = "shipper_id",
    insertable=false, updatable=false)
  private Shipper shipper;
  

  @Column(name = "customer_id", columnDefinition = "bpchar")
  private String customer_id;
  private Short employee_id;
  private Short ship_via;

  private Date order_date;
  private Date required_date;
  private Date shipped_date;
  private Float freight;
  private String ship_name;
  private String ship_address;
  private String ship_city;
  private String ship_region;
  private String ship_postal_code;
  private String ship_country;

  public Order() {}

  public Short getId() { return id; }
  public String getCustomerId() { return customer_id; }
  public Short getEmployeeId() { return employee_id; }
  public Short getShipVia() { return ship_via; }
  public Date getOrderDate() { return order_date; }
  public Date getRequiredDate() { return required_date; }
  public Date getShippedDate() { return shipped_date; }
  public Float getFreight() { return freight; }
  public String getShipName() { return ship_name; }
  public String getShipAddress() { return ship_address; }
  public String getShipCity() { return ship_city; }
  public String getShipRegion() { return ship_region; }
  public String getShipPostalCode() { return ship_postal_code; }
  public String getShipCountry() { return ship_country; }

  public void setId(Short idtt) { id = idtt; }
  public void setCustomerId(String cid) { customer_id = cid; }
  public void setEmployeeId(Short eid) { employee_id = eid; }
  public void setShipVia(Short ship) { ship_via = ship; }
  public void setOrderDate(Date od) { order_date = od; }
  public void setShippedDate(Date sd) { shipped_date = sd; }
  public void setFreight(Float fr) { freight = fr; }
  public void setShipName(String name) { ship_name = name; }
  public void setShipAddress(String addr) { ship_address = addr; }
  public void setShipCity(String ct) { ship_city = ct; }
  public void setShipRegion(String re) { ship_region = re; }
  public void setShipPostalCode(String code) { ship_postal_code = code; }
  public void setShipCountry(String cty) { ship_country = cty; }
}
