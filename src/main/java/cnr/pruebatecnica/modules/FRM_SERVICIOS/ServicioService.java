package cnr.pruebatecnica.modules.FRM_SERVICIOS;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import cnr.pruebatecnica.modules.FRM_CONTADOR.ContadorService;
import cnr.pruebatecnica.responses.ResponseAPIs;



//=================================================================================================
// SERVICE ----------------------------------------------------------------------------------------
//=================================================================================================



/**
 * Servicio para la gestión de servicios.
 * @author: PRUEBA TECNICA
 * @version: 1.0.0
 */
@ApplicationScoped
public class ServicioService {
    @Inject
    ServicioRepository repository;

    @Inject
    ContadorService contadorService;

    public List<ServicioEntity> findAll() {
        return repository.listAll();
    }

    public ServicioEntity findByCodigo(String codigo) {
        return repository.findByCodigo(codigo);
    }

    public List<ServicioEntity> findByDescripcion(String descripcion) {
        return repository.findByDescripcion(descripcion);
    }

    public List<ServicioEntity> findByActivo(BigDecimal activo) {
        return repository.findByActivo(activo);
    }

    public List<ServicioEntity> findActivos() {
        return repository.findActivos();
    }

    @Transactional
    public List<ServicioEntity> readAllServicios() {

        //RETRIEVE - DATA -------------------------------------------------------------------------

        List<ServicioEntity> servicios = repository.listAll();

        if (servicios == null || servicios.isEmpty()) {
            throw new ResponseAPIs.Error("No se encontraron servicios");
        }

        //RETURN - DATA ---------------------------------------------------------------------------

        return servicios;
    }

    @Transactional
    public ServicioEntity readServicioByCodigo(String codigo) {

        //VALIDATIONS - PARAMS --------------------------------------------------------------------

        if (codigo == null || codigo.isEmpty()) {
            throw new ResponseAPIs.Error("El código del servicio es requerido");
        }

        //RETRIEVE - DATA -------------------------------------------------------------------------

        ServicioEntity servicio = repository.findByCodigo(codigo);

        if (servicio == null) {
            throw new ResponseAPIs.Error("No se encontró el servicio con código: " + codigo);
        }

        //RETURN - DATA ---------------------------------------------------------------------------

        return servicio;
    }

    @Transactional
    public List<ServicioEntity> readServiciosByDescripcion(String descripcion) {

        //VALIDATIONS - PARAMS --------------------------------------------------------------------

        if (descripcion == null || descripcion.isEmpty()) {
            throw new ResponseAPIs.Error("La descripción del servicio es requerida");
        }

        //RETRIEVE - DATA -------------------------------------------------------------------------

        List<ServicioEntity> servicios = repository.findByDescripcion(descripcion);

        if (servicios == null || servicios.isEmpty()) {
            throw new ResponseAPIs.Error("No se encontraron servicios con la descripción: " + descripcion);
        }

        //RETURN - DATA ---------------------------------------------------------------------------

        return servicios;
    }

    @Transactional
    public ServicioEntity crearServicio(ServicioEntity servicio) {
        // Obtiene el próximo ID desde la tabla CONTADOR para "SERVICIOS"
        BigDecimal nuevoId = contadorService.obtenerSiguienteId("SERVICIOS");
        servicio.setCodigo(nuevoId.toString()); // CODIGO es VARCHAR2, así que convertimos a String
        repository.persist(servicio);
        return servicio;
    }
}
