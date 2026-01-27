package ourbusinessproject;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Enterprise {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String name;

    @Size(min =10)
    private String description;

    @NotBlank
    private String contactname;
    @NotBlank @Email
    private String contactemail;

    
    public Enterprise(String name, String contactname, String contactemail, String description) {
        this.name = name;
        this.contactname = contactname;
        this.contactemail = contactemail;
        this.description = description;
    }
    
    public Enterprise() {}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactName() {
        return contactname;
    }
    public void setContactName(String contactName) {
        this.contactname = contactName;
    }

    public String getContactEmail() {
        return contactemail;
    }
    public void setContactEmail(String contactemail) {
        this.contactemail = contactemail;
    }
}
