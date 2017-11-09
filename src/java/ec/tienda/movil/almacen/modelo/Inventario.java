package ec.tienda.movil.almacen.modelo;
// Generated 09/11/2017 16:57:53 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Inventario generated by hbm2java
 */
public class Inventario  implements java.io.Serializable {


     private Integer idStock;
     private Producto producto;
     private String unidadMax;
     private String unidadMin;
     private String stock;
     private Date fecha;
     private String precioEntradaT;
     private String precioSalidaT;

    public Inventario() {
    }

	
    public Inventario(Producto producto) {
        this.producto = producto;
    }
    public Inventario(Producto producto, String unidadMax, String unidadMin, String stock, Date fecha, String precioEntradaT, String precioSalidaT) {
       this.producto = producto;
       this.unidadMax = unidadMax;
       this.unidadMin = unidadMin;
       this.stock = stock;
       this.fecha = fecha;
       this.precioEntradaT = precioEntradaT;
       this.precioSalidaT = precioSalidaT;
    }
   
    public Integer getIdStock() {
        return this.idStock;
    }
    
    public void setIdStock(Integer idStock) {
        this.idStock = idStock;
    }
    public Producto getProducto() {
        return this.producto;
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public String getUnidadMax() {
        return this.unidadMax;
    }
    
    public void setUnidadMax(String unidadMax) {
        this.unidadMax = unidadMax;
    }
    public String getUnidadMin() {
        return this.unidadMin;
    }
    
    public void setUnidadMin(String unidadMin) {
        this.unidadMin = unidadMin;
    }
    public String getStock() {
        return this.stock;
    }
    
    public void setStock(String stock) {
        this.stock = stock;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getPrecioEntradaT() {
        return this.precioEntradaT;
    }
    
    public void setPrecioEntradaT(String precioEntradaT) {
        this.precioEntradaT = precioEntradaT;
    }
    public String getPrecioSalidaT() {
        return this.precioSalidaT;
    }
    
    public void setPrecioSalidaT(String precioSalidaT) {
        this.precioSalidaT = precioSalidaT;
    }




}


