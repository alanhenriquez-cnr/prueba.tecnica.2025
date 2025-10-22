package cnr.pruebatecnica.modules.FRM_CONTADOR;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.math.BigDecimal;

import cnr.pruebatecnica.responses.ResponseAPIs;



//=================================================================================================
// SERVICE ----------------------------------------------------------------------------------------
//=================================================================================================



/**
 * Servicio para obtener el próximo ID para las tablas de la base de datos.
 * @author: PRUEBA TECNICA
 * @version: 1.0.0
 */
@ApplicationScoped
public class ContadorService {

    //=============================================================================================
    // INJECTIONS ---------------------------------------------------------------------------------
    //=============================================================================================

    @Inject
    private ContadorRepository contadorRepository;



    //=============================================================================================
    // METHODS - OBTENER SIGUIENTE ID -------------------------------------------------------------
    //=============================================================================================



    /**
     * Obtiene el próximo ID para la tabla especificada.
     * @param nombreTabla Nombre de la tabla (ej: "PRESENTACION", "SERVICIOS")
     * @return El próximo ID (valor actual + 1)
     */
    @Transactional
    public BigDecimal obtenerSiguienteId(String nombreTabla) {



        //VALIDATIONS - PARAMS --------------------------------------------------------------------



        if (nombreTabla == null || nombreTabla.isEmpty()) {
            throw new ResponseAPIs.Error("El nombre de la tabla es requerido");
        }

        

        //RETRIEVE - DATA -------------------------------------------------------------------------



        ContadorEntity contador = contadorRepository.findByPkTabla(nombreTabla);
        if (contador == null) {
            throw new ResponseAPIs.Error("No se encontró el contador para la tabla: " + nombreTabla);
        }



        //PERSIST - DATA --------------------------------------------------------------------------



        contador.setCntValor(contador.getCntValor().add(BigDecimal.ONE));
        contadorRepository.persist(contador);



        //RETURN - DATA ---------------------------------------------------------------------------


        
        return contador.getCntValor();
    }



    //=============================================================================================
    // METHODS - NEXT ID --------------------------------------------------------------------------
    //=============================================================================================



    public BigDecimal nextIdPRESENTACION() {
        return obtenerSiguienteId("PRESENTACION");
    }

    public BigDecimal nextIdSERVICIO() {
        return obtenerSiguienteId("SERVICIO");
    }

}