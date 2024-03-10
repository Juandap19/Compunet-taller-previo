package co.edu.icesi.viajes.repository;

import co.edu.icesi.viajes.domain.Cliente;
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
     List<Cliente> findByNumeroIdentificacion(String numeroIdentificacion);
     List<Cliente> findByPrimerApellidoAndSegundoApellido(String primerApellido, String segundoApellido);
    @Query(nativeQuery = true)
    List<ClienteDTO> consultarClientePorSexo(@Param("psexo") String sexo);
    List<Cliente> findByEstadoAndNumeroIdentificacionAndIdTiidAndNombreLikeOrderByNombreAsc(String estado, String numeroIdentificacion ,Integer identificationTipe,String name);


}
