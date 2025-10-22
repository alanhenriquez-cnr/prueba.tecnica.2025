package cnr.pruebatecnica.modules.FRM_PRESENTACION;

import jakarta.inject.Inject;

import java.time.LocalDate;
import java.util.List;
import cnr.pruebatecnica.modules.FRM_CONTADOR.ContadorService;
import cnr.pruebatecnica.responses.ResponseAPIs;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;


//=================================================================================================
// SERVICE ----------------------------------------------------------------------------------------
//=================================================================================================



/**
 * Servicio para la gestión de presentaciones.
 * @author: PRUEBA TECNICA
 * @version: 1.0.0
 */
@ApplicationScoped
public class PresentacionService {
    
    @Inject
    PresentacionRepository repository;

    @Inject
    ContadorService contadorService;

    public List<PresentacionEntity> findAll() {
        return repository.listAll();
    }

    public PresentacionEntity findByNumero(String numero) {
        return repository.findByNumero(numero);
    }

    public List<PresentacionEntity> findByTipoServicio(String tipoServicio) {
        return repository.findByTipoServicio(tipoServicio);
    }

    public List<PresentacionEntity> findByFechaRange(LocalDate inicio, LocalDate fin) {
        return repository.findByFechaRange(inicio, fin);
    }

    @Transactional
    public PresentacionEntity readPresentacionByNumero(String numero) {

        //VALIDATIONS - PARAMS --------------------------------------------------------------------

        if (numero == null || numero.isEmpty()) {
            throw new ResponseAPIs.Error("El número de la presentación es requerido");
        }

        //RETRIEVE - DATA -------------------------------------------------------------------------

        PresentacionEntity presentacion = repository.findByNumero(numero);

        if (presentacion == null) {
            throw new ResponseAPIs.Error("No se encontró la presentación con el número: " + numero);
        }

        //RETURN - DATA ---------------------------------------------------------------------------

        return presentacion;
    }

    @Transactional
    public List<PresentacionEntity> readPresentacionesByTipoServicio(String tipoServicio) {

        //VALIDATIONS - PARAMS --------------------------------------------------------------------

        if (tipoServicio == null || tipoServicio.isEmpty()) {
            throw new ResponseAPIs.Error("El tipo de servicio es requerido");
        }

        //RETRIEVE - DATA -------------------------------------------------------------------------

        List<PresentacionEntity> presentaciones = repository.findByTipoServicio(tipoServicio);

        if (presentaciones == null || presentaciones.isEmpty()) {
            throw new ResponseAPIs.Error("No se encontraron presentaciones para el tipo de servicio: " + tipoServicio);
        }

        //RETURN - DATA ---------------------------------------------------------------------------

        return presentaciones;
    }

    @Transactional
    public List<PresentacionEntity> readPresentacionesByRangoFechas(LocalDate fechaInicio, LocalDate fechaFin) {

        //VALIDATIONS - PARAMS --------------------------------------------------------------------

        if (fechaInicio == null) {
            throw new ResponseAPIs.Error("La fecha de inicio es requerida");
        }

        if (fechaFin == null) {
            throw new ResponseAPIs.Error("La fecha de fin es requerida");
        }

        if (fechaInicio.isAfter(fechaFin)) {
            throw new ResponseAPIs.Error("La fecha de inicio no puede ser posterior a la fecha de fin");
        }

        //RETRIEVE - DATA -------------------------------------------------------------------------

        List<PresentacionEntity> presentaciones = repository.findByFechaRange(fechaInicio, fechaFin);

        if (presentaciones == null || presentaciones.isEmpty()) {
            throw new ResponseAPIs.Error("No se encontraron presentaciones en el rango de fechas especificado");
        }

        //RETURN - DATA ---------------------------------------------------------------------------

        return presentaciones;
    }
}
