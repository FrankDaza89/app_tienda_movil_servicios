package ec.tienda.movil.almacen.modelo;
// Generated 09/11/2017 16:57:53 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Entrada generated by hbm2java
 */
public class Entrada  implements java.io.Serializable {


     private Integer idEntrada;
     private Producto producto;
     private Date fecha;
     private String precioNeto;
     private String precioUnitario;
     private String precio;
     private String unidad;

    public Entrada() {
    }

	
    public Entrada(Producto producto) {
        this.producto = producto;
    }
    public Entrada(Producto producto, Date fecha, String precioNeto, String precioUnitario, String precio, String unidad) {
       this.producto = producto;
       this.fecha = fecha;
       this.precioNeto = precioNeto;
       this.precioUnitario = precioUnitario;
       this.precio = precio;
       this.unidad = unidad;
    }
   
    public Integer getIdEntrada() {
        return this.idEntrada;
    }
    
    public void setIdEntrada(Integer idEntrada) {
        this.idEntrada = idEntrada;
    }
    public Producto getProducto() {
        return this.producto;
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getPrecioNeto() {
        return this.precioNeto;
    }
    
    public void setPrecioNeto(String precioNeto) {
        this.precioNeto = precioNeto;
    }
    public String getPrecioUnitario() {
        return this.precioUnitario;
    }
    
    public void setPrecioUnitario(String precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    public String getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(String precio) {
        this.precio = precio;
    }
    public String getUnidad() {
        return this.unidad;
    }
    
    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }




}


