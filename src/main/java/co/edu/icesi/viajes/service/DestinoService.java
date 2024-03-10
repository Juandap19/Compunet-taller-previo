package co.edu.icesi.viajes.service;

import co.edu.icesi.viajes.domain.Destino;
import co.edu.icesi.viajes.domain.TipoDestino;

import java.util.List;


public interface DestinoService extends GenericService<Destino,Integer> {

    List<Destino> findByCodigoAndEstado(String codigo);

    List<Object[]> findAllDestinosWithActiveType();

    List<Destino> finAllOrderByNombreAsc();
}
