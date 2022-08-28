package dat3.cars.entity;

import dat3.security.entity.UserWithRoles;

import javax.persistence.Entity;

@Entity
public class Member extends UserWithRoles {
    String firstname;

    public Member() {
    }
    public Member(String user, String password, String email, String firstname) {
        super(user, password, email);
        this.firstname = firstname;
    }
}