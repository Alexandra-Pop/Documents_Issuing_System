package entity;

import constants.RequestEnum;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "user_residence_document")
public class UserResidenceDocument {

    @Id
    @Column(unique = true, nullable = false)
    private String id;

    @Column(nullable = false)
    private RequestEnum request;

    @Column(nullable = false)
    private String date;

    @ManyToOne()
    @JoinColumn(name = "user_residence_id", nullable = false)
    private UserResidence userResidence;

    @ManyToOne()
    @JoinColumn(name = "document_id", nullable = false)
    private Document document;

    public UserResidenceDocument(UserResidence userResidence, Document document, String date){
        this.id = UUID.randomUUID().toString();
        this.date = date;
        this.request = RequestEnum.PENDING;
        this.userResidence = userResidence;
        this.document = document;
    }

    public UserResidenceDocument(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserResidence getUserResidence() {
        return userResidence;
    }

    public void setUserResidence(UserResidence userResidence) {
        this.userResidence = userResidence;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public RequestEnum getRequest() {
        return request;
    }

    public void setRequest(RequestEnum request) {
        this.request = request;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
