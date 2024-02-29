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
@Table(name = "tipo_identificacion")
public class TipoIdentificacion {

    @Id
    @Column(name = "id_tiid", nullable = false)
    private Integer idTiid;
    @Column(name = "codigo", nullable = false)
    private String codigo;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "fecha_creacion", nullable = false)
    private String fechaCreacion;
    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;
    @Column(name = "usu_creador", nullable = false)
    private String usuCreador;
    @Column(name = "usu_modificador")
    private String usuModificador;
    @Column(name = "estado", nullable = false)
    private String estado;
    @Column(name = "id_clie", nullable = false)
    private String idClie;
    @Column(name = "id_usua", nullable = false)
    private String idUsua;

}
