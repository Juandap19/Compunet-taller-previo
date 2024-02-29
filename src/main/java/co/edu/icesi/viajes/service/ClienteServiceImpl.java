package co.edu.icesi.viajes.service;

import co.edu.icesi.viajes.domain.Cliente;
import co.edu.icesi.viajes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Scope("Singleton")
@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Override
    public List<Cliente> findAll() {
        List<Cliente> lsClientes = clienteRepository.findAll();
        return lsClientes;
    }

    @Override
    public Optional<Cliente> findById(Integer id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente save(Cliente entity) throws Exception {
        return clienteRepository.save(null);
    }

    @Override
    public Cliente update(Cliente entity) throws Exception {
        return clienteRepository.save(entity);
    }

    @Override
    public void delete(Cliente entity) throws Exception {
            clienteRepository.delete(entity);
    }

    @Override
    public void deleteById(Integer id) throws Exception {
            clienteRepository.deleteById(id);
    }

    @Override
    public void validate(Cliente entity) throws Exception {
//            No yet
    }

    @Override
    public Long count() {
        return clienteRepository.count();
    }
}
