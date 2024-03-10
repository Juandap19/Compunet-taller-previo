package co.edu.icesi.viajes.repository;

import co.edu.icesi.viajes.domain.Cliente;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import co.edu.icesi.viajes.dto.ClienteDTO;

import java.util.Date;
import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {

     List<Cliente> findByEstadoOrderByNumeroIdentificacionAsc(String estado);

     List<Cliente> findByCorreoIgnoreCase(String correo);

     List<Cliente> findByNumeroIdentificacionLike(String numeroIdentificacion);

     List<Cliente> findByNombreIsLikeIgnoreCase(String nombre);

    @Query("SELECT cl FROM Cliente cl where cl.fechaNacimiento <= ?1 and cl.fechaNacimiento >=?2 or cl.fechaNacimiento  <= ?2 and cl.fechaNacimiento >=?1")
     List<Cliente> findByTwoDates(Date date1, Date date2);

     List<Cliente> findByEstado(String estado);

     @Query("SELECT cl FROM Cliente cl JOIN TipoIdentificacion ti ON cl.idTiid = ti.idTiid WHERE ti.codigo = ?1 ")
     List<Cliente> findByTipoIdentificacion(String TipoIdentificacion, Pageable pageable);
     List<Cliente> findByPrimerApellidoAndSegundoApellido(String primerApellido, String segundoApellido);
    @Query(nativeQuery = true)
    List<ClienteDTO> consultarClientePorSexo(@Param("psexo") String sexo);
    @Query(nativeQuery = true)
    List<ClienteDTO> consultarFiltros(
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
    List<ClienteDTO> findByTop3ActiveClientsSpent();
}
