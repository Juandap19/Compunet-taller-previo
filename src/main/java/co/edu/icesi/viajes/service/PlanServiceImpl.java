package co.edu.icesi.viajes.service;

import co.edu.icesi.viajes.domain.Plan;
import co.edu.icesi.viajes.repository.PlanRepository;
import org.hibernate.annotations.DialectOverride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Scope("Singleton")
@Service

public class PlanServiceImpl implements PlanService{


    @Autowired
    private PlanRepository planRepository;

    @Override
    public List<Plan> findAll() {
        List<Plan> lsPlan = planRepository.findAll();
        return lsPlan;
    }

    @Override
    public Optional<Plan> findById(Integer id) {
        return  planRepository.findById(id);
    }

    @Override
    public Plan save(Plan entity) throws Exception {
        return  planRepository.save(null);
    }

    @Override
    public Plan update(Plan entity) throws Exception {
        return  planRepository.save(entity);
    }

    @Override
    public void delete(Plan entity) throws Exception {
        planRepository.delete(entity);
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        planRepository.deleteById(id);
    }

    @Override
    public void validate(Plan entity) throws Exception {
//No yet
    }

    @Override
    public Long count() {
        return  planRepository.count();
    }
}
