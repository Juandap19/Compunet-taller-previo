package co.edu.icesi.viajes.service;

import co.edu.icesi.viajes.domain.Destino;
import co.edu.icesi.viajes.repository.DestinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Scope("Singleton")
@Service
public class DestinoServiceImpl implements DestinoService{


    @Autowired
    private DestinoRepository destinoRepository;

    @Override
    public List<Destino> findAll() {
        List<Destino> lsDestinoRepository = destinoRepository.findAll();
        return lsDestinoRepository;
    }

    @Override
    public Optional<Destino> findById(Integer id) {
        return destinoRepository.findById(id);
    }

    @Override
    public Destino save(Destino entity) throws Exception {
        return destinoRepository.save(null);
    }

    @Override
    public Destino update(Destino entity) throws Exception {
        return destinoRepository.save(entity);
    }

    @Override
    public void delete(Destino entity) throws Exception {
        destinoRepository.delete(entity);

    }

    @Override
    public void deleteById(Integer id) throws Exception {
        destinoRepository.deleteById(id);
    }

    @Override
    public void validate(Destino entity) throws Exception {
//No yet
    }

    @Override
    public Long count() {
        return destinoRepository.count();
    }
}
