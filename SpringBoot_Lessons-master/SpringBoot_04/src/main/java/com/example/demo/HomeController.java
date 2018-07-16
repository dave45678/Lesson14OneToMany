package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @RequestMapping("/loadform")
    public String loadFormPage(){
        return "formtemplate";
    }

    @RequestMapping("processform")
    // Whatever value is passed in for "login" (comes from the "name"
    // // attribute on the HTML form in @RequestParam, that
    // value is take and assigned to the String login variable
    public String loadFromPage(@RequestParam("login") String login, Model model) {
        // Model object created here bc you want to interact with that login
        // value on a separate page
        model.addAttribute("loginval", login);
        return "confirm";
    }
}
