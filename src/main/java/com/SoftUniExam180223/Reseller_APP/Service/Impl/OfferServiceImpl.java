package com.SoftUniExam180223.Reseller_APP.Service.Impl;

import com.SoftUniExam180223.Reseller_APP.Current.CurrentUser;
import com.SoftUniExam180223.Reseller_APP.Model.Binding.OfferAddBindingModel;
import com.SoftUniExam180223.Reseller_APP.Model.Entity.Offer;
import com.SoftUniExam180223.Reseller_APP.Model.Entity.User;
import com.SoftUniExam180223.Reseller_APP.Model.Service.OfferServiceModel;
import com.SoftUniExam180223.Reseller_APP.Model.View.OfferViewModel;
import com.SoftUniExam180223.Reseller_APP.Repository.OfferRepository;
import com.SoftUniExam180223.Reseller_APP.Repository.UserRepository;
import com.SoftUniExam180223.Reseller_APP.Service.ConditionService;
import com.SoftUniExam180223.Reseller_APP.Service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final ModelMapper modelMapper;
    private final ConditionService conditionService;
    private final OfferRepository offerRepository;
    private final CurrentUser currentUser;
    private final UserRepository userRepository;

@Autowired
    public OfferServiceImpl(ModelMapper modelMapper, ConditionService categoryService, ConditionService conditionService, OfferRepository productRepository, OfferRepository offerRepository, CurrentUser currentUser, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.conditionService = conditionService;
        this.offerRepository = offerRepository;

        this.currentUser = currentUser;
        this.userRepository = userRepository;
    }

    @Override
    public void addOffer(OfferAddBindingModel offerAddBindingModel) {
//        Offer offer=modelMapper.map(offerAddBindingModel,Offer.class);
        Offer offer=new Offer();
        offer.setDescription(offerAddBindingModel.getDescription());
        offer.setPrice(offerAddBindingModel.getPrice());
        offer.setCondition(conditionService.findByConditionNameEnum(offerAddBindingModel.getCondition()));
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
if(offer!=null) {

    User current = offer.getSeller();
    current.getOffers().remove(offer);
    offer.setSeller(null);
    offerRepository.save(offer);
    userRepository.save(current);


    User buyer= userRepository.findById(currentUser.getId()).orElse(null);

    if (buyer != null) {
        buyer.getBoughtOffers().add(offer);

    userRepository.save(buyer);
    }
}

    }

    @Override
    public List<OfferViewModel> findMyOffers(Long id) {

    User user= userRepository.findById(id).orElse(null);
    if (user==null){
        return null;
    }

        return user.getOffers().stream().map(offer->modelMapper.map(offer,OfferViewModel.class)).collect(Collectors.toList());

    }

    @Override
    public List<OfferViewModel> findBoughtOffers(Long id) {
    User user=userRepository.findById(id).orElse(null);
    if(user==null){
        return null;
    }

    return user.getBoughtOffers().stream().map(offer->modelMapper.map(offer,OfferViewModel.class)).collect(Collectors.toList());

    }
}
