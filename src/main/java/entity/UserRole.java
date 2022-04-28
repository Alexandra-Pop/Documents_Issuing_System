package entity;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @Column(unique = true, nullable = false)
    private String id;

    @Column(unique = true, nullable = false)
    private String roleName;

    @OneToMany(mappedBy = "userRole", cascade = CascadeType.ALL)
    private Set<User> users;

    public UserRole(String roleName){
        this.id = UUID.randomUUID().toString();
        this.roleName = roleName;
    }

    public UserRole(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
