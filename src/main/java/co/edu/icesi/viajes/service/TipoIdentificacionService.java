package co.edu.icesi.viajes.service;


import co.edu.icesi.viajes.domain.TipoDestino;
import co.edu.icesi.viajes.domain.TipoIdentificacion;

import java.util.List;

public interface TipoIdentificacionService extends GenericService<TipoIdentificacion,Integer>{

    List<TipoIdentificacion> findByEstadoOrderByEstadoDesc(String a);

    List<TipoIdentificacion> findByCodigoAndEstado(String number, String a);
}
