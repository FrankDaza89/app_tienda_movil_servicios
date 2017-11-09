package ec.tienda.movil.usuario.modelo;
// Generated 09/11/2017 16:19:18 by Hibernate Tools 4.3.1



/**
 * Ubicacion generated by hbm2java
 */
public class Ubicacion  implements java.io.Serializable {


     private Integer idUbicacion;
     private DatosUsuario datosUsuario;
     private Sector sector;
     private String direccion;
     private String referenciaDireccion;
     private String tipoDireccion;

    public Ubicacion() {
    }

	
    public Ubicacion(DatosUsuario datosUsuario, Sector sector) {
        this.datosUsuario = datosUsuario;
        this.sector = sector;
    }
    public Ubicacion(DatosUsuario datosUsuario, Sector sector, String direccion, String referenciaDireccion, String tipoDireccion) {
       this.datosUsuario = datosUsuario;
       this.sector = sector;
       this.direccion = direccion;
       this.referenciaDireccion = referenciaDireccion;
       this.tipoDireccion = tipoDireccion;
    }
   
    public Integer getIdUbicacion() {
        return this.idUbicacion;
    }
    
    public void setIdUbicacion(Integer idUbicacion) {
        this.idUbicacion = idUbicacion;
    }
    public DatosUsuario getDatosUsuario() {
        return this.datosUsuario;
    }
    
    public void setDatosUsuario(DatosUsuario datosUsuario) {
        this.datosUsuario = datosUsuario;
    }
    public Sector getSector() {
        return this.sector;
    }
    
    public void setSector(Sector sector) {
        this.sector = sector;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getReferenciaDireccion() {
        return this.referenciaDireccion;
    }
    
    public void setReferenciaDireccion(String referenciaDireccion) {
        this.referenciaDireccion = referenciaDireccion;
    }
    public String getTipoDireccion() {
        return this.tipoDireccion;
    }
    
    public void setTipoDireccion(String tipoDireccion) {
        this.tipoDireccion = tipoDireccion;
    }




}

