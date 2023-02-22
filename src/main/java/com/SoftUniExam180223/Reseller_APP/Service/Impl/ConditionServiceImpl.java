package com.SoftUniExam180223.Reseller_APP.Service.Impl;

import com.SoftUniExam180223.Reseller_APP.Model.Entity.Condition;
import com.SoftUniExam180223.Reseller_APP.Model.Entity.ConditionNameEnum;
import com.SoftUniExam180223.Reseller_APP.Repository.ConditionRepository;
import com.SoftUniExam180223.Reseller_APP.Service.ConditionService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
@Service
public class ConditionServiceImpl implements ConditionService {

    private final ConditionNameEnum conditionNameEnum;
    private final ConditionRepository conditionRepository;



    public ConditionServiceImpl(ConditionNameEnum conditionNameEnum, ConditionRepository conditionRepository) {
        this.conditionNameEnum = conditionNameEnum;
        this.conditionRepository = conditionRepository;
    }

    @Override
    public void initCategories() {
        if (conditionRepository.count() != 0) {
            return;
        }
        Arrays.stream(ConditionNameEnum.values())
                .forEach((categoryNameEnum -> {
                    Condition condition=new Condition();
                    condition.setConditionName(conditionNameEnum);
                    switch (categoryNameEnum){
                        case EXCELLENT -> condition.setDescription("In perfect condition");
                        case GOOD -> condition.setDescription("Some signs of wear and tear or minor defects");
                        case ACCEPTABLE -> condition.setDescription("The item is fairly worn but continues to function properly");
                    }
                    conditionRepository.save(condition);
                }));
    }

    @Override
    public Condition findByConditionNameEnum(ConditionNameEnum conditionNameEnum) {
        return conditionRepository
                .findByName(conditionNameEnum)
                .orElse(null);
    }
}
