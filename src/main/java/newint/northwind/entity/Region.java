package newint.northwind.entity;

import java.util.ArrayList;
import java.util.List;

import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "region", schema = "public")
public class Region {
  @Id @NotNull
  @Column(name = "region_id")
  private Short id;

  @OneToMany(
        mappedBy = "region",
        cascade = CascadeType.ALL,
        orphanRemoval = true
  )
  List<Territory> territories = new ArrayList<>();

  @Column(name = "region_description", columnDefinition = "bpchar")
  private String description;

  public Region() {}

  public Short getId() { return id; }
  public String getDescription() { return description; }
  
  public void setId(Short idtt) { id = idtt; }
  public void setDescription(String desc) { description = desc; }
}
