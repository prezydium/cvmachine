package org.prezydium.cvmachine.service;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.prezydium.cvmachine.model.CVModel;
import org.prezydium.cvmachine.model.Education;
import org.prezydium.cvmachine.model.Skill;
import org.prezydium.cvmachine.model.WorkExperience;
import org.prezydium.cvmachine.testutil.CVModelExampleGenerator;

import java.time.LocalDate;

public class SaveNewCvElementServiceTest {

    private CVModel cvModel;
    private SaveNewCvElementService saveNewCvElementService;

    @Before
    public void setUp() {
        cvModel = CVModelExampleGenerator.create();
        saveNewCvElementService = new SaveNewCvElementService(cvModel);
    }

    @Test
    public void shouldAddSkill() {
        //given
        String skillName = "Unit test 1";
        Skill skill = new Skill();
        skill.setName(skillName);
        //when
        cvModel = saveNewCvElementService.save(skill);
        //then
        Assertions.assertThat(cvModel.getSkillMap().containsKey(3L)).isTrue();
        Assertions.assertThat(cvModel.getSkillMap().get(3L).getName()).isEqualTo(skillName);
    }

    @Test
    public void shouldContain4Skills() {
        //given
        Skill skill = new Skill();
        skill.setName("Unit test 2");
        //when
        cvModel = saveNewCvElementService.save(skill);
        //then
        Assertions.assertThat(cvModel.getSkillMap().keySet().size()).isEqualTo(4);
    }

    @Test
    public void shouldAddEducation() {
        //given
        String educationName = "Unit test 3";
        Education education = new Education();
        education.setSchoolName(educationName);
        education.setStartDate(LocalDate.of(2018, 1, 1));
        //when
        cvModel = saveNewCvElementService.save(education);
        //then
        Assertions.assertThat(cvModel.getEducationMap().containsKey(2L)).isTrue();
        Assertions.assertThat(cvModel.getEducationMap().get(2L).getSchoolName()).isEqualTo(educationName);
    }

    @Test
    public void shouldContain3Educations() {
        //given
        String educationName = "Unit test 4";
        Education education = new Education();
        education.setSchoolName(educationName);
        education.setStartDate(LocalDate.of(2018, 1, 1));
        //when
        cvModel = saveNewCvElementService.save(education);
        //then
        Assertions.assertThat(cvModel.getEducationMap().keySet().size()).isEqualTo(3);
    }

    @Test
    public void shouldAddWorkExperience() {
        //given
        String companyName = "Unit test 5";
        WorkExperience workExperience = new WorkExperience();
        workExperience.setCompanyName(companyName);
        workExperience.setStartDate(LocalDate.of(2018, 1, 1));
        //when
        cvModel = saveNewCvElementService.save(workExperience);
        //then
        Assertions.assertThat(cvModel.getWorkExperienceMap().containsKey(2L)).isTrue();
        Assertions.assertThat(cvModel.getWorkExperienceMap().get(2L).getCompanyName()).isEqualTo(companyName);
    }

    @Test
    public void shouldContain4Experiences() {
        //given
        String companyName = "Unit test 6";
        String companyName2 = "Unit test 6.5";
        WorkExperience workExperience = new WorkExperience();
        workExperience.setCompanyName(companyName);
        workExperience.setStartDate(LocalDate.of(2018, 1, 1));
        WorkExperience workExperience2 = new WorkExperience();
        workExperience2.setCompanyName(companyName);
        workExperience2.setStartDate(LocalDate.of(2018, 1, 1));
        workExperience2.setEndDate(LocalDate.of(2018, 12, 1));
        //when
        cvModel = saveNewCvElementService.save(workExperience);
        cvModel = saveNewCvElementService.save(workExperience2);
        //then
        Assertions.assertThat(cvModel.getWorkExperienceMap().keySet().size()).isEqualTo(4);
    }

}