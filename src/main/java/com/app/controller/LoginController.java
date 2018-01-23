package com.app.controller;

import java.security.Principal;

import com.app.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginController {

    @Autowired
    private PeopleService peopleService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(Model model) {
        return "login";
    }

    @RequestMapping("/admin")
    public String admin(Model model, Principal principal) {
        String loggedInUserName = principal.getName();
        model.addAttribute("login", loggedInUserName);
        model.addAttribute("name", "Spring Security Custom Login Demo");
        model.addAttribute("description", "Protected page !");
        model.addAttribute("listPeople", peopleService.getAllPeople());
        return "admin";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap model) {
        return "login";
    }

    //@RequestMapping(value = "/logout", method = RequestMethod.GET)
    //public String logout(ModelMap model) {

        //model.addAttribute("message", "You have successfully logged off from application !");
        //return "logout";

    //}

    @RequestMapping(value = "/loginError", method = RequestMethod.GET)
    public String loginError(ModelMap model) {
        model.addAttribute("error", "true");
        return "login";
    }
}