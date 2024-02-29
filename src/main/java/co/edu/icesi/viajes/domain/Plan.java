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
@Table(name = "plan")
public class Plan {

    @Id
    @Column(name = "id_plan", nullable = false)
    private Integer idPlan;
    @Column(name = "codigo", nullable = false)
    private String codigo;
    @Column(name = "descripcion_solicitud", nullable = false)
    private String descripcionSolicitud;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "cantidad_personas", nullable = false)
    private Date cantidadPersonas;
    @Column(name = "fecha_solicitud", nullable = false)
    private Date fechaSolicitud;
    @Column(name = "fecha_inicio_viaje")
    private String fechaInicioViaje;
    @Column(name = "fecha_fin_viaje")
    private String fechaFinViaje;
    @Column(name = "valor_total", nullable = false)
    private String valorTotal;
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
    @Column(name = "id_clie", nullable = false)
    private String idClie;
    @Column(name = "id_usua", nullable = false)
    private String idUsua;

}