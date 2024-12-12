package newint.northwind.entity;

import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "products", schema = "public")
public class Product {
  @Id @NotNull
  @Column(name = "product_id")
  private Short id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
    name = "category_id", referencedColumnName = "category_id",
    insertable=false, updatable=false)
  private Category category;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
    name = "supplier_id", referencedColumnName = "supplier_id",
    insertable=false, updatable=false)
  private Supplier supplier;

  private Short supplier_id;

  private Short category_id;

  @NotNull
  @Column(name = "product_name")
  private String name;

  private String quantity_per_unit;

  private Float unit_price;

  private Short units_in_stock;

  private Short units_on_order;

  private Short reorder_level;

  private Integer discontinued;

  public Product() {}

  public Short getId() { return id; }
  public Short getSupplierId() { return supplier_id; }
  public Short getCategoryId() { return category_id; }
  public String getName() { return name; }
  public String getQuantityPerUnit() { return quantity_per_unit; }
  public Float getPrice() { return unit_price; }
  public Short getUnitsInStock() { return units_in_stock; }
  public Short getUnitsOnOrder() { return units_on_order; }
  public Short getReorderLevel() { return reorder_level; }
  public Integer getDiscontinued() { return discontinued; }

  public void setId(Short idtt) { id = idtt; }
  public void setSupplierId(Short sid) { supplier_id = sid; }
  public void setCategoryId(Short cid) { category_id = cid; } 
  public void setName(String n) { name = n; }
  public void setQuantityPerUnit(String qpu) { quantity_per_unit = qpu; }
  public void setUnitPrice(Float price) { unit_price = price; }
  public void setUnitsInStock(Short uis){ units_in_stock = uis; }
  public void setUnitsOnOrder(Short uoo) { units_on_order = uoo; }
  public void setReorderLevel(Short level) { reorder_level = level; }
  public void setDiscontinued(Integer disc) { discontinued = disc; }
    
}
