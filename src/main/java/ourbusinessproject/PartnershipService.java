package ourbusinessproject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PartnershipService {
    @PersistenceContext
    private EntityManager entityManager;

    public PartnershipService(){}
    public PartnershipService(EntityManager entityManager){
        this.entityManager = entityManager;
    }


    public Partnership newPartnership(Project project, Enterprise partnerEnterprise) {
        Partnership partnership = new Partnership();
        partnership.setEnterprise(partnerEnterprise);
        partnership.setProject(project);
        partnership.setCreationDate(new Date());
        entityManager.persist(partnership);
        entityManager.flush();
        return partnership;
    }

    public Partnership findPartnershipById(Object id) {
        return  this.entityManager.find(Partnership.class, id);
    }

    public void remove(Partnership partnership){
        entityManager.remove(partnership);
        entityManager.flush();
    }
}
