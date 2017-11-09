package ec.tienda.movil.financiero.modelo;
// Generated 09/11/2017 16:36:03 by Hibernate Tools 4.3.1



/**
 * Efectivo generated by hbm2java
 */
public class Efectivo  implements java.io.Serializable {


     private Integer idEfectivo;
     private String identificadorEf;
     private String valorCambioEf;

    public Efectivo() {
    }

	
    public Efectivo(String identificadorEf) {
        this.identificadorEf = identificadorEf;
    }
    public Efectivo(String identificadorEf, String valorCambioEf) {
       this.identificadorEf = identificadorEf;
       this.valorCambioEf = valorCambioEf;
    }
   
    public Integer getIdEfectivo() {
        return this.idEfectivo;
    }
    
    public void setIdEfectivo(Integer idEfectivo) {
        this.idEfectivo = idEfectivo;
    }
    public String getIdentificadorEf() {
        return this.identificadorEf;
    }
    
    public void setIdentificadorEf(String identificadorEf) {
        this.identificadorEf = identificadorEf;
    }
    public String getValorCambioEf() {
        return this.valorCambioEf;
    }
    
    public void setValorCambioEf(String valorCambioEf) {
        this.valorCambioEf = valorCambioEf;
    }




}


