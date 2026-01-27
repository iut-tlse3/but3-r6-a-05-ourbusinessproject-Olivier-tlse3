package ourbusinessproject;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Enterprise {
    
    @NotBlank
    private String name;

    @NotBlank
    private String contactname;
    @NotBlank @Email
    private String contactemail;

    @Size(min =10)
    private String description;
    
    public Enterprise(String name, String contactname, String contactemail, String description) {
        this.name = name;
        this.contactname = contactname;
        this.contactemail = contactemail;
        this.description = description;
    }
    
    public Enterprise() {}
    
    
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
