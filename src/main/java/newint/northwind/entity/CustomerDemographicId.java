package newint.northwind.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class CustomerDemographicId implements Serializable {
  private String id;

  private String typeId;

  public CustomerDemographicId() {}

  public CustomerDemographicId(String customerId, String customerTypeId) {
    id = customerId;
    typeId = customerTypeId;
  }

  public String getId() { return id; }
  public String getTypeId() { return typeId; }

  public void setId(String idtt) { id = idtt; }
  public void setTypeId(String tid) { typeId = tid; }

  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(o == null || getClass() != o.getClass()) return false;

    CustomerDemographicId that = (CustomerDemographicId) o;
    return Objects.equals(id, that.id) && Objects.equals(typeId, that.typeId);
  }

  @Override
  public int hashCode() { return Objects.hash(id, typeId); }
}
