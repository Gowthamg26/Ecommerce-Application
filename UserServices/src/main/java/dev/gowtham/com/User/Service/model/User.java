package dev.gowtham.com.User.Service.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User extends BaseModel {

    private String firstName;

    private String lastName;

    private String emailId;

    private transient String password;
}
