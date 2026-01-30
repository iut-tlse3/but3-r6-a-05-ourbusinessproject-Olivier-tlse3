package ourbusinessproject;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
public class Partnership {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private Date date;

    @NotNull @ManyToOne
    private Enterprise enterprise;
    @NotNull @OneToOne
    private Project project;

    public Partnership(){}

    public void setCreationDate(Date date) {
        this.date = date;
    }


    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Object getId() {
        return  this.id;
    }

    public Enterprise getEnterprise() {
        return this.enterprise;
    }

    public Date getCreationDate() {
        return this.date;
    }

    public Project getProject() {
        return this.project;
    }
}
