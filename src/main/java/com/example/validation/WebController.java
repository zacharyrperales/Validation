package com.example.validation;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("personForm", new PersonForm());
        return "form";
    }

    @PostMapping("/")
    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {
        PersonForm p = personForm;
        if (bindingResult.hasErrors()) {
            return "form";
        }
        return "results";
    }
}
