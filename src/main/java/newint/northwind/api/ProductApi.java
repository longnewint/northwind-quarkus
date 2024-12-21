package newint.northwind.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import newint.northwind.data.repo.ProductRepo;

@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductApi {
  @Inject ProductRepo repo;

  @GET
  public Response get() {
    return Response.ok(repo.find()).build();
  }

  @GET
  @Path("/{id}")
  public Response get(String id) {
    var optional = repo.find(id);

    if(optional.isEmpty())
      return Response.status(Status.NOT_FOUND).build();
    else
      return Response.status(Status.OK).entity(optional.get()).build();
  }
}
