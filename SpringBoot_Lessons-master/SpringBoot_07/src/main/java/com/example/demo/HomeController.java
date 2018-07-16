package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    @GetMapping("/tvform")
    public String loadTvForm(Model model) {
        // Object is created when the form loads so that when the user begins filling
        // out the form fields, they're saved to that object (values are set on the HTML side)
        model.addAttribute("tvshow", new Tvshow());
        return "tvform";
    }

    @PostMapping("/tvform")
    // @Valid indicates that there are validations for the object
    // Always required for validation, BindingResult picks up constraints for the
    // validation (e.g. min, not null)
    public String processTvForm(@Valid Tvshow tvshow, BindingResult result) {
        if(result.hasErrors()) {
            return "tvform";
        }
        return "tvshowconfirm";
    }
}
