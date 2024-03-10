package co.edu.icesi.viajes.repository;

import co.edu.icesi.viajes.domain.TipoDestino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface TipoDestinoRepository extends JpaRepository<TipoDestino,Integer> {

     List<TipoDestino> findByCodigo(String codigo);

     List<TipoDestino> findByCodigoAndEstado(String codigo, String estado);

    @Query("select tp from TipoDestino tp where  tp.codigo = ?1 and tp.estado = ?2 ")
     List<TipoDestino> consultarPorCodigo(String codigo, String estado);


    @Query("SELECT tp FROM TipoDestino tp order by tp.nombre")
    List<TipoDestino> finAllOrderByNombreAsc();




}
