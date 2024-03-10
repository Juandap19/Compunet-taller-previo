package co.edu.icesi.viajes.domain;

import java.util.Date;

import co.edu.icesi.viajes.dto.ClienteDTO;
import jakarta.persistence.*;
import lombok.Data;


@NamedNativeQueries({
                @NamedNativeQuery(name="Cliente.consultarClientePorSexo", query = "", resultSetMapping="consultarClientePorSexo"),
                @NamedNativeQuery(name="Cliente.consultarFiltros", query = "", resultSetMapping="consultarFiltros"),
})

@SqlResultSetMappings({
                @SqlResultSetMapping(name = "consultarClientePorSexo",
                        classes = {
                            @ConstructorResult(targetClass = ClienteDTO.class,
                            columns = {
                                    @ColumnResult(name = "id_clie", type = Integer.class),
                                    @ColumnResult(name = "numero_identificacion", type = String.class),
                                    @ColumnResult(name = "primer_apellido", type = String.class),
                                    @ColumnResult(name = "segundo_apellido", type = String.class),
                                    @ColumnResult(name = "nombre", type = String.class),
                                    @ColumnResult(name = "telefono1", type = String.class),
                                    @ColumnResult(name = "telefono2", type = String.class),
                                    @ColumnResult(name = "correo", type = String.class),
                                    @ColumnResult(name = "sexo", type = String.class),
                                    @ColumnResult(name = "fecha_nacimiento", type = Date.class),
                                    @ColumnResult(name = "usu_creador", type = String.class),
                                    @ColumnResult(name = "estado", type = String.class),
                            })
                        }
                ),
                @SqlResultSetMapping(name = "consultarFiltros",
                        classes = {
                                @ConstructorResult(targetClass = ClienteDTO.class,
                                        columns = {
                                                @ColumnResult(name = "numero_identificacion", type = String.class),
                                                @ColumnResult(name = "nombre", type = String.class),
                                                @ColumnResult(name = "estado", type = String.class),
                                                @ColumnResult(name = "id_tiid", type = Integer.class),
                                        })
                        }
                ),
})


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
    private String nombre;
    @Column(name = "telefono1")
    private String telefono1;
    @Column(name = "telefono2")
    private String telefono2;
    @Column(name = "correo")
    private String correo;
    @Column(name = "sexo", nullable = false)
    private String sexo;
    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fechaNacimiento;
    @Column(name = "fecha_creacion", nullable = false)
    private Date fechaCreacion;
    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;
    @Column(name = "usu_creador", nullable = false)
    private String usuCreador;
    @Column(name = "usu_modificador")
    private String usuModificador;
    @Column(name = "estado", nullable = false)
    private String estado;
    @Column(name = "id_tiid", nullable = false)
    private Integer idTiid;

}
