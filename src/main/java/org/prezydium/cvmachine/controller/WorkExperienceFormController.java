package org.prezydium.cvmachine.controller;

import org.prezydium.cvmachine.model.Education;
import org.prezydium.cvmachine.model.WorkExperience;
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
public class WorkExperienceFormController {

    private Logger LOG = LoggerFactory.getLogger(WorkExperienceFormController.class);

    @GetMapping(path = "/experience")
    public ModelAndView personalDataProvider(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView("experience");
        if (httpSession.getAttribute("experience") == null) {
            modelAndView.addObject("experience", new WorkExperience());
        } else {
            modelAndView.addObject("experience", httpSession.getAttribute("education"));
        }
        return modelAndView;
    }

    @PostMapping("/experience")
    public RedirectView savePersonalData(@ModelAttribute WorkExperienceFormController experience, HttpSession httpSession) {
        LOG.info("Processing experience: ".concat(experience.toString()));
        httpSession.setAttribute("experience", experience);
        return new RedirectView("/");
    }
}
