package co.edu.icesi.viajes.service;

import co.edu.icesi.viajes.domain.TipoIdentificacion;
import co.edu.icesi.viajes.repository.TipoIdentificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Scope("singleton")
@Service
public class TipoIdentificacionImpl implements co.edu.icesi.viajes.service.TipoIdentificacionService {

    @Autowired
    private TipoIdentificacionRepository tipoIdentificacionRepository;

    @Override
    public List<TipoIdentificacion> findAll() {
        List<TipoIdentificacion> lsTipoIdentifacion = tipoIdentificacionRepository.findAll();
        return lsTipoIdentifacion;
    }

    @Override
    public Optional<TipoIdentificacion> findById(Integer integer) {
        return tipoIdentificacionRepository.findById(integer);
    }

    @Override
    public TipoIdentificacion save(TipoIdentificacion entity) throws Exception {
        return tipoIdentificacionRepository.save(null);
    }

    @Override
    public TipoIdentificacion update(TipoIdentificacion entity) throws Exception {
        return tipoIdentificacionRepository.save(entity);
    }

    @Override
    public void delete(TipoIdentificacion entity) throws Exception {
        tipoIdentificacionRepository.delete(entity);
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        tipoIdentificacionRepository.deleteById(id);
    }

    @Override
    public void validate(TipoIdentificacion entity) throws Exception {
// not Yet
    }

    @Override
    public Long count() {
        return tipoIdentificacionRepository.count();
    }


    @Override
    public List<TipoIdentificacion> findByEstadoOrderByEstadoDesc(String a) {
        return tipoIdentificacionRepository.findByEstadoOrderByEstadoDesc(a);
    }

    @Override
    public List<TipoIdentificacion> findByCodigoAndEstado(String number, String a) {
        return tipoIdentificacionRepository.findByCodigoAndEstado(number,a);
    }
}
