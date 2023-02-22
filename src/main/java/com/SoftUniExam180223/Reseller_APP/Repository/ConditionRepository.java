package com.SoftUniExam180223.Reseller_APP.Repository;

import com.SoftUniExam180223.Reseller_APP.Model.Entity.Condition;
import com.SoftUniExam180223.Reseller_APP.Model.Entity.ConditionNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConditionRepository extends JpaRepository<Condition, Long> {


    Optional<Condition> findByName(ConditionNameEnum conditionNameEnum);

}
