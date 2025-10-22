package cnr.pruebatecnica.modules.FRM_CONTADOR;

import jakarta.persistence.*;
import java.math.BigDecimal;



//=================================================================================================
// ENTITY -----------------------------------------------------------------------------------------
//=================================================================================================



/**
 * Entidad de la tabla CONTADOR
 * @author: PRUEBA TECNICA
 * @version: 1.0.0
 * @since: 22/10/2025
 */
@Entity
@Table(name = "CONTADOR", schema = "MI_EVAL11")
public class ContadorEntity {

    @Id
    @Column(name = "CNT_ID")
    private BigDecimal cntId;

    @Column(name = "CNT_PK_TABLA", length = 20, nullable = false)
    private String cntPkTabla;

    @Column(name = "CNT_VALOR", nullable = false)
    private BigDecimal cntValor;

    @Column(name = "CNT_COMENTARIO", length = 300)
    private String cntComentario;



    //=============================================================================================
    // GETTERS AND SETTERS ------------------------------------------------------------------------
    //=============================================================================================


    
    public BigDecimal getCntId() {
        return cntId;
    }

    public void setCntId(BigDecimal cntId) {
        this.cntId = cntId;
    }

    public String getCntPkTabla() {
        return cntPkTabla;
    }

    public void setCntPkTabla(String cntPkTabla) {
        this.cntPkTabla = cntPkTabla;
    }

    public BigDecimal getCntValor() {
        return cntValor;
    }

    public void setCntValor(BigDecimal cntValor) {
        this.cntValor = cntValor;
    }

    public String getCntComentario() {
        return cntComentario;
    }

    public void setCntComentario(String cntComentario) {
        this.cntComentario = cntComentario;
    }
}