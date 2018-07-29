package org.prezydium.cvmachine.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StartViewController {

    @GetMapping("/")
    public ModelAndView welcomeView(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("message", "this is test");
        return modelAndView;
    }
}
