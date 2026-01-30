package ourbusinessproject;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitializationService {
    private Enterprise enterprise1, enterprise2;
    private Project project1, project2, project3;

    @Autowired
    private EnterpriseProjectService enterpriseprojectservice;

    @Transactional
    public void initProjects() {
        //Lorsqu'un des Projets ont une des informations est incorrecte (ex: null),
        // toute la construction transactionnelle "échoue"
        //Cela est dû à la nature d'un processus transactionnelle,
        // qui rollback tout processus jusque là effectué en cas d'erreur
        enterprise1 = enterpriseprojectservice.newEnterprise(
                "entreprise1",
                "la premiere",
                "premier contact",
                "premier@email.com"
        );

        enterprise2 = enterpriseprojectservice.newEnterprise(
                "entreprise2",
                "la seconde",
                "lecond contact",
                "second@email.com"
        );

        project1 = enterpriseprojectservice.newProject(
                "project 2",
                "second projet",
                enterprise1
        );

        project2 = enterpriseprojectservice.newProject(
                "project 2",
                "deuxieme projet",
                enterprise2
        );
        project3 = enterpriseprojectservice.newProject(
                "project 3",
                "troisieme projet",
                enterprise1
        );

    }



    public Project getProject1E1() {
        return project1;
    }

    public Project getProject1E2() {
        return project2;
    }

    public Project getProject2E1() {
        return project3;
    }

    public Enterprise getEnterprise1() {
        return enterprise1;
    }

    public Enterprise getEnterprise2() {
        return enterprise2;
    }
}
