package com.SoftUniExam180223.Reseller_APP.Init;

import com.SoftUniExam180223.Reseller_APP.Service.ConditionService;
import org.springframework.boot.CommandLineRunner;

public class DBInit implements CommandLineRunner {
    private final ConditionService conditionService;

    public DBInit(ConditionService conditionService) {
        this.conditionService = conditionService;
    }


    @Override
    public void run(String... args) throws Exception {
        conditionService.initCategories();
    }
}
