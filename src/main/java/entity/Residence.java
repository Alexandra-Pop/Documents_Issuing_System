package entity;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "residence")
public class Residence {

    @Id
    @Column(unique = true, nullable = false)
    private String id;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private int number;

    @OneToMany(mappedBy = "residence", cascade = CascadeType.ALL)
    private Set<UserResidence> userResidences;

    public Residence(String street, int number){
        this.id = UUID.randomUUID().toString();
        this.street = street;
        this.number = number;
    }

    public Residence(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
