package ec.tienda.movil.financiero.modelo;
// Generated 09/11/2017 16:36:03 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * ClientePago generated by hbm2java
 */
public class ClientePago implements java.io.Serializable {

    private Integer idCliente;
    private String identificacionClienteP;
    private Set ventas = new HashSet(0);

    public ClientePago() {
    }

    public ClientePago(String identificacionClienteP, Set ventas) {
        this.identificacionClienteP = identificacionClienteP;
        this.ventas = ventas;
    }

    public Integer getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdentificacionClienteP() {
        return this.identificacionClienteP;
    }

    public void setIdentificacionClienteP(String identificacionClienteP) {
        this.identificacionClienteP = identificacionClienteP;
    }

    public Set getVentas() {
        return this.ventas;
    }

    public void setVentas(Set ventas) {
        this.ventas = ventas;
    }

}
