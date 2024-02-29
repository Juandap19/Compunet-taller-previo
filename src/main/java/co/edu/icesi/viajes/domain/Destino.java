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
@Table(name = "destino")
public class Destino {

    @Id
    @Column(name = "id_dest", nullable = false)
    private Integer idDest;
    @Column(name = "codigo", nullable = false)
    private String codigo;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    @Column(name = "tierra", nullable = false)
    private Date tierra;
    @Column(name = "aire", nullable = false)
    private Date aire;
    @Column(name = "mar", nullable = false)
    private String mar;
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
    @Column(name = "id_tide", nullable = false)
    private String idTide;

}
