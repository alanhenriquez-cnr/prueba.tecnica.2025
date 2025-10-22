package cnr.pruebatecnica.modules.FRM_PRESENTACION;

import jakarta.enterprise.context.ApplicationScoped;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import java.time.LocalDate;
import java.util.List;



@ApplicationScoped
public class PresentacionRepository implements PanacheRepository<PresentacionEntity> {
    /**
        * Busca una presentación por su número.
     * @param numero El número de la presentación.
     * @return La presentación o null si no existe.
     */
    public PresentacionEntity findByNumero(String numero) {
        return find("preNumero", numero).firstResult();
    }

    /**
     * Busca presentaciones por tipo de servicio.
     * @param tipoServicio El tipo de servicio de las presentaciones.
     * @return Lista de presentaciones que coinciden con el tipo de servicio.
     */
    public List<PresentacionEntity> findByTipoServicio(String tipoServicio) {
        return find("preServicio", tipoServicio).list();
    }

    /**
     * Busca presentaciones por rango de fechas.
     * @param startDate La fecha de inicio.
     * @param endDate La fecha de fin.
     * @return Lista de presentaciones en el rango de fechas.
     */
    public List<PresentacionEntity> findByFechaRange(LocalDate startDate, LocalDate endDate) {
        return find("preFecha BETWEEN ?1 AND ?2", startDate, endDate).list();
    }   
}
