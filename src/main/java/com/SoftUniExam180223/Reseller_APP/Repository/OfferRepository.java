package com.SoftUniExam180223.Reseller_APP.Repository;


import com.SoftUniExam180223.Reseller_APP.Model.Entity.Offer;
import com.SoftUniExam180223.Reseller_APP.Model.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

    List<Offer> findAllBySeller_IdNot(Long userId);

    List<Offer> findBySeller(User user);


    Optional<Offer> findById(Long id);
}
