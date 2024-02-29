package co.edu.icesi.viajes.repository;

import co.edu.icesi.viajes.domain.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan,Integer> {
}
