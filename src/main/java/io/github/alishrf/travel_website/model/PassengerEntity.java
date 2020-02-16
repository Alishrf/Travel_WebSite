package io.github.alishrf.travel_website.model;


import io.micrometer.core.annotation.Counted;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.ws.rs.DefaultValue;
import java.util.List;

@Entity
@Table(name = "passengers")
public class PassengerEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long ID;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Email
    @Column(name = "email")
    private String email;

    @Enumerated()
    private GenderEntity gender;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_passenger" ,referencedColumnName = "id")
    private List<TicketEntity> ActivityTickets;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_passenger" ,referencedColumnName = "id")
    private List<TicketEntity> recentTickets;

    public PassengerEntity() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public GenderEntity getGender() {
        return gender;
    }

    public void setGender(GenderEntity gender) {
        this.gender = gender;
    }
}
