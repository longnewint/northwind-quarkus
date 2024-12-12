package newint.northwind.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer_customer_demo", schema = "public")
public class CustomerDemographic {
  @EmbeddedId
  private CustomerDemographicId id;

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("id")
  @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", columnDefinition = "bpchar")
  private Customer customer;

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("typeId")
  @JoinColumn(name = "customer_type_id", referencedColumnName = "customer_type_id", columnDefinition = "bpchar")
  private Demographic demographic;

  public CustomerDemographic() {}

  public CustomerDemographicId getId() { return id; }

}
