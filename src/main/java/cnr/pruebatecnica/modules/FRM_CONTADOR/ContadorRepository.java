package cnr.pruebatecnica.modules.FRM_CONTADOR;

import jakarta.enterprise.context.ApplicationScoped;
import io.quarkus.hibernate.orm.panache.PanacheRepository;



//=================================================================================================
// REPOSITORY -------------------------------------------------------------------------------------
//=================================================================================================



/**
 * Repositorio para la entidad Contador.
 * @author: PRUEBA TECNICA
 * @version: 1.0.0
 */
@ApplicationScoped
public class ContadorRepository implements PanacheRepository<ContadorEntity> {

    /**
     * Busca un contador por su clave primaria de tabla.
     * @param pkTabla El nombre de la tabla (ej: "PRESENTACION")
     * @return La entidad Contador o null si no existe
     */
    public ContadorEntity findByPkTabla(String pkTabla) {
        return find("cntPkTabla", pkTabla).firstResult();
    }
}