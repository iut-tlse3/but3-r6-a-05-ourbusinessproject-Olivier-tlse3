package ourbusinessproject;

import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectController {

    private final EnterpriseProjectService enterpriseProjectService;

    /**
     * Creates a new project Controller
     * @param enterpriseProjectService  the service to ues to manage projects
     */
    public ProjectController(EnterpriseProjectService enterpriseProjectService) {
        this.enterpriseProjectService = enterpriseProjectService;
    }

    /**
     * through the service, return all project with their enterprise
     * @return
     */
    @GetMapping("/projects")
    public List<Project> findAllProjectsWithEnterprises() {
        return this.enterpriseProjectService.findAllProjects();
    }
}
