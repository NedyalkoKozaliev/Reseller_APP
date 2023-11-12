package com.SoftUniExam180223.Reseller_APP.Model.Binding;

import com.SoftUniExam180223.Reseller_APP.Model.Entity.Condition;
import com.SoftUniExam180223.Reseller_APP.Model.Entity.ConditionNameEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public class OfferAddBindingModel {

    @Size(min=2,max=50, message = "Description length must be between 2 and 50 characters.")
    @NotEmpty(message = "Description could not be empty.")
    private String description;
    @Positive(message = "Price must be positive number.")
    @DecimalMin(value="0")
    private Float price ;
    @NotNull(message = "You must select condition.")
    private ConditionNameEnum condition;

    public OfferAddBindingModel() {
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
}
