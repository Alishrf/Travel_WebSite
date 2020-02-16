package io.github.alishrf.travel_website.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "trip")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class TripEntity {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id")
    private Long ID;

    @ManyToOne(targetEntity = CityEntity.class,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "source_city",referencedColumnName = "id")
    private CityEntity sourceCityEntity;

    @ManyToOne(targetEntity = CityEntity.class,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "destination_city",referencedColumnName = "id")
    private CityEntity destinationCityEntity;

    @Column(name = "start_date")
    private Timestamp startDate;

    @Column(name = "end_date")
    private Timestamp endDate;

    @Column(name = "price",length = 10)
    private int price;

    @Column(name = "residual_capacity")
    private int residualCapacity;

    private int off;

    @Column(name = "description")
    private String description;

    @ManyToOne(targetEntity = CompanyEntity.class,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_company",referencedColumnName = "id")
    private CompanyEntity companyEntity;

    public TripEntity() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public CityEntity getSourceCityEntity() {
        return sourceCityEntity;
    }

    public void setSourceCityEntity(CityEntity sourceCityEntity) {
        this.sourceCityEntity = sourceCityEntity;
    }

    public CityEntity getDestinationCityEntity() {
        return destinationCityEntity;
    }

    public void setDestinationCityEntity(CityEntity destinationCityEntity) {
        this.destinationCityEntity = destinationCityEntity;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getResidualCapacity() {
        return residualCapacity;
    }

    public void setResidualCapacity(int residualCapacity) {
        this.residualCapacity = residualCapacity;
    }

    public int getOff() {
        return off;
    }

    public void setOff(int off) {
        this.off = off;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CompanyEntity getCompanyEntity() {
        return companyEntity;
    }

    public void setCompanyEntity(CompanyEntity companyEntity) {
        this.companyEntity = companyEntity;
    }
}
