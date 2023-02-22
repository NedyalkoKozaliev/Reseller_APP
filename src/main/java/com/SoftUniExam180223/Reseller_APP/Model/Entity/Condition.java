package com.SoftUniExam180223.Reseller_APP.Model.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="conditions")
public class Condition extends BaseEntity{

    private ConditionNameEnum conditionName;
    private String description;

    public Condition() {
    }

    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    public ConditionNameEnum getConditionName() {
        return conditionName;
    }

    public void setConditionName(ConditionNameEnum conditionName) {
        this.conditionName = conditionName;
    }

    @Column(nullable = false,columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
