package newint.northwind.api;

import java.util.List;

import org.jboss.resteasy.reactive.RestForm;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
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
  public String post(@RestForm String id, @RestForm String company, @RestForm String name,
  @RestForm String title, @RestForm String address, @RestForm String city, @RestForm String region,
  @RestForm String postal_code, @RestForm String country, @RestForm String phone, @RestForm String fax) {
    Customer c = new Customer(id, company, name, title, address, city, region, postal_code,
      country, phone, fax);
    repo.add(c);

    return "ok";
  }

  @DELETE
  @Path("/{id}")
  public String delete(String id) {
    repo.remove(id);

    return "ok";
  }
}
