package org.prezydium.cvmachine.controller;

import org.prezydium.cvmachine.model.Skill;
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
public class SkillFormController {

    private Logger LOG = LoggerFactory.getLogger(SkillFormController.class);

    @GetMapping(path = "/skill")
    public ModelAndView personalDataProvider(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView("skill");
        if (httpSession.getAttribute("skill") == null) {
            modelAndView.addObject("skill", new Skill());
        } else {
            modelAndView.addObject("skill", httpSession.getAttribute("skill"));
        }
        return modelAndView;
    }

    @PostMapping("/main-skill")
    public RedirectView savePersonalData(@ModelAttribute Skill skill, HttpSession httpSession) {
        LOG.info("Processing experience: ".concat(skill.toString()));
        httpSession.setAttribute("skill", skill);
        return new RedirectView("/");
    }
}
