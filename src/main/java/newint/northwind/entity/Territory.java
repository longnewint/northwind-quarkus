package newint.northwind.entity;

import java.util.ArrayList;
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
@Table(name = "territories", schema = "public")
public class Territory {
  @Id @NotNull
  @Column(name = "territory_id")
  private String id;

  @OneToMany(
    mappedBy = "territory",
    cascade = CascadeType.ALL,
    orphanRemoval = true
  )
  private List<EmployeeTerritory> employeeTerritories = new ArrayList<>();

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
    name = "region_id", referencedColumnName = "region_id",
    insertable=false, updatable=false)
  private Region region;

  @Column(name = "territory_description", columnDefinition = "bpchar")
  private String descripton;

  private Short region_id;

  public Territory() {}

  public String getId() { return id; }
  public String getDescription() { return descripton; }
  public Short getRegionId() { return region_id; }

  public void setId(String idtt) { id = idtt; }
  public void setDescription(String desc) { descripton = desc; }
  public void setRegionId(Short rid) { region_id = rid; }
}
