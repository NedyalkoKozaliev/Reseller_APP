package com.SoftUniExam180223.Reseller_APP.Service.Impl;

import com.SoftUniExam180223.Reseller_APP.Current.CurrentUser;
import com.SoftUniExam180223.Reseller_APP.Model.Entity.Offer;
import com.SoftUniExam180223.Reseller_APP.Model.Entity.User;
import com.SoftUniExam180223.Reseller_APP.Model.Service.OfferServiceModel;
import com.SoftUniExam180223.Reseller_APP.Repository.OfferRepository;
import com.SoftUniExam180223.Reseller_APP.Repository.UserRepository;
import com.SoftUniExam180223.Reseller_APP.Service.ConditionService;
import com.SoftUniExam180223.Reseller_APP.Service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {

    private final ModelMapper modelMapper;
    private final ConditionService conditionService;
    private final OfferRepository offerRepository;
    private final CurrentUser currentUser;
    private final UserRepository userRepository;


    public OfferServiceImpl(ModelMapper modelMapper, ConditionService categoryService, ConditionService conditionService, OfferRepository productRepository, OfferRepository offerRepository, CurrentUser currentUser, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.conditionService = conditionService;
        this.offerRepository = offerRepository;

        this.currentUser = currentUser;
        this.userRepository = userRepository;
    }

    @Override
    public void addOffer(OfferServiceModel offerServiceModel) {
        Offer offer=modelMapper.map(offerServiceModel,Offer.class);
        offer.setCondition (conditionService.findByConditionNameEnum(offerServiceModel.getCondition()));
        offer.setSeller(findUserById(currentUser.getId()));
       offerRepository.save(offer);
    }

    private User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    @Override
    public void removeOffer(Long id) {
        offerRepository
                .deleteById(id);
    }

    @Override
    public void buyOffer(Long id) {
        Offer offer=offerRepository.findById(id).orElse(null);

        User seller=offer.getSeller();
        User current=findUserById(currentUser.getId());
        current.getBoughtOffers().add(offer);
    }
}
