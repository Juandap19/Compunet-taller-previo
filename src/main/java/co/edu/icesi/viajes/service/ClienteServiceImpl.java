package co.edu.icesi.viajes.service;

import co.edu.icesi.viajes.domain.Cliente;
import co.edu.icesi.viajes.dto.ClienteDTO;
import co.edu.icesi.viajes.repository.ClienteRepository;
import jdk.swing.interop.SwingInterOpUtils;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Scope("singleton")
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

    @Override
    public List<Cliente> findByEstadoOrderByNumeroIdentificacionAsc(String estado,Pageable pageable) {
        return clienteRepository.findByEstadoOrderByNumeroIdentificacionAsc(estado);
    }

    @Override
    public List<Cliente> findByCorreoIgnoreCase(String correo) {
        return clienteRepository.findByCorreoIgnoreCase(correo);
    }

    @Override
    public List<Cliente> findByNumeroIdentificacionLike(String numeroIdentificacion) {
        return clienteRepository.findByNumeroIdentificacionLike(numeroIdentificacion);
    }

    @Override
    public List<Cliente> findByNombreIsLikeIgnoreCase(String nombre) {
        return clienteRepository.findByNombreIsLikeIgnoreCase(nombre);
    }

    @Override
    public List<Cliente> findByTwoDates(Date date1, Date date2) {
        return clienteRepository.findByTwoDates(date1,date2);
    }

    @Override
    public Long countByEstado(String estado) {
        List<Cliente> ls = clienteRepository.findByEstado(estado);
        return (long)ls.size();

    }

    @Override
    public List<Cliente> findByTipoIdentificacion(String tipoIdentificacion , Pageable pageable) {
        return clienteRepository.findByTipoIdentificacion(tipoIdentificacion,pageable);
    }

    @Override
    public List<Cliente> findByPrimerApellidoAndSegundoApellido(String primerApellido, String segundoApellido) {
        return clienteRepository.findByPrimerApellidoAndSegundoApellido(primerApellido,segundoApellido);
    }

    @Override
    public List<ClienteDTO> consultarClientePorSexo(String sexo) {
        return clienteRepository.consultarClientePorSexo(sexo);
    }


    @Override
    public List<ClienteDTO> consultarClienteFiltros(String numero_identificacion, String nombre, String estado, Integer id_tiid) {
        return clienteRepository.consultarFiltros(numero_identificacion,nombre,estado,id_tiid);
    }

    @Override
    public List<ClienteDTO> test_findByTop3ActiveClientsSpent() {
        return clienteRepository.findByTop3ActiveClientsSpent();
    }



}
