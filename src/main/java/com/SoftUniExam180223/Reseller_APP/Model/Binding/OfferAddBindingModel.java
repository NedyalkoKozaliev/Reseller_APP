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

    public Float getPrice() {
        return price;
    }

    @Positive
    @DecimalMin(value="0")
    public void setPrice(Float price) {
        this.price = price;
    }

    @NotBlank
    public ConditionNameEnum getCondition() {
        return condition;
    }

    public void setCondition(ConditionNameEnum condition) {
        this.condition = condition;
    }
}
