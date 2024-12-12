package newint.northwind.entity;

import java.sql.Date;
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
@Table(name = "employees", schema = "public")
public class Employee {
  @Id @NotNull
  @Column(name = "employee_id")
  private Short id;

  @OneToMany(
    mappedBy = "employee",
    cascade = CascadeType.ALL,
    orphanRemoval = true
  )
  private List<Order> orders;

  @OneToMany(
    mappedBy = "employee",
    cascade = CascadeType.ALL,
    orphanRemoval = true
  )
  List<EmployeeTerritory> employeeTerritories = new ArrayList<>();

  @NotNull
  private String first_name;
  @NotNull
  private String last_name;
  
  private String title;
  private String title_of_courtesy;
  private Date birth_date;
  private Date hire_date;
  private String address;
  private String city;
  private String region;
  private String postal_code;
  private String country;
  private String home_phone;
  private String extension;
  private byte[] photo;
  private String notes;
  private Short reports_to;
  private String photo_path;

  public Employee() {}

  public Short getId() { return id; }
  public Short getReportTo() { return reports_to; }
  public String getFirstName() { return first_name; }
  public String getLastName() { return last_name; }
  public String getTitle() { return title; }
  public String getTitleOfCourtesy() { return title_of_courtesy; }
  public Date getBirthDate() { return birth_date; }
  public Date getHireDate() { return hire_date; }
  public String getAddress() { return address; }
  public String getCity() { return city; }
  public String getRegion() { return region; }
  public String getPostalCode() { return postal_code; }
  public String getCountry() { return country; }
  public String getPhone() { return home_phone; }
  public String getExtension() { return extension; }
  public byte[] getPhoto() { return photo; }
  public String getNotes() { return notes; }
  public String getPhotoPath() { return photo_path; }

  public void setId(Short idtt) { id = idtt; }
  public void setReportTo(Short rpt) { reports_to = rpt; }
  public void setFirstName(String fn) { first_name = fn; }
  public void setLastName(String ln) { last_name = ln; }
  public void setTitle(String tt) { title = tt; }
  public void setTitleOfCourtesy(String toc) { title_of_courtesy = toc; }
  public void setBirthDate(Date bd) { birth_date = bd; }
  public void setHireDate(Date hd) { hire_date = hd; }
  public void setAddress(String addr) { address = addr; }
  public void setCity(String ct) { city = ct; }
  public void setRegion(String re) { region = re; }
  public void setPostalCode(String code) { postal_code = code; }
  public void setCountry(String cty) { country = cty; }
  public void setPhone(String number) { home_phone = number; }
  public void setExtension(String ext) { extension = ext; }
  public void setPhoto(byte[] img) { photo = img; }
  public void setNotes(String note) { notes = note; }
  public void setPhotoPath(String path) { photo_path = path; }
}
