package newint.northwind.entity;

import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class EmployeeTerritoryId {
  private Short employee_id;

  private String territory_id;

  public EmployeeTerritoryId() {}

  public EmployeeTerritoryId(Short id1, String id2) {
    employee_id = id1;
    territory_id = id2;
  }

  public Short getEmployeeId() { return employee_id; }
  public String getTerritoryId() { return territory_id; }

  public void setEmployeeId(Short id1) { employee_id = id1; }
  public void setTerritoryId(String id2) { territory_id = id2; }

  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(o == null || getClass() != o.getClass()) return false;

    EmployeeTerritoryId that = (EmployeeTerritoryId) o;
    return Objects.equals(employee_id, that.employee_id) && Objects.equals(territory_id, that.territory_id);
  }

  @Override
  public int hashCode() { return Objects.hash(employee_id, territory_id); }
}
