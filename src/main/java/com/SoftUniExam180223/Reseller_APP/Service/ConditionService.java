package com.SoftUniExam180223.Reseller_APP.Service;

import com.SoftUniExam180223.Reseller_APP.Model.Entity.Condition;
import com.SoftUniExam180223.Reseller_APP.Model.Entity.ConditionNameEnum;

public interface ConditionService {
    void initCategories();

    Condition findByConditionNameEnum(ConditionNameEnum conditionNameEnum);
}
