package co.edu.icesi.viajes.repository;

import co.edu.icesi.viajes.domain.Destino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface DestinoRepository extends JpaRepository<Destino,Integer> {

    @Query(value = "SELECT dt FROM Destino dt where dt.codigo = ?1 and dt.estado = 'A'")
     List<Destino> findByCodigoAndEstado(String codigo);

    @Query("SELECT d, td.nombre,td.descripcion FROM Destino d JOIN TipoDestino td ON d.idTide = td.idTide WHERE d.estado = 'A'")
    List<Object[]> findAllDestinosWithActiveType();


    @Query(value = "SELECT dt FROM Destino dt ORDER BY dt.nombre ASC")
     List<Destino> finAllOrderByNombreAsc();





}
