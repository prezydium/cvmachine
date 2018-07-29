package org.prezydium.cvmachine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class StartViewController {

    @GetMapping("/")
    public ModelAndView welcomeView(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
}
