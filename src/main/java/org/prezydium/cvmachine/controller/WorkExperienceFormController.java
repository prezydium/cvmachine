package org.prezydium.cvmachine.controller;

import org.prezydium.cvmachine.model.CVModel;
import org.prezydium.cvmachine.model.WorkExperience;
import org.prezydium.cvmachine.service.SaveNewCvElementService;
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
        modelAndView.addObject("experience", new WorkExperience());
        return modelAndView;
    }

    @GetMapping(path = "/experience", params = {"id", "edit"})
    public ModelAndView editWorkExperience(HttpSession httpSession, @RequestParam("id") long id) {
        ModelAndView modelAndView = new ModelAndView("experience");
        CVModel cvModel = (CVModel) httpSession.getAttribute("cvModel");
        WorkExperience workExperience = cvModel.getWorkExperienceMap().get(id);
        modelAndView.addObject("experience", workExperience);
        return modelAndView;
    }

    @GetMapping(path = "/experience", params = {"id", "delete"})
    public RedirectView deleteWorkExperience(HttpSession httpSession, @RequestParam("id") long id) {
        CVModel cvModel = (CVModel) httpSession.getAttribute("cvModel");
        WorkExperience workExperience = cvModel.getWorkExperienceMap().remove(id);
        httpSession.setAttribute("cvModel", cvModel);
        return new RedirectView("/");
    }

    @PostMapping("/experience")
    public RedirectView saveNewExperience(@ModelAttribute WorkExperience experience, HttpSession httpSession) {
        LOG.info("Processing experience: ".concat(experience.toString()));
        CVModel cvModel = (CVModel) httpSession.getAttribute("cvModel");
        SaveNewCvElementService saveNewCvElementService = new SaveNewCvElementService(cvModel);
        httpSession.setAttribute("cvModel", saveNewCvElementService.save(experience));
        return new RedirectView("/");
    }

    @PostMapping(value = "/experience", params = {"id"})
    public RedirectView saveEditedExperience(@ModelAttribute WorkExperience workExperience, HttpSession httpSession, @RequestParam("id") long id) {
        LOG.info("Processing skill: ".concat(workExperience.toString()));
        CVModel cvModel = (CVModel) httpSession.getAttribute("cvModel");
        cvModel.getWorkExperienceMap().put(id, workExperience);
        return new RedirectView("/");
    }
}
