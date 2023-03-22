package fausio.domain.employeemanager.model;
 
import java.io.Serializable;

import jakarta.persistence.*;

@Entity
public class Employee implements Serializable {


    // props
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String name;
    private String email;
    private String jobPosition;
    private String phone;
    private String imageUrl;

    @Column(nullable = false, updatable = false)
    private String code;
  

    // gets and sets

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobPosition() {
        return this.jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    // construtors

    public Employee() {
    }

    public Employee( String name, String email, String jobPosition, String phone, String imageUrl, String code) {
       
        this.name = name;
        this.email = email;
        this.jobPosition = jobPosition;
        this.phone = phone;
        this.imageUrl = imageUrl;
        this.code = code;
    }

    //  others

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", email='" + getEmail() + "'" +
            ", jobPosition='" + getJobPosition() + "'" +
            ", phone='" + getPhone() + "'" +
            ", imageUrl='" + getImageUrl() + "'" +
            ", code='" + getCode() + "'" +
            "}";
    }

    

    
}
