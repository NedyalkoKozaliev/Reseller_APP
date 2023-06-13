package com.SoftUniExam180223.Reseller_APP.Web;


import com.SoftUniExam180223.Reseller_APP.Current.CurrentUser;
import com.SoftUniExam180223.Reseller_APP.Model.View.OfferViewModel;
import com.SoftUniExam180223.Reseller_APP.Repository.OfferRepository;
import com.SoftUniExam180223.Reseller_APP.Repository.UserRepository;
import com.SoftUniExam180223.Reseller_APP.Service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {


    private final CurrentUser currentUser;
    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final OfferService offerService;

    public HomeController(CurrentUser currentUser, OfferRepository offerRepository, UserRepository userRepository, ModelMapper modelMapper, OfferService offerService) {
        this.currentUser = currentUser;
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.offerService = offerService;
    }
    // private final ProductService productService;


    @GetMapping("/")
    public String index(Model model) {

        if (currentUser.getId() == null) {
            return "index";

        }

        String Logged=currentUser.getUsername();
        List<OfferViewModel> Others=offerRepository.findAllBySeller_IdNot(currentUser.getId()).stream().
                map(offer -> modelMapper.map(offer,OfferViewModel.class)).collect(Collectors.toList());
        List<OfferViewModel> myOffers=offerService.findMyOffers(currentUser.getId());
        List<OfferViewModel> bought=offerService.findBoughtOffers(currentUser.getId());
//        List<OfferViewModel> bought=userRepository.findById(currentUser.getId()).
//                stream().map(offer->modelMapper.map(offer,OfferViewModel.class)).toList();

        int count=Others.size();


        model.addAttribute("MyOffers",myOffers);
        model.addAttribute("BoughtOffers",bought);


        model.addAttribute("other",Others);
        model.addAttribute("Logged", Logged);
        model.addAttribute("count", count);
        return "home";
    }


}
