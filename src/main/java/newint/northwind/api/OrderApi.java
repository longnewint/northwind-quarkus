package newint.northwind.api;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import newint.northwind.data.repo.OrderRepo;
import newint.northwind.entity.Order;

@Path("/order")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OrderApi {
  @Inject OrderRepo repo;

  @GET
  public List<Order> get() {
    return repo.find();
  }

  @GET
  @Path("/{id}")
  public Order get(String id) {
    return repo.find(id);
  }
}
