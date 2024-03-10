package co.edu.icesi.viajes.service;

import co.edu.icesi.viajes.domain.Destino;
import co.edu.icesi.viajes.domain.TipoDestino;

import java.util.List;

public interface TipoDestinoService extends GenericService<TipoDestino,Integer>{

    public List<TipoDestino> findByCodigo(String codigo);
    public List<TipoDestino> findByCodigoAndEstado(String codigo, String estado);

    public List<TipoDestino> consultarPorCodigo(String codigo, String estado);

    List<TipoDestino> finAllOrderByNombreAsc();
}
