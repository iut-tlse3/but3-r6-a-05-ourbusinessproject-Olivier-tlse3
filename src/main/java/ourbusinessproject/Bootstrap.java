package ourbusinessproject;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Bootstrap {

    private static final Logger logger = LoggerFactory.getLogger(Bootstrap.class);

    private final InitializationService initializationService;


    public Bootstrap(InitializationService initializationService) {
        this.initializationService =  initializationService;
    }

    @PostConstruct
    public void init() {
        try{

            this.initializationService.initProjects();
        }catch(RuntimeException exception){
            logger.error("Error during init",exception);
        }
    }

    public InitializationService getInitializationService() {
        return this.initializationService;
    }
}
