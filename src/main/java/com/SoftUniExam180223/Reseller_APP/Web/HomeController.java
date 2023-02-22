package com.SoftUniExam180223.Reseller_APP.Web;


import com.SoftUniExam180223.Reseller_APP.Current.CurrentUser;
import com.SoftUniExam180223.Reseller_APP.Model.Entity.User;
import com.SoftUniExam180223.Reseller_APP.Repository.OfferRepository;
import com.SoftUniExam180223.Reseller_APP.Repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    private final CurrentUser currentUser;
    private final OfferRepository offerRepository;
    private final UserRepository userRepository;

    public HomeController(CurrentUser currentUser, OfferRepository offerRepository, UserRepository userRepository) {
        this.currentUser = currentUser;
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
    }
    // private final ProductService productService;


    @GetMapping("/")
    public String index(Model model) {

        if (currentUser.getId() == null) {
            return "index";

        }




        model.addAttribute("MyOffers",userRepository.findById(currentUser.getId()).get().getOffers());
        model.addAttribute("BoughtOffers",userRepository.findById(currentUser.getId()).get().getBoughtOffers());



        model.addAttribute("other",offerRepository.findAllByIdNot(currentUser.getId()));
        String Logged=userRepository.findById(currentUser.getId()).get().getUsername();

        int count=offerRepository.findAllByIdNot(currentUser.getId()).size();
        return "home";
    }


}
