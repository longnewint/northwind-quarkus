package newint.northwind.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import newint.northwind.core.UtilController;

@Path("/util")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UtilApi {
  @Inject UtilController utils;

  @PUT
  public String exec() {
    utils.exit();
    return "success";
  }
}
