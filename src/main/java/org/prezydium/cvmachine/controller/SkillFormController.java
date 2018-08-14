package org.prezydium.cvmachine.controller;

import org.prezydium.cvmachine.model.CVModel;
import org.prezydium.cvmachine.model.Education;
import org.prezydium.cvmachine.model.Skill;
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
public class SkillFormController {

    private Logger LOG = LoggerFactory.getLogger(SkillFormController.class);

    @GetMapping(path = "/skill")
    public ModelAndView skillProvider(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView("skill");
        modelAndView.addObject("skill",new Skill());
        return modelAndView;
    }

    @GetMapping(path = "/skill", params = {"id", "edit"})
    public ModelAndView editSkill(HttpSession httpSession, @RequestParam("id") long id) {
        ModelAndView modelAndView = new ModelAndView("skill");
        CVModel cvModel = (CVModel) httpSession.getAttribute("cvModel");
        Skill skillnToEdit = cvModel.getSkillMap().get(id);
        modelAndView.addObject("skill", skillnToEdit);
        return modelAndView;
    }

    @GetMapping(path = "/skill", params = {"id", "delete"})
    public RedirectView deleteSkill(HttpSession httpSession, @RequestParam("id") long id) {
        CVModel cvModel = (CVModel) httpSession.getAttribute("cvModel");
        cvModel.getSkillMap().remove(id);
        httpSession.setAttribute("cvModel", cvModel);
        return new RedirectView("/");
    }

    @PostMapping("/skill")
    public RedirectView saveEducation(@ModelAttribute Skill skill, HttpSession httpSession) {
        LOG.info("Processing skill: ".concat(skill.toString()));
        CVModel cvModel = (CVModel) httpSession.getAttribute("cvModel");
        cvModel.getSkillMap().put(skill.getId(), skill);
        return new RedirectView("/");
    }
}
