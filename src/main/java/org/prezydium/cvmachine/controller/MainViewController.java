package org.prezydium.cvmachine.controller;

import org.prezydium.cvmachine.model.CVModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class MainViewController {

    @GetMapping("/")
    public ModelAndView welcomeView(HttpSession httpSession) {
        httpSession.setAttribute("cvModel", new TestUser().create()); //TODO test line
        if (httpSession.getAttribute("cvModel") == null) {
            return new ModelAndView("index");
        } else {
            ModelAndView modelAndView = new ModelAndView("cv-in-progress");
            CVModel cvModel = (CVModel) httpSession.getAttribute("cvModel");
            modelAndView.addObject(cvModel);
            return modelAndView;
        }
    }
}
