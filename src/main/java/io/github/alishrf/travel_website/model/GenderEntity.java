package io.github.alishrf.travel_website.model;

import javax.persistence.*;

@Entity
@Table(name = "gender")
public enum GenderEntity {
    MAN,WOMAN,NULL;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    public Long ID;

}
