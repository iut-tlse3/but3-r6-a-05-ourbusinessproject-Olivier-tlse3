package ourbusinessproject;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min=1)
    private String title;

    private String description;

    @NotNull @ManyToOne
    private Enterprise enterprise;


    public Project(String title, String description) {
        this.title = title;
        this.description = description;
    }
    public Project(String title, String description, Enterprise enterprise) {
        this.enterprise = enterprise;
        this.title = title;
        this.description = description;
    }
    public Project() {}

    /**
     * set the title
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * set the description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }


    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

}
