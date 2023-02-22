package com.SoftUniExam180223.Reseller_APP.Service.Impl;

import com.SoftUniExam180223.Reseller_APP.Model.Entity.Offer;
import com.SoftUniExam180223.Reseller_APP.Model.Service.OfferServiceModel;
import com.SoftUniExam180223.Reseller_APP.Repository.OfferRepository;
import com.SoftUniExam180223.Reseller_APP.Service.ConditionService;
import com.SoftUniExam180223.Reseller_APP.Service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {

    private final ModelMapper modelMapper;
    private final ConditionService conditionService;
    private final OfferRepository offerRepository;

    public OfferServiceImpl(ModelMapper modelMapper, ConditionService categoryService, ConditionService conditionService, OfferRepository productRepository, OfferRepository offerRepository) {
        this.modelMapper = modelMapper;
        this.conditionService = conditionService;
        this.offerRepository = offerRepository;

    }

    @Override
    public void addOffer(OfferServiceModel offerServiceModel) {
        Offer offer=modelMapper.map(offerServiceModel,Offer.class);
        offer.setCondition (conditionService.findByConditionNameEnum(offerServiceModel.getCondition()));
       offerRepository.save(offer);
    }

    @Override
    public void removeOffer(Long id) {
        offerRepository
                .deleteById(id);
    }
}
