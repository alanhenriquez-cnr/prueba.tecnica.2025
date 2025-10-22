package cnr.pruebatecnica.modules.FRM_PRESENTACION;

import java.time.LocalDate;
import java.util.List;

import cnr.pruebatecnica.responses.ResponseAPIs;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;



@Path("/presentaciones")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PresentacionResource {
    @Inject
    PresentacionService service;


    /**
     * Obtiene una presentación por su número.
     */
    @GET
    @Path("/numero/{numero}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseAPIs.Basic<PresentacionEntity> getByNumero(@PathParam("numero") String numero) {
        ResponseAPIs.Basic<PresentacionEntity> response = new ResponseAPIs.Basic<PresentacionEntity>();

        try {
            PresentacionEntity presentacion = service.readPresentacionByNumero(numero);
            response.setSuccess(true);
            response.setMessage("Presentación encontrada correctamente");
            response.setData(presentacion);
            return response;
        } catch (ResponseAPIs.Error e) {
            response.setSuccess(false);
            response.setMessage(e.getMessage());
            response.setData(null);
            return response;
        }
        catch (Exception e) {
            throw new ResponseAPIs.Error("Error al obtener la presentación: " + e.getMessage());
        }
    }

    /**
     * Obtiene presentaciones por tipo de servicio.
     */
    @GET
    @Path("/servicio/{tipoServicio}")
    public ResponseAPIs.Basic<List<PresentacionEntity>> getByTipoServicio(@PathParam("tipoServicio") String tipoServicio) {
        ResponseAPIs.Basic<List<PresentacionEntity>> response = new ResponseAPIs.Basic<List<PresentacionEntity>>();

        try {
            List<PresentacionEntity> presentaciones = service.readPresentacionesByTipoServicio(tipoServicio);
            response.setSuccess(true);
            response.setMessage("Presentaciones encontradas correctamente");
            response.setData(presentaciones);
            return response;
        } catch (ResponseAPIs.Error e) {
            response.setSuccess(false);
            response.setMessage(e.getMessage());
            response.setData(null);
            return response;
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage("Error al obtener las presentaciones: " + e.getMessage());
            response.setData(null);
            return response;
        }
    }

    /**
     * Obtiene presentaciones por rango de fechas.
     */
    @GET
    @Path("/fecha")
    public ResponseAPIs.Basic<List<PresentacionEntity>> getByFechaRange(
            @QueryParam("inicio") LocalDate inicio,
            @QueryParam("fin") LocalDate fin) {
        ResponseAPIs.Basic<List<PresentacionEntity>> response = new ResponseAPIs.Basic<List<PresentacionEntity>>();

        try {
            List<PresentacionEntity> presentaciones = service.readPresentacionesByRangoFechas(inicio, fin);
            response.setSuccess(true);
            response.setMessage("Presentaciones encontradas correctamente");
            response.setData(presentaciones);
            return response;
        } catch (ResponseAPIs.Error e) {
            response.setSuccess(false);
            response.setMessage(e.getMessage());
            response.setData(null);
            return response;
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage("Error al obtener las presentaciones: " + e.getMessage());
            response.setData(null);
            return response;
        }
    }

}
