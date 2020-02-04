package io.github.alishrf.travel_website.model;


import com.sun.istack.Nullable;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Entity
@Table(name = "company")

public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long ID;
    @NotNull
    @Length(max = 50,min = 2)
    private String name;
    @Nullable
    private String description;
    @Column(name = "img_logo")
    private byte[] imgLogo;

    public Company() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImgLogo() {
        return imgLogo;
    }

    public void setImgLogo(byte[] imgLogo) {
        this.imgLogo = imgLogo;
    }
}
