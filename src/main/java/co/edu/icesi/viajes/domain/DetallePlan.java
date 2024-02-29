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
@Table(name = "detalle_plan")
public class DetallePlan {

    @Id
    @Column(name = "id_depl", nullable = false)
    private Integer idDepl;
    @Column(name = "alimentacion", nullable = false)
    private String alimentacion;
    @Column(name = "hospedaje", nullable = false)
    private String hospedaje;
    @Column(name = "transporte", nullable = false)
    private String transporte;
    @Column(name = "traslados", nullable = false)
    private Date traslados;
    @Column(name = "valor", nullable = false)
    private Date valor;
    @Column(name = "cantidad_noches", nullable = false)
    private String cantidadNoches;
    @Column(name = "cantidad_dias", nullable = false)
    private String cantidadDias;
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
    @Column(name = "id_plan", nullable = false)
    private String idPlan;
    @Column(name = "id_dest", nullable = false)
    private String idDest;

}
