package entity;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "user_residence")
public class UserResidence {

    @Id
    @Column(unique = true, nullable = false)
    private String id;

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne()
    @JoinColumn(name = "residence_id", nullable = false)
    private Residence residence;

    @OneToMany(mappedBy = "userResidence", cascade = CascadeType.ALL)
    private Set<UserResidenceDocument> userResidenceDocuments;

    public UserResidence(User user, Residence residence){
        this.id = UUID.randomUUID().toString();
        this.user = user;
        this.residence = residence;
    }

    public UserResidence(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Residence getResidence() {
        return residence;
    }

    public void setResidence(Residence residence) {
        this.residence = residence;
    }

}
