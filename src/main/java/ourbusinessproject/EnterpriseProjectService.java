package ourbusinessproject;

import jakarta.persistence.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseProjectService {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     *
     * @param entityManager fs
     */
    public EnterpriseProjectService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public EnterpriseProjectService() {
    }

    /**
     * Add a new Enterprise into the EntityManager
     * @param aName
     * @param aDescription
     * @param aContactName
     * @param mail
     * @return
     */
    public Enterprise newEnterprise(String aName, String aDescription, String aContactName, String mail) {

        Enterprise enterprise = new Enterprise(aName, aDescription, aContactName, mail);
        this.entityManager.persist(enterprise);
        this.entityManager.flush();
        return enterprise;
    }


    /**
     * Add a new project into the EntityManager
     * @param aTitle
     * @param aDescription
     * @return
     */
    public Project newProject(String aTitle, String aDescription, Enterprise enterprise) {
        Project project = new Project(aTitle, aDescription, enterprise);

        this.entityManager.persist(project);
        this.entityManager.flush();

        enterprise.addProject(project);
        return project;
    }


    /**
     *
     * @return
     */
    public EntityManager getEntityManager() {
        return entityManager;
    }


    /**
     * Find a project with its ID
     * @param anId
     * @return
     */
    public Project findProjectById(Long anId) {
        return entityManager.find(Project.class, anId);
    }

    /**
     * Find an enterprise by its ID
     * @param anId
     * @return
     */
    public Enterprise findEnterpriseById(Long anId) {
        return entityManager.find(Enterprise.class, anId);
    }


    public List<Project> findAllProjects() {
        String query = "SELECT p FROM Project p ORDER BY p.title" ;
        TypedQuery<Project> queryObj = entityManager.createQuery(query,Project.class);
        return queryObj.getResultList();
    }
}
