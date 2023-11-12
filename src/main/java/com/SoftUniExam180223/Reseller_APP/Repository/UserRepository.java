package com.SoftUniExam180223.Reseller_APP.Repository;

import com.SoftUniExam180223.Reseller_APP.Model.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User,Long>{


    Optional<User> findByUsernameAndPassword(String username, String password);






    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String name);

    Optional<User> findById(Long id);


}
