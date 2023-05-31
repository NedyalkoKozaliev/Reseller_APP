package com.SoftUniExam180223.Reseller_APP.Model.Binding;

import com.SoftUniExam180223.Reseller_APP.Model.Entity.Condition;
import com.SoftUniExam180223.Reseller_APP.Model.Entity.ConditionNameEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public class OfferAddBindingModel {

    private String description;

    private Float price ;

    private ConditionNameEnum condition;

    public OfferAddBindingModel() {
    }

    @Size(min=2,max=50)
    @NotNull
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Positive
    @DecimalMin(value="0")
    public Float getPrice() {
        return price;
    }


    public void setPrice(Float price) {
        this.price = price;
    }

    @NotNull
    public ConditionNameEnum getCondition() {
        return condition;
    }

    public void setCondition(ConditionNameEnum condition) {
        this.condition = condition;
    }
}
