package ourbusinessproject;

import jakarta.validation.constraints.NotNull;

import java.util.Date;


public class Partnership {
    @NotNull
    private Date date;

    @NotNull
    private Enterprise enterprise;
    @NotNull
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
}
