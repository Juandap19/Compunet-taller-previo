package co.edu.icesi.viajes.service;

import co.edu.icesi.viajes.domain.Usuario;
import co.edu.icesi.viajes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Scope("Singleton")
@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public List<Usuario> findAll() {
        List<Usuario> lsUsuarios = usuarioRepository.findAll();
        return lsUsuarios;
    }

    @Override
    public Optional<Usuario> findById(Integer id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario save(Usuario entity) throws Exception {
        return usuarioRepository.save(null);
    }

    @Override
    public Usuario update(Usuario entity) throws Exception {
        return usuarioRepository.save(entity);
    }

    @Override
    public void delete(Usuario entity) throws Exception {
        usuarioRepository.delete(entity);
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        usuarioRepository.deleteById(id);
    }

    @Override
    public void validate(Usuario entity) throws Exception {
//Not yet
    }

    @Override
    public Long count() {
        return usuarioRepository.count();
    }
}
