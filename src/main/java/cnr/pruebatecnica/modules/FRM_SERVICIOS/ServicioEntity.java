package cnr.pruebatecnica.modules.FRM_SERVICIOS;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import java.math.BigDecimal;



//=================================================================================================
// ENTITY -----------------------------------------------------------------------------------------
//=================================================================================================



/**
 * Entidad de la tabla SERVICIOS
 * @author: PRUEBA TECNICA
 * @version: 1.0.0
 * @since: 22/10/2025
 */
@Entity
@Table(name = "SERVICIOS", schema = "MI_EVAL11")
public class ServicioEntity {

    @Id
    @Column(name = "CODIGO", length = 10, nullable = false)
    private String codigo;

    @Column(name = "DESCRIPCION", length = 100)
    private String descripcion;

    @Column(name = "ACTIVO", precision = 38, scale = 0, columnDefinition = "NUMBER(38,0) DEFAULT 1")
    private BigDecimal activo;


    
    //=============================================================================================
    // GETTERS AND SETTERS ------------------------------------------------------------------------
    //=============================================================================================



    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getActivo() {
        return activo;
    }

    public void setActivo(BigDecimal activo) {
        this.activo = activo;
    }
}