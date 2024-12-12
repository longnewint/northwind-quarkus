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
@Table(name = "customers", schema = "public")
public class Customer {
  @Id @NotNull
  @Column(name = "customer_id", columnDefinition = "bpchar")
  private String id;

  @OneToMany(
    mappedBy = "customer",
    cascade = CascadeType.ALL,
    orphanRemoval = true
  )
  private List<Order> orders;

  @OneToMany(
    mappedBy = "customer",
    cascade = CascadeType.ALL,
    orphanRemoval = true
  )
  private List<CustomerDemographic> demographics;

  @NotNull
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

  public Customer() {}

  public Customer(String idtt, String company_n, String contact_n, String contact_t,
  String addr, String cit, String reg, String post_code, String ctry,
  String phone_num, String fax_num) {
    id = idtt;
    company_name = company_n;
    contact_name = contact_n;
    contact_title = contact_t;
    address = addr;
    city = cit;
    region = reg;
    postal_code = post_code;
    country = ctry;
    phone = phone_num;
    fax = fax_num;
  }

  public String getId() { return id; }
  public String getCompany() { return company_name; }
  public String getContactName() { return contact_name; }
  public String getContactTitle() { return contact_title; }
  public String getAddress() { return address; }
  public String getCity() { return city; }
  public String getRegion() { return region; }
  public String getPostalCode() { return postal_code; }
  public String getCountry() { return country; }
  public String getPhone() { return phone; }
  public String getFax() { return fax; }
}
