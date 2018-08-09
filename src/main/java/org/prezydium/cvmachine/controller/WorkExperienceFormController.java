package org.prezydium.cvmachine.controller;

import org.prezydium.cvmachine.model.CVModel;
import org.prezydium.cvmachine.model.WorkExperience;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
public class WorkExperienceFormController {

    private Logger LOG = LoggerFactory.getLogger(WorkExperienceFormController.class);

    @GetMapping(path = "/experience")
    public ModelAndView workExperienceProvider(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView("experience");
        if (httpSession.getAttribute("experience") == null) {
            modelAndView.addObject("experience", new WorkExperience());
        } else {
            modelAndView.addObject("experience", httpSession.getAttribute("experience"));
        }
        return modelAndView;
    }
    @GetMapping(path = "/experience", params = "id")
    public ModelAndView editWorkExperience(HttpSession httpSession, @RequestParam("id") long id) {
        ModelAndView modelAndView = new ModelAndView("experience");
        CVModel cvModel = (CVModel) httpSession.getAttribute("cvModel");
        WorkExperience workExperience = cvModel.getWorkExperienceMap().get((int) id);
        modelAndView.addObject("experience", workExperience);
        return modelAndView;
    }

    @PostMapping("/experience")
    public RedirectView saveExperience(@ModelAttribute WorkExperience experience, HttpSession httpSession) {
        LOG.info("Processing experience: ".concat(experience.toString()));
        httpSession.setAttribute("experience", experience);
        return new RedirectView("/");
    }
}
