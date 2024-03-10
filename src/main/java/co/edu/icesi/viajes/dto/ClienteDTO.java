package co.edu.icesi.viajes.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
public class ClientDTO implements Serializable {

    private Integer idClie;
    private String numeroIdentificacion;
    private String primerApellido;
    private String segundoApellido;
    private String nombre;
    private String telefono1;
    private String telefono2;
    private String correo;
    private String sexo;
    private Date fechaNacimiento;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private String usuCreador;
    private String usuModificador;
    private String estado;
    private Integer idTiid;

    public ClientDTO(String sexo) {
        this.sexo = sexo;
    }

    public ClientDTO(Integer idClie, String numeroIdentificacion, String primerApellido, String segundoApellido, String nombre, String telefono1, String telefono2, String correo, String sexo, Date fechaNacimiento, String usuCreador,String estado) {
        this.idClie = idClie;
        this.numeroIdentificacion = numeroIdentificacion;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.nombre = nombre;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.correo = correo;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.usuCreador = usuCreador;
        this.estado = estado;
    }

    //    public ClientDTO(Integer idClie, String numeroIdentificacion, String primerApellido, String segundoApellido, String nombre, String telefono1, String telefono2, String correo, String sexo, Date fechaNacimiento, Date fechaCreacion, Date fechaModificacion, String usuCreador, String estado, Integer idTiid) {
//        this.idClie = idClie;
//        this.numeroIdentificacion = numeroIdentificacion;
//        this.primerApellido = primerApellido;
//        this.segundoApellido = segundoApellido;
//        this.nombre = nombre;
//        this.telefono1 = telefono1;
//        this.telefono2 = telefono2;
//        this.correo = correo;
//        this.sexo = sexo;
//        this.fechaNacimiento = fechaNacimiento;
//        this.fechaCreacion = fechaCreacion;
//        this.fechaModificacion = fechaModificacion;
//        this.usuCreador = usuCreador;
//        this.estado = estado;
//        this.idTiid = idTiid;
//    }
}