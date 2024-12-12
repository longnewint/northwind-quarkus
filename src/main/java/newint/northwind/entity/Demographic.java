package newint.northwind.entity;

import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer_demographics", schema = "public")
public class Demographic {
  @Id @NotNull
  @Column(name = "customer_type_id", columnDefinition = "bpchar")
  private String id;

  @Column(name = "customer_desc")
  private String description;
  
  public Demographic() {}

  public Demographic(String idtt, String desc) {
    id = idtt;
    description = desc;
  }

  public String getId() { return id; }
  public String getDescription() { return description; }

}
