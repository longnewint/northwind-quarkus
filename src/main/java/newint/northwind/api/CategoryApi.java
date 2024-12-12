package newint.northwind.api;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import newint.northwind.data.repo.CategoryRepo;
import newint.northwind.entity.Category;

@Path("/category")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoryApi {
  @Inject CategoryRepo repo;

  @GET
  public List<Category> get() {
    return repo.find();
  }

  @GET
  @Path("/{id}")
  public Category get(Short id) {
    return repo.find(id);
  }
}
