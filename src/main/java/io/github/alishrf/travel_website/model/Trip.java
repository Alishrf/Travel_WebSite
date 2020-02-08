package io.github.alishrf.travel_website.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Entity
@Table(name = "trip")
@Inheritance(strategy = InheritanceType.JOINED)
public class Trip {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long ID;

    @ManyToOne(targetEntity = City.class)
    @JoinColumn(name = "source_city",referencedColumnName = "id")
    private City sourceCity;

    @ManyToOne(targetEntity = City.class)
    @JoinColumn(name = "destination_city",referencedColumnName = "id")
    private City destinationCity;

    @Column(name = "start_date")
    private Timestamp startDate;

    @Column(name = "end_date")
    private Timestamp endDate;

    @Column(name = "price",length = 10)
    private int price;

    @Column(name = "residual_capacity")
    private int residualCapacity;

    @Size(min = 0,max = 100)
    private int off;

    @Column(name = "description")
    private String description;

    @ManyToOne(targetEntity = Company.class)
    @JoinColumn(name = "fk_company",referencedColumnName = "id")
    private Company company;

    public Trip() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public City getSourceCity() {
        return sourceCity;
    }

    public void setSourceCity(City sourceCity) {
        this.sourceCity = sourceCity;
    }

    public City getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(City destinationCity) {
        this.destinationCity = destinationCity;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
