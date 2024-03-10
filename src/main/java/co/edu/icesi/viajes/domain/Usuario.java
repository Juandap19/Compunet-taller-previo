package co.edu.icesi.viajes.domain;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;


import java.util.Date;


@Data
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @Column(name = "id_usua", nullable = false)
    private Integer idUsua;
    @Column(name = "login", nullable = false)
    private String login;
    @Column(name = "password_", nullable = false)
    private String password_;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "identificacion", nullable = false)
    private Date identificacion;
    @Column(name = "fecha_creacion", nullable = false)
    private Date fecha_creacion;
    @Column(name = "fecha_modificacion")
    private String fechaModificacion;
    @Column(name = "usu_creador", nullable = false)
    private String usuCreador;
    @Column(name = "usu_modificador")
    private String usuModificador;
    @Column(name = "estado", nullable = false)
    private String estado;

}
