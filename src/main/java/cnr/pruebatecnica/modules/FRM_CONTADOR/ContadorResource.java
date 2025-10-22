package cnr.pruebatecnica.modules.FRM_CONTADOR;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import cnr.pruebatecnica.responses.ResponseAPIs;
import java.math.BigDecimal;
import jakarta.ws.rs.Consumes;



@Path("/contador")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContadorResource {
    
    

    @Inject
    private ContadorService contadorService;



    //=============================================================================================
    // METHODS - OBTENER SIGUIENTE ID -------------------------------------------------------------
    //=============================================================================================



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseAPIs.Basic<BigDecimal> obtenerSiguienteId(@QueryParam("nombreTabla") String nombreTabla) {
        return new ResponseAPIs.Basic<BigDecimal>(contadorService.obtenerSiguienteId(nombreTabla));
    }



    //=============================================================================================
    // METHODS - NEXT ID --------------------------------------------------------------------------
    //=============================================================================================



    @GET
    @Path("/nextIdPRESENTACION")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseAPIs.Basic<BigDecimal> nextIdPRESENTACION() {
        return new ResponseAPIs.Basic<BigDecimal>(contadorService.nextIdPRESENTACION());
    }

    @GET
    @Path("/nextIdSERVICIO")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseAPIs.Basic<BigDecimal> nextIdSERVICIO() {
        return new ResponseAPIs.Basic<BigDecimal>(contadorService.nextIdSERVICIO());
    }
}