package co.edu.icesi.viajes.service;


import co.edu.icesi.viajes.domain.Cliente;
import co.edu.icesi.viajes.dto.ClienteDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import org.springframework.data.domain.Pageable;
import java.util.Date;
import java.util.List;

public interface ClienteService extends GenericService<Cliente,Integer> {


    List<Cliente> findByEstadoOrderByNumeroIdentificacionAsc(String estado, Pageable pageable);

    List<Cliente> findByCorreoIgnoreCase(String correo);

    List<Cliente> findByNumeroIdentificacionLike(String numeroIdentificacion);

    List<Cliente> findByNombreIsLikeIgnoreCase(String nombre);

    @Query("SELECT cl FROM Cliente cl where cl.fechaNacimiento <= ?1 and cl.fechaNacimiento >=?2 or cl.fechaNacimiento  <= ?2 and cl.fechaNacimiento >=?1")
    List<Cliente> findByTwoDates(Date date1, Date date2);

    Long countByEstado(String estado);
    List<Cliente> findByTipoIdentificacion(String tipoIdentificacion, Pageable pageable);
    List<Cliente> findByPrimerApellidoAndSegundoApellido(String primerApellido, String segundoApellido);
    @Query(nativeQuery = true)
    List<ClienteDTO> consultarClientePorSexo(@Param("psexo") String sexo);


    @Query(nativeQuery = true)
    List<ClienteDTO> consultarClienteFiltros(
            @Param("pnumeroIdentificacion") String numero_identificacion,
            @Param("pnombre") String nombre,
            @Param("pestado") String estado,
            @Param("ptipoIdentificacion") Integer id_tiid
    );


    @Query( "SELECT new co.edu.icesi.viajes.dto.ClienteDTO(cl.nombre, cl.fechaCreacion, SUM(pl.valorTotal)) " +
            "FROM Cliente cl " +
            "JOIN Plan pl ON pl.idClie = cl.idClie " +
            "WHERE cl.estado = 'A' " +
            "GROUP BY cl.nombre, cl.fechaCreacion " +
            "ORDER BY SUM(pl.valorTotal) DESC LIMIT 3")
    List<ClienteDTO> test_findByTop3ActiveClientsSpent();
}
