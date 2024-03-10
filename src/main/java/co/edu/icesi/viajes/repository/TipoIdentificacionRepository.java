package co.edu.icesi.viajes.repository;

import co.edu.icesi.viajes.domain.TipoDestino;
import co.edu.icesi.viajes.domain.TipoIdentificacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TipoIdentificacionRepository extends JpaRepository<TipoIdentificacion,Integer> {

     List<TipoIdentificacion> findByEstadoOrderByEstadoDesc(String estado);
     List<TipoIdentificacion> findByCodigoAndEstado(String codigo, String estado);


}
