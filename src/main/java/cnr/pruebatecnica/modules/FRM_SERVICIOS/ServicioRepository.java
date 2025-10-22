package cnr.pruebatecnica.modules.FRM_SERVICIOS;

import java.util.List;
import java.math.BigDecimal;

import jakarta.enterprise.context.ApplicationScoped;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ServicioRepository implements PanacheRepository<ServicioEntity> {
    
/**
     * Busca un servicio por su código.
     */
    public ServicioEntity findByCodigo(String codigo) {
        return find("codigo", codigo).firstResult();
    }

    /**
     * Busca servicios por descripción (búsqueda parcial).
     */
    public List<ServicioEntity> findByDescripcion(String descripcion) {
        return find("descripcion like ?1", "%" + descripcion + "%").list();
    }

    /**
     * Busca servicios activos (activo = 1).
     */
    public List<ServicioEntity> findActivos() {
        return find("activo", BigDecimal.ONE).list();
    }

    /**
     * Busca servicios por estado de activo (1 o 0).
     */
    public List<ServicioEntity> findByActivo(BigDecimal activo) {
        return find("activo", activo).list();
    }
}
