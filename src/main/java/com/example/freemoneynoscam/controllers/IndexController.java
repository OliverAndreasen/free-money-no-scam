package com.example.freemoneynoscam.controllers;

import com.example.freemoneynoscam.models.User;
import com.example.freemoneynoscam.services.UserService;
import com.example.freemoneynoscam.services.ValidateEmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/users")
    public String users(Model model){
        UserService userService = new UserService();
        ArrayList<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "users";

    }

    @PostMapping("/test")
    public String test(WebRequest dataFromForm) {
        String email = dataFromForm.getParameter("email");
        ValidateEmailService validateEmailService = new ValidateEmailService();
        UserService userService = new UserService();
        if(validateEmailService.isEmailValid(email)){
            System.out.println(email + " is valid");
            userService.insertUserToDb(email);
            return "success";
        }
        if(!validateEmailService.isEmailValid(email)) {
            System.out.println(email + " is not valid!");
            System.out.println("Try again");
        }
            return "redirect:/";
    }

}
