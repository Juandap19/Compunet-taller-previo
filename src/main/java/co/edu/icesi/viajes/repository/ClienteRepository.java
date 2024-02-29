package co.edu.icesi.viajes.repository;

import co.edu.icesi.viajes.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
}
