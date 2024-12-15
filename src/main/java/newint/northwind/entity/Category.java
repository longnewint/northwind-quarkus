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
@Table(name = "categories", schema = "public")
public class Category {
  @Id @NotNull
  @Column(name = "category_id")
  private Short id;

  @OneToMany(
    mappedBy = "category",
    cascade = CascadeType.ALL,
    orphanRemoval = true
  )
  private List<Product> products;

  @NotNull
  @Column(name = "category_name")
  private String name;

  private String description;

  private byte[] picture;

  public Category() {}

  public Short getId() { return id; }
  public String getName() { return name; }
  public String getDescription() { return description; }
  public byte[] getPicture() { return picture; }

  public void setId(Short idtt) { id = idtt; }
  public void setName(String n) { name = n; }
  public void setDescription(String desc) { description = desc; }
  public void setPicture(byte[] pic) { picture = pic; }
}
