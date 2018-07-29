package org.prezydium.cvmachine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonalDataFormController {

    @GetMapping(path = "/personaldata")
    public ModelAndView personalDataProvider() {
        ModelAndView modelAndView = new ModelAndView("personaldata");
        return modelAndView;
    }
}
