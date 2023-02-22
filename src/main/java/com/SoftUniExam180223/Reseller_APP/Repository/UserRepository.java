package com.SoftUniExam180223.Reseller_APP.Repository;

import com.SoftUniExam180223.Reseller_APP.Model.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User,Long>{

    Optional<User> findByUsernameAndPassword(String username, String password);


}
