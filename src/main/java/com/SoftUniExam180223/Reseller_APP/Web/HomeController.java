package com.SoftUniExam180223.Reseller_APP.Web;


import com.SoftUniExam180223.Reseller_APP.Current.CurrentUser;
import com.SoftUniExam180223.Reseller_APP.Model.View.OfferViewModel;
import com.SoftUniExam180223.Reseller_APP.Repository.OfferRepository;
import com.SoftUniExam180223.Reseller_APP.Repository.UserRepository;
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

    public HomeController(CurrentUser currentUser, OfferRepository offerRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.currentUser = currentUser;
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }
    // private final ProductService productService;


    @GetMapping("/")
    public String index(Model model) {

        if (currentUser.getId() == null) {
            return "index";

        }

        String Logged=userRepository.findById(currentUser.getId()).get().getUsername();
        List<OfferViewModel> Others=offerRepository.findAllByIdNot(currentUser.getId()).stream().
                map(offer -> modelMapper.map(offer,OfferViewModel.class)).collect(Collectors.toList());

        int count=Others.size();


        model.addAttribute("MyOffers",offerRepository.findBySeller_Id(currentUser.getId()));
        model.addAttribute("BoughtOffers",userRepository.findById(currentUser.getId()).get().getBoughtOffers());


        model.addAttribute("other",Others);
        model.addAttribute("Logged", Logged);
        model.addAttribute("count", count);
        return "home";
    }


}
