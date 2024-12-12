package newint.northwind.entity;

import java.util.List;

import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "shippers", schema = "public")
public class Shipper {
  @Id @NotNull
  @Column(name = "shipper_id")
  private Short id;

  @OneToMany(
    mappedBy = "shipper",
    cascade = CascadeType.ALL,
    orphanRemoval = true
  )
  private List<Order> orders;

  @NotNull
  private String company_name;

  private String phone;

  public Short getId() { return id; }
  public String getCompanyName() { return company_name; }
  public String getPhone() { return phone; }

  public void setId(Short idtt) { id = idtt; }
  public void setCompanyName(String name) { company_name = name; }
  public void setPhone(String num) { phone = num; }
}
