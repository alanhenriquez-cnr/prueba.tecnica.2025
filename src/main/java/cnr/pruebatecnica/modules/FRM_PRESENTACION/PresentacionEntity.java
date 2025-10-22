package cnr.pruebatecnica.modules.FRM_PRESENTACION;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;



//=================================================================================================
// ENTITY -----------------------------------------------------------------------------------------
//=================================================================================================



/**
 * Entidad de la tabla PRESENTACION
 * @author: PRUEBA TECNICA
 * @version: 1.0.0
 * @since: 22/10/2025
 */
@Entity
@Table(name = "PRESENTACION", schema = "MI_EVAL11")
public class PresentacionEntity {



    @Id
    @Column(name = "PRE_ID")
    private BigDecimal preId;

    @Column(name = "PRE_NUMERO", length = 10)
    private String preNumero;

    @Column(name = "PRE_FECHA")
    private LocalDate preFecha;

    @Column(name = "PRE_SOLICITANTE", length = 200)
    private String preSolicitante;

    @Column(name = "PRE_SERVICIO", length = 100)
    private String preServicio;

    @Column(name = "PRE_ESTADO", length = 1, columnDefinition = "VARCHAR2(1) DEFAULT 'I'")
    private String preEstado;

    @Column(name = "PRE_ENVIADO")
    private BigDecimal preEnviado;



    //=============================================================================================
    // GETTERS AND SETTERS ------------------------------------------------------------------------
    //=============================================================================================



    public BigDecimal getPreId() {
        return preId;
    }

    public void setPreId(BigDecimal preId) {
        this.preId = preId;
    }

    public String getPreNumero() {
        return preNumero;
    }

    public void setPreNumero(String preNumero) {
        this.preNumero = preNumero;
    }

    public LocalDate getPreFecha() {
        return preFecha;
    }

    public void setPreFecha(LocalDate preFecha) {
        this.preFecha = preFecha;
    }

    public String getPreSolicitante() {
        return preSolicitante;
    }

    public void setPreSolicitante(String preSolicitante) {
        this.preSolicitante = preSolicitante;
    }

    public String getPreServicio() {
        return preServicio;
    }

    public void setPreServicio(String preServicio) {
        this.preServicio = preServicio;
    }

    public String getPreEstado() {
        return preEstado;
    }

    public void setPreEstado(String preEstado) {
        this.preEstado = preEstado;
    }

    public BigDecimal getPreEnviado() {
        return preEnviado;
    }

    public void setPreEnviado(BigDecimal preEnviado) {
        this.preEnviado = preEnviado;
    }
}