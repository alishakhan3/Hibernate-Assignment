package entity;

import org.hibernate.annotations.Generated;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String emailAddress;
    @OneToOne
    @JoinColumn(name="user_id")
    private Users user;

    
    public String getEmailAddress() {
        return emailAddress;
    }

    public Users getUser() {
        return user;
    }

    public void setEmailAddress(String email) {
        this.emailAddress = email;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Email [email=" + emailAddress + ", user=" + user + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
