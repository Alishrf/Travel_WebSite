package io.github.alishrf.travel_website.model;



import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;




@Entity
@Table(name = "company")

public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long ID;
    @NotNull
    @Length(max = 50,min = 2)

    private String name;
    @Nullable
    private String description;


    @Nullable
    @OneToOne(targetEntity =ImageLogoEntity.class, cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "img_id",referencedColumnName = "id")
    private ImageLogoEntity imageLogoEntity;



    public CompanyEntity() {
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

    @Nullable
    public ImageLogoEntity getImageLogoEntity() {
        return imageLogoEntity;
    }

    public void setImageLogoEntity(@Nullable ImageLogoEntity imageLogoEntity) {
        this.imageLogoEntity = imageLogoEntity;
    }
}
