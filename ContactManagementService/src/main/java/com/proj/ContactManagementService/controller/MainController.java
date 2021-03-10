package com.proj.ContactManagementService.controller;

import com.proj.ContactManagementService.entities.User;
import com.proj.ContactManagementService.helpers.Message;
import com.proj.ContactManagementService.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    public static final String MAIN_PAGE = "main";
    public static final String ABOUT_PAGE = "about.html";
    public static final String REGISTER_PAGE = "register.html";
    public static final String LOGIN_PAGE = "login.html";

    @Autowired
    private userService userService;

    @GetMapping(value = "/")
    public String getHomePage() {
        return MAIN_PAGE;
    }

    @GetMapping(value = "/about")
    public String getAboutPage() {
        return ABOUT_PAGE;
    }

    @GetMapping(value = "/signup")
    public String getSignUpPage(Model model) {
        model.addAttribute("user", new User());
        return REGISTER_PAGE;
    }

    @GetMapping(value = "/login")
    public String getLoginPage() {
        return LOGIN_PAGE;
    }

    @RequestMapping(value="/do_register", method = RequestMethod.POST)
    public String do_register(@ModelAttribute("user") User user, @RequestParam(value = "agreement") boolean agreement, Model model,
                              HttpSession session) {
        try {
            if (agreement) {
                user.setEnabled(true);
                user.setRole("USER");
                User saved_user = userService.save(user);
                model.addAttribute("user", saved_user);
                session.setAttribute("message", new Message("Successfully registered","success"));
            }
            else
            {
                session.setAttribute("message", new Message("You have not agreed to the terms and conditions","error"));
            }

        } catch (Exception e){
            model.addAttribute(user);
            session.setAttribute("message", new Message("Something went Wrong","alert"));
        }

        return REGISTER_PAGE;
    }


}
