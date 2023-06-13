package com.SoftUniExam180223.Reseller_APP.Service;

import com.SoftUniExam180223.Reseller_APP.Model.Binding.OfferAddBindingModel;
import com.SoftUniExam180223.Reseller_APP.Model.Service.OfferServiceModel;
import com.SoftUniExam180223.Reseller_APP.Model.View.OfferViewModel;

import java.util.List;

public interface OfferService {

    void addOffer(OfferAddBindingModel offerAddBindingModel);

    void removeOffer(Long id);

    void buyOffer(Long id);

    List<OfferViewModel> findMyOffers(Long id);

    List<OfferViewModel> findBoughtOffers(Long id);

}
