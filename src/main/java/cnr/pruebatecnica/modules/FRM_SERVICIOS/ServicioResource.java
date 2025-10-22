package cnr.pruebatecnica.modules.FRM_SERVICIOS;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.math.BigDecimal;
import java.util.List;
import cnr.pruebatecnica.responses.ResponseAPIs;

@Path("/servicios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ServicioResource {
    @Inject
    ServicioService service;

    @GET
    public ResponseAPIs.Basic<List<ServicioEntity>> getAll() {
        ResponseAPIs.Basic<List<ServicioEntity>> response = new ResponseAPIs.Basic<List<ServicioEntity>>();

        try {
            List<ServicioEntity> servicios = service.readAllServicios();
            response.setSuccess(true);
            response.setMessage("Servicios encontrados correctamente");
            response.setData(servicios);
            return response;
        } catch (ResponseAPIs.Error e) {
            response.setSuccess(false);
            response.setMessage(e.getMessage());
            response.setData(null);
            return response;
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage("Error al obtener los servicios: " + e.getMessage());
            response.setData(null);
            return response;
        }
    }

    @GET
    @Path("/{codigo}")
    public ResponseAPIs.Basic<ServicioEntity> getByCodigo(@PathParam("codigo") String codigo) {
        ResponseAPIs.Basic<ServicioEntity> response = new ResponseAPIs.Basic<ServicioEntity>();

        try {
            ServicioEntity servicio = service.readServicioByCodigo(codigo);
            response.setSuccess(true);
            response.setMessage("Servicio encontrado correctamente");
            response.setData(servicio);
            return response;
        } catch (ResponseAPIs.Error e) {
            response.setSuccess(false);
            response.setMessage(e.getMessage());
            response.setData(null);
            return response;
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage("Error al obtener el servicio: " + e.getMessage());
            response.setData(null);
            return response;
        }
    }

    @GET
    @Path("/descripcion/{descripcion}")
    public ResponseAPIs.Basic<List<ServicioEntity>> getByDescripcion(@PathParam("descripcion") String descripcion) {
        ResponseAPIs.Basic<List<ServicioEntity>> response = new ResponseAPIs.Basic<List<ServicioEntity>>();

        try {
            List<ServicioEntity> servicios = service.readServiciosByDescripcion(descripcion);
            response.setSuccess(true);
            response.setMessage("Servicios encontrados correctamente");
            response.setData(servicios);
            return response;
        } catch (ResponseAPIs.Error e) {
            response.setSuccess(false);
            response.setMessage(e.getMessage());
            response.setData(null);
            return response;
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage("Error al obtener los servicios: " + e.getMessage());
            response.setData(null);
            return response;
        }
    }

    @GET
    @Path("/activo/{activo}")
    public ResponseAPIs.Basic<List<ServicioEntity>> getByActivo(@PathParam("activo") BigDecimal activo) {
        ResponseAPIs.Basic<List<ServicioEntity>> response = new ResponseAPIs.Basic<List<ServicioEntity>>();

        try {
            List<ServicioEntity> servicios = service.findByActivo(activo);
            response.setSuccess(true);
            response.setMessage("Servicios encontrados correctamente");
            response.setData(servicios);
            return response;
        } catch (ResponseAPIs.Error e) {
            response.setSuccess(false);
            response.setMessage(e.getMessage());
            response.setData(null);
            return response;
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage("Error al obtener los servicios: " + e.getMessage());
            response.setData(null);
            return response;
        }
    }

    @POST
    public Response create(ServicioEntity servicio) {
        try {
            ServicioEntity nuevo = service.crearServicio(servicio);
            return Response.status(Response.Status.CREATED).entity(nuevo).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("{\"error\": \"Error al crear el servicio: " + e.getMessage() + "\"}")
                           .build();
        }
    }
}
