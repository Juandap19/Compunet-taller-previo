package co.edu.icesi.viajes.service;

import co.edu.icesi.viajes.domain.DetallePlan;
import co.edu.icesi.viajes.repository.DetallePlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Scope("Singleton")
@Service
public class DetallePlanServiceImpl implements DetallePlanService{

    @Autowired
    private DetallePlanRepository detallePlanRepository;
    @Override
    public List<DetallePlan> findAll() {
        List<DetallePlan> lsDetallePlan = detallePlanRepository.findAll();
        return lsDetallePlan;
    }

    @Override
    public Optional<DetallePlan> findById(Integer id) {
        return detallePlanRepository.findById(id);
    }

    @Override
    public DetallePlan save(DetallePlan entity) throws Exception {
        return detallePlanRepository.save(null);
    }

    @Override
    public DetallePlan update(DetallePlan entity) throws Exception {
        return detallePlanRepository.save(entity);
    }

    @Override
    public void delete(DetallePlan entity) throws Exception {
        detallePlanRepository.delete(entity);
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        detallePlanRepository.deleteById(id);
    }

    @Override
    public void validate(DetallePlan entity) throws Exception {
//        No yet
    }

    @Override
    public Long count() {
        return detallePlanRepository.count();
    }
}
