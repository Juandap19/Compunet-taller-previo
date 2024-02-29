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
@Table(name = "cliente")
public class Cliente {

    @Id
    @Column(name = "id_clie", nullable = false)
    private Integer idClie;
    @Column(name = "numero_identificacion", nullable = false)
    private String numeroIdentificacion;
    @Column(name = "primer_apellido", nullable = false)
    private String primerApellido;
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    @Column(name = "nombre", nullable = false)
    private Date nombre;
    @Column(name = "telefono1")
    private Date telefono1;
    @Column(name = "telefono2")
    private String telefono2;
    @Column(name = "correo")
    private String correo;
    @Column(name = "sexo", nullable = false)
    private String sexo;
    @Column(name = "fecha_nacimiento", nullable = false)
    private String fechaNacimiento;
    @Column(name = "fecha_creacion", nullable = false)
    private String fechaCreacion;
    @Column(name = "fecha_modificacion")
    private String fechaModificacion;
    @Column(name = "usu_creador", nullable = false)
    private String usuCreador;
    @Column(name = "usu_modificador")
    private String usuModificador;
    @Column(name = "estado", nullable = false)
    private String estado;
    @Column(name = "id_tiid", nullable = false)
    private String idTiid;

}
