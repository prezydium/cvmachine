package org.prezydium.cvmachine.controller;

import org.prezydium.cvmachine.model.CVModel;
import org.prezydium.cvmachine.model.Education;
import org.prezydium.cvmachine.model.UserData;
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
public class EducationFormController {

    private Logger LOG = LoggerFactory.getLogger(EducationFormController.class);

    @GetMapping(path = "/education")
    public ModelAndView educationProvider(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView("education");
        modelAndView.addObject("education",new Education());
        return modelAndView;
    }

    @GetMapping(path = "/education", params = "id")
    public ModelAndView editEducation(HttpSession httpSession, @RequestParam("id") long id) {
        ModelAndView modelAndView = new ModelAndView("education");
        CVModel cvModel = (CVModel) httpSession.getAttribute("cvModel");
        Education educationToEdit = cvModel.getEducationList().get((int) id);
        modelAndView.addObject("education", educationToEdit);
        return modelAndView;
    }

    @PostMapping("/education")
    public RedirectView saveEducation(@ModelAttribute Education education, HttpSession httpSession) {
        LOG.info("Processing education: ".concat(education.toString()));
        httpSession.setAttribute("education", education);
        return new RedirectView("/");
    }
}
