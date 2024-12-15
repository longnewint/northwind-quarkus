package newint.northwind.api;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import newint.northwind.data.repo.CustomerRepo;
import newint.northwind.entity.Customer;

@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerApi {
  @Inject CustomerRepo repo;

  @GET
  public List<Customer> get() {
    return repo.find();
  }

  @GET
  @Path("/{id}")
  public Customer get(String id) {
    return repo.find(id);
  }

  @POST
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  public String post(@BeanParam CustomerFormParam param) {
    Customer c = new Customer(param.id, param.company, param.name, param.title, param.address,
    param.city, param.region, param.postal_code, param.country, param.phone, param.fax);

    repo.add(c);

    return "ok";
  }

  @DELETE
  @Path("/{id}")
  public String delete(String id) {
    repo.remove(id);

    return "ok";
  }

  public static class CustomerFormParam {
    @FormParam("id") String id;
    @FormParam("company") String company;
    @FormParam("name") String name;
    @FormParam("title") String title;
    @FormParam("address") String address;
    @FormParam("city") String city;
    @FormParam("region") String region;
    @FormParam("postal_code") String postal_code;
    @FormParam("country") String country;
    @FormParam("phone") String phone;
    @FormParam("fax") String fax;
  }
}
