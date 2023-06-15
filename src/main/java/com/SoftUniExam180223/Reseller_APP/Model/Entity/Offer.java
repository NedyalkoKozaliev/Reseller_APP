package com.SoftUniExam180223.Reseller_APP.Model.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="offers")
public class Offer extends BaseEntity{

   private String description;

    private Float price ;

    private Condition condition;

    private User seller;



    public Offer() {
    }

    @Column(nullable = false, columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(nullable = false)
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @ManyToOne
    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    @OneToOne
    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }
}
