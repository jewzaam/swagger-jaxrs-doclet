package fixtures.jaxb;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/jaxb")
public class JaxbResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel get() {
        return new ResponseModel();
    }

    @POST
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response create(PayloadModel payload) {
        return Response.ok().build();
    }
}
