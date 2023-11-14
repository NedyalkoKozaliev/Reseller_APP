package com.SoftUniExam180223.Reseller_APP.Model.Service;

import com.SoftUniExam180223.Reseller_APP.Model.Entity.ConditionNameEnum;
import com.SoftUniExam180223.Reseller_APP.Model.Entity.User;

public class OfferServiceModel {

    private Long id;
    private String description;

    private Float price;

    private ConditionNameEnum condition;
    private User seller;

    public OfferServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public ConditionNameEnum getCondition() {
        return condition;
    }

    public void setCondition(ConditionNameEnum condition) {
        this.condition = condition;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }
}



