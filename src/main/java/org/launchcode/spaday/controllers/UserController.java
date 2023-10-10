package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.sql.SQLOutput;
import java.util.Objects;

@Controller
@RequestMapping("user")
public class UserController {

    @PostMapping("")
    public String processAddUserForm(Model model, @ModelAttribute @Valid User user, Errors errors) {
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("password", user.getPassword());
        model.addAttribute("verify", user.getVerify());

        if(errors.hasErrors()){
            if(!Objects.equals(user.getPassword(), user.getVerify())){
                model.addAttribute("error", "Passwords must match!");
            }
            return "user/add";
        }
        if(Objects.equals(user.getPassword(), user.getVerify())){
            return "user/index";
        }
        model.addAttribute("error", "Passwords must match!");
        return "user/add";
    }

    @GetMapping("add")
    public String displayAddUserForm(Model model){
        model.addAttribute(new User());
        return "user/add";
    }

}
