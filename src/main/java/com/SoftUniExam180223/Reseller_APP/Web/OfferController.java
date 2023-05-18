package com.SoftUniExam180223.Reseller_APP.Web;

import com.SoftUniExam180223.Reseller_APP.Current.CurrentUser;
import com.SoftUniExam180223.Reseller_APP.Model.Binding.OfferAddBindingModel;

import com.SoftUniExam180223.Reseller_APP.Model.Service.OfferServiceModel;
import com.SoftUniExam180223.Reseller_APP.Service.OfferService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public OfferController(OfferService offerService, ModelMapper modelMapper, CurrentUser currentUser) {
        this.offerService = offerService;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @GetMapping("/add")
    public String add(Model model) {
        if (currentUser.getId() == null) {
            return "redirect:/login";
        }
        if (!model.containsAttribute("offerAddBindingModel")) {
            model.addAttribute("offerAddBindingModel", new OfferAddBindingModel());
        }
        return "product-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid OfferAddBindingModel offerAddBindingModel, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("offerAddBindingModel", offerAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springFramework.validation.BindingResult.offerAddBindingModel", bindingResult);
            return "redirect:add";
        }
        offerService.addOffer(modelMapper.map(offerAddBindingModel, OfferServiceModel.class));

        return "home";

    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable Long id) {
        offerService.removeOffer(id);

        return "redirect:/";


    }
    @GetMapping("/buy/{id}")
    public String buy(@PathVariable Long id) {
        offerService.buyOffer(id);

        return "redirect:/";
    }
}
