package co.edu.icesi.viajes.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;


@Data
@Entity
@Table(name="tipo_destino")
public class TipoDestino {
    @Id
    @Column(name = "id_tide")
    private Integer idTide;
    @Column(name = "codigo", nullable = false)
    private String codigo;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha_creacion")
    private Date fechaCreacion;
    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;
    @Column(name = "usu_creador")
    private String usuCreador;
    @Column(name = "usu_modificador")
    private String usuModificador;
    @Column(name = "estado")
    private String estado;

}
