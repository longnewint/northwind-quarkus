package newint.northwind.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee_territories", schema = "public")
public class EmployeeTerritory {
  @EmbeddedId
  private EmployeeTerritoryId id;

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("employee_id")
  @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
  private Employee employee;

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("territory_id")
  @JoinColumn(name = "territory_id", referencedColumnName = "territory_id")
  private Territory territory;

  public EmployeeTerritory() {}

  public EmployeeTerritoryId getId() { return id; }
}
