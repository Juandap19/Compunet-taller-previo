package co.edu.icesi.viajes.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
public class ClienteDTO implements Serializable {

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
    private double pp;
    private double sumatoriaPagos;


    public ClienteDTO(Integer idClie, String numeroIdentificacion, String primerApellido, String segundoApellido, String nombre, String telefono1, String telefono2, String correo, String sexo, Date fechaNacimiento, String usuCreador, String estado) {
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

    public ClienteDTO(String numero_identificacion, String nombre, String estado, Integer id_tiid) {
        this.numeroIdentificacion = numero_identificacion;
        this.nombre = nombre;
        this.estado = estado;
        this.idTiid =id_tiid;
    }

    public ClienteDTO(String nombre, Date fechaCreacion, Double sumatoriaPagos) {
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.sumatoriaPagos = sumatoriaPagos;
    }
}