package com.SoftUniExam180223.Reseller_APP.Web;

import com.SoftUniExam180223.Reseller_APP.Model.Binding.UserLoginBindingModel;
import com.SoftUniExam180223.Reseller_APP.Model.Binding.UserRegisterBindingModel;
import com.SoftUniExam180223.Reseller_APP.Model.Service.UserServiceModel;
import com.SoftUniExam180223.Reseller_APP.Service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

//    @Autowired
////    @Qualifier("userValidator")
//    private Validator validator;
//
//    @InitBinder
//    private void initBinder(WebDataBinder binder) {
//        binder.setValidator(validator);
//    }


    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/register")
    public String register(Model model){
        if(!model.containsAttribute("userRegisterBindingModel")){
            model.addAttribute("userRegisterBinding",new UserRegisterBindingModel());
        }
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()|| !userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())){
            redirectAttributes.addFlashAttribute("userRegisterBindingModel",userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel",bindingResult);
            return "redirect:register";

        }
        userService.registerUser(modelMapper.
                map(userRegisterBindingModel, UserServiceModel.class));

        return "redirect:login";
    }

    @GetMapping("/login")
    public String login(Model model){
        if(!model.containsAttribute("isFound")){
            model.addAttribute("isFound", true);
        }

        return "login";
    }

    @PostMapping("/login")
    public String loginConfirmation(@Valid UserLoginBindingModel userLoginBindingModel, BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("UserLoginBindingModel",userLoginBindingModel );
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);

            return "redirect:login";
        }
        UserServiceModel userServiceModel=userService
                .findByNameAndPassword(userLoginBindingModel.getUsername(),userLoginBindingModel.getPassword());
        if(userServiceModel==null){
            redirectAttributes.addFlashAttribute("userLoginBindingModel",userLoginBindingModel);
            redirectAttributes.addFlashAttribute("isFound", false);
            return "redirect:login";
        }
        userService.loginUser(userServiceModel.getId(), userLoginBindingModel.getUsername());
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:/";
    }




    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel(){
        return new UserRegisterBindingModel();
    }
    @ModelAttribute
    public UserLoginBindingModel userLoginBindingModel(){
        return new UserLoginBindingModel();
    }
}
