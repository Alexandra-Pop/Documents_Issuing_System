package entity;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "document")
public class Document {

    @Id
    @Column(unique = true, nullable = false)
    private String id;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "document", cascade = CascadeType.ALL)
    private Set<UserResidenceDocument> userResidenceDocuments;

    public Document(String type, String description){
        this.id = UUID.randomUUID().toString();
        this.type = type;
        this.description = description;
    }

    public Document(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
