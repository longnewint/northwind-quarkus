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
@Table(name = "suppliers", schema = "public")
public class Supplier {
  @Id @NotNull
  @Column(name = "supplier_id")
  private Short id;

  @OneToMany(
    mappedBy = "supplier",
    cascade = CascadeType.ALL,
    orphanRemoval = true
  )
  private List<Product> products;

  private String company_name;

  private String contact_name;

  private String contact_title;

  private String address;

  private String city;
  
  private String region;

  private String postal_code;

  private String country;

  private String phone;

  private String fax;

  private String homepage;

  public Supplier() {}

  public Short getId() { return id; }
  public String getCompanyName() { return company_name; }
  public String getContactName() { return contact_name; }
  public String getContactTitle() { return contact_title; }
  public String getAddress() { return address; }
  public String getCity() { return city; }
  public String getRegion() { return region; }
  public String getPostalCode() { return postal_code; }
  public String getCountry() { return country; }
  public String getPhone() { return phone; }
  public String getFax() { return fax; }
  public String getHomePage() { return homepage; }

  public void setId(Short idtt) { id = idtt; }
  public void setCompanyName(String name) { company_name = name; }
  public void setContactName(String contact) { contact_name = contact; }
  public void setContactTitle(String title) { contact_title = title; }
  public void setAddress(String addr) { address = addr; }
  public void setCity(String ct) { city = ct; }
  public void setRegion(String re) { region = re; }
  public void setPostalCode(String code) { postal_code = code; }
  public void setCountry(String cty) { country = cty; }
  public void setPhone(String num) { phone = num; }
  public void setFax(String fx) { fax = fx; }
  public void setHomepage(String page) { homepage = page; }
}
