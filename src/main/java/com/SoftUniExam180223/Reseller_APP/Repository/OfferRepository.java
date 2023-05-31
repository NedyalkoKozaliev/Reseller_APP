package com.SoftUniExam180223.Reseller_APP.Repository;


import com.SoftUniExam180223.Reseller_APP.Model.Entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

    List<Offer> findAllByIdNot(Long userId);

    List<Offer> findBySeller_Id(Long id);



}
