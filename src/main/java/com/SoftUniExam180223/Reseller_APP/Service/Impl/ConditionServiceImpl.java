package com.SoftUniExam180223.Reseller_APP.Service.Impl;

import com.SoftUniExam180223.Reseller_APP.Model.Entity.Condition;
import com.SoftUniExam180223.Reseller_APP.Model.Entity.ConditionNameEnum;
import com.SoftUniExam180223.Reseller_APP.Repository.ConditionRepository;
import com.SoftUniExam180223.Reseller_APP.Service.ConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
@Service
public class ConditionServiceImpl implements ConditionService {

    private final ConditionRepository conditionRepository;



    @Autowired
    public ConditionServiceImpl(ConditionRepository conditionRepository) {
        this.conditionRepository = conditionRepository;
    }

    @Override
    public void initCategories() {
        if (conditionRepository.count() != 0) {
            return;
        }
        Arrays.stream(ConditionNameEnum.values())
                .forEach((conditionNameEnum -> {
                    Condition condition=new Condition();
                    condition.setConditionName(conditionNameEnum);
                    switch (conditionNameEnum){
                        case EXCELLENT -> condition.setDescription("In perfect condition");
                        case GOOD -> condition.setDescription("Some signs of wear and tear or minor defects");
                        case ACCEPTABLE -> condition.setDescription("The item is fairly worn but continues to function properly");
                    }
                    conditionRepository.save(condition);
                }));
    }

    @Override
    public Condition findByConditionNameEnum(ConditionNameEnum conditionNameEnum) {
        return conditionRepository.findByConditionName(conditionNameEnum).orElse(null);

//        return conditionRepository
//                .findByConditionName(conditionNameEnum)
//                .orElse(null);
    }
}
