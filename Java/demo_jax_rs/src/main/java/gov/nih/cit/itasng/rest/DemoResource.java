package gov.nih.cit.itasng.rest;

import gov.nih.cit.itasng.domain.DemoResult;
import java.util.ArrayList;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Path("demo")
@Produces(MediaType.APPLICATION_JSON)
@Component
@RequiredArgsConstructor
@Slf4j
public class DemoResource extends RestResource {

  //  private static final String DEMO_SP = "tmp_demo_args";

  //region Injected beans (via a RequiredArgsConstructor). Auto-wired by Spring 4.3+.
  //  @Nonnull private final StoredProcRepository repository;
  //  String UNEXPECTED_ERROR_MSG = "Unexpected error";
  //  protected String JAX_RS_UNEXPECTED_ERROR_MSG = "Invalid request";
  //endregion

  /**
   * Retrieves a demo record using the demo stored procedure returning a result set (from SELECT)
   *
   * @param i an integer
   * @return a hitlist consisting of a single record
   */
  @GET
  public Response render(@QueryParam("i") @DefaultValue("35") String i, @Context UriInfo uriInfo,
      @Context Request request) {
    /*List<DemoResult> hitList = repository.queryViaMsSqlStoredProc(DEMO_SP, DemoResult.class, //
        "Foo", // Returns doubled argument
        i, // Returns argument + 1
        false, //true = 1, // Returns NOT argument
        0, // = false //true = 1, // Returns NOT argument
        "y", //"Y" // Returns argument
        "1", // Returns argument
        new Date() // Returns argument
    );*/
    //    log.debug("Demo record: {}", hitList.get(0));
    var hitList = new ArrayList<DemoResult>();
    hitList.add(new DemoResult(1, "foo"));
//    throw new RuntimeException("Error!");
    return Response.ok(hitList).build();
  }
}