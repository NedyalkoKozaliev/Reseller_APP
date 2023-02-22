package com.SoftUniExam180223.Reseller_APP.Service;

import com.SoftUniExam180223.Reseller_APP.Model.Service.OfferServiceModel;

public interface OfferService {

    void addOffer(OfferServiceModel offerServiceModel);

    void removeOffer(Long id);

}
