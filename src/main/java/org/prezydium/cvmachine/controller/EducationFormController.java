package org.prezydium.cvmachine.controller;

import org.prezydium.cvmachine.model.Education;
import org.prezydium.cvmachine.model.UserData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
public class EducationFormController {

    private Logger LOG = LoggerFactory.getLogger(EducationFormController.class);

    @GetMapping(path = "/education")
    public ModelAndView personalDataProvider(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView("education");
        if (httpSession.getAttribute("education") == null) {
            modelAndView.addObject("education", new Education());
        } else {
            modelAndView.addObject("education", httpSession.getAttribute("education"));
        }
        return modelAndView;
    }

    @PostMapping("/education")
    public RedirectView savePersonalData(@ModelAttribute Education education, HttpSession httpSession) {
        LOG.info("Processing education: ".concat(education.toString()));
        httpSession.setAttribute("education", education);
        return new RedirectView("/");
    }
}
