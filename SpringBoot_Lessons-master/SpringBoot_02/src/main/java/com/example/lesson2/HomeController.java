package com.example.lesson2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    // 1. When the program runs, it will first make sure all the paths are built out @RequestMapping
    @RequestMapping("/")
    // Model object connects Java classes and the HTML
    // The Model object passed in is limited to the method's scope
    public String homePage(Model model) {
        model.addAttribute("myvar", "Say hello to the people.");
        // 2. Then it will go into the "templates" folder and try to locate "homestemplate"
        return "hometemplate";
    }
}
